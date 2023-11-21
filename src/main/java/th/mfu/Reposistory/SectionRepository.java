package th.mfu.Reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

import th.mfu.domain.Course;
import th.mfu.domain.Section;
import th.mfu.domain.Student;

@Repository
public interface SectionRepository extends JpaRepository<Section,Integer> {

    @Query(value = "SELECT * FROM Section WHERE course_id = :course_id", nativeQuery = true)
    List<Section> findAllByCourse_id(@Param("course_id")int course_id);

    @Query(value = "SELECT * FROM Section WHERE course_id = :course_id And sec_no = :sec_no", nativeQuery = true)
    Section findByCourse_idandSection_id(@Param("course_id")int course_id , @Param("sec_no")int sec_no);

}
