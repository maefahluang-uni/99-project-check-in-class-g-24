package th.mfu.Reposistory;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Lecturer;

public interface LecturerRepository extends CrudRepository<Lecturer,Long> {
    
}
