package ovh.spajste.langusta;

public class LoginStatus {
    public enum LoginState {
        LOGIN_STATE_SUCCESS,
        LOGIN_STATE_DBERROR,
        LOGIN_STATE_FAILED
    }

    private LoginState loginState;
    private long userId;

    public LoginStatus(LoginState loginState, long userId) {
        this.loginState = loginState;
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public LoginState getLoginState() {
        return loginState;
    }
}
