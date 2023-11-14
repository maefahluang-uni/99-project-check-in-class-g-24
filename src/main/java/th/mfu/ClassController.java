package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.Reposistory.CourseRepository;
import th.mfu.Reposistory.LecturerRepository;
import th.mfu.Reposistory.PasswordRepository;
import th.mfu.Reposistory.SectionRepository;
import th.mfu.Reposistory.StudentRepository;
import th.mfu.domain.Course;
import th.mfu.domain.Password;
import th.mfu.domain.Section;
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

    @Autowired
    SectionRepository sectionrepo;

    //This method will map when the mapping is not matched with all the mapping method 
    @GetMapping("/**")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginprocess(@PathVariable String user_email, @PathVariable String password, Model model) {

        Student user = studentrepo.findById(user_email).get();
        Password pw = passwordrepo.findById(user.getStd_id()).orElse(null);

        //need to change entity relation of course(can't find the course_id from student_entity)

        // Section sec = sectionrepo.findById(user_email).orElse(null);
        Course c = new Course();
        Section s = new Section();
    
        if (user != null && password.equals(pw.getPassword_id())) {
            // Valid login
            model.addAttribute("student_firstname", user.getStd_firstname());
            model.addAttribute("student_lastname", user.getStd_lastname());
            model.addAttribute("useremail", user_email);

            model.addAttribute("course_cose", c.getCourse_id());
            model.addAttribute("course_name", c.getCourse_name());
            model.addAttribute("course_section", s.getSec_id());


            return "viewcourse";
        } else {
            // Invalid login
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
