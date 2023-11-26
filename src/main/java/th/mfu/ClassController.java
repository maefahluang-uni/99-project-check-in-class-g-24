package th.mfu;




import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.Optional;




import th.mfu.Reposistory.AccountRepository;
// import th.mfu.Reposistory.AdminRepository;
import th.mfu.Reposistory.LecturerRepository;
import th.mfu.Reposistory.StudentRepository;
import th.mfu.Reposistory.CourseRepository;
import th.mfu.Reposistory.SectionRepository;
import th.mfu.Reposistory.PostRepository;
import th.mfu.Reposistory.AttendanceRepository;
import th.mfu.domain.Student;
import th.mfu.domain.Account;
import th.mfu.domain.Attendance;
import th.mfu.domain.Course;
import th.mfu.domain.Lecturer;
import th.mfu.domain.Section;
import th.mfu.domain.Post;
import th.mfu.domain.Attendance;




@Controller
public class ClassController {




    @Autowired
    private LecturerRepository lecRepo;




    // @Autowired
    //  private AdminRepository adminRepo;




    @Autowired
    private StudentRepository stdRepo;




    @Autowired
    private CourseRepository courseRepo;




    @Autowired
    private SectionRepository secRepo;




    @Autowired
    private AccountRepository accRepo;




    @Autowired
    private PostRepository postRepo;


    @Autowired
    private AttendanceRepository attRepo;








    //=============Login==================




    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new Account());




        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute Account user, Model model) {
        String userEmail = user.getStd_email();




        if (userEmail != null) {
            Account account = null;




            if (userEmail.endsWith("@lamduan.mfu.ac.th") && userEmail.startsWith("6")) {
                account = accRepo.findByStd_email(userEmail);
               
                if (account != null && validatePassword(user.getPassword(), account.getPassword())) {
                // Password is correct, redirect to the view course page
                System.out.println("excuted for std");
           
                return "redirect:/Std_home_page/"+ userEmail;
            }




            } else if (userEmail.endsWith("@lamduan.mfu.ac.th")) {
                account = accRepo.findByLec_email(userEmail);
                if (account != null && validatePassword(user.getPassword(), account.getPassword())) {
                // Password is correct, redirect to the view course page
                System.out.println("excuted for lec");
                return "redirect:/Lec_home_page/"+ userEmail;
            }
            } else if (userEmail.endsWith("@gmail.com")) {
                account = accRepo.findByAdmin_email(userEmail);
                if (account != null && validatePassword(user.getPassword(), account.getPassword())) {
                // Password is correct, redirect to the view course page
                System.out.println("excuted for admin");
                return "admin_home_page";
            }
            }




        }




        // If no matching user or incorrect password, redirect to login with an error message
        System.out.println("Invalid user email or password");
        model.addAttribute("user", new Account());
        model.addAttribute("error", "Invalid user email or password");
        return "login";
    }








    private boolean validatePassword(String enteredPassword, String correctPassword) {
           
        return enteredPassword.equals(correctPassword);
    }




    //=======================  STUDENT  ================================








        //=============  Student Home page ==================




    @GetMapping("/Std_home_page/{std_email}")
    public String courseView(@PathVariable String std_email,Model model) {
           
        List<Course> courses = courseRepo.findByStudentEmail(std_email);
        List<Student> student= stdRepo.findByStd_email(std_email);
           
        model.addAttribute("student_info",student.get(0));
        model.addAttribute("courses", courses);
        model.addAttribute("sections", secRepo.findSecNoByStdEmail(std_email));




        return "Std_home_page";
    }




            //============= Student Home page to profile ==================




    @GetMapping("Std_home_page/Std_profile/{std_email}")
        public String studen_profile(@PathVariable String std_email,Model model) {




            List<Student> student = stdRepo.findByStd_email(std_email);
            model.addAttribute("profile_info", student.get(0));
           
            return "Std_profile";
        }




        //=============  Student Home page to Specific Courses  ==================




    @GetMapping("/Std_home_page/Std_course/{course_id}/{sec_no}/{std_email}")
    public String std_course(@PathVariable int course_id,@PathVariable int sec_no,@PathVariable String std_email, Model model) {
       
        List<Student> student = stdRepo.findByStd_email(std_email);
        model.addAttribute("student_info", student.get(0));




        Course selectedCourse = courseRepo.findByCourse_id(course_id); // Assuming you have a method like this in your repository
        model.addAttribute("selectedCourse", selectedCourse);




        model.addAttribute("selected", sec_no);


           List<Post> posts= postRepo.findAll();
           
        Section section = secRepo.findByCourse_idAndSec_no(course_id, sec_no);
        Lecturer lecturer = lecRepo.findByLec_id(section.getLec_id());
        model.addAttribute("lecturer", lecturer);
        model.addAttribute("new_posts", posts);
        model.addAttribute("att", new Attendance());
        return "Std_course";
        }


        @PostMapping("/attendance/{course_id}/{sec_no}/{std_email}")
    public String std_att_submit(@ModelAttribute Attendance att, @PathVariable String std_email,@PathVariable int course_id, @PathVariable int sec_no, Model model) {


        Section section = secRepo.findByCourse_idAndSec_no(course_id, sec_no);


        Long sec_id = section.getSec_id();
        System.out.println(sec_id);


        List<Post> posts = postRepo.findPostBySec_id(sec_id);
        int i = postRepo.findAll().size()-1;
        System.out.println(i);

        int idx = posts.size() - 1;
        Post lastPost = posts.get(idx);

        System.out.println(lastPost.getLec_input());
        System.out.println(lastPost.getWeek_no());


        if (lastPost.getLec_input().equals(att.getStd_input()) && (lastPost.getWeek_no() == att.getWeek_no())) {
            System.out.println("This is in if condition");
            att.setStatus(true);
            Attendance asave = attRepo.save(att);
            System.out.println(att.getStd_input());
            System.out.println(att.getWeek_no());
            System.out.println(att.getAtt_id());
        }


        System.out.println("=====================================================");
        System.out.println("This is outside if condition");
        System.out.println(att.isStatus());


        return "redirect:/Std_home_page/Std_total_attendance/" + course_id + "/" + sec_no + "/" + std_email;
    }






        //=============  Specific course to students list  ==================




    @GetMapping("/Std_home_page/Std_std_list/{course_id}/{sec_no}/{std_email}")
    public String view_student_list(@PathVariable int course_id,@PathVariable int sec_no,@PathVariable String std_email,Model model) {




        List<Student> student = stdRepo.findByStd_email(std_email);
        model.addAttribute("student_info", student.get(0));




        Course selectedCourse = courseRepo.findByCourse_id(course_id); // Assuming you have a method like this in your repository
        model.addAttribute("selectedCourse", selectedCourse);
           
        Section section = secRepo.findByCourse_idAndSec_no(course_id,sec_no);
        Long sec_id = section.getSec_id();
        List<Student> students = stdRepo.findByCourse_idAndSec_id(course_id, sec_id);
        model.addAttribute("students", students);




        model.addAttribute("course_id", course_id);
        model.addAttribute("sec_no", sec_no);


        return "Std_std_list";
    }
//original
    @GetMapping("/Std_home_page/Std_total_attendance/{course_id}/{sec_no}/{std_email}")
    public String Sview_att_total(@PathVariable int course_id,@PathVariable int sec_no,@PathVariable String std_email,Model model) {




        List<Student> student = stdRepo.findByStd_email(std_email);
        model.addAttribute("student_info", student.get(0));




        Course selectedCourse = courseRepo.findByCourse_id(course_id); // Assuming you have a method like this in your repository
        model.addAttribute("selectedCourse", selectedCourse);


        model.addAttribute("course_id", course_id);
        model.addAttribute("sec_no", sec_no);
        return "Std_total_attendance";
    }


       




    //=======================  LECTURER   ================================




        //=============  Lecturer Home page ==================
    @GetMapping("/Lec_home_page/{lec_email}")
    public String LcourseView(@PathVariable String lec_email,Model model) {
           
        Lecturer lecturer = lecRepo.findByLec_email(lec_email);
        model.addAttribute("lecturer_info", lecturer);




        List<Course> courses = courseRepo.findByLecturerEmail(lec_email);
        model.addAttribute("courses", courses);
        model.addAttribute("sections", secRepo.findSecNoByLecEmail(lec_email));




        return "Lec_home_page";
    }




        //=============  Lecturer Home page to Profile ==================




    @GetMapping("Lec_home_page/Lec_profile/{lec_email}")
    public String lec_profile(@PathVariable String lec_email,Model model) {


        Lecturer lec = lecRepo.findByLec_email(lec_email);
        model.addAttribute("profile_info", lec);
           
        return "Lec_profile";
    }




        //==============  Lecturer Home Page to Specific Course =================
    @GetMapping("/Lec_home_page/Lec_course/{course_id}/{sec_no}/{lec_email}")
    public String lec_course(@PathVariable int course_id,@PathVariable int sec_no,@PathVariable String lec_email, Model model) {
       
        Lecturer lec = lecRepo.findByLec_email(lec_email);
        model.addAttribute("lec_info", lec);




        Course selectedCourse = courseRepo.findByCourse_id(course_id);
        model.addAttribute("selectedCourse", selectedCourse);
        model.addAttribute("selected", sec_no);






        List<Post> post= postRepo.findPostByCourseID(course_id);
        model.addAttribute("material", post);
        List<Post> posts= postRepo.findAll();
        model.addAttribute("new_posts", posts);


        return "Lec_course";
    }




        //=============  Add materials  ==================




        @GetMapping("Lec_home_page/Lec_add_materials/{course_id}/{sec_no}/{lec_email}")
    public String lec_add_materials(@PathVariable int course_id,@PathVariable int sec_no,@PathVariable String lec_email,Model model) {




         Lecturer lec = lecRepo.findByLec_email(lec_email);
        model.addAttribute("lec_info", lec);
        Course selectedCourse = courseRepo.findByCourse_id(course_id);
        model.addAttribute("selectedCourse", selectedCourse);
        model.addAttribute("selected", sec_no);
        model.addAttribute("new_post", new Post());
        model.addAttribute("create_att", new Attendance());
           
        return "Lec_add_materials";
    }


   
    @Transactional
    @PostMapping("/post/{course_id}/{sec_no}/{lec_email}")
    public String createPost(@ModelAttribute Post new_post,@PathVariable String lec_email,@PathVariable int course_id, @PathVariable int sec_no,Model model) {
       
        Section Ssec_id = secRepo.findByCourse_idAndSec_no(course_id, sec_no);
        new_post.setSec_id(Ssec_id.getSec_id());
       
        Post psave = postRepo.save(new_post);
     
        return "redirect:/Lec_home_page/Lec_course/" + course_id + "/" + sec_no + "/" + lec_email;


    }




        //=============  Specific course to students list  ==================




    @GetMapping("/Lec_home_page/Lec_std_list/{course_id}/{sec_no}/{lec_email}")
    public String Lec_view_student_list(@PathVariable int course_id,@PathVariable int sec_no,@PathVariable String lec_email,Model model) {




        Lecturer lec = lecRepo.findByLec_email(lec_email);
        model.addAttribute("lec_info", lec);




        Course selectedCourse = courseRepo.findByCourse_id(course_id);
        model.addAttribute("selectedCourse", selectedCourse);
           
        Section section = secRepo.findByCourse_idAndSec_no(course_id,sec_no);
        Long sec_id = section.getSec_id();
        List<Student> students = stdRepo.findByCourse_idAndSec_id(course_id, sec_id);
        model.addAttribute("students", students);




        model.addAttribute("course_id", course_id);
        model.addAttribute("sec_no", sec_no);




        return "Lec_std_list";
    }


    //=================== Lecturer Add student====================
    @GetMapping("/Lec_home_page/Lec_add_std/{course_id}/{sec_no}/{lec_email}")
    public String Lec_add_std(@PathVariable int course_id,@PathVariable int sec_no,@PathVariable String lec_email,Model model) {


        secRepo.findByCourse_idAndSec_no(course_id, sec_no);
        Student student = new Student();
        model.addAttribute("student", student);


        return "Lec_add_std";
    }




    @PostMapping("/Lec_add_std")
    public String Lec_std_add(Model model , @ModelAttribute Student student ){




        stdRepo.save(student);




        return "Lec_add_std";
    }


        //=============  Lecturer announce post ==================


    @GetMapping("/lec_add_materials")
    public String lec_add_materials(Model model) {




        return "lec_add_materials";
    }





  //=======================  ADMIN   ================================


         //Admin home page


    @GetMapping("admin_home_page")
    public String admin_home_pageG(Model model){


        return "admin_home_page";
    }


        //Admin create class


    @GetMapping("admin_create_class")
    public String admin_create_class(Model model){


        Course course = new Course();
        model.addAttribute("course",course);


        Lecturer lec = new Lecturer();
        model.addAttribute("lec", lec);


        Section sec = new Section();
        model.addAttribute("sec", sec);


        List<Course> courses = courseRepo.findAll();
        model.addAttribute("courses", courses);




        return "/admin_create_class";
    }


    @PostMapping("/admin_create_class")
    public String admin_create_classP(Model model, @ModelAttribute Course course,@ModelAttribute Lecturer lec , @ModelAttribute Section sec) {


        Course c = new Course();
        Lecturer l = new Lecturer();
        Section s = new Section();
        if( !(course.getCourse_name().equals(null))){
            courseRepo.save(course);    
            secRepo.save(sec);
        }
                   
        model.addAttribute("course",c);
        model.addAttribute("lec", l);
        model.addAttribute("sec", s);


        List<Course> courses = courseRepo.findAll();
        model.addAttribute("courses", courses);


        return "admin_create_class";
    }


        //Admin delete class
        // @GetMapping("delete/{course_id}/{sec_no}")
        // public String class_delete(Model model , @PathVariable int course_id , @PathVariable int sec_no ){


        //     return "admin_create_class";
        // }


        //Admin create lecturer


    @GetMapping("admin_create_lec")
    public String admin_create_lec(Model model){
   
        Lecturer lecturer = new Lecturer();
        model.addAttribute("lecturer", lecturer);
        List<Lecturer> lecturers = lecRepo.findAll();
        model.addAttribute("lecturers", lecturers);
   
        return "/admin_create_lec";
    }


    @PostMapping("/admin_create_lec")
    public String admin_create_lecP(Model model , @ModelAttribute Lecturer lec) {


        Lecturer l = new Lecturer();  
        model.addAttribute("lecturer", l);
        if( !(lecRepo.findByLec_id(lec.getLec_id()).equals(null)) ){
            lecRepo.save(lec);
        }


        List<Lecturer> lecturers = lecRepo.findAll();
        model.addAttribute("lecturers", lecturers);


        return "admin_create_lec";


    }


   
    //Need to fix
    @GetMapping("/delete/{Lec_id}")
    public String deleteCourse(@PathVariable("Lec_id") String Lec_id,Model model) {
   
        Lecturer lecturer = new Lecturer();
   
        model.addAttribute("lecturer", lecturer);
        Lecturer lec = lecRepo.findByLec_id(Lec_id);
   
        lecRepo.delete(lec);
        List<Lecturer> lecturers = lecRepo.findAll();
        model.addAttribute("lecturers", lecturers);
   
        return "admin_create_lec";
    }
   
        //Admin create student
   
    @GetMapping("admin_create_std")
    public String admin_create_std(Model model){
   
        Student student = new Student();
        model.addAttribute("student", student);
        List<Student> students = stdRepo.findAll();
        model.addAttribute("students", students);
   
        return "/admin_create_std";
    }


    @PostMapping("/admin_create_std")
    public String admin_create_stdP(Model model , @ModelAttribute Student std) {


        Student student = new Student();
        model.addAttribute("student", student);
        if( !(stdRepo.findByStd_email(std.getStd_email()).equals(null)) ){
            stdRepo.save(std);
        }

        List<Student> students = stdRepo.findAll();
        model.addAttribute("students", students);
        return "admin_create_std";
    }

}
