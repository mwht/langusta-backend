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
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class FacebookPageController {

    @Value("${langusta.hmac-secret}")
    private String langustaHmacSecret;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FacebookAccessTokenRepository facebookAccessTokenRepository;

    @Autowired
    private FacebookService facebookService;

    @CrossOrigin(origins = "*")
    @GetMapping("/facebook/page/all")
    public GenericStatus getAllPages(HttpServletRequest httpServletRequest) {
        try {
            Session session = SessionBuilder.getCurrentSession(langustaHmacSecret, userRepository, httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens.size() > 0) {
                facebookService.setAccessToken(facebookAccessTokens.get(0).getAccessToken());
                return GenericStatus.createSuccessfulStatus(facebookService.getAllPages());
            } else {
                throw new NoSuchElementException("No Facebook access tokens found!");
            }
        } catch (Exception e) {
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
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
            Session session = SessionBuilder.getCurrentSession(langustaHmacSecret, userRepository, httpServletRequest);
            List<FacebookAccessToken> facebookAccessTokens = facebookAccessTokenRepository.findByUserId(session.getUser().getId());
            if(facebookAccessTokens.size() > 0) {
                facebookService.setAccessToken(facebookAccessTokens.get(0).getAccessToken());
                FacebookResponse<FacebookBasicPageInfo> facebookPageQueryResponse = facebookService.getAllPages();
                for(FacebookBasicPageInfo facebookBasicPageInfo: facebookPageQueryResponse.getDataHeaders().getData()) {
                    if(id.equals(facebookBasicPageInfo.getId())) {
                        facebookService.addNewPost(id, content.getContent());
                        httpServletResponse.setStatus(201);
                        return GenericStatus.createSuccessfulStatus(null);
                    }
                }
                return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, "Facebook page not found!", null);
            } else {
                throw new NoSuchElementException("No Facebook access tokens found!");
            }
        } catch (Exception e) {
            return new GenericStatus(GenericStatus.GenericState.STATUS_ERROR, e.getMessage(), e);
        }
    }

}
