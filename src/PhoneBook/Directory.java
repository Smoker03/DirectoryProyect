package PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class Directory{
    private final List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return this.contacts;
    }

    public boolean addContact(Contact contact) {
        return this.contacts.add(contact);
    }

    public boolean deleteContact(Contact contact) {
        return this.contacts.remove(contact);
    }

    public List<Contact> searchContactsByName(String query) {
        var found = new ArrayList<Contact>();
        for (var contact : contacts) {
            if (contact.matchByName(query)) {
                found.add(contact);
            }
        }
        return found;
    }
    public List<Contact> searchContactsByPhoneNumber(String query){
        var found = new ArrayList<Contact>();
        for (var contact : contacts) {
            if (contact.searchByPhone(query)) {
                found.add(contact);
            }
        }
        return found;
    }
}
