package th.mfu.domain;


import java.util.HashSet;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int course_id;
    private String course_name;
    private int credit;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "enrollments_course",  // This is the name of the join table
        joinColumns = @JoinColumn(name = "course_id"),  // Column in the join table that references the Student
        inverseJoinColumns = @JoinColumn(name = "sec_id")  // Column in the join table that references the Course
    )
    private List<Section> section;

    public Course(){

    }

    public Course(int course_id) {
        this.course_id = course_id;
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

    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }

   
}
