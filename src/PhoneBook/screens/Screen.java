package PhoneBook.screens;

import PhoneBook.Directory;
import javax.swing.*;
import java.util.List;

public class Screen {

    protected Directory phoneDirectory;

    public Screen(Directory phoneDirectory){
        this.phoneDirectory =  phoneDirectory;
    }

    public void Render(){
        new JOptionPane();
        JOptionPane.showMessageDialog(null,
                """
                        El contacto regular es representado por '-'
                        El contacto privado es representado por '*'
                        El contacto de negocios es representado por '$'""",
                "Directorio",
                JOptionPane.INFORMATION_MESSAGE);

        String[] options = new String[3];
        options[0] = "Añadir Contactos";
        options[1] = "Eliminar Contactos";
        options[2] = "Buscar Contactos";

        var selection = JOptionPane.showOptionDialog(null,
                "Escoja la opcion que desea realizar",
                "Directorio",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                null);

        switch (selection){
            case 0 -> {
                //Cycle to add more than one contact
                String decision;
                do {
                    //Screen to add a new contact
                    var renderA = new AddScreen(phoneDirectory);
                    //Method to add a new contact
                    renderA.Render(phoneDirectory);

                    decision = JOptionPane.showInputDialog(null, "Desea añadir mas contactos?");
                } while (List.of("y", "Y", "Yes", "yes").contains(decision));
            }
            case 1 -> {
                //Screen to delete a contact
                var renderD = new DeleteScreen(phoneDirectory);
                //Method to delete a contact
                renderD.Render();
            }
            case 2 -> {
                //Screen to search a contact
                var renderS = new SearchScreen(phoneDirectory);
                //Method to search a contact
                renderS.Render();
            }
        }
    }

}
