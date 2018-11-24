package ovh.spajste.langusta.facebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.facebook.entity.FacebookAccessToken;
import ovh.spajste.langusta.facebook.entity.FacebookProfile;
import ovh.spajste.langusta.facebook.repository.FacebookAccessTokenRepository;
import ovh.spajste.langusta.facebook.service.FacebookService;
import ovh.spajste.langusta.repository.SessionRepository;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class FacebookUserProfileController {

    @Autowired
    private FacebookAccessTokenRepository facebookAccessTokenRepository;

    @Autowired
    private FacebookService facebookService;

    @Autowired
    private SessionBuilder sessionBuilder;


    @GetMapping("/facebook/profile/{id}")
    public GenericStatus getFacebookProfile(@PathVariable("id") String id) {
        return GenericStatus.createSuccessfulStatus(null);
    }

    @GetMapping("/facebook/profile/me")
    public GenericStatus getMineFacebookProfile(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
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
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

    /*
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/facebook/profile/post", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public GenericStatus addNewPostOnProfile(@RequestParam String content, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = SessionBuilder.getCurrentSession(langustaHmacSecret, userRepository, httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens != null) {
                FacebookAccessToken facebookAccessToken = facebookAccessTokens.get(0);
                facebookService.setAccessToken(facebookAccessToken.getAccessToken());
            } else {
                throw new NoSuchElementException("No Facebook access tokens found!");
            }

            facebookService.addNewPost(content);
            httpServletResponse.setStatus(201);
            return GenericStatus.createSuccessfulStatus(null);
        } catch (Exception e) {
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }
    */
}
