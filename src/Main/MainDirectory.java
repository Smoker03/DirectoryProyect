package Main;

import java.io.IOException;
public class MainDirectory {
    public static void main(String[] args) throws IOException {
        Directory phoneDirectory = new Directory();

        var juan = new RegularContact("-","Juan", "Bentancur", "0987182565");
        var pedro = new PrivateContact("*","Pedro", "Canizares", "0987654839");
        var oscar = new BusinessContact("$","Oscar", "Ramirez", "09723982342", "El Titanic del Sabor");
        var patricio = new RegularContact("-","Patricio", "Jimenez", "0987458435");
        var martha = new PrivateContact("*", "Martha", "Corrales", "0987568412");
        var hernesto = new BusinessContact("$", "Hernesto", "Herrera", "0987453165", "GAB Motors S.A");
        var pablo = new RegularContact("-", "Pablo", "Alvarez", "0985302091");

        System.out.println("__________________________________Contacts__________________________________");
        System.out.println("Type of contacts:");
        System.out.println("'-' means  regular contact");
        System.out.println("'*' means private contact");
        System.out.println("'$' means  business contact");
        phoneDirectory.addContact(juan);
        phoneDirectory.addContact(pedro);
        phoneDirectory.addContact(oscar);
        phoneDirectory.addContact(patricio);
        phoneDirectory.addContact(martha);
        phoneDirectory.addContact(hernesto);
        phoneDirectory.addContact(pablo);
        phoneDirectory.writetoFile();
        //Display contacts added to the ArrayList
        for (var contact : phoneDirectory.getContacts()) {
            System.out.println(contact);
        }
        System.out.println("__________________________________Delete contacts__________________________________");
        phoneDirectory.deleteContact(oscar);
        System.out.println("__________________________________Found Contacts by Name__________________________________");

        //Display contact founded by query matching by name
        var foundContactsbyName = phoneDirectory.searchContactsbyName("J");
        if (foundContactsbyName.size() == 0) {
            System.out.println("No contacts found");
        } else {
            for (var contact : foundContactsbyName) {
                System.out.println(contact);
            }
        }
        System.out.println("_________________________________Found Contacts by Phone Number____________________________");
        //Display contact founded by query matching by phone number
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
