package PhoneBook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class DirectoryWriter {
    private final Directory directory;
    private final String path;

    public DirectoryWriter(Directory directory, String path) {
        this.directory = directory;
        this.path = path;
    }

    //Method to write the data stored in the ArrayList into a text file
    public void write() throws IOException {
        BufferedWriter ous = new BufferedWriter(new FileWriter(this.path, false));
        var content = this.directory.getContacts()
                .stream()
                .map(contact -> contact.toCSV() + "\n")
                .collect(Collectors.joining());

        ous.write(content);

        ous.close();
    }
}
