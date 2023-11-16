package th.mfu.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int std_num;
    private Long std_id;
    private String std_firstname;
    private String std_lastname;
    private String std_email;
    private int sec_id;
    private String std_password;
    private int c_id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> course;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Section> section;

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public String getStd_password() {
        return std_password;
    }

    public void setStd_password(String std_password) {
        this.std_password = std_password;
    }

    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }

    public Student(){

    }

    public int getStd_num() {
        return std_num;
    }

    public void setStd_num(int std_num) {
        this.std_num = std_num;
    }

    public Long getStd_id() {
        return std_id;
    }

    public void setStd_id(Long std_id) {
        this.std_id = std_id;
    }

    public String getStd_firstname() {
        return std_firstname;
    }

    public void setStd_firstname(String std_firstname) {
        this.std_firstname = std_firstname;
    }

    public String getStd_lastname() {
        return std_lastname;
    }

    public void setStd_lastname(String std_lastname) {
        this.std_lastname = std_lastname;
    }

    public String getStd_email() {
        return std_email;
    }

    public void setStd_email(String std_email) {
        this.std_email = std_email;
    }

    public int getSec_id() {
        return sec_id;
    }

    public void setSec_id(int sec_id) {

        this.sec_id=sec_id;
    }

    

}
