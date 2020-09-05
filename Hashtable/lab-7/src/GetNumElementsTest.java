/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//import static org.junit.Assert.*;
//import org.junit.Test;

class GetNumElementsTest {

	@Test 
	public void test() {

	    Hash<Movie> h = new Hash<Movie>(20);
	    Movie bond1 = new Movie("Dr No", "Terence Young", 1962, 59.5);
	    Movie bond2 = new Movie("From Russia with Love", "Terence Young", 1963, 79.0);
	

	    h.insert(bond1);

	    assertEquals(1, h.getNumElements());
	    
	    h.insert(bond2);
	    
	    assertEquals(2, h.getNumElements());	    

	    h.remove(bond2);
	    
	    assertEquals(1, h.getNumElements()); 
	}


}
