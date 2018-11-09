package ovh.spajste.langusta.facebook.repository;

import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.facebook.entity.FacebookPostLogEntry;

public interface FacebookPostLogEntryRepository extends CrudRepository<FacebookPostLogEntry, Integer> {
}
