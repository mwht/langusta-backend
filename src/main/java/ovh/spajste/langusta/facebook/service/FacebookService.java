package ovh.spajste.langusta.facebook.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;
import ovh.spajste.langusta.facebook.entity.FacebookProfile;

@Service
public class FacebookService {
    @Value("${spring.social.facebook.appId}")
    private String facebookAppId;
    @Value("${spring.social.facebook.appSecret}")
    private String facebookSecret;

    private String accessToken;

    public String createFacebookAuthorizationURL(String authToken){
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri("https://langusta.zapto.org/api/facebook/authSuccess/"+authToken);
        params.setScope("public_profile,email,user_birthday,pages_messaging,publish_to_groups");
        return oauthOperations.buildAuthorizeUrl(params);
    }

    public String createFacebookAccessToken(String code, String authToken) {
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code, "https://langusta.zapto.org/api/facebook/authSuccess/"+authToken, null);
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
}
