package th.mfu.Reposistory;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Course;

public interface CourseRepository extends CrudRepository<Course,Long>{
    
}
