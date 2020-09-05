/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class IsEmptyTest {

    @Test
    public void test() {
        List L = new List();
        assertEquals(0, L.getLength());
        assertEquals(true, L.isEmpty());
        L.addLast(3);
        assertEquals(false, L.isEmpty());
        L.removeFirst();
        assertEquals(true, L.isEmpty());
        
    }

}


