package ovh.spajste.langusta.facebook.repository;

import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.facebook.entity.FacebookAccessToken;

import java.util.List;
import java.util.Optional;

public interface FacebookAccessTokenRepository extends CrudRepository<FacebookAccessToken, Integer> {
    List<FacebookAccessToken> findByUserId(int userId);
}
