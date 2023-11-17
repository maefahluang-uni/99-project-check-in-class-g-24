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

        Optional<Lecturer> lecOptional = lecturerrepo.findById(email);
        Optional<List<Student>> stdOptional = Optional.ofNullable(studentRepo.findAllByStd_email(email));
        Optional<AdminC> adOptional = adminRepo.findById(email);

        if (lecOptional.isPresent()) {
            return "redirect:/Lviewcourse/" + email;
        } else if (stdOptional.isPresent() && !stdOptional.get().isEmpty()) {
            return "redirect:/Sviewcourse/" + email;
        } else if (adOptional.isPresent()) {
            return "redirect:/Ahomepage/" + email;
        }

        return "redirect:/login";
    }

    @GetMapping("Lviewcourse/{lec_email}")
    public String lview(@PathVariable String lec_email,Model model){

        Lecturer lec = lecturerrepo.findById(lec_email).get();
        model.addAttribute("lec", lec);
        // model.addAttribute("lec_email", lec.getLec_email());
        model.addAttribute("courses",courserepo.findAllByLecId(lec.getLec_id()));

        return "Lviewcourse";
    }

    // @GetMapping("Sviewcourse/{std_email}")
    // public String sview(@PathVariable String std_email,Model model){

    //     Student student = studentRepo.findAllByStd_email(std_email).get(0);
    //     System.out.println(student.getStd_id());
    //     List<Student> s = studentRepo.findAllByStd_email(std_email);
    //     System.out.println(s.get(0));

    //     // List<Course> c = courserepo.findAllByStd_emailCourses(std_email);
    //     // System.out.println(c.get(0));
    //     List <Course> c = studentRepo.findAllByStd_list(s);
    //     List <Course> courses = courserepo.findAllByCourse_id(c);

    //     model.addAttribute("std", student);
    //     model.addAttribute("students", s);
    //     model.addAttribute("courses",courses);

    //     return "Sviewcourse";
    // }

    @GetMapping("Ahomepage/{admin_email}")
    public String aview(Model model){

        return "Ahomepage";
    }


    @GetMapping("Lviewcourse/Lprofile/{lec_email}")
    public String Lpfview(@PathVariable String lec_email,Model model){
    
        Lecturer lecturer = lecturerrepo.findById(lec_email).get();
        model.addAttribute("lecturer",lecturer);
        return "Lprofile";
    }


}

