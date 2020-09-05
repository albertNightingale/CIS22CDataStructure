/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetDistanceTest {

	@Test 
	public void test() {

		Graph graph = new Graph(3);
		
		assertEquals(-1, graph.getDistance(2).intValue());
	    
		graph.addDirectedEdge(1, 2);
		graph.addDirectedEdge(2, 3);
		graph.BFS(1);

		assertEquals(1, graph.getDistance(2).intValue());
	    assertEquals(2, graph.getDistance(3).intValue());
	   
	}
}
