package th.mfu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.Reposistory.CourseRepository;
import th.mfu.Reposistory.LecturerRepository;
import th.mfu.Reposistory.PasswordRepository;
import th.mfu.Reposistory.StudentRepository;
import th.mfu.domain.Password;
import th.mfu.domain.Student;


@Controller
public class ClassController {

    @Autowired
    LecturerRepository lecturerrepo;

    @Autowired
    StudentRepository studentrepo;

    @Autowired
    CourseRepository courserepo;

    @Autowired
    PasswordRepository passwordrepo;

    //This method will map when the mapping is not matched with all the mapping method 
    @GetMapping("/**")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginprocess(@PathVariable Long student_email,@PathVariable String password,Model model){

        Student user = studentrepo.findById(student_email).get();
        Password pw = passwordrepo.findById(user).get();

        if (user.getStd_email().equals(student_email) && pw.getPassword_id().equals(password)) {

            model.addAttribute("student_firstname",student_firstname);
            model.addAttribute("student_lastname",student_lastname);
            model.addAttribute("useremail", student_email);
            return "viewcourse";

        } else {

            return "redirect:/login"; 
        }
        
    }

    //To view courses by the specific id
    @GetMapping("/class/{student_id}")
    public String book(@PathVariable Long student_id, Model model) {

        //need change(no student_id in courserepo)
        model.addAttribute("courses", courserepo.findById(student_id));
        return "view-course";
    }

    //To add the student by the lecturer
    @GetMapping("/add-student")
    public String addAConcertForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student-form";
    }

     //To save the value of student object which used in other handler method
    @PostMapping("/students")
    public String saveConcert(@ModelAttribute Student student) {
        studentrepo.save(student);
        return "redirect:/student-list";
    }
    
    //TO show the list of students 
    @GetMapping("/students")
    public String addstudent(Model model) {
        model.addAttribute("students", studentrepo.findAll());
        return "students-list";
    }
    
   

}
