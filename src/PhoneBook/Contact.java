package PhoneBook;

public abstract class Contact {
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String csvDelimiter = ",";
    protected String [] query;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    //Getters for the fields of "First Name", "Last Name" and "Phone Number"
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Method to match the name entered by a query for the user
    public boolean matchByName(String query){
        this.query = query.split(" ");
        if(this.query.length == 2 ){
            return this.firstName.contains(this.query[0]) && this.lastName.contains(this.query[1]) ;
        }else{
            return this.firstName.contains(this.query[0]);
        }
    }

    //Method to match the phone number entered by a query for the user
    public boolean matchByPhone(String query){
        return this.phoneNumber.contains(query);
    }

    //Method abstract to show the data into a String
    public abstract String toString();

    //Method to show the data into a CSV
    public abstract String toCSV();

    //Override for the method equals to compare two objects by his first name, last name and phone number
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Contact other = (Contact) o;
        return this.firstName.equals(other.getFirstName()) && this.lastName.equals(other.getLastName()) && this.phoneNumber.equals(other.getPhoneNumber());
    }
}