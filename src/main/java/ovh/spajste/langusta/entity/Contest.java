package ovh.spajste.langusta.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "platform_id")
    private Platform platform;
    private String postLink;
    private String topComments;
    private Integer topCommLikes;
    private Integer likesAmount;
    private String winnerId; // FB/YT id
    private Date endDate;

    public Contest() {
        this(null,null,null,null,null,null,null,null,null,null);
    }

    public Contest(Integer id, User user, String title, Platform platform, String postLink, String topComments, Integer topCommLikes, Integer likesAmount, String winnerId, Date endDate) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.platform = platform;
        this.postLink = postLink;
        this.topComments = topComments;
        this.topCommLikes = topCommLikes;
        this.likesAmount = likesAmount;
        this.winnerId = winnerId;
        this.endDate = endDate;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getPostLink() {
        return postLink;
    }

    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }

    public String getTopComments() {
        return topComments;
    }

    public void setTopComments(String topComments) {
        this.topComments = topComments;
    }

    public Integer getTopCommLikes() {
        return topCommLikes;
    }

    public void setTopCommLikes(Integer topCommLikes) {
        this.topCommLikes = topCommLikes;
    }

    public Integer getLikesAmount() {
        return likesAmount;
    }

    public void setLikesAmount(Integer likesAmount) {
        this.likesAmount = likesAmount;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
