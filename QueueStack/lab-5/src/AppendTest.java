
/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class AppendTest {

	@Test
	public void test() {
		Queue q1 = new Queue();
		q1.enqueue("1");
		q1.enqueue("2");
		q1.enqueue("3");

		Queue q2 = new Queue();
		q2.enqueue("4");
		q2.enqueue("5");
		q2.enqueue("6");
		
		Queue q3 = new Queue();
		q3.enqueue("1");
		q3.enqueue("2");
		q3.enqueue("3");
		q3.enqueue("4");
		q3.enqueue("5");
		q3.enqueue("6");
		
		
		assertEquals(3, q1.getSize());
		q1.append(q2);
		assertEquals(6, q1.getSize());
		assertEquals(true, q1.equals(q3));
		assertEquals(false, q1.equals(q2));

	}
}