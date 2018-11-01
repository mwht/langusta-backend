package ovh.spajste.langusta.facebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.facebook.entity.*;
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

    @PostMapping(name = "/facebook/page/{pageid}/conversations/all/send", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public GenericStatus pageConversationSend(@PathVariable String pageid, @RequestParam String content, HttpServletRequest httpServletRequest) {
        return pageConversationSendJson(pageid, new FacebookPost(content), httpServletRequest);
    }

    @PostMapping(name = "/facebook/page/{pageid}/conversations/all/send", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public GenericStatus pageConversationSendJson(@PathVariable String pageid, @RequestBody FacebookPost content, HttpServletRequest httpServletRequest) {
        try {
            Session session = SessionBuilder.getCurrentSession(langustaHmacSecret, userRepository, httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens.size() > 0) {
                FacebookAccessToken facebookAccessToken = facebookAccessTokens.get(0);
                facebookService.setAccessToken(facebookAccessToken.getAccessToken());
                FacebookPageQueryResponse facebookBasicPageInfoFacebookResponse = facebookService.getAllPages();
                for(FacebookBasicPageInfo facebookBasicPageInfo: facebookBasicPageInfoFacebookResponse.getAccounts().getData()) {
                    if(pageid.equals(facebookBasicPageInfo.getId())) {
                        String pageAccessToken = facebookBasicPageInfo.getAccessToken();
                        facebookService.setAccessToken(pageAccessToken);
                        for(FacebookConversationId facebookConversationId: facebookService.getIdsForAllConversations().getConversations().getData()) {
                            facebookService.sendMessage(facebookConversationId, content.getContent());
                        }
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

    @GetMapping("/facebook/page/{id}/conversations")
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
