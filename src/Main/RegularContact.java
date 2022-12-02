package Main;

import javax.swing.*;

public class RegularContact extends Contact {
    public RegularContact(String firstName, String lastName, String phoneNumber){
        super(firstName, lastName, phoneNumber);
    }
    public RegularContact(String firstName){
        super(firstName);
    }
    @Override
    public String toString() {
        return "-" + " Nombre = " + firstName + " | Apellido = " + lastName + " | Numero = " + phoneNumber;
    }
}
