/****
*    @author Mia Skinner
* 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class GetHeightTest {
	@Test 
	 public void test() {
	    BST<Integer> b = new BST<Integer>(); 
        assertEquals(-1, b.getHeight());
	    b.insert(10);
        assertEquals(0, b.getHeight());
	    b.insert(15); 
	    b.insert(8);
        assertEquals(1, b.getHeight());      
	}

}
