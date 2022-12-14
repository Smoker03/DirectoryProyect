package PhoneBook.screens;

import PhoneBook.Directory;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteScreen extends Screen {

    public DeleteScreen(Directory phoneDirectory) {
        super(phoneDirectory);
    }

    @Override
    public void Render() {

        //Cycle to delete another contact if the user wants to
        String deleteOtherContact;
        do {
            var query = JOptionPane.showInputDialog(null, "Ingrese el contacto que desea eliminar: \n" + this.phoneDirectory.getContacts().stream().map(contact -> contact.toString() + "\n").collect(Collectors.joining()));
            //Method store the contact found
            var contacts = this.phoneDirectory.searchContactsByName(query);
            for (var contact : contacts) {
                this.phoneDirectory.deleteContact(contact);
            }

            deleteOtherContact = JOptionPane.showInputDialog(null, "Desea eliminar otro contacto?");
        } while (List.of("y", "Y", "yes", "Yes").contains(deleteOtherContact));
        //Show the data after deleting the contact
        JOptionPane.showMessageDialog(null, this.phoneDirectory.getContacts().stream().map(contact -> contact.toString() + "\n").collect(Collectors.joining()), "Contactos del directorio despues de borrar el contacto ingresado:", JOptionPane.INFORMATION_MESSAGE, null);
    }
}
