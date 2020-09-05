/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class EnqueueTest {
	    
	@Test 
	public void test() {
		Queue q = new Queue(); 
	        
		q.enqueue("2");
	    assertEquals("2", q.getFront());
	    q.dequeue();
	    q.enqueue("3");
	    assertEquals("3", q.getFront());	    
	    q.dequeue();
	    q.enqueue("1"); 
	    assertEquals("1", q.getFront()); 
	}
}