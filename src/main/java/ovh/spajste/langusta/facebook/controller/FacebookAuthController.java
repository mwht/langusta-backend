package ovh.spajste.langusta.facebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.facebook.dataview.BasicFacebookAccessTokenDataView;
import ovh.spajste.langusta.facebook.entity.FacebookAccessToken;
import ovh.spajste.langusta.facebook.repository.FacebookAccessTokenRepository;
import ovh.spajste.langusta.facebook.service.FacebookService;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FacebookAuthController {

    @Autowired
    private FacebookService facebookService;

    @Autowired
    private FacebookAccessTokenRepository facebookAccessTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Value("${langusta.hmac-secret}")
    private String langustaHmacSecret;

    // TODO: limit returned amount of data
    @CrossOrigin(origins = "*")
    @GetMapping("/facebook/authSuccess/{authToken}")
    public GenericStatus onFacebookAuthSuccess(@RequestParam("code") String code, @PathVariable("authToken") String authToken, HttpServletRequest httpServletRequest) {
        try {
            //if(httpServletRequest.getHeader("X-Auth-Token") == null) throw new java.lang.IllegalAccessException("No Langusta auth token provided.");
            String langustaAuthToken = authToken;
            String accessToken = facebookService.createFacebookAccessToken(code, langustaAuthToken);
            Session session = SessionBuilder.buildFromJWT(langustaAuthToken, langustaHmacSecret, userRepository);
            if(session == null) throw new java.lang.IllegalAccessException("Invalid Langusta auth token.");
            FacebookAccessToken facebookAccessToken = new FacebookAccessToken(
                    null,
                    session.getUser(),
                    accessToken
            );
            facebookAccessTokenRepository.save(facebookAccessToken);
            return GenericStatus.createSuccessfulStatus(facebookAccessToken);

        } catch (Exception e) {
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "Can't obtain access token.", e);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/facebook/tokens")
    public GenericStatus getUserTokens(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = SessionBuilder.getCurrentSession(langustaHmacSecret, userRepository, httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens != null) {
                List<BasicFacebookAccessTokenDataView> basicFacebookAccessTokenDataViews = new ArrayList<>();
                facebookAccessTokens.forEach(token -> basicFacebookAccessTokenDataViews.add(BasicFacebookAccessTokenDataView.getDataViewFor(token)));
                return GenericStatus.createSuccessfulStatus(basicFacebookAccessTokenDataViews);
            } else {
                httpServletResponse.setStatus(204);
                return GenericStatus.createSuccessfulStatus(null);
            }
        } catch (Exception e) {
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, null, e);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/facebook/createAuth/{authToken}")
    public GenericStatus generateAuth(@PathVariable("authToken") String authToken, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            /*if (httpServletRequest.getHeader("X-Auth-Token") == null)
                throw new java.lang.IllegalAccessException("No Langusta auth token provided.");*/
            httpServletResponse.setStatus(301);
            httpServletResponse.addHeader("Location", facebookService.createFacebookAuthorizationURL(authToken));
            return GenericStatus.createSuccessfulStatus(null);
        } catch (Exception e) {
            httpServletResponse.setStatus(400);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "Can't query for Facebook access token.", e);
        }
    }
}
