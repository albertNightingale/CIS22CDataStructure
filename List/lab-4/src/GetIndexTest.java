/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class GetIndexTest {

    @Test
    public void test() {
        List<Integer> L = new List<Integer>();
        L.addLast(2);
        L.addLast(3);
        L.addLast(4);
        L.pointIterator();
        assertEquals(1, L.getIndex());
        L.advanceIterator();
        assertEquals(2, L.getIndex());
        L.advanceIterator();
        assertEquals(3, L.getIndex());

    }

}


