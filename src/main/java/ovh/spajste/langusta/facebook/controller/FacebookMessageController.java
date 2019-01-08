package ovh.spajste.langusta.facebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ovh.spajste.langusta.GenericStatus;
import ovh.spajste.langusta.SessionBuilder;
import ovh.spajste.langusta.TokenFilter;
import ovh.spajste.langusta.entity.Session;
import ovh.spajste.langusta.facebook.entity.*;
import ovh.spajste.langusta.facebook.repository.FacebookAccessTokenRepository;
import ovh.spajste.langusta.facebook.service.FacebookService;
import ovh.spajste.langusta.repository.SessionRepository;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class FacebookMessageController {

    @Autowired
    private SessionBuilder sessionBuilder;

    @Autowired
    private FacebookAccessTokenRepository facebookAccessTokenRepository;

    @Autowired
    private FacebookService facebookService;

    @PostMapping(path = "/facebook/page/{id}/conversations/all/send", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public GenericStatus pageConversationSend(@PathVariable("id") String id, @RequestParam String content, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return pageConversationSendJson(id, new FacebookPost(content), httpServletRequest, httpServletResponse);
    }

    @PostMapping(path = "/facebook/page/{id}/conversations/all/send", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public GenericStatus pageConversationSendJson(@PathVariable("id") String id, @RequestBody FacebookPost content, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens.size() > 0) {
                FacebookAccessToken facebookAccessToken = facebookAccessTokens.get(0);
                facebookService.setAccessToken(facebookAccessToken.getAccessToken());
                FacebookPageQueryResponse facebookBasicPageInfoFacebookResponse = facebookService.getAllPages();
                for(FacebookBasicPageInfo facebookBasicPageInfo: facebookBasicPageInfoFacebookResponse.getAccounts().getData()) {
                    if(id.equals(facebookBasicPageInfo.getId())) {
                        String pageAccessToken = facebookBasicPageInfo.getAccessToken();
                        facebookService.setAccessToken(pageAccessToken);
                        for(FacebookConversationId facebookConversationId: facebookService.getIdsForAllConversations().getConversations().getData()) {
                            try {
                                facebookService.sendMessage(facebookConversationId, TokenFilter.processText(content.getContent()));
                            } catch(Exception e) {
                                /* TODO: report errors to client */
                                e.printStackTrace();
                            }
                        }
                    }   httpServletResponse.setStatus(202);
                }
            } else {
                httpServletResponse.setStatus(404);
                throw new NoSuchElementException("No Facebook access tokens found!");
            }
            return GenericStatus.createSuccessfulStatus(null);
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping("/facebook/page/{id}/conversations")
    public GenericStatus getAllConversationsFromPage(@PathVariable String id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
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
                httpServletResponse.setStatus(404);
                throw new NoSuchElementException("No Facebook access tokens found!");
            }
            httpServletResponse.setStatus(500);
            return GenericStatus.createFailedStatusWithAdditionalInfo("Unknown error!", null);
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

}
