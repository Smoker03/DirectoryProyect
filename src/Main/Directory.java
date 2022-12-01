package Main;

import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory{
    private final ArrayList<Contact> contacts = new ArrayList<>();
    private final static String path = "data.txt";
    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }
    public void addContact() {
        Contact contact;
        BusinessContact businessContact;
        String decision;
        do {
            contact.setTypeContact(JOptionPane.showInputDialog( null,"Ingrese el tipo de contacto: "));
            switch (contact.getTypeContact()) {
                case "regular" -> {
                    contact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto regular: "));
                    contact.setLastName(JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto regular: "));
                    contact.setPhoneNumber(JOptionPane.showInputDialog(null, "Ingrese el numero del contacto regular: "));
                    var rc = new RegularContact(contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber());
                    contacts.add(rc);
                }
                case "private" -> {
                    contact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto privado: "));
                    contact.setLastName(JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto privado: "));
                    contact.setPhoneNumber(JOptionPane.showInputDialog(null, "Ingrese el numero del contacto privado: "));
                    var pc = new PrivateContact(contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber());
                    contacts.add(pc);
                }
                case "bussines" -> {
                    contact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto de negocios: "));
                    contact.setLastName(JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto de negocios: "));
                    contact.setPhoneNumber(JOptionPane.showInputDialog(null, "Ingrese el numero del contacto de negocios: "));
                    businessContact.setBusinessName(JOptionPane.showInputDialog(null, "Ingrese el nombre del negocio: "));
                    var bc = new BusinessContact(contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), businessContact.getBusinessName());
                    contacts.add(bc);
                }
            }
            decision = JOptionPane.showInputDialog(null, "Desea añadir mas contactos?");
        } while (Objects.equals(decision, "y") || Objects.equals(decision, "Y"));
    }
    public boolean deleteContact(Contact contact) {
        System.out.println("Contact " +contact.firstName+ " deleted");
        return contacts.remove(contact);
    }
    public List<Contact> searchContactsbyName(String query) {
        var found = new ArrayList<Contact>();
        for (var contact : contacts) {
            if (contact.matchbyName(query)) {
                found.add(contact);
            }
        }
        return found;
    }
    public List<Contact> searchContactsbyPhoneNumber(String query){
        var found = new ArrayList<Contact>();
        for (var contact : contacts) {
            if (contact.matchbyPhoneNumber(query)) {
                found.add(contact);
            }
        }
        return found;
    }
    public void writetoFile()  throws IOException{
        BufferedWriter ous = new BufferedWriter(new FileWriter(path));
        for (var contact : this.getContacts()) {
            ous.write(String.valueOf((contact)).concat("\n"));
        }
        ous.close();
    }
}
