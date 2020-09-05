/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class AddIteratorTest {
    
	@Test 
    public void test() {
        List L = new List(); 
        L.addFirst(10);
        L.pointIterator();
		L.addIterator(2);
        
		assertEquals(2, L.getLast());
        L.advanceIterator();
		L.addIterator(3);
        assertEquals(3, L.getLast());
        L.advanceIterator();
        L.addIterator(1); 
        assertEquals(1, L.getLast());
    }
}
