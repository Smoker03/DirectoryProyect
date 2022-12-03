package Main;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;
public class MainDirectory {
    public static void main(String[] args) throws IOException {
        Directory phoneDirectory = new Directory();
        PrivateContact pc = new PrivateContact();

        System.out.println("__________________________________Contacts__________________________________");
        System.out.println("Type of contacts:");
        System.out.println("'-' means  regular contact");
        System.out.println("'*' means private contact");
        System.out.println("'$' means  business contact");

        String decision;
        do {
            phoneDirectory.addContacts();
            decision = JOptionPane.showInputDialog(null, "Desea añadir mas contactos?");
        } while (Objects.equals(decision, "y") || Objects.equals(decision, "Y"));

        for(var contact : phoneDirectory.getContacts()){
            System.out.println(contact);
        }

        //phoneDirectory.showPrivateContacts();

        System.out.println("__________________________________Delete contacts__________________________________");
        System.out.println();
        String deleteOtherContact;

        String deletedData =(JOptionPane.showInputDialog(null, "Desea eliminar algun contacto?"));
        if (deletedData.equals("y") || deletedData.equals("y") || deletedData.equals("yes") || deletedData.equals("Yes")) {
            do {
                phoneDirectory.deletedContact();
                deleteOtherContact = (JOptionPane.showInputDialog(null, "Desea eliminar otro contacto?"));
            } while (Objects.equals(deleteOtherContact, "y") || Objects.equals(deleteOtherContact, "Y") || Objects.equals(deleteOtherContact, "yes") || Objects.equals(deleteOtherContact, "Yes"));
        }

        System.out.println("__________________________________Data after deliting contact__________________________________");
        System.out.println();
        for (var contact : phoneDirectory.getContacts()) {
            System.out.println(contact);
        }


        System.out.println("__________________________________Found Contacts by Name__________________________________");
        System.out.println();
       //Display contact founded by query matching by name
        var deleteContactsbyName = phoneDirectory.searchContactsbyName("El");
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
        var foundContactsbyPhoneNumber = phoneDirectory.searchContactsbyPhoneNumber("25");
        if (foundContactsbyPhoneNumber.size() == 0) {
            System.out.println("No contacts found");
        } else {
            for (var contact : foundContactsbyPhoneNumber) {
                System.out.println(contact);
            }
        }
        String addData =(JOptionPane.showInputDialog(null, "Desea agragar los datos a un archivo de texto?"));
        if (addData.equals("y") || addData.equals("y")){
            phoneDirectory.writetoFile();
        }
    }
}
