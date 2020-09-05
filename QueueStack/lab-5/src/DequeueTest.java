/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class DequeueTest {
	    
		@Test 
	public void test() {
		Queue q = new Queue(); 
	    
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("4");

		q.dequeue();
	    assertEquals("2", q.getFront());
	    q.dequeue();
	    assertEquals("3", q.getFront());	    
	    q.dequeue();
	    assertEquals("4", q.getFront()); 
	}
}