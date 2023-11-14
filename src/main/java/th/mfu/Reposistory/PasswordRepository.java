package th.mfu.Reposistory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Password;

public interface PasswordRepository extends CrudRepository<Password, String> {

    
}