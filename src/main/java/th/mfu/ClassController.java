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
            Lecturer lec = lecturerrepo.findById(email).get();
            System.out.println("===============================");
            System.out.println(pw);
            System.out.println("===============================");
            if(lec.getLec_password() == pw){
                return "redirect:/Lec_course_list/" + email;
            }else{
                 return "redirect:/login";
            }

        } else if (stdOptional.isPresent() && !stdOptional.get().isEmpty()) {
            return "redirect:/Sviewcourse/" + email;
        } else if (adOptional.isPresent()) {
            return "redirect:/admin_home_page/" + email;
        }

        return "redirect:/login";
    }

    @GetMapping("Lec_course_list/{lec_email}")
    public String lview(@PathVariable String lec_email,Model model){

        Lecturer lec = lecturerrepo.findById(lec_email).get();
        model.addAttribute("lec", lec);
        // model.addAttribute("lec_email", lec.getLec_email());
        model.addAttribute("courses",courserepo.findAllByLecId(lec.getLec_id()));

        return "Lec_course_list";
    }

    

    @GetMapping("Lec_course-list/Lprofile/{lec_email}")
    public String Lpfview(@PathVariable String lec_email,Model model){
    
        Lecturer lecturer = lecturerrepo.findById(lec_email).get();
        model.addAttribute("lecturer",lecturer);
        return "Lprofile";
    }

    @GetMapping("Lec_course_list/Lec_announce_view/{Lec_id}")
    public String Lannounce(@PathVariable String Lec_id,Model model){
    
        Lecturer lecturer = lecturerrepo.findByLec_id(Lec_id);
        model.addAttribute("lec",lecturer);
        return "Lec_announce_view";
    }

    @GetMapping("/Lec_course_list/Lec_announce_view/Lec_add_materials")
    public String Lec_add_materials(){


        return "Lec_add_materials";
    }

    @GetMapping("admin_home_page/{admin_email}")
    public String admin_home_pageG(Model model,@PathVariable String admin_email){
        AdminC admin = adminRepo.findById(admin_email).get();
        model.addAttribute("admin", admin);
        return "admin_home_page";
    }

    @GetMapping("admin_home_page/admin_create_lec/{admin_email}")
    public String admin_create_lec(Model model,@PathVariable String admin_email){

        AdminC admin = adminRepo.findById(admin_email).get();
        Lecturer lecturer = new Lecturer();

        model.addAttribute("lecturer", lecturer);
        model.addAttribute("admin",admin);

        return "/admin_create_lec";
    }

    @GetMapping("admin_home_page/admin_create_std/{admin_email}")
    public String admin_create_std(Model model,@PathVariable String admin_email){

        AdminC admin = adminRepo.findById(admin_email).get();
        Student student = new Student();
        model.addAttribute("student" , student);
        model.addAttribute("admin",admin);

        return "/admin_create_std";
    }

    @GetMapping("admin_home_page/admin_create_class/{admin_email}")
    public String admin_create_class(Model model,@PathVariable String admin_email){

        AdminC admin = adminRepo.findById(admin_email).get();
        Course course = new Course();
        model.addAttribute("course",course);
        model.addAttribute("admin",admin);

        return "/admin_create_class";
    }


    @PostMapping("/admin_create_class")
    public String admin_create_classP(Model model, @ModelAttribute Course course, @ModelAttribute AdminC admin) {

        courserepo.save(course);

        List<Course> courses = courserepo.findAll();
        System.out.println("This is text for " + courses);

        model.addAttribute("courses", courses);
        
        // List <Section> sections = sectionrepo.findAllById();

        return "admin_create_class";
    }

    @PostMapping("/admin_create_lec")
    public String admin_create_lecP(Model model,@ModelAttribute Lecturer lecturer){

        lecturerrepo.save(lecturer);
        
        return "admin_create_lec";
    }

    @PostMapping("/admin_create_std")
    public String admin_create_stdP(Model model,@ModelAttribute Student student){

        studentRepo.save(student);
        return "admin_create_std";
    }


}

