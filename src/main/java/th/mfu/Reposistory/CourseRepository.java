package th.mfu.Reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import th.mfu.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{

    @Query(value = "SELECT * FROM Course WHERE Lec_id = :lecId", nativeQuery = true)
    List<Course> findAllByLecId(@Param("lecId") String lecId);
    
}
