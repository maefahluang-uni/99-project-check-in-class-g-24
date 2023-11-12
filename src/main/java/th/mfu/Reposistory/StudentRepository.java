package th.mfu.Reposistory;

import org.springframework.data.repository.CrudRepository;
import th.mfu.domain.Student;

public interface StudentRepository extends CrudRepository<Student,Long>{
    
}
