/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetParentTest {

	@Test 
	public void test() {

		Graph graph = new Graph(3);
		
		assertEquals(0, graph.getParent(2).intValue());
	    assertEquals(0, graph.getParent(3).intValue());
	    
		graph.addDirectedEdge(1, 2);
		graph.addDirectedEdge(1, 3);
		graph.BFS(1);

		assertEquals(1, graph.getParent(2).intValue());
	    assertEquals(1, graph.getParent(3).intValue());
	   
	}
}
