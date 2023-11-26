package th.mfu.domain;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class Lecturer {
   
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)


    private String lec_id;
    private String first_name;
    private String last_name;
    private String lec_email;


    @OneToOne (cascade = CascadeType.ALL)
    private Account account;
    
     @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Section> sections;

    //  @ManyToOne // Assuming many lecturers can be associated with one section
    // @JoinColumn(name = "sec_id") // Adjust this based on your actual database schema
    // private Section section; 


    public Lecturer(){


    }


    public Lecturer(String lec_id) {
        this.lec_id = lec_id;
    }


    public String getLec_id() {
        return lec_id;
    }


    public void setLec_id(String lec_id) {
        this.lec_id = lec_id;
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


    public String getLec_email() {
        return lec_email;
    }


    public void setLec_email(String lec_email) {
        this.lec_email = lec_email;
    }


    public Account getAccount() {
        return account;
    }


    public void setAccount(Account account) {
        this.account = account;
    }


   


}
