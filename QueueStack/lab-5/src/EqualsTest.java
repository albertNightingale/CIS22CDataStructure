
/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class EqualsTest {

	@Test
	public void test() {
		Queue q1 = new Queue();
		q1.enqueue("test");
		Queue q2 = new Queue(q1);
		Queue q3 = new Queue();

		assertEquals(true, q2.equals(q1));
		q1.enqueue("2");
		assertEquals(false, q2.equals(q1));
		q2.dequeue();
		assertEquals(true, q3.equals(q2));
	}
}