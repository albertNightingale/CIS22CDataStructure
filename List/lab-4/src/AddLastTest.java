/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class AddLastTest {

    @Test 
    public void test() {
        List L = new List();
        L.addLast(1);
        assertEquals(1, L.getLength());
        L.addLast(2);
        assertEquals(2, L.getLast());
        L.addLast(3);
        assertEquals(3, L.getLast());
    }

}
