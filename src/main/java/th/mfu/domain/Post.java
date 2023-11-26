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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;
    private String content;
    private String lec_input;
    private int week_no;
    private Long sec_id;

    @ManyToMany(cascade = CascadeType.ALL)
    // @JoinTable(
    //     name = "post",  // This is the name of the join table
    //     joinColumns = @JoinColumn(name = "p_id"),  
    //     inverseJoinColumns = @JoinColumn(name = "sec_id")  
    // )
    private List<Section> section;
    public Post(){
        
    }

    public String getLec_input() {
        return lec_input;
    }
    public void setLec_input(String lec_input) {
        this.lec_input = lec_input;
    }



    public int getWeek_no() {
        return week_no;
    }



    public void setWeek_no(int week_no) {
        this.week_no = week_no;
    }



    public Post(Long p_id) {
        this.p_id = p_id;
    } 
    public Long getP_id() {
        return p_id;
    }
    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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

    public void setSection(Section sec_id2) {
    }
    
}
