package ovh.spajste.langusta.facebook.dataview;

import ovh.spajste.langusta.facebook.entity.FacebookAccessToken;

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

    public static BasicFacebookAccessTokenDataView getDataViewFor(FacebookAccessToken facebookAccessToken) {
        return new BasicFacebookAccessTokenDataView(facebookAccessToken.getId(), facebookAccessToken.getAccessToken());
    }

    public int getId() {
        return id;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
