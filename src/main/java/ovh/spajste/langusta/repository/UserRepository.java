package ovh.spajste.langusta.repository;

import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByEmail(String email);
    Optional<User> findByActivationCode(String activationCode);
}
