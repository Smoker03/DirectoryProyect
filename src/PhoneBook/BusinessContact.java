package PhoneBook;

public class BusinessContact extends Contact {
    private static final String IDENTIFIER = "$";
    private String businessName;

    public BusinessContact()
    {
    }

    public BusinessContact(String firstName, String lastName, String phoneNumber, String businessName){
        super(firstName, lastName, phoneNumber);
        this.businessName = businessName;
    }

    @Override
    public String toString() {
        return "$" + " Nombre = " + firstName + " | Apellido = " + lastName + " | Numero = " + phoneNumber + " | Negocio = " + businessName;
    }

    @Override
    public String toCSV() {
        return String.join(csvDelimiter, IDENTIFIER, firstName, lastName, phoneNumber, businessName);
    }
}
