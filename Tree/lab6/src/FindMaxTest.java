/****
*    @author Mia Skinner
* 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class FindMaxTest {
	@Test 
	 public void test() {
	    BST<String> b = new BST<String>(); 
	    b.insert("G");
        assertEquals("G", b.findMax());
	    b.insert("Z"); 
        assertEquals("Z", b.findMax()); 
	    b.insert("Zero");
        assertEquals("Zero", b.findMax()); 
	}

}
