package ovh.spajste.langusta.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import ovh.spajste.langusta.ContestHandler;
import ovh.spajste.langusta.entity.Contest;
import ovh.spajste.langusta.facebook.entity.FacebookPostReactions;
import ovh.spajste.langusta.facebook.service.FacebookService;

import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacebookContestHandler implements ContestHandler {

    @Autowired
    private FacebookService facebookService;

    @Override
    public Contest fetchNewContestData(Contest contest) {
        // https://www.facebook.com/[page name]/posts/[post id]
        FacebookPostReactions facebookPostReactions = facebookService.getFacebookPostAndReactions(contest.getPostLink());
        Logger.getAnonymousLogger().info("FB contest handler - contest link "+contest.getPostLink()+", "+facebookPostReactions.getReactions().getData().size()+" reactions");
        return contest;
    }

    public Contest doContest(Contest contest) {
        Random random = new Random();
        FacebookPostReactions facebookPostReactions = facebookService.getFacebookPostAndReactions(contest.getPostLink());
        int winner = random.nextInt(facebookPostReactions.getReactions().getData().size());
        Logger.getAnonymousLogger().info("FB contest handler - contest ended, winner id = "+facebookPostReactions.getReactions().getData().get(winner).getId()
                + ", winner name = " + facebookPostReactions.getReactions().getData().get(winner).getName());
        contest.setWinnerId(facebookPostReactions.getReactions().getData().get(winner).getId());
        return contest;
    }
}
