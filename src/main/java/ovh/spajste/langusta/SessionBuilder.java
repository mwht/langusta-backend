package ovh.spajste.langusta;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.repository.UserRepository;

import java.util.Date;
import java.util.NoSuchElementException;

public class SessionBuilder {

    @Autowired
    private static UserRepository userRepository;

    public static Session buildFromJWT(String token, String secret) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512(secret))
                                         .withIssuer("SpajsTech Inc.")
                                         .build();
            DecodedJWT jwt = jwtVerifier.verify(token);
            if(new Date().after(jwt.getExpiresAt())) {
                throw new TokenExpiredException("Token expired.");
            } else {
                try {
                    System.err.println(jwt.getClaim("trackingId").asString() + " " + userRepository.findById(jwt.getClaim("id").asInt()).get());
                } catch (NoSuchElementException nsee) {
                    nsee.printStackTrace();
                }
                Session result = new Session(
                      -1,
                      jwt.getClaim("trackingId").asString(),
                      userRepository.findById(jwt.getClaim("id").asInt()).get(),
                      jwt.getIssuedAt(),
                        null,
                        null
                );
                return result;
            }
        } catch (JWTVerificationException jve) {
            return null;
        }
    }
}
