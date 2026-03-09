package opg4;

import java.util.Locale;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = null;
        this.lastName = lastName;
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFullName() {
        if (middleName == null) {
            return firstName + " " + lastName;
        }
        return firstName + " " + middleName + " " + lastName;
    }

    public String createUsername() {
        if (middleName == null) {
            return firstName.substring(0, 2).toUpperCase() + 0 + lastName.substring(lastName.length() - 2).toLowerCase();
        }
        return firstName.substring(0, 2).toUpperCase() + middleName.length() + lastName.substring(lastName.length() - 2).toLowerCase();
    }

    public String getInitials() {
        if (middleName == null) {
            return firstName.substring(0, 1) + lastName.substring(0, 1);
        }
        return firstName.substring(0, 1) + middleName.substring(0, 1) + lastName.substring(0, 1);
    }

    public String getCryptoInitials(int count) {
        char char1 = firstName.charAt(0);
        char char3 = lastName.charAt(0);

        if (middleName == null) {
            char1 = (char) (char1 + count);
            char3 = (char) (char3 + count);

            return ""+char1+char3;
        } else {
            char char2 = middleName.charAt(0);
            char1 = (char) (char1 + count);
            char2 = (char) (char2 + count);
            char3 = (char) (char3 + count);
            return ""+char1+char2+char3;
        }
    }
}

