package th.mfu.domain;

import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class Lecturer {
    
    @Id
    private String lec_email;
    
    private String Lec_id;
    private String lec_firstname;
    private String lec_lastname;
    private String lec_password;
    //===========
    // private int lec_cid;
    // private int lec_sec;

    @ManyToMany(cascade = CascadeType.ALL)    
    private List<Section> section;

    
    public Lecturer(){
        
    }

    public String getLec_password() {
        return lec_password;
    }

    public void setLec_password(String lec_password) {
        this.lec_password = lec_password;
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

    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }
    

    // public int getLec_cid() {
    //     return lec_cid;
    // }

    // public void setLec_cid(int lec_cid) {
    //     this.lec_cid = lec_cid;
    // }

    // public int getLec_sec() {
    //     return lec_sec;
    // }

    // public void setLec_sec(int lec_sec) {
    //     this.lec_sec = lec_sec;
    // }

    

}
