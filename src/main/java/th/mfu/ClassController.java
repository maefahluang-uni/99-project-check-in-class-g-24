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
import th.mfu.domain.Student;
import th.mfu.domain.AdminC;
// import th.mfu.Reposistory.PasswordRepository;
// import th.mfu.domain.Password;


@Controller
public class ClassController {

    @Autowired
    private StudentRepository studentRepo;

    // @Autowired
    // private PasswordRepository passwordRepo;

    @Autowired 
    private AdminCReposistory adminRepo;

    @Autowired
    private LecturerRepository lecturerrepo;

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam String email, @RequestParam String password, Model model) {

        Student S_user = studentRepo.findById(email).get();
        Lecturer L_user = lecturerrepo.findById(email).get();
        AdminC A_user = adminRepo.findById(email).get();


    //    if(!(A_user.equals(null)) ){

    //         return "admin_dashboard";

    //    }else if (!(S_user.equals(null)) ){
            
    //         if (S_user.getStd_password().equals(password)) {

    //             // model.addAttribute("std_firstname", S_user.getStd_firstname());
    //             // model.addAttribute("std_lastname", S_user.getStd_lastname());
    //             // model.addAttribute("std_email", S_user.getStd_email());

    //             // return "viewcourse/{" + S_user.getStd_id()+"}";
    //             return "";

    //         }

    //     }else if(!(L_user.equals(null)) ) {

    //         if(L_user.getLec_password().equals(password)){

    //             model.addAttribute("lec_firstname",L_user.getLec_firstname());
    //             model.addAttribute("lec_lastname",L_user.getLec_lastname());
    //             model.addAttribute("lec_email", L_user.getLec_email());

    //             return "viewcourse/{" + L_user.getLec_id()+"}";

    //         }
    //     }

        return "test";

    }

    @GetMapping("/viewcourse/{user_id}")
    public String book(@PathVariable Long studentId, Model model) {
        // Implement logic to display information about the student with the given ID
        return "view-course";
    }
    //  @GetMapping("/viewcourse")
    // public String boo() {
    //     // Implement logic to display information about the student with the given ID
    //     return "view-course";
    // }

    @GetMapping("/add-student")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student-form";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute Student student) {
        // Implement logic to save the student
        studentRepo.save(student);
        return "redirect:/student-list";
    }

    @GetMapping("/students")
    public String studentList(Model model) {
        model.addAttribute("students", studentRepo.findAll());
        return "students-list";
    }
}

