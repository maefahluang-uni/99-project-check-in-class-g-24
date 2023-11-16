package th.mfu.Reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import th.mfu.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{

    @Query(value = "SELECT * FROM Course WHERE Lec_id = :Lec_id", nativeQuery = true)
    List<Course> findAllByLecId(@Param("Lec_id") String Lec_id);

    @Query(value = "SELECT * FROM Course WHERE lec_email = :lec_email", nativeQuery = true)
    List<Course> findAllByLec_email(@Param("lec_email") String lec_email);
    
    @Query(value = "SELECT * FROM Course WHERE std_email = :std_email", nativeQuery = true)
    List<Course> findAllByStd_emailCourses(@Param("std_email") String std_email);    

}
