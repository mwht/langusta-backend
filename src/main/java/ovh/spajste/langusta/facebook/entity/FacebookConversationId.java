package ovh.spajste.langusta.facebook.entity;

public class FacebookConversationId {
    private String id;

    public FacebookConversationId() {
        this(null);
    }

    public FacebookConversationId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
