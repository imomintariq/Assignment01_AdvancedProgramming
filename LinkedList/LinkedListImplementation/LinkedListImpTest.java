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
class LinkedListImpTest {
    private static LinkedListImp list = new LinkedListImp();
    @Test
    @Order(1)
    void add() {
        list.add(7);
        list.add(6);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        list.display();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "LinkedList : [ 7 6 ]";

        assertEquals(output, expectedOutput);
    }

    @Test
    @Order(2)
    void pushFront() {
        list.pushFront(10);
        list.pushFront(8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        list.display();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "LinkedList : [ 8 10 7 6 ]";

        assertEquals(output, expectedOutput);
    }

    @Test//(expected  = Exception.class)
    @Order(3)
    public void topFront() throws Exception{

        list.popFront();
        list.popFront();
        list.popFront();
        list.popFront();
        try {
            list.topFront();
        }catch(Exception e){
            System.out.println(e);
        }


    }

    @Test
    @Order(4)
    void popFront() throws Exception{
        try {
            list.popFront();
        }catch(Exception e){
            System.out.println(e);
        }

    }

    @Test
    @Order(5)
    void pushBack() {
        list.pushBack(10);
        list.pushBack(8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        list.display();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "LinkedList : [ 10 8 ]";

        assertEquals(output, expectedOutput);
    }

    @Test
    @Order(6)
    void topBack() throws Exception {
        list.popFront();
        list.popFront();
        try {
            list.topBack();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Test
    @Order(7)
    void display() {
        list.pushBack(10);
        list.pushBack(8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        list.display();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "LinkedList : [ 10 8 ]";

        assertEquals(output, expectedOutput);
    }

    @Test
    @Order(8)
    void size() {
        assertEquals(2, list.size());
    }
}