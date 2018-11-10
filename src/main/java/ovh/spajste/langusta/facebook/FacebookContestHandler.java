package ovh.spajste.langusta.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import ovh.spajste.langusta.ContestHandler;
import ovh.spajste.langusta.entity.Contest;
import ovh.spajste.langusta.facebook.service.FacebookService;

import java.util.logging.Logger;

public class FacebookContestHandler implements ContestHandler {

    public void doContest(Contest contest) {
        Logger.getAnonymousLogger().info("FB contest handler - ! TODO !");
    }
}
