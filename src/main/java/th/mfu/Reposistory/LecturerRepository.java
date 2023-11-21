package th.mfu.Reposistory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import th.mfu.domain.Course;
import th.mfu.domain.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, String> {
    
    @Query(value = "SELECT * FROM lecturer WHERE Lec_id = :lec_id", nativeQuery = true)
    Lecturer findByLec_id(String lec_id);

    // Lecturer findByCourse_id(int lec_cid,int lec_sec);


    @Query(value = "SELECT * FROM lecturer WHERE lec_email = :lec_email", nativeQuery = true)
    Lecturer findByLec_email(String lec_email);
    
    
}