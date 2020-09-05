/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class InsertTest {
	
	@Test 
    public void test() {
        BST<Integer> b = new BST<Integer>(); 
       
        b.insert(10);
        assertEquals(10, b.getRoot().intValue());
        
        b.insert(20); 
        b.insert(30);
        assertEquals(3, b.getSize());
        b.insert(50);
        assertEquals(3, b.getHeight());
    }
}
