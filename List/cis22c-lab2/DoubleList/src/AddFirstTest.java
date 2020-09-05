/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class AddFirstTest {

    @Test 
    public void test() {
        List L = new List();
        L.addFirst(1);
        assertEquals(1, L.getLength());
        L.addFirst(2);
        assertEquals(2, L.getFirst());
        L.addFirst(3);
        assertEquals(3, L.getFirst());
    }

}