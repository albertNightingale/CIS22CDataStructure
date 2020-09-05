/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class AdvanceIteratorTest {
    
	@Test 
    public void test() {
        List L = new List(); 
		L.addFirst(1);
		L.addFirst(2);
        L.addFirst(3);
        L.addFirst(4);
		
		L.pointIterator();
        assertEquals(4, L.getIterator());
        L.advanceIterator();
        assertEquals(3, L.getIterator());
        L.advanceIterator();
        assertEquals(2, L.getIterator());
        L.advanceIterator();
        assertEquals(1, L.getIterator());
    }
}
