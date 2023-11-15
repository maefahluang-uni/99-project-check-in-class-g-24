package th.mfu.Reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.mfu.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{
    
}
