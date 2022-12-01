package Main;

public class RegularContact extends Contact {
    public RegularContact(String firstName, String lastName, String phoneNumber){
        super(firstName, lastName, phoneNumber);
    }
    @Override
    public String toString() {
        return "- Nombre = " + firstName + " | Apellido = " + lastName + " | Numero = " + phoneNumber;
    }
}
