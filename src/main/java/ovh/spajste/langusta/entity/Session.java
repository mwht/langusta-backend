package ovh.spajste.langusta.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String sessionToken;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private Date loginDate;
    private Date expiryDate;
    private String loginIp;
    private String userAgent;

    public Session() {
        this(null, null, null, null, null, null);
    }

    public static String getNewToken() {
        return UUID.randomUUID().toString();
    }

    public Session(Integer id, String sessionToken, User user, Date loginDate, String loginIp, String userAgent) {
        this.id = id;
        this.sessionToken = sessionToken;
        this.user = user;
        this.loginDate = loginDate;
        if(loginDate != null)
            this.expiryDate = new Date(loginDate.getTime() + (60000 * 15));
        else
            this.expiryDate = null;
        this.loginIp = loginIp;
        this.userAgent = userAgent;
    }

    public Integer getId() {
        return id;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public User getUser() {
        return user;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
