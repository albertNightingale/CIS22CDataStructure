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
		
		L.addIterator(2);
        assertEquals(2, L.getFirst());
        L.addIterator(3);
        assertEquals(3, L.getLast());
        L.addIterator(1); 
        L.advanceIterator();
        assertEquals(1, L.getIterator());
    }
}
