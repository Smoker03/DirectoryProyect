package PhoneBook;

import PhoneBook.screens.DeleteScreen;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;
public class Main {

    public static void main(String[] args) throws IOException {
        var reader = new DirectoryReader("contacts.txt");
        var phoneDirectory = reader.read();

        // Enjoy!
        phoneDirectory.getContacts().stream().map(contact -> contact.toCSV()).forEach(System.out::println);

        for (var contact : phoneDirectory.getContacts()) {
            var line = contact.toCSV();
            System.out.println(line);
        }

        System.out.println("__________________________________Contacts__________________________________");
        System.out.println("Type of contacts:");
        System.out.println("'-' means  regular contact");
        System.out.println("'*' means private contact");
        System.out.println("'$' means  business contact");

        String decision;
        do {
            addContacts(phoneDirectory);

            decision = JOptionPane.showInputDialog(null, "Desea añadir mas contactos?");
        } while (Objects.equals(decision, "y") || Objects.equals(decision, "Y"));

        for(var contact : phoneDirectory.getContacts()){
            System.out.println(contact);
        }

        var deleteScreen = new DeleteScreen(phoneDirectory);
        deleteScreen.render();

        System.out.println("__________________________________Data after deleting contact__________________________________");
        System.out.println();
        for (var contact : phoneDirectory.getContacts()) {
            System.out.println(contact);
        }


        System.out.println("__________________________________Found Contacts by Name__________________________________");
        System.out.println();
       //Display contact founded by query matching by name
        var deleteContactsbyName = phoneDirectory.searchContactsByName("El");
        if (deleteContactsbyName.size() == 0) {
            System.out.println("No contacts found");
        } else {
            for (var contact : deleteContactsbyName) {
                System.out.println(contact);
            }
        }
        System.out.println("_________________________________Found Contacts by Phone Number____________________________");
        System.out.println();
        //Display contact founded by query matching by phone number
        var foundContactsbyPhoneNumber = phoneDirectory.searchContactsByPhoneNumber("25");
        if (foundContactsbyPhoneNumber.size() == 0) {
            System.out.println("No contacts found");
        } else {
            for (var contact : foundContactsbyPhoneNumber) {
                System.out.println(contact);
            }
        }

        var writer = new DirectoryWriter(phoneDirectory, "contacts.txt");
        writer.write();
    }

    private static void addContacts(Directory phoneDirectory) {
        String typeContact = JOptionPane.showInputDialog(null, "Ingrese el tipo de contacto: ");

        switch (typeContact) {
            case "regular", "Regular", "regular contact", "Regular contact" -> {
                var firstName = JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto regular: ");
                var lastName = JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto regular: ");
                var phoneNumber = JOptionPane.showInputDialog(null, "Ingrese el numero del contacto regular: ");
                phoneDirectory.addContact(new RegularContact(firstName, lastName, phoneNumber));
            }
            case "private", "Private", "private contact", "Private contact" -> {
                var firstName = JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto privado: ");
                var lastName = JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto privado: ");
                var phoneNumber = JOptionPane.showInputDialog(null, "Ingrese el numero del contacto privado: ");
                phoneDirectory.addContact(new PrivateContact(firstName, lastName, phoneNumber));
            }
            case "business", "Business", "business contact", "Business contact" -> {
                var firstName = JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto de negocios: ");
                var lastName = JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto de negocios: ");
                var phoneNumber = JOptionPane.showInputDialog(null, "Ingrese el numero del contacto de negocios: ");
                var businessName = JOptionPane.showInputDialog(null, "Ingrese el nombre del negocio: ");
                phoneDirectory.addContact(new BusinessContact(firstName, lastName, phoneNumber, businessName));
            }
            default -> System.out.println("El tipo de contacto esta incorrecto");
        }
    }
}