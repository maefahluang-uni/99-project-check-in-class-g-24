package th.mfu.Reposistory;

import org.apache.tomcat.jni.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import th.mfu.domain.Account;
import th.mfu.domain.Student;
import th.mfu.domain.Section;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
   
    @Query(value = "SELECT * FROM Student WHERE std_email = :std_email", nativeQuery = true)
    List<Student> findByStd_email(@Param("std_email") String std_email);

    @Query(value = "SELECT st.* FROM Student st " +
    "JOIN Section s ON st.sec_id = s.sec_id " +
    "JOIN Course c ON s.course_id = c.course_id " +
    "WHERE s.course_id = :course_id AND s.sec_id = :sec_id ", nativeQuery = true)
    List<Student> findByCourse_idAndSec_id(@Param("course_id") int course_id , @Param("sec_id") Long sec_id);


    // @Query(value = "SELECT * FROM Student WHERE std_email = :std_email", nativeQuery = true)
    // Student findByStd(@Param("std_email") String std_email);

    @Query(value = "SELECT * FROM Student s WHERE s.std_num = :std_num", nativeQuery = true)
    Student findByStd_num(@Param("std_num") Long std_num);
    
    @Query("SELECT COUNT(DISTINCT s.std_id) FROM Student s")
    Integer countDistinctStudent();

}