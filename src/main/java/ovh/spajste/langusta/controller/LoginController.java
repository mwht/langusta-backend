package ovh.spajste.langusta.controller;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajste.langusta.LoginStatus;
import ovh.spajste.langusta.PlainLoginParameters;

@RestController
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public LoginStatus login(@RequestBody MultiValueMap<String, String> formData) {
        if(formData.containsKey("login")) {
            if(formData.containsKey("pass")) {
                if(formData.get("login").get(0).equals("falcon1986@o2.pl")) {
                    if(formData.get("pass").get(0).equals("testpass")) {
                        return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_SUCCESS, 1);
                    } else {
                        return new LoginStatus(LoginStatus.LoginState.LOGIN_STATE_FAILED, -1);
                    }
                } else {
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
    public LoginStatus login(@RequestBody PlainLoginParameters loginParameters) {
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
