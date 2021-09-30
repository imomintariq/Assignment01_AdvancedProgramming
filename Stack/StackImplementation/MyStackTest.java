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
class MyStackTest {


    private static MyStack stack = new MyStack(5);

    @Test
    @Order(1)
    void push() {
        try{
            stack.push(10); //push num=10
            stack.push(12); //push num=12
            stack.push(14); //push num=14
            stack.push(17); //push num=14
            stack.push(19); //push num=14

        }
        catch(Exception e){
            System.out.println(e);
        }
        int [] actualArray = {10, 12, 14, 17, 19};
        assertArrayEquals(stack.arraytostoreStack,actualArray);
    }

    @Test
    @Order(2)
    void top() throws Exception{
        assertEquals(stack.top(),19);
        assertNotEquals(stack.top(), 20);
    }

    @Test
    @Order(3)
    void pop() throws Exception{
        assertEquals(stack.pop(),19);
        assertNotEquals(stack.pop(), 19);

    }

    @Test
    @Order(4)
    void size() {
        assertEquals(stack.size(),3);
        assertNotEquals(stack.size(),4);
    }

    @Test
    @Order(5)
    void displayStack() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        stack.displayStack();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "Stack : [ 10 12 14 ]";

        assertEquals(output, expectedOutput);
    }
}