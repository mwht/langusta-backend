package ovh.spajste.langusta.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.repository.SessionRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Bridge/glue code between Langusta controllers and Google servlets.
 */
@RestController
public class YoutubeAuthController {

    @Autowired
    private SessionBuilder sessionBuilder;

    @Autowired
    private SessionRepository sessionRepository;

    @Value("${langusta.hmac-secret}")
    private String langustaHmacSecret;

    @GetMapping("/youtube/createAuth/{authToken}")
    public GenericStatus createYoutubeAuthRequest(@PathVariable("authToken") String authToken, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.buildFromJWT(authToken, langustaHmacSecret, sessionRepository);
            httpServletResponse.setStatus(301);
            httpServletResponse.addHeader("Set-Cookie", "ytauth="+session.getTrackingId()+"; path=/api");
            httpServletResponse.addHeader("Location", "/api/youtube/beginAuth");
            return GenericStatus.createSuccessfulStatus(null);
        } catch (Exception e) {
            try {
                httpServletResponse.sendRedirect("/error");
                return GenericStatus.createFailedStatusWithAdditionalInfo(e.getMessage(), e);
            } catch (Exception ee) {
                ee.printStackTrace(); // something went *REALLY* wrong here
                return GenericStatus.createFailedStatusWithAdditionalInfo(ee.getMessage(), ee);
            }
        }
    }
}
