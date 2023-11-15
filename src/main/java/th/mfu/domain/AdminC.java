 package th.mfu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class AdminC {

    @Id
    private String admin_email;
    private String admin_password;
    

    public AdminC(){
        
    }


    public String getAdmin_email() {
        return admin_email;
    }


    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }


    public String getAdmin_password() {
        return admin_password;
    }


    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    
}