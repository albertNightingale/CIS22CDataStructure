/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class StackIsEmptyTest {
	    
		@Test 
	public void test() {
		Stack<Integer> s = new Stack<Integer>(); 
	        
	    assertEquals(true, s.isEmpty());
	    s.push(3);
	    assertEquals(false, s.isEmpty());
	    s.pop();
	    assertEquals(true, s.isEmpty());
	}
}