package ovh.spajste.langusta;

public class PlainLoginParameters {
    private String username;
    private String password;

    public PlainLoginParameters(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}