/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class LinearSearchTest {

    @Test
    public void test() {
        List<Integer> L = new List<Integer>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        assertEquals(-1, L.linearSearch(5));
        assertEquals(1, L.linearSearch(1));
        assertEquals(3, L.linearSearch(3));
    }
}


