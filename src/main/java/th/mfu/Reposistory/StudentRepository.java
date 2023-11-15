package th.mfu.Reposistory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import th.mfu.domain.Student;

// @Repository
public interface StudentRepository extends CrudRepository<Student,String>{

    public List<Student> findByStudentId(Long student_Id);
    public List<Student> deleteByStudentId(long id);
    
}
