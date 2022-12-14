package PhoneBook.screens;

import PhoneBook.Directory;

import javax.swing.*;
import java.util.stream.Collectors;

public class SearchScreen extends Screen{

    public SearchScreen(Directory phoneDirectory){
        super(phoneDirectory);
    }

    @Override
    public void Render(){

        String[] search = new String[2];
        search[0] = "Nombre";
        search[1] = "Numero";

        String searchOption = (String) JOptionPane.showInputDialog(null, "Ingrese la forma que quiera busca el contacto:", "Busqueda", JOptionPane.QUESTION_MESSAGE, null, search, "Nombre");
        switch (searchOption){
            case "Nombre" -> {
                //Search contact by name
                String searchName = JOptionPane.showInputDialog(null, "Inngrese el nombre que desea buscar \n" + this.phoneDirectory.getContacts().stream().map(contact -> contact.toString() + "\n")
                        .collect(Collectors.joining()));
                var searchContacts = this.phoneDirectory.searchContactsByName(searchName);
                if (searchContacts.size() == 0) {
                    //List of searchContacts is empty
                    JOptionPane.showMessageDialog(null,"Contacto no encontrado");
                } else {
                    //Contact found
                    JOptionPane.showMessageDialog(null, "Contacto encontrado: \n" + searchContacts);
                }
            }
            case "Numero" -> {
                    //Search contact by phone number
                    String searchPhoneNumber = JOptionPane.showInputDialog(null, "Inngrese el numero que desea buscar \n" + this.phoneDirectory.getContacts().stream().map(contact -> contact.toString() + "\n")
                            .collect(Collectors.joining()));
                    var searchContacts = this.phoneDirectory.searchContactsByPhoneNumber(searchPhoneNumber);
                    if (searchContacts.size() == 0) {
                        //List of searchContacts is empty
                        JOptionPane.showMessageDialog(null,"Contacto no encontrado");
                    } else {
                        //Contact found
                        JOptionPane.showMessageDialog(null, "Contacto encontrado: \n" + searchContacts);
                    }
                }
            default -> JOptionPane.showInputDialog(null, "Opcion incorrecta");
        }
    }
}
