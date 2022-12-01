package Main;

import java.io.IOException;
public class MainDirectory {
    public static void main(String[] args) throws IOException {
        Directory phoneDirectory = new Directory();
        System.out.println("Adding contacts...");
//records
        var juan = new RegularContact("Juan", "Bentancur", "0987182565");
        var pedro = new PrivateContact("Pedro", "Canizares", "0987654839");
        var oscar = new BusinessContact("Oscar", "Ramirez", "09723982342", "El Titanic del Sabor");
        var patricio = new RegularContact("Patricio", "Jimenez", "0987458435");

        phoneDirectory.addContact(juan);
        phoneDirectory.addContact(pedro);
        phoneDirectory.addContact(oscar);
        phoneDirectory.addContact(patricio);
        phoneDirectory.writetoFile();
        for (var contact : phoneDirectory.getContacts()) {
            System.out.println(contact);
        }

        System.out.println("--------------------");
        var foundContactsbyName = phoneDirectory.searchContactsbyName("J");
        if (foundContactsbyName.size() == 0) {
            System.out.println("No contacts found");
        } else {
            for (var contact : foundContactsbyName) {
                System.out.println(contact);
            }
        }
        System.out.println("--------------------");
        var foundContactsbyPhoneNumber = phoneDirectory.searchContactsbyPhoneNumber("25");
        if (foundContactsbyPhoneNumber.size() == 0) {
            System.out.println("No contacts found");
        } else {
            for (var contact : foundContactsbyPhoneNumber) {
                System.out.println(contact);
            }
        }
    }
}
