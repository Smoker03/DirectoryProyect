package PhoneBook;

public class PrivateContact extends Contact {
    private static final String IDENTIFIER = "*";
    public PrivateContact() {
    }

    public PrivateContact(String firstName, String lastName, String phoneNumber){
        super(firstName, lastName, phoneNumber);
    }

    @Override
    public String toString() {
        return "*" + " Nombre = " + firstName + " | Apellido = " + lastName + " | Numero = " + phoneNumber;
    }

    @Override
    public String toCSV() {
        return String.join(csvDelimiter, IDENTIFIER, firstName, lastName, phoneNumber);
    }
}
