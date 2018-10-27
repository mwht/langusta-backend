package ovh.spajste.langusta.facebook.repository;

import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.facebook.entity.FacebookAccessToken;

public interface FacebookAccessTokenRepository extends CrudRepository<FacebookAccessToken, Integer> {
}
