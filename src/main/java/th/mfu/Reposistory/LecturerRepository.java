package th.mfu.Reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import th.mfu.domain.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer,String> {
    
}
