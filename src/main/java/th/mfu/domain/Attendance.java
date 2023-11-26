package th.mfu.domain;

import java.util.List;
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
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long att_id;
    private int std_num;
    private boolean status;
    private String std_input;
    private int week_no;
    private Long sec_id;

    @ManyToMany (cascade = CascadeType.ALL)
    private List<Section> section;

    public Attendance (){

    }

    public Long getAtt_id() {
        return att_id;
    }
   
public String getStd_input() {
    return std_input;
}
public void setStd_input(String std_input) {
    this.std_input = std_input;
}
 public void setAtt_id(Long att_id) {
        this.att_id = att_id;
    }
    public int getStd_num() {
        return std_num;
    }
    public void setStd_num(int std_num) {
        this.std_num = std_num;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getWeek_no() {
        return week_no;
    }
    public void setWeek_no(int week_no) {
        this.week_no = week_no;
    }
    public Long getSec_id() {
        return sec_id;
    }
    public void setSec_id(Long sec_id) {
        this.sec_id = sec_id;
    }
    public List<Section> getSection() {
        return section;
    }
    public void setSection(List<Section> section) {
        this.section = section;
    }

}
