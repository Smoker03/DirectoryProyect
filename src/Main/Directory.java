package Main;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Directory {
    protected String name;
    protected String phoneNumber;
    protected final HashMap<String, String> directory = new HashMap<>();

    protected final static String path = "data.txt";
    Scanner tc = new Scanner(System.in);
    public String typeofContact(){
        System.out.print("Ingrese el tipo de contacto: ");
        String typeContact = tc.nextLine();
        String identificator = switch (typeContact) {
            case "Regular" -> "-";
            case "Private" -> "*";
            case "Negocios" -> "$";
            default -> throw new IllegalStateException("El tipo de contacto ingresado no esta " +
                    "en nuestro directorio: " + typeContact);
        };
        return identificator;
    }
    public void addContactInformation(String addName, String addNumber) {
        name = addName;
        phoneNumber = addNumber;
        String typeName;
        if (name != null && phoneNumber.length() == 10) {
            typeName = typeofContact() + addName;
            directory.put(typeName, phoneNumber);
        } else {
            System.out.println("El numero " + phoneNumber + " no es valido o no añadio ningun nombre al contacto.");
        }
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(path));
            for (Map.Entry pairEntry : directory.entrySet()) {
                bf.write(pairEntry.getKey() + ": " + pairEntry.getValue());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bf != null;
                bf.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteContact(String name) {
        this.name = name;
        directory.remove(name);
        System.out.println("Borrando el contacto de: " + name);
    }

    public void searchNumberbyName(String name) {
        this.name = name;
        if (directory.containsKey(name)) {
            System.out.println("El numero del señ@r " + name + " es " + directory.get(name));
        } else {
            System.out.println("No se encuentra el numero que used busca");
        }
    }

    public void displayDirectory() {
        for (Map.Entry pairEntry : directory.entrySet()) {
            System.out.println((pairEntry.getKey() + " : " + pairEntry.getValue()));
        }
    }

    public void replaceInformationContact(String name, String number) {
        this.name = name;
        this.phoneNumber = number;
        System.out.println("Reemplando el numero de " + name + ": " + directory.get(name) + " por " + number);
        directory.replace(name, directory.get(name), number);
    }
}