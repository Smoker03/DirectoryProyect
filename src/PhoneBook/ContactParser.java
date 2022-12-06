package PhoneBook;

public class ContactParser {
    private final String[] rawContact;

    public ContactParser(String rawContact) {
        this.rawContact = rawContact.split(",");
    }

    public Contact parse() {
        var contactType = this.rawContact[0];
        switch (contactType) {
            case "-" -> {
                return new RegularContact(this.rawContact[1], this.rawContact[2], this.rawContact[3]);
            }
            case "*" -> {
                return new PrivateContact(this.rawContact[1], this.rawContact[2], this.rawContact[3]);
            }
            case "$" -> {
                return new BusinessContact(this.rawContact[1], this.rawContact[2], this.rawContact[3], this.rawContact[4]);
            }
            default -> throw new RuntimeException("Invalid contact type");
        }
    }
}
