import org.junit.jupiter.api.Test;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArrayInsertionTest {

    private static int [] array = new int[5];
    ArrayInsertion insertionObj = new ArrayInsertion();
    @Test
    void insert() {
        insertionObj.insert(array,5, 0);
        assertEquals(array[0],5);

        insertionObj.insert(array,3, 1);
        assertEquals(array[1],3);

        insertionObj.insert(array,1, 2);
        assertEquals(array[2],1);

        insertionObj.insert(array,4, 3);
        assertEquals(array[3],4);

        insertionObj.insert(array,2, 4);
        assertEquals(array[4],2);


       /* insertionObj.insert(array,2, 4);
        assertEquals(array[4],2);
        int[] testArray = {5,3,1,4,2};
        assertArrayEquals(array, testArray);*/
    }

}