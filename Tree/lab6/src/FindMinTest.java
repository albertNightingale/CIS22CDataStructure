/****
*    @author Mia Skinner
* 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class FindMinTest {
	@Test 
	 public void test() {
	    BST<Integer> b = new BST<Integer>(); 
	    b.insert(10);
        assertEquals(10, b.findMin().intValue());
	    b.insert(15); 
        assertEquals(10, b.findMin().intValue()); 
	    b.insert(8);
        assertEquals(8, b.findMin().intValue()); 
	}

}
