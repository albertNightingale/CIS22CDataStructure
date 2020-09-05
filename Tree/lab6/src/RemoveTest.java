/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class RemoveTest {
	
	@Test 
    public void test() {
        BST<Integer> b = new BST<Integer>(); 
       
        // easy
        b.insert(10);
        assertEquals(false, b.isEmpty());
        b.remove(10);
        assertEquals(true, b.isEmpty());

        // medium
        b.insert(20); 
        b.insert(30);
        b.insert(7);
        b.insert(50);
        b.remove(30);
        assertEquals(false, b.search(30));
        
        // hard 
        b.remove(20);
        assertEquals(50, b.getRoot().intValue());
    }
}
