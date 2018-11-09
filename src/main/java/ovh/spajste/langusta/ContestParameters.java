package ovh.spajste.langusta;

public class ContestParameters {
    private String title;
    private String platform;
    private String postLink;

    public ContestParameters() {
        this(null, null, null);
    }

    public ContestParameters(String title, String platform, String postLink) {
        this.title = title;
        this.platform = platform;
        this.postLink = postLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPostLink() {
        return postLink;
    }

    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }
}
