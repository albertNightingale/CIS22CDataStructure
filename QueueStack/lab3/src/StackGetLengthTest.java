/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class StackGetLengthTest {
	    
		@Test 
	public void test() {
		Stack<Integer> s = new Stack<Integer>(); 
	        
	    assertEquals(0, s.getLength());
	    s.push(3);
	    assertEquals(1, s.getLength());
	    s.push(2);
	    assertEquals(2, s.getLength());
	}
}