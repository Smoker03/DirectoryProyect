package PhoneBook;

import PhoneBook.screens.Screen;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var reader = new DirectoryReader("contacts.txt");
        var phoneDirectory = reader.read();

        Screen showScreen = new Screen(phoneDirectory);
        showScreen.Render();

        var writer = new DirectoryWriter(phoneDirectory, "contacts.txt");
        writer.write();
    }
}