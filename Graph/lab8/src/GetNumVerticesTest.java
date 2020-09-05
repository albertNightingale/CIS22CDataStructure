/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//import static org.junit.Assert.*;
//import org.junit.Test;

public class GetNumVerticesTest {

	@Test 
	public void test() {
		Graph graph = new Graph(4);
	    assertEquals(4, graph.getNumVertices());

		graph.addUndirectedEdge(1, 3);
		assertEquals(4, graph.getNumVertices());
		assertEquals(true, graph.getNumVertices() == 4);
	}


}
