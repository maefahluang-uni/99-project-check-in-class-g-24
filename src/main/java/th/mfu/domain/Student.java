package th.mfu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long std_num;
    private Long std_id;
    private String first_name;
    private String last_name;
    private String std_email;
    @Column(name = "sec_id")
    private Long sec_id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Account account;

    // @ManyToMany(cascade = CascadeType.ALL, fetch  = FetchType.EAGER)
    // private Section section;

    public Student (){

    }

    public Student(Long std_num) {
        this.std_num = std_num;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getStd_id() {
        return std_id;
    }

    public void setStd_id(Long std_id) {
        this.std_id = std_id;
    }

    public String getStd_email() {
        return std_email;
    }

    public void setStd_email(String std_email) {
        this.std_email = std_email;
    }

    public Long getSec_id() {
        return sec_id;
    }

    public void setSec_id(Long sec_id) {
        this.sec_id = sec_id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getStd_num() {
        return std_num;
    }

    public void setStd_num(Long std_num) {
        this.std_num = std_num;
    }

    // public Section getSection() {
    //     return section;
    // }

    // public void setSection(Section section) {
    //     this.section = section;
    // }
}
