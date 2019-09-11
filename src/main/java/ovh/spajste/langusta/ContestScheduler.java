package ovh.spajste.langusta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ovh.spajste.langusta.entity.Contest;
import ovh.spajste.langusta.repository.ContestRepository;

import java.util.Date;

@Component
public class ContestScheduler {

    @Autowired
    private ContestRepository contestRepository;

    @Scheduled(fixedRate = 60000) // approx 1 min
    public void doContest() {
        /* TODO: optimize SQL query or add method in ContestRepository interface */

        for(Contest contest: contestRepository.findAll()) {
            if(contest.getEndDate().before(new Date()) && !contest.getEndNotificationSent()) { // end date before current date <=> current date after end
                ContestHandler contestHandler = ContestHandlerFactory.getInstance(contest.getPlatform().getCanonicalName());
                contest = contestHandler.doContest(contest);
                contest.setEndNotificationSent(true);
                contestRepository.save(contest);
            }
            if(contest.getEndDate().after(new Date())) {
                ContestHandler contestHandler = ContestHandlerFactory.getInstance(contest.getPlatform().getCanonicalName());
                contestHandler.fetchNewContestData(contest);
                contestRepository.save(contest);
            }
        }
    }
}
