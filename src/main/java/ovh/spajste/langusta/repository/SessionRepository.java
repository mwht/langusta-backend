package ovh.spajste.langusta.repository;


import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.entity.Session;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Integer> {
    List<Session> findBySessionToken(String sessionToken);
}
