/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;
//import org.junit.Test;

public class PrintPathTest {

	@Test 
	public void test() {
		Graph graph = new Graph(4);
		graph.addUndirectedEdge(1, 3);
		graph.addUndirectedEdge(1, 2);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(2, 4);
		graph.addUndirectedEdge(3, 4);

		graph.BFS(1);
	    assertEquals("1 3 ", graph.printPath(1, 3, ""));
		graph.BFS(4);
	    assertEquals(true, graph.printPath(4, 1, "").equals("4 2 1 "));	 
	    assertEquals(false, graph.printPath(1, 4, "").equals("1 2 4 ")); 
	}


}
