package th.mfu.Reposistory;

import org.apache.tomcat.jni.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import th.mfu.domain.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, String> {

    @Query(value = "SELECT * FROM Lecturer WHERE lec_id = :lec_id", nativeQuery = true)
    Lecturer findByLec_id(@Param("lec_id") String lec_id);
    
    @Query(value = "SELECT * FROM Lecturer WHERE lec_email = :lec_email", nativeQuery = true)
    Lecturer findByLec_email(@Param("lec_email") String lec_email);
   
}
