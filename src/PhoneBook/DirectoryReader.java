package PhoneBook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class DirectoryReader {
    private final Path path;

    public DirectoryReader(String path) {
        this.path = Path.of(path);
    }

    //Method to read the data stored into the file text
    public Directory read() throws IOException {
        var directory = new Directory();
        var rawContacts = Files.lines(path);
        for (var rawContact : rawContacts.collect(Collectors.toList())) {
            var contactParser = new ContactParser(rawContact);
            var contact = contactParser.parse();
            directory.addContact(contact);
        }

        return directory;
    }
}
