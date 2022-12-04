package PhoneBook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class DirectoryReaderTest {

    @Test
    void read() throws IOException {
        var source = new Directory();
        var john = new RegularContact("John", "Bishop", "555 555 5555");
        source.addContact(john);

        var contactsPath = "contacts_test.txt";

        var writer = new DirectoryWriter(source, contactsPath);
        writer.write();

        var reader = new DirectoryReader(contactsPath);
        var directory = reader.read();

        Assertions.assertEquals(directory.getContacts().size(), 1);
        var recoveredJohn = directory.getContacts().get(0);
        Assertions.assertEquals(recoveredJohn, john);
    }
}