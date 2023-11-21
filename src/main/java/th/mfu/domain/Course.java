package th.mfu.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private int course_id;
    private String course_name;
    private String Lec_id;
    private int credit;
    private int course_sec;
    

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Lecturer> Lecturer;

    public int getCourse_sec() {
        return course_sec;
    }

    public void setCourse_sec(int course_sec) {
        this.course_sec = course_sec; 
    }

    
    public String getLec_id() {
        return Lec_id;
    }

    public void setLec_id(String lec_id) {
        Lec_id = lec_id;
    }

    public List<Lecturer> getLecturer() {
        return Lecturer;
    }

    public void setLecturer(List<Lecturer> lecturer) {
        Lecturer = lecturer;
    }

    

    public Course(){

    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

}
