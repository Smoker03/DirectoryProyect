package Main;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory{
    private final ArrayList<Contact> contacts = new ArrayList<>();
    private final static String path = "data.txt";
    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }

    public void addContacts() {
        var regularContact = new RegularContact();
        var privateContact = new PrivateContact();
        var businessContact = new BusinessContact();

        String typeContact = (JOptionPane.showInputDialog(null, "Ingrese el tipo de contacto: "));
        switch (typeContact) {
            case "regular", "Regular", "regular contact", "Regular contact" -> {
                regularContact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto regular: "));
                regularContact.setLastName(JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto regular: "));
                regularContact.setPhoneNumber(JOptionPane.showInputDialog(null, "Ingrese el numero del contacto regular: "));
                contacts.add(regularContact);
            }
            case "private", "Private", "private contact", "Private contact" -> {
                privateContact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto privado: "));
                privateContact.setLastName(JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto privado: "));
                privateContact.setPhoneNumber(JOptionPane.showInputDialog(null, "Ingrese el numero del contacto privado: "));
                contacts.add(privateContact);
            }
            case "business", "Business", "business contact", "Business contact" -> {
                businessContact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto de negocios: "));
                businessContact.setLastName(JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto de negocios: "));
                businessContact.setPhoneNumber(JOptionPane.showInputDialog(null, "Ingrese el numero del contacto de negocios: "));
                businessContact.setBusinessName(JOptionPane.showInputDialog(null, "Ingrese el nombre del negocio: "));
                contacts.add(businessContact);
            }
            default -> System.out.println("El tipo de contacto esta incorrecto");
        }
    }
    public void deletedContact(){
        var businessContact = new BusinessContact();
        var regularContact = new RegularContact();
        var privateContact = new PrivateContact();
        ArrayList<Contact> fList = new ArrayList<>();

        String nametoDeleted = JOptionPane.showInputDialog(null, "Ingrese el tipo de contacto que desea eliminar");
        switch (nametoDeleted) {
            case "Regular contact", "regular contact", "Regular", "regular" -> {
                regularContact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el contacto que desea eliminar: "));
                for( Contact a : contacts) {
                    if (a.getFirstName().equals(regularContact.getFirstName())) {
                        fList.add(a);
                    }
                }
                contacts.remove(fList.get(0));
                fList.clear();
            }
            case "Private contact", "private contact", "Private", "private" -> {
                privateContact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el contacto que desea eliminar: "));
                for( Contact a : contacts) {
                    if (a.getFirstName().equals(privateContact.getFirstName())) {
                        fList.add(a);
                    }
                }
                contacts.remove(fList.get(0));
                fList.clear();
            }
            case "Business contact", "business contact", "Business", "business" -> {
                businessContact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el contacto que desea eliminar: "));
                for( Contact a : contacts) {
                    if (a.getFirstName().equals(businessContact.getFirstName())) {
                        fList.add(a);
                    }
                }
                contacts.remove(fList.get(0));
                fList.clear();
            }
        }
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
        BufferedWriter ous = new BufferedWriter(new FileWriter(path, true));
        for (var contact : this.getContacts()) {
            ous.write(String.valueOf((contact)).concat("\n"));
        }
        ous.close();
    }
    public void displayDataFile(){
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader (path);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null){
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != fr) {
                    Objects.requireNonNull(br).close();
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
