package ovh.spajste.langusta.model;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String pass; // bcrypt? sha-512?
    private static User nullUser;

    static {
        nullUser = new User(-1,null,null,null,null);
    }

    public User(long id, String firstName, String lastName, String email, String pass) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public static User getNullUser() {
        return nullUser;
    }
}
