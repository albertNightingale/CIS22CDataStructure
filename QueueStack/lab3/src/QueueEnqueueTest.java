/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueEnqueueTest {
	    
		@Test 
	public void test() {
		Queue<Integer> q = new Queue<Integer>(); 
	        
		q.enqueue(2);
	    assertEquals(2, q.getFront().intValue());
	    q.enqueue(3);
	    q.dequeue();
	    assertEquals(3, q.getFront().intValue());
	    q.enqueue(1); 
	    q.dequeue();
	    assertEquals(1, q.getFront().intValue());
	}
}
