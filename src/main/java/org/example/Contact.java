package org.example;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Contact implements Serializable {
    private String name;
    private String address;
    private String number;
    private LocalDateTime created;
    private LocalDateTime lastEdited;

    public Contact(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.created = LocalDateTime.now();
        this.lastEdited = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateLastEdited();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        updateLastEdited();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
        updateLastEdited();
    }

    public LocalDateTime getLastEdited() {
        return lastEdited;
    }

    private void updateLastEdited() {
        this.lastEdited = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nNumber: " + number +
                "\nTime created: " + created + "\nTime last edit: " + lastEdited;
    }
}
