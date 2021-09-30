import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
class QueueWithArrayTest {

    private static QueueWithArray queueWithArray = new QueueWithArray(5); //create a queue
    @Test
    @Order(1)
    void enqueue() {
        queueWithArray.enqueue(10);
        queueWithArray.enqueue(12);
        queueWithArray.enqueue(14);
        queueWithArray.enqueue(16);
        int [] arr = {10,12,14,16};
        for(int i = 0; i < queueWithArray.size;i++){
            assertEquals(queueWithArray.array[i],arr[i]);
        }

    }

    @Test
    @Order(2)
    void dequeue() {
        queueWithArray.dequeue();
        queueWithArray.dequeue();
        int [] arr = {10,12};
        for(int i = 0; i < queueWithArray.size;i++){
            assertEquals(queueWithArray.array[i],arr[i]);
        }
    }

    @Test
    @Order(3)
    void display() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        queueWithArray.display();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "Queue : 14 16";

        assertEquals(output, expectedOutput);
    }
}