/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class OffEndTest {
    
	@Test 
    public void test() {
        List L = new List(); 
		L.addFirst(1);
		L.addFirst(2);
        L.addFirst(3);
        L.addFirst(4);
		
        L.pointIterator();
		L.advanceIterator();

        assertEquals(false, L.offEnd());
        L.removeIterator();
        assertEquals(true, L.offEnd());
        L.pointIterator();
        assertEquals(false, L.offEnd());
	}
}
