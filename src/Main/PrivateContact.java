package Main;

import java.util.ArrayList;

public class PrivateContact extends Contact {
    public PrivateContact(String firstName, String lastName, String phoneNumber){
        super(firstName, lastName, phoneNumber);
    }
    @Override
    public String toString() {
        return String.join(" ", "* ", this.lastName, this.firstName);
    }
}
