package Main;

public class PrivateContact extends Contact {
    public PrivateContact(String firstName, String lastName, String phoneNumber){
        super(firstName, lastName, phoneNumber);
    }
    @Override
    public String toString() {
        return "*" + " Nombre = " + firstName + " | Apellido = " + lastName + " | Numero = " + phoneNumber;
    }
}
