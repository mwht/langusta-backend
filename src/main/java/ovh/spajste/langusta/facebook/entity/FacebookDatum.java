
package ovh.spajste.langusta.facebook.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")

/**
 * FacebookDatum is *ACTUAL* facebook comment data
 */
public class FacebookDatum {

    @JsonProperty("created_time")
    private String createdTime;
    private String id;
    private FacebookLikes likes;
    private String message;
    private String name;

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FacebookLikes getLikes() {
        return likes;
    }

    public void setLikes(FacebookLikes likes) {
        this.likes = likes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
