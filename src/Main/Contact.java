package Main;

public abstract class Contact {
    protected String typeContact;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    public Contact(){}
    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getTypeContact() {
        return typeContact;
    }

    public void setTypeContact(String typeContact) {
        this.typeContact = typeContact;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean matchbyName(String query){
        return this.firstName.contains(query) || this.lastName.contains(query);
    }
    public boolean matchbyPhoneNumber(String query){
        return this.phoneNumber.contains(query);
    }
    public abstract String toString();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact compareFirstName = (Contact) o;
        return firstName.equals(compareFirstName.firstName);
    }
}