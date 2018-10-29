package ovh.spajste.langusta.facebook.entity;

public class FacebookPost {
    private String content;

    public FacebookPost() {
        this(null);
    }

    public FacebookPost(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
