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
class StackWithArrayTest {

    private static StackWithArray objStackWithArray = new StackWithArray();
    @Test
    @Order(1)
    void push() {
        objStackWithArray.push(1);
        objStackWithArray.push(2);
        objStackWithArray.push(3);
        objStackWithArray.push(4);
        objStackWithArray.push(5);
        int [] arr = {1,2,3,4,5};

        for(int i = 0; i < objStackWithArray.size; i++){
            assertEquals(objStackWithArray.array[i],arr[i]);
        }

    }

    @Test
    @Order(2)
    void pop() {
        assertEquals(objStackWithArray.pop(),5);
        int [] arr = {1,2,3,4};

        for(int i = 0; i < objStackWithArray.size; i++){
            assertEquals(objStackWithArray.array[i],arr[i]);
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
        objStackWithArray.display();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "Stack : 1 2 3 4";

        assertEquals(output, expectedOutput);
    }
}