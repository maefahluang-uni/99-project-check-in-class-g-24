package th.mfu.Reposistory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.mfu.domain.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, String> {

    // @Query(value = "SELECT * FROM lecturer WHERE Lec_email = :lec_email", nativeQuery = true)
    // Lecturer findByLec_email(String lec_email);
    
    
}