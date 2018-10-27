package ovh.spajste.langusta.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ovh.spajste.langusta.LoginStatus;
import ovh.spajste.langusta.PlainLoginParameters;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.entity.User;
import ovh.spajste.langusta.repository.SessionRepository;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Value("${langusta.hmac-secret}")
    private String langustaHmacSecret;

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/login", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public LoginStatus login(@RequestBody MultiValueMap<String, String> formData, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if(formData.containsKey("login")) {
            if(formData.containsKey("pass")) {

                try {
                    User userToAuth = userRepository.findByEmail(formData.get("login").get(0)).get(0);
                    if(formData.get("pass").get(0).equals(userToAuth.getPass())) {
                        String trackingId = Session.getNewToken();
                        String ipAddress = httpServletRequest.getHeader("X-Forwarded-For");
                        if(ipAddress == null) httpServletRequest.getRemoteAddr();

                        String userAgent = httpServletRequest.getHeader("User-Agent");
                        if(userAgent == null) userAgent = "";

                        Session validSession = new Session(null, trackingId, userToAuth, new Date(), ipAddress, userAgent);
                        String token = JWT.create().withIssuer("SpajsTech Inc.").withIssuedAt(new Date()).withClaim("id", validSession.getUser().getId()).withClaim("trackingId", validSession.getTrackingId()).withExpiresAt(validSession.getExpiryDate()).sign(Algorithm.HMAC512(langustaHmacSecret));
                        sessionRepository.save(validSession);
                        return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_SUCCESS, userToAuth.getId(), token);
                    } else {
                        httpServletResponse.setStatus(401);
                        return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -1, null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    httpServletResponse.setStatus(401);
                    return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -2, null);
                }

            } else {
                httpServletResponse.setStatus(400);
                return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -3, null);
            }
        } else {
            httpServletResponse.setStatus(400);
            return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -4, null);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public LoginStatus login(@RequestBody PlainLoginParameters loginParameters, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            List<User> userToAuthHandle = userRepository.findByEmail(loginParameters.getUsername());
            User userToAuth = userToAuthHandle.get(0);
            if(loginParameters.getPassword().equals(userToAuth.getPass())) {
                String sessionToken = Session.getNewToken();
                String ipAddress = httpServletRequest.getHeader("X-Forwarded-For");
                if(ipAddress == null) httpServletRequest.getRemoteAddr();

                String userAgent = httpServletRequest.getHeader("User-Agent");
                if(userAgent == null) userAgent = "";
                Session validSession = new Session(null,sessionToken,userToAuth,new Date(),ipAddress,userAgent);
                String token = JWT.create().withIssuer("SpajsTech Inc.").withIssuedAt(new Date()).withClaim("id", validSession.getUser().getId()).withClaim("trackingId", validSession.getTrackingId()).withExpiresAt(validSession.getExpiryDate()).sign(Algorithm.HMAC512(langustaHmacSecret));
                sessionRepository.save(validSession);
                return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_SUCCESS, userToAuth.getId(), token);
            } else {
                httpServletResponse.setStatus(401);
                return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -1, null);
            }
        } catch (Exception e) {
            httpServletResponse.setStatus(401);
            return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -2, null);
        }
    }

}
