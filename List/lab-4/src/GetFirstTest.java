/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class GetFirstTest {

    @Test 
    public void test() {
        List L = new List();
        L.addFirst(3);
        L.addFirst(2);
        L.addFirst(1);
        
        assertEquals(1, L.getFirst());
        L.removeFirst();
        assertEquals(2, L.getFirst());
        L.removeFirst();
        assertEquals(3, L.getFirst());
    }

}
