package ovh.spajste.langusta.youtube;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.youtube.entity.YoutubeAccessToken;
import ovh.spajste.langusta.youtube.repository.YoutubeAccessTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

@WebServlet("/youtube/authCallback")
public class YoutubeAuthCallbackServlet extends AbstractAuthorizationCodeCallbackServlet {

    @Value("${langusta.google.oauth.clientId}")
    private String langustaClientId;

    @Value("${langusta.google.oauth.clientSecret}")
    private String langustaClientSecret;

    @Autowired
    private YoutubeAccessTokenRepository youtubeAccessTokenRepository;

    @Autowired
    private SessionBuilder sessionBuilder;

    @Override
    protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
            throws ServletException, IOException {
        try {
            Session session = sessionBuilder.getCurrentSession(req);
            YoutubeAccessToken youtubeAccessToken = new YoutubeAccessToken(null, session.getUser().getId(), credential.getAccessToken(), new Date(((long)credential.getExpirationTimeMilliseconds()) * 1000L));
            youtubeAccessTokenRepository.save(youtubeAccessToken);
            resp.sendRedirect("/home");
        } catch (Exception e) {
            resp.sendRedirect("/error");
        }
    }

    @Override
    protected void onError(
            HttpServletRequest req, HttpServletResponse resp, AuthorizationCodeResponseUrl errorResponse)
            throws ServletException, IOException {
        resp.sendRedirect("/error");
    }

    @Override
    protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
        GenericUrl url = new GenericUrl(req.getRequestURL().toString());
        url.setRawPath("/youtube/authCallback");
        return url.build();
    }

    @Override
    protected AuthorizationCodeFlow initializeFlow() throws IOException {
        return new GoogleAuthorizationCodeFlow.Builder(
                new NetHttpTransport(), JacksonFactory.getDefaultInstance(),
                langustaClientId, langustaClientSecret,
                Collections.singleton("https://www.googleapis.com/auth/youtube.force-ssl")).setAccessType("offline").build();
    }

    @Override
    protected String getUserId(HttpServletRequest httpServletRequest) {
        return null;
    }
}
