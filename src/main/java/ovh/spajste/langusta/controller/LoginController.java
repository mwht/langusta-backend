package ovh.spajste.langusta.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
                        Map<String, Object> jwtData = new HashMap<>();
                        jwtData.put("id", Integer.toString(validSession.getUser().getId()));
                        jwtData.put("expireDate", Long.toString(validSession.getExpiryDate().getTime()));
                        jwtData.put("trackingId", validSession.getTrackingId());
                        String token = JWT.create().withIssuer("SpajsTech Inc.").withHeader(jwtData).withExpiresAt(validSession.getExpiryDate()).sign(Algorithm.HMAC512(langustaHmacSecret));
                        //sessionRepository.save(authedSession);
                        httpServletResponse.addHeader("X-Auth-Token", token);
                        return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_SUCCESS, userToAuth.getId());
                    } else {
                        return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_SUCCESS, -1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -2);
                }

            } else {
                return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -3);
            }
        } else {
            return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -4);
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
                Map<String, Object> jwtData = new HashMap<>();
                jwtData.put("id", Integer.toString(validSession.getUser().getId()));
                jwtData.put("expireDate", Long.toString(validSession.getExpiryDate().getTime()));
                jwtData.put("trackingId", validSession.getTrackingId());
                String token = JWT.create().withIssuer("SpajsTech Inc.").withHeader(jwtData).withExpiresAt(validSession.getExpiryDate()).sign(Algorithm.HMAC512(langustaHmacSecret));
                sessionRepository.save(validSession);
                httpServletResponse.addHeader("X-Auth-Token", token);
                return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_SUCCESS, userToAuth.getId());
            } else {
                return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -1);
            }
        } catch (Exception e) {
            return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -2);
        }
    }

}
