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
    private User userId;

    private String accessToken;
    private Date expiryDate;

    public YoutubeAccessToken() {
        this(null, null, null, null);
    }

    public YoutubeAccessToken(Integer id, Integer userId, String accessToken, Date expiryDate) {
        this.id = id;
        this.userId = userId;
        this.accessToken = accessToken;
        this.expiryDate = expiryDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
