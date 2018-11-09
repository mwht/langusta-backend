package ovh.spajste.langusta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping(path = "/contest", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public GenericStatus addNewContest(@RequestBody ContestParameters contestParameters, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = SessionBuilder.getCurrentSession(langustaHmacSecret, sessionRepository, httpServletRequest);
            Contest contest = new Contest(
                    null,
                    session.getUser(),
                    contestParameters.getTitle(),
                    platformRepository.findPlatformByCanonicalName(contestParameters.getPlatform()).get(),
                    contestParameters.getPostLink(),
                    null,
                    null,
                    0,
                    null
            );
            contestRepository.save(contest);
            httpServletResponse.setStatus(201);
            return GenericStatus.createSuccessfulStatus(null);
        } catch (Exception e) {
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping("/contest/all")
    public GenericStatus getAllContests() {
        /* TODO: probably security! */
        return GenericStatus.createSuccessfulStatus(contestRepository.findAll());
    }


}
