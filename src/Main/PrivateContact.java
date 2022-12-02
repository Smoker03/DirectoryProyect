package Main;

import javax.swing.*;

public class PrivateContact extends Contact {
    public PrivateContact(){}
    public PrivateContact(String firstName, String lastName, String phoneNumber){
        super(firstName, lastName, phoneNumber);
    }
    public PrivateContact(String firstName){
        super(firstName);
    }
    @Override
    public String toString() {
        return "*" + " Nombre = " + firstName + " | Apellido = " + lastName + " | Numero = " + phoneNumber;
    }
}
