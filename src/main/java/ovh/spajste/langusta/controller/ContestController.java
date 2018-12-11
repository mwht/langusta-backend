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
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class ContestController {

    @Autowired
    private ContestRepository contestRepository;

    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private SessionBuilder sessionBuilder;


    @PostMapping(path = "/contest", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public GenericStatus addNewContest(@RequestParam String title, @RequestParam String platform, @RequestParam("post_link") String postLink, @RequestParam("end_time") Long endTime, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return addNewContestJson(new ContestParameters(title, platform, postLink, endTime), httpServletRequest, httpServletResponse);
    }

    @PostMapping(path = "/contest", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public GenericStatus addNewContestJson(@RequestBody ContestParameters contestParameters, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
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
                    new Date((long) contestParameters.getEndTime() * 1000),
                    false,
                    null
            );
            contestRepository.save(contest);
            httpServletResponse.setStatus(201);
            return GenericStatus.createSuccessfulStatus(null);
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping("/contest/{id}")
    public GenericStatus getContestResults(@PathVariable("id") Integer id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
            Optional<Contest> contestHandle = contestRepository.findById(id);
            if(contestHandle.isPresent()) {
                Contest contest = contestHandle.get();
                return GenericStatus.createSuccessfulStatus(contest);
            } else {
                httpServletResponse.setStatus(404);
                throw new NoSuchElementException("Contest not found.");
            }
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

    @DeleteMapping("/contest/{id}")
    public GenericStatus deleteContest(@PathVariable("id") Integer id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
            Optional<Contest> contestHandle = contestRepository.findById(id);
            if(contestHandle.isPresent()) {
                Contest contest = contestHandle.get();
                contestRepository.delete(contest);
                return GenericStatus.createSuccessfulStatus(null);
            } else {
                httpServletResponse.setStatus(404);
                throw new NoSuchElementException("Contest not found.");
            }
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping("/contest/all")
    public GenericStatus getAllContests(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
            if(session != null) {
                return GenericStatus.createSuccessfulStatus(contestRepository.findAllByUser(session.getUser()));
            } else {
                httpServletResponse.setStatus(401);
                return GenericStatus.createFailedStatusWithAdditionalInfo("Not logged in.", null);
            }
        } catch(Exception e) {
            httpServletResponse.setStatus(500);
            return GenericStatus.createFailedStatusWithAdditionalInfo(e.getMessage(), e);
        }
    }


}
