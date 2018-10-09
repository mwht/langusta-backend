package ovh.spajste.langusta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajste.langusta.model.Version;

@RestController
public class VersionController {
    @RequestMapping("/version")
    public Version getVersion() {
        return Version.getInstance();
    }
}
