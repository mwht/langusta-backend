package ovh.spajste.langusta.facebook.entity;

public class FacebookProfile {
    private String id;
    private String name;
    private String avatarUrl;

    public FacebookProfile() {
        this(null, null, null);
    }

    public FacebookProfile(String id, String name, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
