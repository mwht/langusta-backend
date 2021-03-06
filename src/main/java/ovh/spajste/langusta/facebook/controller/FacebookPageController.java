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
import ovh.spajste.langusta.facebook.repository.FacebookPostLogEntryRepository;
import ovh.spajste.langusta.facebook.service.FacebookService;
import ovh.spajste.langusta.repository.SessionRepository;
import ovh.spajste.langusta.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class FacebookPageController {

    @Autowired
    private SessionBuilder sessionBuilder;

    @Autowired
    private FacebookAccessTokenRepository facebookAccessTokenRepository;

    @Autowired
    private FacebookPostLogEntryRepository facebookPostLogEntryRepository;

    @Autowired
    private FacebookService facebookService;

    @GetMapping("/facebook/page/all")
    public GenericStatus getAllPages(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens.size() > 0) {
                facebookService.setAccessToken(facebookAccessTokens.get(0).getAccessToken());
                return GenericStatus.createSuccessfulStatus(facebookService.getAllPages());
            } else {
                httpServletResponse.setStatus(404);
                throw new NoSuchElementException("No Facebook access tokens found!");
            }
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping("/facebook/page/{id}/posts")
    public GenericStatus getPostsFromPage(@PathVariable("id") String id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens.size() > 0) {
                FacebookAccessToken facebookAccessToken = facebookAccessTokens.get(0);
                facebookService.setAccessToken(facebookAccessToken.getAccessToken());
                return GenericStatus.createSuccessfulStatus(facebookService.getPostsFromPage(id));
                /* // TODO: make this as default instead of code above
                FacebookPageQueryResponse facebookBasicPageInfoFacebookResponse = facebookService.getAllPages();
                for(FacebookBasicPageInfo facebookBasicPageInfo: facebookBasicPageInfoFacebookResponse.getAccounts().getData()) {
                    if(id.equals(facebookBasicPageInfo.getId())) {
                        String pageAccessToken = facebookBasicPageInfo.getAccessToken();
                        facebookService.setAccessToken(pageAccessToken);
                        return GenericStatus.createSuccessfulStatus(facebookService.getPostsFromPage(id));
                    } else {
                        return GenericStatus.createFailedStatusWithAdditionalInfo("No Facebook access tokens were found!", null);
                    }
                }
                */
            } else {
                httpServletResponse.setStatus(404);
                throw new NoSuchElementException("No Facebook access tokens found!");
            }
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return GenericStatus.createFailedStatusWithAdditionalInfo(e.getMessage(), e);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/facebook/page/{id}/post", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public GenericStatus addNewPost(@PathVariable("id") String id, @RequestParam String content, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return addNewPostJson(id, new FacebookPost(content), httpServletRequest, httpServletResponse);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/facebook/page/{id}/post", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public GenericStatus addNewPostJson(@PathVariable("id") String id, @RequestBody FacebookPost content, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            Session session = sessionBuilder.getCurrentSession(httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens.size() > 0) {
                facebookService.setAccessToken(facebookAccessTokens.get(0).getAccessToken());
                FacebookPageQueryResponse facebookPageQueryResponse = facebookService.getAllPages();
                for(FacebookBasicPageInfo facebookBasicPageInfo: facebookPageQueryResponse.getAccounts().getData()) {
                    if(id.equals(facebookBasicPageInfo.getId())) {
                        String contentString = content.getContent();
                        if(contentString.length() > 30) contentString = contentString.substring(0,30);
                        facebookService.addNewPost(id, content.getContent());
                        FacebookPostLogEntry facebookPostLogEntry = new FacebookPostLogEntry(null, id, contentString, new Date(), session);
                        facebookPostLogEntryRepository.save(facebookPostLogEntry);
                        httpServletResponse.setStatus(201);
                        return GenericStatus.createSuccessfulStatus(null);
                    }
                }
                httpServletResponse.setStatus(404);
                return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "Facebook page not found!", null);
            } else {
                httpServletResponse.setStatus(400);
                throw new NoSuchElementException("No Facebook access tokens found!");
            }
        } catch (Exception e) {
            httpServletResponse.setStatus(500);
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

}
