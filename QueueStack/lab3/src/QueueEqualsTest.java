/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueEqualsTest {
	    
		@Test 
	public void test() {
		Queue<Integer> q = new Queue<Integer>(); 
	    q.enqueue(3);
		Queue<Integer> q1 = new Queue<Integer>(q); 
		Queue<Integer> q2 = new Queue<Integer>(); 

	        
	    assertEquals(true, q1.equals(q));
	    q.enqueue(2);
	    assertEquals(false, q1.equals(q));
	    q1.dequeue();
	    assertEquals(true, q2.equals(q1));
	}
}