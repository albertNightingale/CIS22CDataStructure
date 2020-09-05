/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class StackPushTest {
	    
		@Test 
	public void test() {
		Stack<Integer> s = new Stack<Integer>(); 
	        
		s.push(2);
	    assertEquals(2, s.peek().intValue());
	    s.push(3);
	    s.pop();
	    assertEquals(2, s.peek().intValue());
	    s.push(1); 
	    assertEquals(1, s.peek().intValue());
	}
}
