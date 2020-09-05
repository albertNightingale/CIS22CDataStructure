/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueIsEmptyTest {
	    
		@Test 
	public void test() {
		Queue<Integer> q = new Queue<Integer>(); 
	        
	    assertEquals(true, q.isEmpty());
	    q.enqueue(3);
	    assertEquals(false, q.isEmpty());
	    q.dequeue();
	    assertEquals(true, q.isEmpty());
	}
}