package ovh.spajste.langusta.repository;

import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.entity.Contest;
import ovh.spajste.langusta.entity.User;

import java.util.List;

public interface ContestRepository extends CrudRepository<Contest, Integer> {
    List<Contest> findContestByUser(User user);
}
