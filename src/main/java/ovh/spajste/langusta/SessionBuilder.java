package ovh.spajste.langusta;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.entity.User;
import ovh.spajste.langusta.repository.SessionRepository;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SessionBuilder {

    @Autowired
    SessionRepository sessionRepository;

    @Value("${langusta.hmac-secret}")
    private String langustaHmacSecret;

    public Session getCurrentSession(HttpServletRequest httpServletRequest) {
        String jwtToken= null;
        if(httpServletRequest.getHeader("X-Auth-Token") != null) {
            jwtToken = httpServletRequest.getHeader("X-Auth-Token");
        }
        else {
            if(httpServletRequest.getHeader("Authorization") != null) {
                Pattern regex = Pattern.compile("^Bearer (.*)");
                Matcher regexMatcher = regex.matcher(httpServletRequest.getHeader("Authorization"));
                try {
                    while (regexMatcher.find())
                        jwtToken = regexMatcher.group(1);
                } catch (NullPointerException npe) {
                    throw new SecurityException("Unparsable Langusta token supplied!");
                }
            } else {
                throw new SecurityException("No valid Langusta token supplied!");
            }
        }

        Session resultSession = buildFromJWT(jwtToken, langustaHmacSecret, sessionRepository);
        return resultSession;
    }

    public Session buildFromJWT(String token, String secret, SessionRepository sessionRepository) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512(secret))
                                         .withIssuer("SpajsTech Inc.")
                                         .build();
            DecodedJWT jwt = jwtVerifier.verify(token);
            Session session = null;
            if(new Date().after(jwt.getExpiresAt())) {
                throw new TokenExpiredException("Token expired.");
            } else {
                try {
                    session = sessionRepository.findByTrackingId(jwt.getClaim("trackingId").asString()).get();
                } catch (NoSuchElementException nsee) {
                    throw new IllegalStateException("Session does not exist.");
                }
                return session;
            }
        } catch (JWTVerificationException jve) {
            throw jve;
        }
    }
}
