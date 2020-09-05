/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class EqualsTest {
	
	@Test 
    public void test() {
        BST<Integer> b = new BST<Integer>(); 
        b.insert(10);
        b.insert(20); 
        b.insert(30);
        
        BST<Integer> b2 = new BST<Integer>(b);
        
        
        assertEquals(true, b.equals(b2) == b2.equals(b));
        assertEquals(false, b.equals(null));
        b2 = new BST<Integer>(); 
        assertEquals(false, b.equals(b2));
        BST<String> stringb = new BST<String>(); 
        //assertEquals(false, stringb.equals(b2));


    }
}
