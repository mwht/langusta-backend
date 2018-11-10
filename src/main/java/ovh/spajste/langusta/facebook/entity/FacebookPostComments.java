
package ovh.spajste.langusta.facebook.entity;

import javax.annotation.Generated;

/* /{page_id}_{post_id}?fields=comments{from,message,created_time,likes.summary(true)} */

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FacebookPostComments {

    private FacebookComments comments;
    private String id;

    public FacebookComments getComments() {
        return comments;
    }

    public void setComments(FacebookComments comments) {
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
