/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
*/


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class CountBucketTest {


@Test 
public void test() {

    Hash<Movie> h = new Hash<Movie>(1);
    Movie bond1 = new Movie("Dr No", "Terence Young", 1962, 59.5);
    Movie bond2 = new Movie("From Russia with Love", "Terence Young", 1963, 79.0);
    Movie bond3 = new Movie("Goldfinger", "Guy Hamilton", 1964, 125.0);

    h.insert(bond1);
    h.insert(bond2);
    h.insert(bond3);

    assertEquals(3, h.countBucket(h.search(bond1)));

    h.remove(bond1);
    assertEquals(2, h.countBucket(h.search(bond2)));	    

    assertEquals(true, h.getNumElements() == h.countBucket(h.search(bond3))); 
}

}
