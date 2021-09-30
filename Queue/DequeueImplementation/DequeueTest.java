import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DequeueTest {

    private static Dequeue queue = new Dequeue(5);
    @Test
    @Order(1)
    void addLeft() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        queue.addLeft(10);
        queue.addLeft(9);
        queue.addLeft(8);
        queue.addLeft(7);
        queue.display();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "Inserting data in the left  : 10\r\nInserting data in the left  : 9\r\nInserting data in the left  : 8\r\nInserting data in the left  : 7\r\nDeQueue : 10 9 8 7 0";

        assertEquals(output, expectedOutput);
    }

    @Test
    @Order(2)
    void addRight() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        queue.addRight(11);
        queue.addRight(12);
        queue.addRight(13);
        queue.addRight(14);
        queue.display();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "Inserting data in the right : 11\r\nInserting data in the right : 12\r\nInserting data in the right : 13\r\nInserting data in the right : 14\r\nDeQueue : 10 9 8 7 11";

        assertEquals(output, expectedOutput);
    }

    @Test
    @Order(3)
    void display() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        queue.display();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "DeQueue : 10 9 8 7 11";

        assertEquals(output, expectedOutput);
    }
}