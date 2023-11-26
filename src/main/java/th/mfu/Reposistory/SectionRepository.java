package th.mfu.Reposistory;

import org.apache.tomcat.jni.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import th.mfu.domain.Course;
import th.mfu.domain.Section;

@Repository
public interface SectionRepository extends CrudRepository<Section, Long> {

    @Query(value = "SELECT * FROM Section WHERE course_id = :course_id", nativeQuery = true)
     Integer findSecNoByCourseID(@Param("course_id")int course_id);

    @Query(value = "SELECT s.sec_no FROM Section s " +
                "JOIN Student st ON st.sec_id = s.sec_id " +
                "WHERE st.std_email = :std_email", nativeQuery = true)
    List<Integer> findSecNoByStdEmail(@Param("std_email") String std_email);

     @Query(value = "SELECT s.sec_no FROM Section s " +
                "JOIN Lecturer lec ON lec.lec_id = s.lec_id " +
                "WHERE lec.lec_email = :lec_email", nativeQuery = true)
    List<Integer> findSecNoByLecEmail(@Param("lec_email") String lec_email);

    @Query("SELECT s FROM Section s WHERE s.course_id = :course_id AND s.sec_no = :sec_no")
    Section findByCourse_idAndSec_no(@Param("course_id")int course_id,@Param("sec_no")int sec_no);



}


