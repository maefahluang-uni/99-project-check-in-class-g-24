package th.mfu.Reposistory;


import org.apache.tomcat.jni.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


import th.mfu.domain.Account;
import th.mfu.domain.Student;


@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    @Query(value = "SELECT * FROM Account WHERE std_email = :std_email", nativeQuery = true)
    Account findByStd_email(@Param("std_email") String std_email);


    // @Query(value = "SELECT * FROM Account WHERE std_email = :std_email", nativeQuery = true)
    // String findByStd_email(@Param("std_email") String std_email);


    @Query(value = "SELECT * FROM Account WHERE lec_email = :lec_email", nativeQuery = true)
    Account findByLec_email(@Param("lec_email") String lec_email);




    @Query(value = "SELECT * FROM Account WHERE admin_email = :admin_email", nativeQuery = true)
    Account findByAdmin_email(@Param("admin_email") String admin_email);
}
