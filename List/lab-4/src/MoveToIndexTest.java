/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveToIndexTest {

    @Test
    public void test() {
        List<Integer> L = new List<Integer>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        L.moveToIndex(1);
        assertEquals(1, (int)(L.getIterator()));
        L.moveToIndex(2);
        assertEquals(2, (int)(L.getIterator()));
        L.moveToIndex(3);
        assertEquals(3, (int)(L.getIterator()));
    }

}


