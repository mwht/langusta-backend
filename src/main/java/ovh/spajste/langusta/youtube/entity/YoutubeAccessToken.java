package ovh.spajste.langusta.youtube.entity;

import ovh.spajste.langusta.entity.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class YoutubeAccessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private String accessToken;
    private Date expiryDate;

    public YoutubeAccessToken() {
        this(null, null, null, null);
    }

    public YoutubeAccessToken(Integer id, User userId, String accessToken, Date expiryDate) {
        this.id = id;
        this.user = userId;
        this.accessToken = accessToken;
        this.expiryDate = expiryDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
