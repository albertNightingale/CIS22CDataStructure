/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;
//import org.junit.Test;

public class BFSTest {

	@Test 
	public void test() {
		Graph graph = new Graph(4);
		graph.addUndirectedEdge(1, 3);
		graph.addUndirectedEdge(1, 2);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(2, 4);
		graph.addUndirectedEdge(3, 4);

		graph.BFS(1);
	    assertEquals(0, graph.getParent(1).intValue());
		graph.BFS(2);
	    assertEquals(true, graph.getParent(3).equals(2));	 
		graph.BFS(4);
	    assertEquals(true, graph.getDistance(1).intValue() == 2); 
	}


}
