package ovh.spajste.langusta.facebook.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FacebookBasicPageInfo {
    private String id;
    private String name;
    private Integer fanCount;
    private boolean hasAddedApp;
    private String pageToken;
    private String accessToken;

    public FacebookBasicPageInfo() {
        this(null, null, null, false, null, null);
    }

    public FacebookBasicPageInfo(String id, String name, Integer fanCount, boolean hasAddedApp, String pageToken, String accessToken) {
        this.id = id;
        this.name = name;
        this.fanCount = fanCount;
        this.hasAddedApp = hasAddedApp;
        this.pageToken = pageToken;
        this.accessToken = accessToken;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("fan_count")
    public Integer getFanCount() {
        return fanCount;
    }

    @JsonProperty("has_added_app")
    public boolean getHasAddedApp() {
        return hasAddedApp;
    }

    @JsonProperty("page_token")
    public String getPageToken() {
        return pageToken;
    }

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFanCount(Integer fanCount) {
        this.fanCount = fanCount;
    }

    public void setHasAddedApp(boolean hasAddedApp) {
        this.hasAddedApp = hasAddedApp;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
