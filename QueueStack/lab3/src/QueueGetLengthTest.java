/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueGetLengthTest {
	    
		@Test 
	public void test() {
		Queue<Integer> q = new Queue<Integer>(); 
	        
	    assertEquals(0, q.getLength());
	    q.enqueue(3);
	    assertEquals(1, q.getLength());
	    q.enqueue(2);
	    assertEquals(2, q.getLength());
	}
}