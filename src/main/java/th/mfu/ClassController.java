package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import th.mfu.Reposistory.CourseRepository;
import th.mfu.Reposistory.PasswordRepository;
import th.mfu.Reposistory.StudentRepository;
import th.mfu.domain.Password;
import th.mfu.domain.Student;



@Controller
public class ClassController {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private PasswordRepository passwordRepo;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@PathVariable String studentEmail, @PathVariable String password, Model model) {

        Student user = studentRepo.findById(studentEmail).get();
        if (user != null) {
            Password pw = passwordRepo.findById(password).orElse(null);
            if (pw != null && pw.getPassword_id().equals(password)) {
                model.addAttribute("student_firstname", user.getStd_firstname());
                model.addAttribute("student_lastname", user.getStd_lastname());
                model.addAttribute("useremail", studentEmail);
                return "viewcourse";
            }else{
                return "redirect:/login";
            }
        }
        return "redirect:/login";
    }

    // @GetMapping("/class/{studentId}")
    // public String book(@PathVariable Long studentId, Model model) {
    //     // Implement logic to display information about the student with the given ID
    //     return "view-course";
    // }

    // @GetMapping("/add-student")
    // public String addStudentForm(Model model) {
    //     model.addAttribute("student", new Student());
    //     return "add-student-form";
    // }

    // @PostMapping("/students")
    // public String saveStudent(@ModelAttribute Student student) {
    //     // Implement logic to save the student
    //     studentRepo.save(student);
    //     return "redirect:/student-list";
    // }

    // @GetMapping("/students")
    // public String studentList(Model model) {
    //     model.addAttribute("students", studentRepo.findAll());
    //     return "students-list";
    // }
}

