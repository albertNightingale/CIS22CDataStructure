/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class StackEqualsTest {
	    
		@Test 
	public void test() {
		Stack<Integer> s = new Stack<Integer>(); 
	    s.push(3);
		Stack<Integer> s1 = new Stack<Integer>(s); 
		Stack<Integer> s2 = new Stack<Integer>(); 

	        
	    assertEquals(true, s1.equals(s));
	    s.push(2);
	    assertEquals(false, s1.equals(s));
	    s1.pop();
	    assertEquals(true, s2.equals(s1));
	}
}