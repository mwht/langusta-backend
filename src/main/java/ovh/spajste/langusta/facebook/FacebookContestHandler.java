package ovh.spajste.langusta.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import ovh.spajste.langusta.ContestHandler;
import ovh.spajste.langusta.SpringContext;
import ovh.spajste.langusta.entity.Contest;
import ovh.spajste.langusta.facebook.entity.FacebookBasicPageInfo;
import ovh.spajste.langusta.facebook.entity.FacebookPostReactions;
import ovh.spajste.langusta.facebook.repository.FacebookAccessTokenRepository;
import ovh.spajste.langusta.facebook.service.FacebookService;

import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacebookContestHandler implements ContestHandler {

    @Override
    public Contest fetchNewContestData(Contest contest) {
        // https://www.facebook.com/[page name]/posts/[post id]
        // PostLink IS NOW POST ID FETCHED DIRECTLY FROM FACEBOOK !!!
        try {
            // get all required components
            ApplicationContext applicationContext = SpringContext.getApplicationContext();
            FacebookService facebookService = (FacebookService) applicationContext.getBean("facebookService");
            FacebookAccessTokenRepository facebookAccessTokenRepository = (FacebookAccessTokenRepository) applicationContext.getBean("facebookAccessTokenRepository");
            // set access token
            facebookService.setAccessToken(
                    facebookAccessTokenRepository.findByUserId(contest.getUser().getId()).get(0).getAccessToken()
            );
            // compile regex for page id
            Pattern regex = Pattern.compile("^(\\d+)_");
            String pageId = null;

            for (FacebookBasicPageInfo facebookBasicPageInfo : facebookService.getAllPages().getAccounts().getData()) {
                Matcher regexMatcher = regex.matcher(contest.getPostLink());
                try {
                    while (regexMatcher.find()) {
                        pageId = regexMatcher.group(1);
                        if(contest.getPostLink().startsWith(pageId)) {
                            Logger.getAnonymousLogger().info("Setting access token to " + facebookBasicPageInfo.getName());
                            facebookService.setAccessToken(facebookBasicPageInfo.getAccessToken());
                            break;
                        }
                        break;
                    }
                } catch (NullPointerException npe) {
                    throw new IllegalArgumentException("No facebook page access token supplied!");
                }
            }

            FacebookPostReactions facebookPostReactions = facebookService.getFacebookPostAndReactions(contest.getPostLink());
            Logger.getAnonymousLogger().info("FB contest handler - contest link " + contest.getPostLink() + ", " + facebookPostReactions.getReactions().getData().size() + " reactions");
            contest.setLikesAmount(facebookPostReactions.getReactions().getData().size());
            return contest;
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe("Can't fetch data for contest (\"" + contest.getTitle() + "\"): " + e.getClass().getSimpleName() + ": " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Contest doContest(Contest contest) {
        try {
            ApplicationContext applicationContext = SpringContext.getApplicationContext();
            FacebookService facebookService = (FacebookService) applicationContext.getBean("facebookService");
            FacebookAccessTokenRepository facebookAccessTokenRepository = (FacebookAccessTokenRepository) applicationContext.getBean("facebookAccessTokenRepository");
            facebookService.setAccessToken(facebookAccessTokenRepository.findByUserId(contest.getUser().getId()).get(0).getAccessToken());
            Pattern regex = Pattern.compile("^(\\d+)_");
            String pageId = null;

            for (FacebookBasicPageInfo facebookBasicPageInfo : facebookService.getAllPages().getAccounts().getData()) {
                Matcher regexMatcher = regex.matcher(contest.getPostLink());
                try {
                    while (regexMatcher.find()) {
                        pageId = regexMatcher.group(1);
                        if(contest.getPostLink().startsWith(pageId)) {
                            Logger.getAnonymousLogger().info("Setting access token to " + facebookBasicPageInfo.getName());
                            facebookService.setAccessToken(facebookBasicPageInfo.getAccessToken());
                            break;
                        }
                    }
                } catch (NullPointerException npe) {
                    throw new IllegalArgumentException("No facebook page access token supplied!");
                }
            }

            Random random = new Random();
            FacebookPostReactions facebookPostReactions = facebookService.getFacebookPostAndReactions(contest.getPostLink());
            int winner = random.nextInt(facebookPostReactions.getReactions().getData().size());
            Logger.getAnonymousLogger().info("FB contest handler - contest ended, winner id = " + facebookPostReactions.getReactions().getData().get(winner).getId()
                    + ", winner name = " + facebookPostReactions.getReactions().getData().get(winner).getName());
            contest.setWinnerId(facebookPostReactions.getReactions().getData().get(winner).getId());
            contest.setWinnerDisplayName(facebookPostReactions.getReactions().getData().get(winner).getName());
            return contest;
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe("Can't do contest (\"" + contest.getTitle() + "\"): " + e.getClass().getSimpleName() + ": " + e.getMessage());
            e.printStackTrace();
            return contest;
        }
    }
}
