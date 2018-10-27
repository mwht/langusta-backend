package ovh.spajste.langusta;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.entity.User;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SessionBuilder {

    public static Session getCurrentSession(String secret, UserRepository userRepository, HttpServletRequest httpServletRequest) {
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

        Session resultSession = buildFromJWT(jwtToken, secret, userRepository);
        return resultSession;
    }

    public static Session buildFromJWT(String token, String secret, UserRepository userRepository) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512(secret))
                                         .withIssuer("SpajsTech Inc.")
                                         .build();
            DecodedJWT jwt = jwtVerifier.verify(token);
            User userToAuth = User.getNullUser();
            if(new Date().after(jwt.getExpiresAt())) {
                throw new TokenExpiredException("Token expired.");
            } else {
                try {
                    userToAuth = userRepository.findById(jwt.getClaim("id").asInt()).get();
                } catch (NoSuchElementException nsee) {
                    throw new IllegalStateException("User associated with session does not exist.");
                }
                Session result = new Session(
                      -1,
                      jwt.getClaim("trackingId").asString(),
                      userToAuth,
                      jwt.getIssuedAt(),
                        null,
                        null
                );
                return result;
            }
        } catch (JWTVerificationException jve) {
            throw jve;
        }
    }
}
