/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class IsSortedTest {

    @Test
    public void test() {
        List<Integer> L = new List<Integer>();
        L.addLast(2);
        L.addLast(3);
        L.addLast(4);
        assertEquals(true, L.isSorted());
        L.addLast(1);
        assertEquals(false, L.isSorted());
        L.removeLast();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        assertEquals(true, L.isSorted());

    }

}


