package ovh.spajste.langusta.dataview;

import ovh.spajste.langusta.entity.User;

public class BasicUserDataView {
    private String email;
    private String firstName;
    private String lastName;

    public BasicUserDataView() {
        this(null, null, null);
    }

    public BasicUserDataView(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static BasicUserDataView getDataViewFor(User user) {
        return new BasicUserDataView(user.getEmail(), user.getFirstName(), user.getLastName());
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
}
