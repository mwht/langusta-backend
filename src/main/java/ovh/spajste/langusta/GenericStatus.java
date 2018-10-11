package ovh.spajste.langusta;

public class GenericStatus {

    public enum GenericState {
        STATUS_SUCCESS,
        STATUS_ERROR
    }

    private GenericState state;
    private String additionalInfo;
    private Object payload;

    public GenericStatus(GenericState state, String additionalInfo, Object payload) {
        this.state = state;
        this.additionalInfo = additionalInfo;
        this.payload = payload;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public GenericState getState() {
        return state;
    }

    public Object getPayload() {
        return payload;
    }

    public static GenericStatus createSuccessfulStatus(Object payload) {
        return new GenericStatus(GenericState.STATUS_SUCCESS, null, payload);
    }
}
