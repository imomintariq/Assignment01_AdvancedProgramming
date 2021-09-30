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
class Queue1Test {

    private static Queue1 queue = new Queue1(5); //create queue of size=5.

    @Test
    @Order(1)
    void enqueue() throws Exception {
        queue.enqueue(10);
        queue.enqueue(12);
        try{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(byteArrayOutputStream);
            PrintStream stdout = System.out;
            System.setOut(ps);

            String[] args =null;
            queue.enqueue(10);
            queue.display();


            //System.setIn(stdin);
            System.setOut(stdout);

            String outputText = byteArrayOutputStream.toString();
            String key = "";
            String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

            String expectedOutput = "Inserting : 10\r\nQueue : 10 12 10";

            assertEquals(output, expectedOutput);
        }
        catch (Exception e){
            System.out.println(e);
        }


    }

    @Test
    @Order(2)
    void dequeue() throws Exception{
        try{
            queue.enqueue(10);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(byteArrayOutputStream);
            PrintStream stdout = System.out;
            System.setOut(ps);

            String[] args =null;

            queue.dequeue();
            queue.display();

            //System.setIn(stdin);
            System.setOut(stdout);

            String outputText = byteArrayOutputStream.toString();
            String key = "";
            String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

            String expectedOutput = "Dequeue Operation.\r\nQueue : 12 10 10";

            assertEquals(output, expectedOutput);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    @Test
    @Order(3)
    void empty() {
        assertEquals(queue.empty(),false);

        try{
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            assertEquals(queue.empty(),true);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    @Test
    @Order(4)
    void size() {
        assertEquals(queue.size(),0);

        try{
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            assertEquals(queue.size(),3);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Test
    @Order(5)
    void display() {

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(byteArrayOutputStream);
            PrintStream stdout = System.out;
            System.setOut(ps);

            String[] args = null;
            queue.display();

            //System.setIn(stdin);
            System.setOut(stdout);

            String outputText = byteArrayOutputStream.toString();
            String key = "";
            String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

            String expectedOutput = "LinkedList : [ 10 8 ]";

            assertEquals(output, expectedOutput);
        }
        catch(Exception e){
            System.out.println("OutOfBound");
        }
    }
}