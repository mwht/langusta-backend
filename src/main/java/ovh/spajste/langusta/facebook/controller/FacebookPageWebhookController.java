package ovh.spajste.langusta.facebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@RestController
public class FacebookPageWebhookController {
    @GetMapping("/facebook/webhook")
    public String facebookWebhookHandler(@RequestParam(name = "hub.mode", required = false) String hubMode,
                                         @RequestParam(name = "hub.challenge", required = false) String hubChallenge,
                                         @RequestParam(name = "hub.verify_token", required = false) String hubVerifyToken,
                                         @RequestBody(required = false) String postData,
                                         HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse) {

        if(hubMode != null) {
            if(hubChallenge != null) {
                if(hubVerifyToken != null) {
                    return hubChallenge;
                }
            }
        }

        if(postData != null) {
            Logger.getAnonymousLogger().info(postData);
        }
        return "OK";
    }
}
