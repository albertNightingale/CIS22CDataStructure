/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void test() {
        List<Integer> L8 = new List<Integer>();
        L8.addLast(1);
        L8.addLast(2);
        L8.addLast(3);
        L8.addLast(4);
        L8.addLast(5);

        assertEquals(1, L8.binarySearch(1));
        assertEquals(2, L8.binarySearch(2));
        assertEquals(3, L8.binarySearch(3));
        assertEquals(4, L8.binarySearch(4));
        assertEquals(5, L8.binarySearch(5));
        assertEquals(-1, L8.binarySearch(100));
    }
}


