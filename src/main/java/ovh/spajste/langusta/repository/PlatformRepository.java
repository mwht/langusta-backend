package ovh.spajste.langusta.repository;

import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.entity.Platform;

import java.util.Optional;

public interface PlatformRepository extends CrudRepository<Platform, Integer> {
    Optional<Platform> findPlatformByCanonicalName(String canonicalName);
}
