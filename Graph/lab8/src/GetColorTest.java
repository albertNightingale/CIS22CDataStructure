/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetColorTest {

	@Test 
	public void test() {

		Graph graph = new Graph(3);
		
		assertEquals("W", graph.getColor(1).toString());
	    
		graph.addDirectedEdge(1, 2);
		graph.BFS(1);

		assertEquals("B", graph.getColor(2).toString());
		assertEquals("W", graph.getColor(3).toString());
	   
	}
}
