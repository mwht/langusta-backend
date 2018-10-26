package ovh.spajste.langusta;

public class LoginStatus {
    public enum LoginState {
        LOGIN_STATE_SUCCESS,
        LOGIN_STATE_FAILED
    }

    private LoginState loginState;
    private long userId;
    private String token;

    public LoginStatus(LoginState loginState, long userId, String token) {
        this.loginState = loginState;
        this.userId = userId;
        this.token = token;
    }

    public long getUserId() {
        return userId;
    }

    public LoginState getLoginState() {
        return loginState;
    }

    public String getToken() { return token; }
}
