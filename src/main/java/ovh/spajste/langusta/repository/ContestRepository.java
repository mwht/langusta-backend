package ovh.spajste.langusta.repository;

import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.entity.Contest;

public interface ContestRepository extends CrudRepository<Contest, Integer> {
}
