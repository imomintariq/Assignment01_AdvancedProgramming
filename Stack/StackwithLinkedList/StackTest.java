import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StackTest {

    Stack stack = new Stack(); //create new stack.
    @Test
    @Order(1)
    void push() {
        stack.push(10);            //push num = 10
        stack.push(20);            //push num = 20
        stack.push(30);            //push num = 30
        int [] testArray= {30,20,10};
        for(int i = 0; i < stack.size ; i++){
            assertEquals(testArray[i],stack.pop());
        }

    }

    @Test
    @Order(2)
    void top() {
        stack.push(10);            //push num = 10
        stack.push(20);            //push num = 20
        stack.push(30);            //push num = 30

        assertEquals(30,stack.top());

    }

    @Test
    @Order(3)
    void pop() {
        stack.push(10);            //push num = 10
        stack.push(20);            //push num = 20
        stack.push(30);            //push num = 30
        int [] testArray= {30,20,10};
        for(int i = 0; i < stack.size ; i++){
            assertEquals(testArray[i],stack.pop());
        }
    }

    @Test
    @Order(4)
    void display() {
        stack.push(10);            //push num = 10
        stack.push(20);            //push num = 20
        stack.push(30);            //push num = 30

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        stack.display();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "Stack \r\n----------\r\n|   30   |\r\n----------\r\n|   20   |\r\n----------\r\n|   10   |\r\n----------";

        assertEquals(output, expectedOutput);
    }

    @Test
    @Order(5)
    void getSize() {
        stack.push(10);            //push num = 10
        stack.push(20);            //push num = 20
        stack.push(30);            //push num = 30
        assertEquals(stack.getSize(),3);
    }
}