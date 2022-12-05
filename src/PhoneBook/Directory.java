package PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class Directory{

    private final List<Contact> contacts = new ArrayList<>();

    //Method to get the contacts stored in the ArrayList
    public List<Contact> getContacts() {
        return this.contacts;
    }

    //Method to add a contact in the ArrayList
    public boolean addContact(Contact contact) {
        return this.contacts.add(contact);
    }

    //Method to delete a contact from the ArrayList
    public boolean deleteContact(Contact contact) {
        return this.contacts.remove(contact);
    }

    //Method to find a contact by his name
    public List<Contact> searchContactsByName(String query) {
        var found = new ArrayList<Contact>();
        for (var contact : contacts) {
            if (contact.matchByName(query)) {
                found.add(contact);
            }
        }
        return found;
    }

    //Method to find a contact by his phone number
    public List<Contact> searchContactsByPhoneNumber(String query){
        var found = new ArrayList<Contact>();
        for (var contact : contacts) {
            if (contact.matchByPhone(query)) {
                found.add(contact);
            }
        }
        return found;
    }
}
