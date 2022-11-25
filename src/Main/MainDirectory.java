package Main;

public class MainDirectory {
    public static void main(String[] args) {
        Directory phoneDirectory = new Directory();
        System.out.println("Añadiendo contactos...\n");
        phoneDirectory.typeofContact();
        phoneDirectory.addContactInformation("Jose Camino", "0998870364");
        phoneDirectory.addContactInformation("Maria Fernanda", "0987186569");
        phoneDirectory.addContactInformation("Luis Suarez", "0998856435");
        phoneDirectory.addContactInformation("Martha Pilco", "0998856324");
        phoneDirectory.addContactInformation("Herique Chavez", "0998856438");



        phoneDirectory.displayDirectory();
        System.out.println();
        phoneDirectory.replaceInformationContact("Maria Fernanda","0995689745");
        System.out.println();
        phoneDirectory.displayDirectory();
        System.out.println();
        phoneDirectory.searchNumberbyName("Jose Camino");
        System.out.println();
        phoneDirectory.displayDirectory();
        System.out.println();
        phoneDirectory.deleteContact("Martha Pilco");
        System.out.println();
        phoneDirectory.displayDirectory();
    }
}
