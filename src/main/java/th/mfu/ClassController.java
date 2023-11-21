package th.mfu;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

import th.mfu.Reposistory.AdminCReposistory;
import th.mfu.Reposistory.CourseRepository;
import th.mfu.Reposistory.LecturerRepository;
import th.mfu.Reposistory.StudentRepository;
import th.mfu.Reposistory.SectionRepository;
import th.mfu.domain.Lecturer;
import th.mfu.domain.Login_acc;
import th.mfu.domain.Student;
import th.mfu.domain.AdminC;
import th.mfu.domain.Course;
import th.mfu.domain.Section;


@Controller
public class ClassController {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired 
    private AdminCReposistory adminRepo;

    @Autowired
    private LecturerRepository lecturerrepo;

    @Autowired
    private CourseRepository courserepo;

    @Autowired
    private SectionRepository sectionrepo;

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("user", new Login_acc());
        
        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute Login_acc user, Model model) {

        String email = user.getEmail();
        String pw = user.getPassword();

        Optional<Lecturer> lecOptional = lecturerrepo.findById(email);
        Optional<List<Student>> stdOptional = Optional.ofNullable(studentRepo.findAllByStd_email(email));
        Optional<AdminC> adOptional = adminRepo.findById(email);

        if (lecOptional.isPresent()) {

            Lecturer lec = lecturerrepo.findByLec_email(email);

            if(lec.getLec_id().equals(pw)){
                return "redirect:/Lec_course_list/" + email;
            }else{
                 return "redirect:/login";
            }

        } else if (stdOptional.isPresent() && (stdOptional.equals(null))) {
            
                
            return "redirect:/Sviewcourse/" + email;

        } else if (adOptional.isPresent()) {

             AdminC ad = adminRepo.findById(email).get();

            if(ad.getAdmin_password().equals(pw)){

                return "redirect:admin_home_page";

            }else{
                 return "redirect:/login";
            }

        }else{
            model.addAttribute("user", new Login_acc());
            model.addAttribute("error", "Invalid email address");
            return "login";
        }
    }

    //lecturer course list 
    @GetMapping("Lec_course_list/{lec_email}")
    public String lview(@PathVariable String lec_email,Model model){

        Lecturer lec = lecturerrepo.findByLec_email(lec_email);

        model.addAttribute("lec", lec);
        
        model.addAttribute("courses",courserepo.findAllByLecId(lec.getLec_id()));

        return "Lec_course_list";
    }

    
    //lecturer profile
    @GetMapping("Lec_course-list/Lprofile/{lec_email}")
    public String Lpfview(@PathVariable String lec_email,Model model){
    
        Lecturer lecturer = lecturerrepo.findByLec_email(lec_email);
        model.addAttribute("lecturer",lecturer);
        return "Lprofile";
    }

    //lecturer announce view
    @GetMapping("Lec_course_list/Lec_announce_view/{Lec_id}")
    public String Lannounce(@PathVariable String Lec_id,Model model){
    
        Lecturer lecturer = lecturerrepo.findByLec_id(Lec_id);
        model.addAttribute("lec",lecturer);
        return "Lec_announce_view";
    }
    
    //lecturer announce view/ add materials
    @GetMapping("/Lec_course_list/Lec_announce_view/Lec_add_materials")
    public String Lec_add_materials(){


        return "Lec_add_materials";
    }


    //==========================///=========
    //Admin home page
    @GetMapping("admin_home_page")
    public String admin_home_pageG(Model model){

        return "admin_home_page";
    }

  
    //Admin create lec
    @GetMapping("admin_create_lec")
    public String admin_create_lec(Model model){

        Lecturer lecturer = new Lecturer();

        model.addAttribute("lecturer", lecturer);
        List<Lecturer> lecturers = lecturerrepo.findAll();
        model.addAttribute("lecturers", lecturers);

        return "/admin_create_lec";
    }

    @GetMapping("/delete/{Lec_id}")
    public String deleteCourse(@PathVariable("Lec_id") String Lec_id,Model model) {

        Lecturer lecturer = new Lecturer();

        model.addAttribute("lecturer", lecturer);
        Lecturer lec = lecturerrepo.findByLec_id(Lec_id);

        lecturerrepo.delete(lec);
        List<Lecturer> lecturers = lecturerrepo.findAll();
        model.addAttribute("lecturers", lecturers);

        return "admin_create_lec"; 
    }

    @PostMapping("/admin_create_lec")
    public String admin_create_lecP(Model model,@ModelAttribute Lecturer lecturer){

        lecturerrepo.save(lecturer);
        List<Lecturer> lecturers = lecturerrepo.findAll();
        model.addAttribute("lecturers", lecturers);
        return "admin_create_lec";
    }


    //Admin create class
    @GetMapping("admin_create_class")
    public String admin_create_class(Model model){

        Course course = new Course();
        model.addAttribute("course",course);

        List<Course> courses = courserepo.findAll();
        model.addAttribute("courses", courses);

        return "/admin_create_class";
    }


    @PostMapping("/admin_create_class")
    public String admin_create_classP(Model model, @ModelAttribute Course course) {

        if( lecturerrepo.findByLec_id(course.getLec_id()).equals(null) ) {
            
        Course c = new Course();
        model.addAttribute("course",c);

        List<Course> courses = courserepo.findAll();
        model.addAttribute("courses", courses);

        return "/admin_create_class";

        }else{
            courserepo.save(course);
            List<Course> courses = courserepo.findAll();
            model.addAttribute("courses", courses);
            return "admin_create_class";
        }
        
    }

    @GetMapping("/delete/{course_id}/{course_sec}/{std_id}")
    public String deleteStudent(@PathVariable("course_id") int course_id, @PathVariable("course_sec") int course_sec ,@PathVariable("std_id") int std_id,Model model) {
        
        Student student = new Student();
        model.addAttribute("student", student);
        // Student s = studentRepo.findByIdAndSec(course_id,course_sec);

        // studentRepo.delete(s);
        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);

        return "admin_create_std"; 
    }


    @GetMapping("admin_create_std")
    public String admin_create_std(Model model){

        Student student = new Student();
        model.addAttribute("student" , student);

        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);

        return "/admin_create_std";
    }





    @PostMapping("/admin_create_std")
    public String admin_create_stdP(Model model,@ModelAttribute Student student){

        studentRepo.save(student);
        return "admin_create_std";
    }




}

    // @GetMapping("/delete/{course_id}/{course_sec}")
    // public String deleteStudent(@PathVariable("std_id") String std_id, Model model) {

    //     Student std = new Student();

    //     model.addAttribute("lecturer", lecturer);
    //     Lecturer lec = studentRepo.find(std_id);

    //     lecturerrepo.delete(lec);
    //     List<Lecturer> lecturers = lecturerrepo.findAll();
    //     model.addAttribute("lecturers", lecturers);

    //     return "admin_create_lec"; 
    // }



    // @GetMapping("/delete/{course_id}/{course_sec}")
    // public String deleteLecturer(@PathVariable("course_id") int course_id, @PathVariable("course_sec") int course_sec,Model model) {

    //      Lecturer lecturer = new Lecturer();
    //     model.addAttribute("lecturer", lecturer);

    //     // Lecturer Lec_id = lecturerrepo.findByCourse_id(course_id,course_sec);
    //     Lecturer lec = lecturerrepo.findByLec_id(Lec_id);

    //     lecturerrepo.delete(Lec_id);
    //     List<Lecturer> lecturers = lecturerrepo.findAll();
    //     model.addAttribute("lecturers", lecturers);

    //     return "admin_create_lec"; 
    // }


    // @GetMapping("admin_home_page/admin_create_std")
    // public String admin_create_std(Model model,@PathVariable String admin_email){

    //     AdminC admin = adminRepo.findById(admin_email).get();
    //     Student student = new Student();
    //     model.addAttribute("student" , student);
    //     model.addAttribute("admin",admin);

    //     return "/admin_create_std";
    // }



    // @GetMapping("admin_home_page/admin_create_class/{admin_email}")
    // public String admin_create_class(Model model,@PathVariable String admin_email){

    //     AdminC admin = adminRepo.findById(admin_email).get();
    //     Course course = new Course();
    //     model.addAttribute("course",course);
    //     model.addAttribute("admin",admin);

    //     return "/admin_create_class";
    // }

    
    // @GetMapping("admin_home_page/{admin_email}")
    // public String admin_home_pageG(Model model,@RequestParam String admin_email){
    //     AdminC admin = adminRepo.findById(admin_email).get();
    //     model.addAttribute("admin", admin);
    //     return "admin_home_page";
    // }

    // @GetMapping("admin_home_page/admin_create_lec/{admin_email}")
    // public String admin_create_lec(Model model,@PathVariable String admin_email){

    //     AdminC admin = adminRepo.findById(admin_email).get();
    //     Lecturer lecturer = new Lecturer();

    //     model.addAttribute("lecturer", lecturer);
    //     model.addAttribute("admin",admin);

    //     return "/admin_create_lec";
    // }
