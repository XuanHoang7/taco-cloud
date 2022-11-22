package xhoang.data;
import org.springframework.data.repository.CrudRepository;
import xhoang.tacos.User;

import javax.persistence.Table;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
  
}
