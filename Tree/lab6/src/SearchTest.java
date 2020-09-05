/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class SearchTest {
	
	@Test 
    public void test() {
        BST<Integer> b = new BST<Integer>(); 
       
        assertEquals(false, b.search(590));
        b.insert(10);
        assertEquals(true, b.search(10));
        b.remove(10);
        assertEquals(false, b.search(10));

    }
}
