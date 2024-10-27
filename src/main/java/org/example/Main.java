package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        if (args.length > 0) {
            phoneBook.loadFromFile(args[0]);
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true; // Flag to control the loop

        while (running) {
            System.out.println("[menu] Enter action (add, list, search, count, exit): ");
            String action = scanner.nextLine();

            switch (action) {
                case "add":
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.println("Enter number: ");
                    String number = scanner.nextLine();
                    phoneBook.addContact(new Contact(name, address, number));
                    break;

                case "list":
                    for (Contact contact : phoneBook.getContacts()) {
                        System.out.println(contact);
                    }
                    break;

                case "search":
                    System.out.println("Enter search query: ");
                    String query = scanner.nextLine();
                    phoneBook.searchContacts(query).forEach(System.out::println);
                    break;

                case "count":
                    System.out.println("The Phone Book has " + phoneBook.getContacts().size() + " records.");
                    break;

                case "exit":
                    running = false; // End the loop instead of calling System.exit()
                    break;

                default:
                    System.out.println("Unknown command.");
            }
            System.out.println(); // Empty line for separation
        }

        System.out.println("Exiting the program..."); // Optional message to confirm exit
    }
}
