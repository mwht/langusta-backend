package ovh.spajste.langusta.facebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.facebook.entity.FacebookAccessToken;
import ovh.spajste.langusta.facebook.entity.FacebookBasicPageInfo;
import ovh.spajste.langusta.facebook.entity.FacebookPageQueryResponse;
import ovh.spajste.langusta.facebook.entity.FacebookResponse;
import ovh.spajste.langusta.facebook.repository.FacebookAccessTokenRepository;
import ovh.spajste.langusta.facebook.service.FacebookService;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class FacebookMessageController {

    @Value("${langusta.hmac-secret}")
    private String langustaHmacSecret;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FacebookAccessTokenRepository facebookAccessTokenRepository;

    @Autowired
    private FacebookService facebookService;

    @CrossOrigin(origins = "*")
    @PostMapping("/facebook/pageconversation/{id}/send")
    public GenericStatus pageConversationSend(@PathVariable String id, HttpServletRequest httpServletRequest) {
        try {
            Session session = SessionBuilder.getCurrentSession(langustaHmacSecret, userRepository, httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens.size() > 0) {
                FacebookAccessToken facebookAccessToken = facebookAccessTokens.get(0);
                facebookService.setAccessToken(facebookAccessToken.getAccessToken());

            } else {
                throw new NoSuchElementException("No Facebook access tokens found!");
            }
            return GenericStatus.createSuccessfulStatus(null);
        } catch (Exception e) {
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/facebook/pageconversation/{id}")
    public GenericStatus getAllConversationsFromPage(@PathVariable String id, HttpServletRequest httpServletRequest) {
        try {
            Session session = SessionBuilder.getCurrentSession(langustaHmacSecret, userRepository, httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens.size() > 0) {
                FacebookAccessToken facebookAccessToken = facebookAccessTokens.get(0);
                facebookService.setAccessToken(facebookAccessToken.getAccessToken());
                FacebookPageQueryResponse facebookBasicPageInfoFacebookResponse = facebookService.getAllPages();
                for(FacebookBasicPageInfo facebookBasicPageInfo: facebookBasicPageInfoFacebookResponse.getAccounts().getData()) {
                    if(id.equals(facebookBasicPageInfo.getId())) {
                        String pageAccessToken = facebookBasicPageInfo.getAccessToken();
                        facebookService.setAccessToken(pageAccessToken);
                        return GenericStatus.createSuccessfulStatus(facebookService.getIdsForAllConversations());
                    }
                }
            } else {
                throw new NoSuchElementException("No Facebook access tokens found!");
            }
            return GenericStatus.createSuccessfulStatus(null);
        } catch (Exception e) {
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

}
