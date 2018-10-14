package ovh.spajste.langusta.repository;

import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
