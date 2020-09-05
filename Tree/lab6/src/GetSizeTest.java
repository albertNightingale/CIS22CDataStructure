/****
*    @author Mia Skinner
* 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class GetSizeTest {
	@Test 
	 public void test() {
	    BST<Integer> b = new BST<Integer>(); 
        assertEquals(0, b.getSize());
	    b.insert(10);
	    b.insert(15); 
	    b.insert(8);
        assertEquals(3, b.getSize());
        b.remove(10);
        assertEquals(2, b.getSize());        
	}

}
