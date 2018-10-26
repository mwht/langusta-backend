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

import java.util.Date;
import java.util.NoSuchElementException;

public class SessionBuilder {

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
                    nsee.printStackTrace();
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
