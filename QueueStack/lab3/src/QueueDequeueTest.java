/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueDequeueTest {
	    
		@Test 
	public void test() {
		Queue<Integer> q = new Queue<Integer>(); 
	        
		q.enqueue(2);
	    assertEquals(2, q.getFront().intValue());
	    q.dequeue();
	    q.enqueue(3);
	    assertEquals(3, q.getFront().intValue());	    
	    q.dequeue();
	    q.enqueue(1); 
	    assertEquals(1, q.getFront().intValue()); 
	}
}