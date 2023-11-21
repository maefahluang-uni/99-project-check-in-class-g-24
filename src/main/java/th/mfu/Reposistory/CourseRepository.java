package th.mfu.Reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import th.mfu.domain.Course;
import th.mfu.domain.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{

    @Query(value = "SELECT * FROM Course WHERE Lec_id = :Lec_id", nativeQuery = true)
    List<Course> findAllByLecId(@Param("Lec_id") String Lec_id);

    // @Query(value = "SELECT * FROM Course WHERE lec_email = :lec_email", nativeQuery = true)
    // List<Course> findAllByLec_email(@Param("lec_email") String lec_email);

    @Query(value = "SELECT * FROM Course WHERE course_id = :course_id And course_sec = :course_sec", nativeQuery = true)
    Course findByIdAndSec(@Param("course_id") int course_id,@Param("course_sec") int course_sec);

}
