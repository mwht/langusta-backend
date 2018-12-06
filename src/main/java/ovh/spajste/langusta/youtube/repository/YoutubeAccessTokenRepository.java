package ovh.spajste.langusta.youtube.repository;

import org.springframework.data.repository.CrudRepository;
import ovh.spajste.langusta.youtube.entity.YoutubeAccessToken;

public interface YoutubeAccessTokenRepository extends CrudRepository<YoutubeAccessToken, Integer> {
}
