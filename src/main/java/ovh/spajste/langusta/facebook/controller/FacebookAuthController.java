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
import ovh.spajste.langusta.repository.SessionRepository;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.Cookie;
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

    @Autowired
    private SessionRepository sessionRepository;

    @Value("${langusta.hmac-secret}")
    private String langustaHmacSecret;

    @Autowired
    private SessionBuilder sessionBuilder;

    @CrossOrigin(origins = "*")
    @GetMapping("/facebook/authSuccess")
    public GenericStatus onFacebookAuthSuccess(@RequestParam(value = "code", defaultValue = "") String code, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if(code.equals("")) {
            httpServletResponse.setStatus(301);
            httpServletResponse.addHeader("Location", "/home");
            return GenericStatus.createSuccessfulStatus(null);
        }

        try {
            //if(httpServletRequest.getHeader("X-Auth-Token") == null) throw new java.lang.IllegalAccessException("No Langusta auth token provided.");
            String trackingId = null;
            for(Cookie cookie: httpServletRequest.getCookies()) {
                if(cookie.getName().equals("fbauth")) {
                    trackingId = cookie.getValue();
                    break;
                }
            }
            Optional<Session> sessionHandle = sessionRepository.findByTrackingId(trackingId);
            if(!sessionHandle.isPresent()) throw new java.lang.IllegalAccessException("Invalid Langusta auth token.");
            Session session = sessionHandle.get();
            String accessToken = facebookService.createFacebookAccessToken(code);
            FacebookAccessToken facebookAccessToken = new FacebookAccessToken(
                    null,
                    session.getUser(),
                    accessToken
            );
            facebookAccessTokenRepository.save(facebookAccessToken);
            httpServletResponse.setStatus(301);
            httpServletResponse.addHeader("Location", "/home");
            return GenericStatus.createSuccessfulStatus(BasicFacebookAccessTokenDataView.getDataViewFor(facebookAccessToken));

        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "Can't obtain access token.", e);
        }
    }

    @GetMapping("/facebook/tokens")
    public GenericStatus getUserTokens(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
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
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, null, e);
        }
    }

    @GetMapping("/facebook/createAuth/{authToken}")
    public GenericStatus generateAuth(@PathVariable("authToken") String authToken, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            /*if (httpServletRequest.getHeader("X-Auth-Token") == null)
                throw new java.lang.IllegalAccessException("No Langusta auth token provided.");*/
            Session session = sessionBuilder.buildFromJWT(authToken, langustaHmacSecret, sessionRepository);
            httpServletResponse.setStatus(301);
            httpServletResponse.addHeader("Set-Cookie", "fbauth="+session.getTrackingId()+"; path=/api");
            httpServletResponse.addHeader("Location", facebookService.createFacebookAuthorizationURL());
            return GenericStatus.createSuccessfulStatus(null);
        } catch (Exception e) {
            httpServletResponse.setStatus(400);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "Can't query for Facebook access token.", e);
        }
    }
}
