package th.mfu.domain;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class Admin {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    private Long admin_id;
    private String admin_name;
    private String admin_email;


    @OneToOne( cascade = CascadeType.ALL)
    private Account account;


   


    public Admin(){


    }


    public Admin(Long admin_id) {
        this.admin_id = admin_id;
    }


    public Long getAdmin_id() {
        return admin_id;
    }


    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }


    public String getAdmin_name() {
        return admin_name;
    }


    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }


    public Account getAccount() {
        return account;
    }


    public void setAccount(Account account) {
        this.account = account;
    }


    public String getAdmin_email() {
        return admin_email;
    }


    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }


   


   


}
