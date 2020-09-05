/****
 *    @author Mia Skinner
 * 	  @author Albert Liu
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class CopyConstructorTest {
    
	@Test 
    public void test() {
        List L = new List();
        List L1 = new List(L);  
        
        assertEquals(true, L1.equals(L));
        
		L.addFirst(1);
		L.addFirst(2);
        L.addFirst(3);
        L.addFirst(4);
		
        List L2 = new List(L);  
        List L3 = new List(L1);

        assertEquals(true, L2.equals(L)); 
        assertEquals(false, L1.equals(L));
    }
}
