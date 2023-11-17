package th.mfu.Reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import th.mfu.domain.Course;
import th.mfu.domain.Section;
import th.mfu.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,String>{

    @Query(value = "SELECT * FROM student WHERE std_email = :std_email", nativeQuery = true)
    List<Student> findAllByStd_email(@Param("std_email") String std_email); 

    @Query(value = "SELECT * FROM student WHERE std_email = :std_email", nativeQuery = true)
    Student findByStd_email(@Param("std_email") String std_email);

    // @Query(value = "SELECT * FROM student WHERE std_email = :std_email", nativeQuery = true)
    // List<Course> findAllByStd_list(List<Student> s); 
    
}
