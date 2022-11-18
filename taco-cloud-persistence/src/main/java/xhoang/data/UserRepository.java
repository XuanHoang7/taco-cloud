package xhoang.data;
import org.springframework.data.repository.CrudRepository;
import xhoang.tacos.User;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
  
}
