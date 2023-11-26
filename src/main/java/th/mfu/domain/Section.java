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
public class Section {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sec_id")
    private Long sec_id;
    private int course_id;
    private String lec_id;
    private int sec_no;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "enrollments",  // This is the name of the join table
        joinColumns = @JoinColumn(name = "sec_id"),  
        inverseJoinColumns = @JoinColumn(name = "std_num")  
    )
    private List<Student> student;

    

    public Section(){

    }

    public Section(Long sec_id) {
        this.sec_id = sec_id;
    }


    public Long getSec_id() {
        return sec_id;
    }

    public void setSec_id(Long sec_id) {
        this.sec_id = sec_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getLec_id() {
        return lec_id;
    }

    public void setLec_id(String lec_id) {
        this.lec_id = lec_id;
    }

    public int getSec_no() {
        return sec_no;
    }

    public void setSec_no(int sec_no) {
        this.sec_no = sec_no;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
    

}
