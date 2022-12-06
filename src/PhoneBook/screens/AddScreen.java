package PhoneBook.screens;

import PhoneBook.BusinessContact;
import PhoneBook.Directory;
import PhoneBook.PrivateContact;
import PhoneBook.RegularContact;

import javax.swing.*;
import java.util.stream.Collectors;

public class AddScreen {
    private Directory directory;

    public AddScreen(Directory directory){
        this.directory= directory;
    }

    public void renderAddContact(Directory directory){
        this.directory = directory;
        //Show a list to choose in a panel of JOptionPane
        String[] typeContact = new String[3];
        typeContact[0] = "Regular";
        typeContact[1] = "Privado";
        typeContact[2] = "Negocios";
        String selectedTypeContact = (String) JOptionPane.showInputDialog(null,
                                                                                "Escoja el tipo de contacto:",
                                                                                   "Tipo de contacto",
                                                                                        JOptionPane.QUESTION_MESSAGE,
                                                                                   null,
                                                                                        typeContact,
                                                                        "Regular");
        //Setting a switch to create a new Contact depends on the contact selected
         switch (selectedTypeContact) {
            case "Regular" -> {
                var firstName = JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto regular: ");
                var lastName = JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto regular: ");
                var phoneNumber = JOptionPane.showInputDialog(null, "Ingrese el numero del contacto regular: ");
                //Add a regular contact
                this.directory.addContact(new RegularContact(firstName, lastName, phoneNumber));
            }
            case "Privado" -> {
                var firstName = JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto privado: ");
                var lastName = JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto privado: ");
                var phoneNumber = JOptionPane.showInputDialog(null, "Ingrese el numero del contacto privado: ");
                //Add a private contact
                this.directory.addContact(new PrivateContact(firstName, lastName, phoneNumber));
            }
            case "Negocios" -> {
                var firstName = JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto de negocios: ");
                var lastName = JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto de negocios: ");
                var phoneNumber = JOptionPane.showInputDialog(null, "Ingrese el numero del contacto de negocios: ");
                var businessName = JOptionPane.showInputDialog(null, "Ingrese el nombre del negocio: ");
                //Add a business contact
                this.directory.addContact(new BusinessContact(firstName, lastName, phoneNumber, businessName));
            }

        default ->  JOptionPane.showInputDialog(null, "EL tipo de contacto esta incorrecto");
        }
        //Show the contacts stored in the ArrayList
        JOptionPane.showMessageDialog(null, "Contacto añadido al directorio: \n" + this.directory.getContacts().stream().map(contact -> contact.toString() + "\n")
                .collect(Collectors.joining()), "Contactos del directorio:", JOptionPane.INFORMATION_MESSAGE, null);
    }
}
