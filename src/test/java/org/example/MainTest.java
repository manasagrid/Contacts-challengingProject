package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testAddContact() {
        String simulatedInput = "add\nJohn Doe\n123 Main St\n+123456789\nexit\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Main.main(new String[]{});

        assertTrue(outputStreamCaptor.toString().contains("Enter name:"));
        assertTrue(outputStreamCaptor.toString().contains("Enter address:"));
        assertTrue(outputStreamCaptor.toString().contains("Enter number:"));
    }

    @Test
    public void testExit() {
        String simulatedInput = "exit\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Main.main(new String[]{});

        assertTrue(outputStreamCaptor.toString().contains("Exiting the program..."));
    }
}
