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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArrayDeletionTest {
    ArrayDeletion objArraydeletion = new ArrayDeletion();
    int [] array = {1,6,34,0,2,43};

    //System.out.println("Before Deletion : ");
    //display(array);
    //array = delete(array,3);
	//	System.out.println("After Deletion of 3rd element : ");
    //display(array);*/


    @Test
    @Order(1)
    void delete() {
        objArraydeletion.delete(array,0);
        int [] testArray = {6,34,0,2,43};
        for(int i = 0; i < testArray.length;i++){
            assertEquals(testArray[i],array[i]);
        }


    }

    @Test
    @Order(2)
    void display() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        objArraydeletion.display(array);

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "1 6 34 0 2 43";

        assertEquals(output, expectedOutput);
    }

    @Test
    @Order(3)
    void main() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        objArraydeletion.main(args);

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        String expectedOutput = "Before Deletion : \r\n1 6 34 0 2 43 \r\nAfter Deletion of 3rd element : \r\n1 6 34 2 43 -1";

        assertEquals(output, expectedOutput);
    }
}