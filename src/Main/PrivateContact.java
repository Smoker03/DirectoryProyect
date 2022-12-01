package Main;

public class PrivateContact extends Contact {
    public PrivateContact(String typeContact, String firstName, String lastName, String phoneNumber){
        super(typeContact, firstName, lastName, phoneNumber);
    }
    @Override
    public String toString() {
        return typeContact + " Nombre = " + firstName + " | Apellido = " + lastName + " | Numero = " + phoneNumber;
    }
}
