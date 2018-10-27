package ovh.spajste.langusta.facebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajste.langusta.GenericStatus;

@RestController
public class FacebookUserProfileController {

    @GetMapping("/facebook/profile/{id}")
    public GenericStatus getFacebookProfile(@PathVariable("id") String id) {
        return GenericStatus.createSuccessfulStatus(null);
    }

}
