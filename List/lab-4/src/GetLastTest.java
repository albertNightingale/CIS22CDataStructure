/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class GetLastTest {

    @Test 
    public void test() {
        List L = new List();
        L.addLast(3);
        L.addLast(2);
        L.addLast(1);
        
        assertEquals(1, L.getLast());
        L.removeLast();
        assertEquals(2, L.getLast());
        L.removeLast();
        assertEquals(3, L.getLast());
    }

}
