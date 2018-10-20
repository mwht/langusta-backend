package ovh.spajste.langusta.repository;


import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.entity.Session;

import java.util.Optional;

public interface SessionRepository extends CrudRepository<Session, Integer> {
    Optional<Session> findBySessionToken(String sessionToken);
}
