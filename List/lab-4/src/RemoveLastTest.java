/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveLastTest {

    @Test 
    public void test() {
        List L = new List();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        
        L.removeLast();
        assertEquals(2, L.getLast());
        L.removeLast();
        assertEquals(1, L.getLast());
        L.removeLast();
        assertEquals(true, L.isEmpty());
        assertEquals(true, L.offEnd());
    
    }

}
