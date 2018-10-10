package ovh.spajste.langusta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajste.langusta.model.Version;
import ovh.spajste.langusta.GenericStatus;

@RestController
public class VersionController {
    @RequestMapping("/version")
    public GenericStatus getVersion() {
        return new GenericStatus(GenericStatus.GenericState.STATUS_SUCCESS, null, Version.getInstance());
    }
}
