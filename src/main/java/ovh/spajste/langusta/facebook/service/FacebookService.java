package ovh.spajste.langusta.facebook.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagePostData;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;
import ovh.spajste.langusta.facebook.entity.FacebookBasicPageInfo;
import ovh.spajste.langusta.facebook.entity.FacebookPageQueryResponse;
import ovh.spajste.langusta.facebook.entity.FacebookProfile;
import ovh.spajste.langusta.facebook.entity.FacebookResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FacebookService {
    @Value("${spring.social.facebook.appId}")
    private String facebookAppId;
    @Value("${spring.social.facebook.appSecret}")
    private String facebookSecret;

    private String accessToken;

    public String createFacebookAuthorizationURL(){
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri("https://langusta.zapto.org/api/facebook/authSuccess");
        params.setScope("public_profile,email,user_birthday,manage_pages,publish_pages,pages_messaging,publish_to_groups,read_page_mailboxes,user_posts");
        return oauthOperations.buildAuthorizeUrl(params);
    }

    public String createFacebookAccessToken(String code) {
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code, "https://langusta.zapto.org/api/facebook/authSuccess", null);
        return accessGrant.getAccessToken();
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public FacebookProfile getMyProfile() {
        Facebook facebook = new FacebookTemplate(accessToken);
        String[] fields = {"id", "name", "picture{url}"};
        return facebook.fetchObject("me", FacebookProfile.class, fields);
    }

    public FacebookResponse<FacebookBasicPageInfo> getAllPages() {
        Facebook facebook = new FacebookTemplate(accessToken);
        String[] fields = {"accounts{id,name,fan_count,has_added_app,page_token,access_token}"};
        FacebookResponse<FacebookBasicPageInfo> response = null;
        String fbResponse = facebook.fetchObject("me", String.class, fields);
        try {

            ObjectMapper mapper = new ObjectMapper();
            response = mapper.readValue(fbResponse, new TypeReference<FacebookResponse<FacebookBasicPageInfo>>() {
            });

        } catch (IOException e) {
            Logger.getGlobal().log(Level.SEVERE,e.getMessage());
        }
        return response;
    }

    public void addNewPost(String pageId, String content) {
        Facebook facebook = new FacebookTemplate(accessToken);
        facebook.pageOperations().post(new PagePostData(pageId).message(content));
    }
}
