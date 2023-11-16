package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.Reposistory.AdminCReposistory;
import th.mfu.Reposistory.CourseRepository;
import th.mfu.Reposistory.LecturerRepository;
import th.mfu.Reposistory.StudentRepository;
import th.mfu.domain.Lecturer;
import th.mfu.domain.Login_acc;
import th.mfu.domain.Student;
import th.mfu.domain.AdminC;
// import th.mfu.Reposistory.PasswordRepository;
// import th.mfu.domain.Password;


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

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("user", new Login_acc());
        return "login";
    }

    @PostMapping("/login")
    public String slogin(@ModelAttribute Login_acc user,Model model){

        String email = user.getEmail();
        System.out.println(email);
        return "redirect:/viewcourse/" + email ;
        
    }

    @GetMapping("viewcourse/{std_email}")
    public String sview(@PathVariable String std_email,Model model){

        Lecturer lec = lecturerrepo.findByLec_email(std_email);
        model.addAttribute("lecturer", lec);
        System.out.println("----------------------------------------------------------");
        System.out.println(lec.getLec_id());
        System.out.println( courserepo.findAllByLecId( lec.getLec_id() ) );        
        System.out.println("----------------------------------------------------------");

        model.addAttribute("courses",courserepo.findAllByLecId( "LEC001"));

        return "viewcourse";
    }


}

