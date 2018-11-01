package ovh.spajste.langusta.facebook.entity;

import ovh.spajste.langusta.entity.Session;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "facebook_post_log")
public class FacebookPostLogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String content;
    private Date postDate;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "session_id")
    private Session session;

    public FacebookPostLogEntry() {
        this(null, null, null, null);
    }

    public FacebookPostLogEntry(Integer id, String content, Date postDate, Session session) {
        this.id = id;
        this.content = content;
        this.postDate = postDate;
        this.session = session;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
