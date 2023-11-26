package th.mfu.Reposistory;
import org.apache.tomcat.jni.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import th.mfu.domain.Attendance;
import th.mfu.domain.Course;
import th.mfu.domain.Post;
import th.mfu.domain.Section;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p JOIN Section s ON p.sec_id = s.sec_id WHERE s.course_id = :course_id")
    List<Post> findPostByCourseID(@Param("course_id") int course_id);

    @Query("SELECT p FROM Post p JOIN Section s ON p.sec_id = s.sec_id WHERE s.sec_id = :sec_id")
    List<Post> findPostBySec_id(@Param("sec_id") Long sec_id);
    
    void save(String new_post);

    void save(Section sec_id);

    

    


}
