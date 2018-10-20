package ovh.spajste.langusta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.LoginStatus;
import ovh.spajste.langusta.PlainLoginParameters;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.entity.User;
import ovh.spajste.langusta.repository.SessionRepository;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;

    @RequestMapping(value="/login", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public LoginStatus login(@RequestBody MultiValueMap<String, String> formData, HttpServletResponse httpServletResponse) {
        if(formData.containsKey("login")) {
            if(formData.containsKey("pass")) {

                try {
                    User userToAuth = userRepository.findByEmail(formData.get("login").get(0)).get(0);
                    if(formData.get("pass").get(0).equals(userToAuth.getPass())) {
                        String sessionToken = Session.getNewToken();
                        Session authedSession = new Session(null, sessionToken, userToAuth, new Date(), "TODO", "TODO");
                        sessionRepository.save(authedSession);
                        httpServletResponse.addHeader("X-Auth-Token", sessionToken);
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
    public LoginStatus login(@RequestBody PlainLoginParameters loginParameters, HttpServletResponse httpServletResponse) {
        if(loginParameters.getUsername().equals("falcon1986@o2.pl")) {
            if(loginParameters.getPassword().equals("testpass")) {
                return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_SUCCESS, 1);
            } else {
                return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -1);
            }
        } else {
            return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -2);
        }
    }

}
