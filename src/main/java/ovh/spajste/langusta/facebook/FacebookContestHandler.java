package ovh.spajste.langusta.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import ovh.spajste.langusta.ContestHandler;
import ovh.spajste.langusta.entity.Contest;
import ovh.spajste.langusta.facebook.service.FacebookService;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacebookContestHandler implements ContestHandler {

    public void doContest(Contest contest) {

        // https://www.facebook.com/[dont care]/posts/[post id]
        Pattern linkRegex = Pattern.compile("^https://www.facebook.com/(.*)/posts/(.*)");
        String postId = null;

        Matcher regexMatcher = linkRegex.matcher(contest.getPostLink());
        try {
            while (regexMatcher.find())
                postId = regexMatcher.group(2);
        } catch (NullPointerException npe) {
            throw new SecurityException("Unparsable Facebook object supplied!");
        }
        Logger.getAnonymousLogger().info("FB contest handler - ! TODO ! (contest link "+postId+")");
    }
}
