package th.mfu.Reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.mfu.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,String>{    
    
}
