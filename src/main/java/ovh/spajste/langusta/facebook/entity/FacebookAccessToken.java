package ovh.spajste.langusta.facebook.entity;

import ovh.spajste.langusta.entity.User;

import javax.persistence.*;

@Entity
public class FacebookAccessToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    private String accessToken;

    public FacebookAccessToken() {
        this(null, null, null);
    }

    public FacebookAccessToken(Integer id, User user, String accessToken) {
        this.id = id;
        this.user = user;
        this.accessToken = accessToken;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
