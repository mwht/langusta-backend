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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ovh.spajste.langusta.facebook.entity.*;
import ovh.spajste.langusta.facebook.entity.posts.FacebookPosts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FacebookService {

    @Value("${spring.social.facebook.appId}")
    private String facebookAppId;

    @Value("${spring.social.facebook.appSecret}")
    private String facebookSecret;

    @Value("${langusta.domain}")
    private String langustaDomain;

    private String accessToken;

    public String createFacebookAuthorizationURL(){
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri("https://"+langustaDomain+"/api/facebook/authSuccess");
        params.setScope("public_profile,email,user_birthday,manage_pages,publish_pages,pages_messaging,pages_messaging_subscriptions,publish_to_groups,read_page_mailboxes,user_posts");
        return oauthOperations.buildAuthorizeUrl(params);
    }

    public String createFacebookAccessToken(String code) {
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code, "https://"+langustaDomain+"/api/facebook/authSuccess", null);
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

    public FacebookPageQueryResponse getAllPages() {
        Facebook facebook = new FacebookTemplate(accessToken);
        String[] fields = {"accounts{id,name,fan_count,has_added_app,page_token,access_token}"};
        return facebook.fetchObject("me", FacebookPageQueryResponse.class, fields);
    }

    public FacebookPosts getPostsFromPage(String pageId) {
        Facebook facebook = new FacebookTemplate(accessToken);
        return  facebook.fetchObject(pageId+"/posts", FacebookPosts.class);
    }

    public FacebookConversationsQueryResponse getIdsForAllConversations() {
        Facebook facebook = new FacebookTemplate(accessToken);
        String[] fields = {"conversations{id}"};
        return facebook.fetchObject("me", FacebookConversationsQueryResponse.class, fields);
    }

    public FacebookPostComments getFacebookPostComments(String pageId, String postId) {
        Facebook facebook = new FacebookTemplate(accessToken);
        String[] fields = {"comments{from,message,created_time,likes.summary(true)}"};
        return facebook.fetchObject(pageId+"_"+postId, FacebookPostComments.class, fields);
    }

    /* TODO: replace method sendMessage with sendMessageTo */
    public void sendMessage(FacebookConversationId facebookConversationId, String content) {
        Facebook facebook = new FacebookTemplate(accessToken);
        MultiValueMap<String, Object> fields = new LinkedMultiValueMap<>();
        ArrayList<Object> strings = new ArrayList<>();
        strings.add(content);
        fields.put("message",strings);
        facebook.post(facebookConversationId.getId()+"/messages", fields);
    }

    public void sendMessageTo(String facebookId, String message) {
        Facebook facebook = new FacebookTemplate(accessToken);
        MultiValueMap<String, Object> fields = new LinkedMultiValueMap<>();
        // TODO: build query with Jackson/org.json instead of manual string building
        ArrayList<Object> recipients = new ArrayList<>();
        recipients.add("{\"id\": \""+facebookId+"\"}");
        fields.put("recipient", recipients);
        ArrayList<Object> strings = new ArrayList<>();
        strings.add("{\"text\": \""+message+"\"}");
        fields.put("message",strings);
        facebook.post("me/messages", fields);
        Logger.getAnonymousLogger().info("New message sent to " + facebookId + ": " + message);
    }

    public void addNewPost(String pageId, String content) {
        Facebook facebook = new FacebookTemplate(accessToken);
        facebook.pageOperations().post(new PagePostData(pageId).message(content));
    }

    public FacebookPostReactions getFacebookPostAndReactions(String postId) {
        Facebook facebook = new FacebookTemplate(accessToken);
        String[] fields = {"caption","type","message","reactions"};
        return facebook.fetchObject(postId, FacebookPostReactions.class, fields);
    }
}
