package Main;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Directory{
    private final ArrayList<Contact> contacts = new ArrayList<>();
    private final static String path = "data.txt";
    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }
    public void addContacts() {

        var contact = new Contact() {
            @Override
            public String toString() {
                return null;
            }
        };
        var bussinescontact = new BusinessContact();

        contact.setTypeContact(JOptionPane.showInputDialog(null, "Ingrese el tipo de contacto: "));
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
            case "business" -> {
                contact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto de negocios: "));
                contact.setLastName(JOptionPane.showInputDialog(null, "Ingrese el apellido del contacto de negocios: "));
                contact.setPhoneNumber(JOptionPane.showInputDialog(null, "Ingrese el numero del contacto de negocios: "));
                bussinescontact.setBusinessName(JOptionPane.showInputDialog(null, "Ingrese el nombre del negocio: "));
                var bc = new BusinessContact(contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), bussinescontact.getBusinessName());
                contacts.add(bc);
            }
            default -> System.out.println("El tipo de contacto esta incorrecto");
        }
    }
//    public boolean deleteContactbyName(){
//
//        var contact = new Contact() {
//            @Override
//            public String toString() {
//                return this.firstName;
//            }
//        };
//
//        String contfirstname = JOptionPane.showInputDialog(null, "Ingrese el contacto que desea eliminar");
//        if(contacts.contains(contfirstname)){
//            contacts.remove(addContacts().);
//        }
//        contact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el contacto que desea eliminar"));
//
//
//        contact.setFirstName(JOptionPane.showInputDialog(null, "Ingrese el contacto que desea eliminar"));
//        Comparator<Contact> firstNameComparator = Comparator.comparing(Contact :: getFirstName);
//
//        ArrayList<Contact> templist = new ArrayList<>();
//        templist.sort(firstNameComparator);
//        System.out.println(templist);
//
//        System.out.println(firstNameComparator.toString());
//
//            return contacts.removeIf(p -> contacts.contains(contact.getFirstName()));
//    }
    public String setPasswordtoPrivateContact(){
        return (JOptionPane.showInputDialog(null, "Establezca una nueva contraseña para los contactos privados"));
    }
    public void showPrivateContacts(){
        var psws = setPasswordtoPrivateContact();
        String userpw= JOptionPane.showInputDialog(null, "Ingrese la contraseña de los contactos privados");
        if(psws.equals(userpw)){
            Comparator<Contact> cptc = Comparator.comparing(Contact :: getFirstName);
            ArrayList<Contact> templist = new ArrayList<>();
            templist.sort(cptc);
            System.out.println(templist);
        }else {
            System.out.println("Contraseña incorrecta");
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
