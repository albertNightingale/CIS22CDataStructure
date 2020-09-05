/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphConstructorTest {

	@Test 
	public void test() {

		Graph graph = new Graph(1); 

	    assertEquals(0, graph.getParent(1).intValue());
	    assertEquals("W", graph.getColor(1).toString());
	    assertEquals(-1, graph.getDistance(1).intValue());
	   
	}
}
