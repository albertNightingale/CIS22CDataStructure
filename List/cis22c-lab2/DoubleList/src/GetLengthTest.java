/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class GetLengthTest {

    @Test
    public void test() {
        List L = new List();
        assertEquals(0, L.getLength());
        L.addLast(3);
        assertEquals(1, L.getLength());
        L.addFirst(2);
        assertEquals(2, L.getLength());
        
    }

}