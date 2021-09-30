import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArrayTest {


    private static Array array = new Array();
    @Test
    @Order(1)
    void getValues() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("10\r\n4\r\n3\r\n2\r\n5\r\n9\r\n1\r\n6\r\n8\r\n7\r\n10\r\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        array.getValues();

        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "output:";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        int arr[] = {4,3,2,5,9,1,6,8,7,10};

        for(int i = 0; i < array.size ; i++) {

            assertEquals(array.array[i], arr[i]);

        }

    }


    @Test
    @Order(2)
    void delete() {

        array.delete(4);
        int arr[] = {4,3,2,5,1,6,8,7,10};

        for(int i = 0; i < array.size ; i++) {

            assertEquals(array.array[i], arr[i]);

        }

    }

    @Test
    @Order(3)
    void display() {
        //InputStream stdin = System.in;
        //System.setIn(new ByteArrayInputStream("10\r\n4\r\n3\r\n2\r\n5\r\n9\r\n1\r\n6\r\n8\r\n7\r\n10".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        array.display();

        //System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "output:";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        int arr[] = {4,3,2,5,1,6,8,7,10};

        for(int i = 0; i < array.size ; i++) {

            assertEquals(array.array[i], arr[i]);

        }
    }

    @Test
    @Order(4)
    void linearSearch() {
        assertEquals(array.linearSearch(10),true);
        assertEquals(array.linearSearch(9),false);

    }

    @Test
    @Order(5)
    void bubbleSort() {
        array.bubbleSort();

        int temp[] = {1,2,3,4,5,6,7,8,10};
        for(int i = 0; i < array.size ; i++) {

            assertEquals(array.array[i], temp[i]);

        }

    }

    @Test
    @Order(6)
    void binarySearch() {
        assertEquals(array.binarySearch(5,1,10),true);
        assertEquals(array.binarySearch(5,10,1),false);
        assertEquals(array.binarySearch(6,4,7),true);
        assertEquals(array.binarySearch(9,4,7),false);

    }

    @Test
    @Order(7)
    void mainTest() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("10\r\n4\r\n3\r\n2\r\n5\r\n9\r\n1\r\n6\r\n8\r\n7\r\n10\r\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        String[] args =null;
        array.main(args);

        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        int arr[] = {4,3,2,5,9,1,6,8,7,10};

        String expectedOutput ="Enter the number of values to insert:\r\nEnter the num0:\r\nEnter the num1:\r\nEnter the num2:\r\nEnter the num3:\r\nEnter the num4:\r\nEnter the num5:\r\nEnter the num6:\r\nEnter the num7:\r\nEnter the num8:\r\nEnter the num9:\r\n4 3 2 5 9 1 6 8 7 10 \r\n4 3 2 5 10 9 1 6 8 7 10 \r\n4 3 2 10 9 1 6 8 7 10 \r\nfalse\r\n1 2 3 4 6 7 8 9 10 10 \r\nfalse";
        assertEquals(expectedOutput,output);
        /*for(int i = 0; i < array.size ; i++) {

            assertEquals(array.array[i], arr[i]);

        }*/
    }
}