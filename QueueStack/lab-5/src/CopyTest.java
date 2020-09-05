
/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class CopyTest {

	@Test
	public void test() {
		Queue q1 = new Queue();
		q1.enqueue("1");
		q1.enqueue("2");
		q1.enqueue("3");

		Queue q2 = new Queue(q1);

		Queue q3 = new Queue();

		assertEquals(true, q1.equals(q2));
		assertEquals(true, q2.equals(q1)==q1.equals(q2));
		assertEquals(false, q2.equals(q3));
		q2 = new Queue();
		assertEquals(true, q2.isEmpty());
		assertEquals(false, q1.isEmpty());
	}
}