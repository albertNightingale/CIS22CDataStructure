/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;
//import org.junit.Test;

class HashMethodTest {

@Test 
public void test() {

    Hash<Movie> h = new Hash<Movie>(1);
    Movie bond1 = new Movie("Dr No", "Terence Young", 1962, 59.5);


    h.insert(bond1);

    assertEquals(0, h.search(bond1));
    
    h.remove(bond1);
    assertEquals(-1, h.search(bond1));	    

    assertEquals(0, h.getNumElements()); 
}

}
