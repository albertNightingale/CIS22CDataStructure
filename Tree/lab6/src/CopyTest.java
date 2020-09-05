/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class CopyTest {
	
	@Test 
    public void test() {
        BST<Integer> b = new BST<Integer>(); 
        b.insert(10);
        b.insert(20); 
        b.insert(30);
        
        BST<Integer> b2 = new BST<Integer>(b);
        
        assertEquals(true, b.getRoot() == b2.getRoot());
        assertEquals(true, b.equals(b2));
        assertEquals(true, b.getSize() == b2.getSize());
		b.insert(4);
        assertEquals(false, b.equals(b2));
    }
}
