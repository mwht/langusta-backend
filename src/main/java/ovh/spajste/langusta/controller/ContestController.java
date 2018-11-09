package ovh.spajste.langusta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ovh.spajste.langusta.ContestParameters;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.entity.Contest;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.repository.ContestRepository;
import ovh.spajste.langusta.repository.PlatformRepository;
import ovh.spajste.langusta.repository.SessionRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
public class ContestController {

    @Autowired
    private ContestRepository contestRepository;

    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Value("${langusta.hmac-secret}")
    private String langustaHmacSecret;

    @PostMapping(path = "/contest", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public GenericStatus addNewContest(@RequestParam String title, @RequestParam String platform, @RequestParam("post_link") String postLink, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return addNewContestJson(new ContestParameters(title, platform, postLink), httpServletRequest, httpServletResponse);
    }

    @PostMapping(path = "/contest", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public GenericStatus addNewContestJson(@RequestBody ContestParameters contestParameters, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = SessionBuilder.getCurrentSession(langustaHmacSecret, sessionRepository, httpServletRequest);
            Contest contest = new Contest(
                    null,
                    session.getUser(),
                    contestParameters.getTitle(),
                    platformRepository.findPlatformByCanonicalName(contestParameters.getPlatform()).get(),
                    contestParameters.getPostLink(),
                    null,
                    0,
                    0,
                    null,
                    new Date(new Date().getTime() + 120000)
            );
            contestRepository.save(contest);
            httpServletResponse.setStatus(201);
            return GenericStatus.createSuccessfulStatus(null);
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping("/contest/all")
    public GenericStatus getAllContests() {
        return GenericStatus.createSuccessfulStatus(contestRepository.findAll());
    }


}
