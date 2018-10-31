package ovh.spajste.langusta.facebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class FacebookPageWebhookController {
    @GetMapping("/facebook/webhook")
    public String facebookHandshakeWebhookHandler(@RequestParam("hub.mode") String hubMode, @RequestParam("hub.challenge") String hubChallenge, @RequestParam("hub.verify_token") String hubVerifyToken, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return hubChallenge;
    }
}
