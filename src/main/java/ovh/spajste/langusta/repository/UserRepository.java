package ovh.spajste.langusta.repository;

import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.entity.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByEmail(String email);
}
