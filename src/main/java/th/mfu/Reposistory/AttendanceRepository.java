package th.mfu.Reposistory;

import org.apache.tomcat.jni.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import th.mfu.domain.Attendance;
import th.mfu.domain.Section;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

     @Query("SELECT a FROM Attendance a WHERE a.sec_id= :sec_id AND a.week_no = :week_no")
    List<Attendance> findByCourse_idAndSec_no(@Param("sec_id")Long sec_id,@Param("week_no")int week_no);
  
}