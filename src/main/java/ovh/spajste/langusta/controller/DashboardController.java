package ovh.spajste.langusta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.entity.Contest;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.repository.ContestRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class DashboardController {

    @Autowired
    private SessionBuilder sessionBuilder;

    @Autowired
    private ContestRepository contestRepository;

    @GetMapping("/dashboard")
    public GenericStatus getLangustaStatus(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
            if(session != null) {
                List<Contest> contestList = contestRepository.findContestByUser(session.getUser());
                return GenericStatus.createSuccessfulStatus(contestList);
            } else {
                httpServletResponse.setStatus(401);
                return GenericStatus.createFailedStatusWithAdditionalInfo("Not logged in.", null);
            }
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return GenericStatus.createFailedStatusWithAdditionalInfo(e.getMessage(), e);
        }
    }

}
