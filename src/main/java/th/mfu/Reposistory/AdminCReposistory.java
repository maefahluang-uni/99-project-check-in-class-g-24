package th.mfu.Reposistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.mfu.domain.AdminC;

@Repository
public interface AdminCReposistory extends JpaRepository<AdminC, String> {
    
}
