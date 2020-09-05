/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;
//import org.junit.Test;

public class GetNumEdgesTest {

	@Test 
	public void test() {
		Graph graph = new Graph(4);
	    assertEquals(0, graph.getNumEdges());

		graph.addUndirectedEdge(1, 3);
		graph.addUndirectedEdge(1, 2);
	    assertEquals(2, graph.getNumEdges());

		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(2, 4);
		graph.addUndirectedEdge(2, 4);
	    assertEquals(4, graph.getNumEdges());
	}


}
