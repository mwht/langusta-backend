package ovh.spajste.langusta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ovh.spajste.langusta.entity.Contest;
import ovh.spajste.langusta.repository.ContestRepository;
import ovh.spajste.langusta.service.MailService;

import java.util.Date;

@Component
public class ContestScheduler {

    @Autowired
    private ContestRepository contestRepository;

    @Autowired
    private MailService mailService;

    @Scheduled(fixedRate = 60000) // approx 1 min
    public void doContest() {
        /* TODO: optimize SQL query or add method in ContestRepository interface */

        for(Contest contest: contestRepository.findAll()) {
            if(contest.getEndDate().before(new Date()) && !contest.getEndNotificationSent()) { // end date before current date <=> current date after end
                ContestHandler contestHandler = ContestHandlerFactory.getInstance(contest.getPlatform().getCanonicalName());
                contest = contestHandler.doContest(contest);
                mailService.sendMail(contest.getUser().getEmail(),"Contest \""+contest.getTitle()+"\" ended successfully", "Hello,\n\nContest \""+contest.getTitle()+"\" has ended at "+contest.getEndDate()+".\nThe winner is [TODO]\n\nLangusta system");
                contest.setEndNotificationSent(true);
                contestRepository.save(contest);
            }
            if(contest.getEndDate().after(new Date())) {
                ContestHandler contestHandler = ContestHandlerFactory.getInstance(contest.getPlatform().getCanonicalName());
                contestHandler.fetchNewContestData(contest);
            }
        }
    }
}
