package Main;

public abstract class Contact {
    protected String typeContact;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;

    public Contact(String typeContact, String firstName, String lastName, String phoneNumber) {
        this.typeContact = typeContact;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    public abstract String toString();
    public boolean matchbyName(String query){
        return this.firstName.contains(query) || this.lastName.contains(query);
    }
    public boolean matchbyPhoneNumber(String query){
        return this.phoneNumber.contains(query);
    }
}