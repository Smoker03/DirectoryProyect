package PhoneBook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectoryTest {
    @Test
    void addContact() {
        // Arrange
        var directory = new Directory();
        var regularContact = new RegularContact();
        var businessContact = new BusinessContact();
        var privateContact = new PrivateContact();

        // Act
        directory.addContact(regularContact);
        directory.addContact(businessContact);
        directory.addContact(privateContact);

        // Assert
        Assertions.assertEquals(directory.getContacts().size(), 3);
        Assertions.assertEquals(directory.getContacts().get(0), regularContact);
        Assertions.assertEquals(directory.getContacts().get(1), businessContact);
        Assertions.assertEquals(directory.getContacts().get(2), privateContact);
    }

    @Test
    void deleteContact() {
        var directory = new Directory();
        var john = new RegularContact();
        var peter = new RegularContact();

        directory.addContact(john);
        directory.addContact(peter);

        Assertions.assertEquals(directory.getContacts().size(), 2);

        directory.deleteContact(john);

        Assertions.assertEquals(directory.getContacts().size(), 1);
        Assertions.assertEquals(directory.getContacts().get(0), peter);
    }
}