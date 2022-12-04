package PhoneBook;

public class RegularContact extends Contact {
    private static final String IDENTIFIER = "-";

    public RegularContact() {
    }

    public RegularContact(String firstName, String lastName, String phoneNumber){
        super(firstName, lastName, phoneNumber);
    }

    @Override
    public String toString() {
        return IDENTIFIER + " Nombre = " + firstName + " | Apellido = " + lastName + " | Numero = " + phoneNumber;
    }

    @Override
    public String toCSV() {
        return String.join(csvDelimeter, IDENTIFIER, firstName, lastName, phoneNumber);
    }
}
