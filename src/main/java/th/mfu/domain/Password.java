package th.mfu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Password {
    
    @Id
    private String password_id;

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


    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
    }
    
    

}
