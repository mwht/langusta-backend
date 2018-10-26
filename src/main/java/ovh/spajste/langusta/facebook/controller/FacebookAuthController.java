package ovh.spajste.langusta.facebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.facebook.service.FacebookService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class FacebookAuthController {

    @Autowired
    private FacebookService facebookService;

    @GetMapping("/facebook/authSuccess")
    public GenericStatus onFacebookAuthSuccess(@RequestParam("code") String code) {
        facebookService.createFacebookAccessToken(code);
        return GenericStatus.createSuccessfulStatus(facebookService.getName());
    }

    @GetMapping("/facebook/createAuth")
    public void generateAuth(HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(301);
        httpServletResponse.addHeader("Location", facebookService.createFacebookAuthorizationURL());
    }
}
