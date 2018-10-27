package ovh.spajste.langusta.facebook.dataview;

public class BasicFacebookAccessTokenDataView {
    private int id;
    private String accessToken;

    public BasicFacebookAccessTokenDataView() {
        this(-1, null);
    }

    public BasicFacebookAccessTokenDataView(int id, String accessToken) {
        this.id = id;
        this.accessToken = accessToken;
    }

    public int getId() {
        return id;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
