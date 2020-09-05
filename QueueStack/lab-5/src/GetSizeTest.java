/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class GetSizeTest {
	    
		@Test 
	public void test() {
		Queue q = new Queue(); 
	    assertEquals(0, q.getSize());
		
		q.enqueue("1");
	    assertEquals(1, q.getSize());

		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("4");
		assertEquals(4, q.getSize()); 
		
		q.dequeue();
	    assertEquals(3, q.getSize());
	}
}