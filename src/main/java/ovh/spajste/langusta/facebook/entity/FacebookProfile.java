package ovh.spajste.langusta.facebook.entity;

public class FacebookProfile {
    private String id;
    private String name;
    class FacebookPicture {
        class FacebookPictureData {
            private String url;

            public FacebookPictureData() {
                this(null);
            }

            public FacebookPictureData(String url) {
                this.url = url;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
        private FacebookPictureData data;

        public FacebookPicture() {
            this(null);
        }

        public FacebookPicture(FacebookPictureData data) {
            this.data = data;
        }

        public FacebookPictureData getData() {
            return data;
        }

        public void setData(FacebookPictureData data) {
            this.data = data;
        }
    }
    private FacebookPicture picture;

    public FacebookProfile() {
        this(null, null, null);
    }

    public FacebookProfile(String id, String name, FacebookPicture picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FacebookPicture getPicture() {
        return picture;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(FacebookPicture picture) {
        this.picture = picture;
    }
}
