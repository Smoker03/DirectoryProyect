package PhoneBook;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

class DirectoryWriterTest {
    @Test
    void write() {
        var directory = new Directory();
        var john = new RegularContact("John", "Bishop", "555 555 5555");
        var ethan = new RegularContact("Ethan", "May", "555 555 5556");
        var contactsPath = "contacts_test.txt";

        directory.addContact(john);
        directory.addContact(ethan);

        var writer = new DirectoryWriter(directory, contactsPath);

        try {
            writer.write();

            var lines = Files.lines(Path.of(contactsPath));
            var content = lines.collect(Collectors.joining("\n"));

            Assert.assertEquals("-,John,Bishop,555 555 5555\n-,Ethan,May,555 555 5556", content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}