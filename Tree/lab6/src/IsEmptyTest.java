/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class IsEmptyTest {
	
	@Test 
    public void test() {
        BST<Integer> b = new BST<Integer>(); 
        assertEquals(true, b.isEmpty());

        b.insert(10);
        b.insert(20); 
        b.insert(30);        
        
        assertEquals(false, b.isEmpty());

        BST<Integer> b2 = new BST<Integer>();

        assertEquals(false, b2.isEmpty() == b.isEmpty());



    }
}
