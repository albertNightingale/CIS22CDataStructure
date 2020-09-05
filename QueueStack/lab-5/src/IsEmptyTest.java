
/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class IsEmptyTest {

	@Test
	public void test() {
		Queue q = new Queue();

		assertEquals(true, q.isEmpty());
		q.enqueue("3");
		assertEquals(false, q.isEmpty());
		q.dequeue();
		assertEquals(true, q.isEmpty());
	}
}