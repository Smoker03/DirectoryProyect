package PhoneBook.screens;

import PhoneBook.Directory;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class DeleteScreen {
    private Directory directory;

    public DeleteScreen(Directory directory) {
        this.directory = directory;
    }

    public void render() {
        System.out.println("__________________________________Delete contacts__________________________________");
        System.out.println();
        String deleteOtherContact;

        String deletedData = JOptionPane.showInputDialog(null, "Desea eliminar algun contacto?");
        if (List.of("y", "Y", "yes", "Yes").contains(deletedData)) {

            do {
                var query = JOptionPane.showInputDialog(null, "Ingrese el contacto que desea eliminar: ");
                var contacts = this.directory.searchContactsByName(query);
                for (var contact : contacts) {
                    this.directory.deleteContact(contact);
                }

                deleteOtherContact = JOptionPane.showInputDialog(null, "Desea eliminar otro contacto?");
            } while (Objects.equals(deleteOtherContact, "y") || Objects.equals(deleteOtherContact, "Y") || Objects.equals(deleteOtherContact, "yes") || Objects.equals(deleteOtherContact, "Yes"));
        }
    }
}
