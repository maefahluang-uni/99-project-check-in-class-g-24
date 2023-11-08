package th.mfu.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
@Entity
public class Section {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int sec_id;
    private int course_id;
    private String Lec_id;
    private int sec_no;

    @ManyToMany(cascade = CascadeType.ALL)
    private Course course;

    

    public Section(){

    }

    public int getSec_id() {
        return sec_id;
    }

    public void setSec_id(int sec_id) {
        this.sec_id = sec_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getLec_id() {
        return Lec_id;
    }

    public void setLec_id(String lec_id) {
        Lec_id = lec_id;
    }

    public int getSec_no() {
        return sec_no;
    }

    public void setSec_no(int sec_no) {
        this.sec_no = sec_no;
    }

    

}
