package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PhoneBook implements Serializable {
    private List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        saveToFile("contacts.dat");
    }

    public List<Contact> searchContacts(String query) {
        List<Contact> results = new ArrayList<>();
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);

        for (Contact contact : contacts) {
            if (pattern.matcher(contact.getName()).find() ||
                    pattern.matcher(contact.getAddress()).find() ||
                    pattern.matcher(contact.getNumber()).find()) {
                results.add(contact);
            }
        }

        return results;
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            contacts = (List<Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            contacts = new ArrayList<>();
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}