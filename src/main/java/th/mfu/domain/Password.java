package th.mfu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Password {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String password_id;
    private String std_id;
    private Long lec_id;
    private long admin_id;

    @OneToOne(cascade = CascadeType.ALL)
    private Lecturer lecturer;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Password(){
        
    }

    public String getPassword_id() {
        return password_id;
    }

    public void setPassword_id(String password_id) {
        this.password_id = password_id;
    }

    public String getStd_id() {
        return std_id;
    }

    public void setStd_id(String std_id) {
        this.std_id = std_id;
    }

    public Long getLec_id() {
        return lec_id;
    }

    public void setLec_id(Long lec_id) {
        this.lec_id = lec_id;
    }

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
    }
    
    

}
