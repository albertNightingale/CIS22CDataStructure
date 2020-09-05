/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveIteratorTest {
    
	@Test 
    public void test() {
        List L = new List(); 
		L.addFirst(1);
		L.addFirst(2);
        L.addFirst(3);
        L.addFirst(4);

        L.pointIterator();
        assertEquals(4, L.getIterator());
        L.removeIterator();
        L.pointIterator();
        assertEquals(3, L.getIterator());
        L.removeIterator();
        L.pointIterator();
        assertEquals(2, L.getIterator());
        L.removeIterator();
        L.pointIterator();
        assertEquals(1, L.getIterator());
    }
}
