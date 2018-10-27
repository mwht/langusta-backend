package ovh.spajste.langusta.facebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.facebook.entity.FacebookAccessToken;
import ovh.spajste.langusta.facebook.entity.FacebookProfile;
import ovh.spajste.langusta.facebook.repository.FacebookAccessTokenRepository;
import ovh.spajste.langusta.facebook.service.FacebookService;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class FacebookUserProfileController {

    @Autowired
    private FacebookAccessTokenRepository facebookAccessTokenRepository;

    @Autowired
    private FacebookService facebookService;

    @Value("${langusta.hmac-secret}")
    private String langustaHmacSecret;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/facebook/profile/{id}")
    public GenericStatus getFacebookProfile(@PathVariable("id") String id) {
        return GenericStatus.createSuccessfulStatus(null);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/facebook/profile/me")
    public GenericStatus getMineFacebookProfile(HttpServletRequest httpServletRequest) {
        try {
            Session session = SessionBuilder.getCurrentSession(langustaHmacSecret, userRepository, httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens != null) {
                FacebookAccessToken facebookAccessToken = facebookAccessTokens.get(0);
                facebookService.setAccessToken(facebookAccessToken.getAccessToken());
            } else {
                throw new NoSuchElementException("No Facebook access tokens found!");
            }
            FacebookProfile myFacebookProfile = facebookService.getMyProfile();
            return GenericStatus.createSuccessfulStatus(myFacebookProfile);
        } catch(Exception e) {
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

}
