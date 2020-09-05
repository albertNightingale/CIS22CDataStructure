/****
*    @author Mia Skinner
* 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class GetRootTest {
	@Test 
	 public void test() {
	    BST<Integer> b = new BST<Integer>(); 
	    b.insert(10);
	    b.insert(15); 
	    b.insert(8);
        assertEquals(10, b.getRoot().intValue());
        b.remove(10);
        assertEquals(15, b.getRoot().intValue());
        b.remove(15);
        assertEquals(8, b.getRoot().intValue());
        
	}

}
