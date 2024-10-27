package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Alice Wonderland", "Wonderland", "+123456789");
    }

    @Test
    void testContactCreation() {
        assertEquals("Alice Wonderland", contact.getName());
        assertEquals("Wonderland", contact.getAddress());
        assertEquals("+123456789", contact.getNumber());
        assertNotNull(contact.toString());
    }

    @Test
    void testSetName() {
        LocalDateTime beforeEdit = contact.getLastEdited();
        contact.setName("Alice Updated");
        assertEquals("Alice Updated", contact.getName());
        assertTrue(contact.getLastEdited().isAfter(beforeEdit));
    }

    @Test
    void testSetAddress() {
        LocalDateTime beforeEdit = contact.getLastEdited();
        contact.setAddress("Updated Address");
        assertEquals("Updated Address", contact.getAddress());
        assertTrue(contact.getLastEdited().isAfter(beforeEdit));
    }

    @Test
    void testSetNumber() {
        LocalDateTime beforeEdit = contact.getLastEdited();
        contact.setNumber("+987654321");
        assertEquals("+987654321", contact.getNumber());
        assertTrue(contact.getLastEdited().isAfter(beforeEdit));
    }

    @Test
    void testToString() {
        String contactString = contact.toString();
        assertTrue(contactString.contains("Alice Wonderland"));
        assertTrue(contactString.contains("Wonderland"));
        assertTrue(contactString.contains("+123456789"));
    }
}
