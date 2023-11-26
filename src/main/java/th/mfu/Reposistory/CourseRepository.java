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

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT * FROM Course WHERE course_id = :course_id", nativeQuery = true)
    Course findByCourse_id(@Param("course_id") int course_id);

    // @Query(value = "SELECT * FROM Section WHERE course_id = :course_id", nativeQuery = true)
    // List<Course> findBySec_id(@Param("course_id") int course_id);
    
    // @Query(value = "SELECT * FROM Course c JOIN Section s ON c.course_id = s.course_id WHERE s.sec_id = :sec_id", nativeQuery = true)
    // List<Course> findBySec_id(@Param("sec_id") int sec_id);

    @Query(value = "SELECT c.* FROM Course c " +
               "JOIN Section s ON c.course_id = s.course_id " +
               "JOIN Student st ON st.sec_id = s.sec_id " +
               "WHERE st.std_email = :std_email", nativeQuery = true)
    List<Course> findByStudentEmail(@Param("std_email") String std_email);

    @Query(value = "SELECT c.* FROM Course c " +
               "JOIN Section s ON c.course_id = s.course_id " +
               "JOIN Lecturer lec ON lec.lec_id = s.lec_id " +
               "WHERE lec.lec_email = :lec_email", nativeQuery = true)
    List<Course> findByLecturerEmail(@Param("lec_email") String lec_email);
} 

