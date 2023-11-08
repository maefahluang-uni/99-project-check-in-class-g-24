package th.mfu.domain;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lecturer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String Lec_id;
    private String lec_firstname;
    private String lec_lastname;
    private String lec_email;

    @OneToMany(cascade = CascadeType.ALL)    
    private Section section;

    public Lecturer(){
        
    }

    public String getLec_id() {
        return Lec_id;
    }

    public void setLec_id(String lec_id) {
        Lec_id = lec_id;
    }

    public String getLec_firstname() {
        return lec_firstname;
    }

    public void setLec_firstname(String lec_firstname) {
        this.lec_firstname = lec_firstname;
    }

    public String getLec_lastname() {
        return lec_lastname;
    }

    public void setLec_lastname(String lec_lastname) {
        this.lec_lastname = lec_lastname;
    }

    public String getLec_email() {
        return lec_email;
    }

    public void setLec_email(String lec_email) {
        this.lec_email = lec_email;
    }

    
    
}
