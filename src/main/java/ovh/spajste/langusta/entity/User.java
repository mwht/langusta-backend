package ovh.spajste.langusta.entity;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String pass; // bcrypt? sha-512?
    private Boolean active;

    @Column(name = "actcode")
    private String activationCode;

    private static User nullUser;

    static {
        nullUser = new User(-1,null,null,null,null,false,null);
    }

    public User() {
        this(-1,null,null,null,null,false,null);
    }

    public User(Integer id, String firstName, String lastName, String email, String pass, Boolean active, String activationCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.active = active;
        this.activationCode = activationCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPass() {
        return pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }


    public static User getNullUser() {
        return nullUser;
    }
}
