/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;
//import org.junit.Test;

class RemoveTest {

	@Test 
	public void test() {

	    Hash<Movie> h = new Hash<Movie>(1);
	    Movie bond1 = new Movie("Dr No", "Terence Young", 1962, 59.5);
	    Movie bond2 = new Movie("From Russia with Love", "Terence Young", 1963, 79.0);
	    Movie bond3 = new Movie("Goldfinger", "Guy Hamilton", 1964, 125.0);

	    h.insert(bond1);
	    h.insert(bond2);
	    h.insert(bond3);
	    
	    assertEquals(0, h.search(bond1));
	    
	    h.remove(bond1);
	    assertEquals(-1, h.search(bond1));	    

	    h.remove(bond2);
	    assertEquals(1, h.getNumElements()); 
	}


}
