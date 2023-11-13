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
import th.mfu.Reposistory.StudentRepository;
import th.mfu.domain.Student;


@Controller
public class ClassController {

    @Autowired
    LecturerRepository lecturerrepo;

    @Autowired
    StudentRepository studentrepo;

    @Autowired
    CourseRepository courserepo;

    //This method will map when the mapping is not matched with all the mapping method 
    @GetMapping("/**")
    public static String login(){
        return "login";
    }

    //This method is for the view courses by the specific id
    @GetMapping("/class/{student_id}")
    public String book(@PathVariable Long student_id, Model model) {

        //need change(no student_id in courserepo)
        model.addAttribute("courses", courserepo.findById(student_id));
        return "view-course";
    }

    //This method is for adding the student by the lecturer
    @GetMapping("/add-student")
    public String addAConcertForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student-form";
    }
    
    //This method is to show the list of students 
    @GetMapping("/students")
    public String addstudent(Model model) {
        model.addAttribute("students", studentrepo.findAll());
        return "students-list";
    }
    
    //This method is for saving the value of student object which used in other handler method
    @PostMapping("/students")
    public String saveConcert(@ModelAttribute Student student) {
        studentrepo.save(student);
        return "redirect:/student-list";
    }

}
