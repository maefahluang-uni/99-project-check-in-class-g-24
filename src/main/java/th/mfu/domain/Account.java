package th.mfu.domain;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    private Long acc_id;
    private String password;  
    private String std_email;
    private String lec_email;
    private String admin_email;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Student student;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Admin admin;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Lecturer lecturer;


    public Admin getAdmin() {
        return admin;
    }




    public void setAdmin(Admin admin) {
        this.admin = admin;
    }




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




    public Account(){


    }




    public Account(String password) {
        this.password = password;
    }


    public Long getAcc_id() {
        return acc_id;
    }




    public void setAcc_id(Long acc_id) {
        this.acc_id = acc_id;
    }




    public void setPassword(String password) {
        this.password = password;
    }




    public String getPassword() {
        return password;
    }




    public String getStd_email() {
        return std_email;
    }




    public void setStd_email(String std_email) {
        this.std_email = std_email;
    }




    public String getLec_email() {
        return lec_email;
    }




    public void setLec_email(String lec_email) {
        this.lec_email = lec_email;
    }




    public String getAdmin_email() {
        return admin_email;
    }




    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }


}
