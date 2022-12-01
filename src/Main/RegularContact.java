package Main;

import javax.swing.*;

public class RegularContact extends Contact {
    public RegularContact(String typeContact, String firstName, String lastName, String phoneNumber){
        super(typeContact, firstName, lastName, phoneNumber);
    }
    @Override
    public String toString() {
        return typeContact + " Nombre = " + firstName + " | Apellido = " + lastName + " | Numero = " + phoneNumber;
    }
}
