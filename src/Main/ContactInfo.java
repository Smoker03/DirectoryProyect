package Main;

public class ContactInfo {
    private String name;
    private String lastName;
    private String phoneN;

    public ContactInfo(String name, String lastName, String phoneN) {
        this.name = name;
        this.lastName = lastName;
        this.phoneN = phoneN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneN() {
        return phoneN;
    }

    public void setPhoneN(String phoneN) {
        this.phoneN = phoneN;
    }
}