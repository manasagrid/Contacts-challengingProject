package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    private PhoneBook phoneBook;

    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBook();
        phoneBook.addContact(new Contact("Alice Wonderland", "Wonderland", "+123456789"));
        phoneBook.addContact(new Contact("Bob Builder", "Builder Street", "+987654321"));
    }

    @Test
    public void testAddContact() {
        assertEquals(2, phoneBook.getContacts().size());

        phoneBook.addContact(new Contact("Charlie Chaplin", "Hollywood", "+555555555"));

        assertEquals(3, phoneBook.getContacts().size());
    }

    @Test
    public void testSearchContacts() {
        List<Contact> results = phoneBook.searchContacts("Alice");

        assertEquals(1, results.size());
        assertEquals("Alice Wonderland", results.get(0).getName());

        results = phoneBook.searchContacts("Builder");

        assertEquals(1, results.size());
        assertEquals("Bob Builder", results.get(0).getName());

        results = phoneBook.searchContacts("Not Found");

        assertTrue(results.isEmpty());
    }

    @Test
    public void testSearchEmptyQuery() {
        List<Contact> results = phoneBook.searchContacts("");
        assertEquals(2, results.size()); // Should return all contacts if query is empty
    }

    @Test
    public void testPartialSearch() {
        List<Contact> results = phoneBook.searchContacts("Build");
        assertEquals(1, results.size());
        assertEquals("Bob Builder", results.get(0).getName());
    }

    @Test
    public void testSaveAndLoadFromFile(@TempDir File tempDir) throws IOException {
        File tempFile = new File(tempDir, "contacts_test.dat");

        phoneBook.saveToFile(tempFile.getAbsolutePath());

        PhoneBook loadedPhoneBook = new PhoneBook();
        loadedPhoneBook.loadFromFile(tempFile.getAbsolutePath());

        assertEquals(phoneBook.getContacts().size(), loadedPhoneBook.getContacts().size());
        assertEquals(phoneBook.getContacts().get(0).getName(), loadedPhoneBook.getContacts().get(0).getName());
    }
}
