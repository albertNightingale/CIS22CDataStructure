/**
 * Class to test List.java
 * @author Mia Skinner
 * @author Albert Liu
 * CIS 22C, Lab 4
 */

import java.util.NoSuchElementException;

public class ListTest {

	public static void main(String[] args) {
		
		        
		System.out.println("*************************************** Test Lab 4 ***************************************"); 
		
        List<Integer> L7 = new List<Integer>();
        L7.addFirst(3);
        L7.addFirst(5);
        L7.addFirst(7);
        List<Integer> L8 = new List<Integer>();
        L8.addFirst(2);     
        L8.addFirst(1);     
        System.out.println("**Testing printReverse");
        System.out.println("L7 should print 7 5 3: " + L7);
        System.out.print("L7 should print 3 5 7: ");
        L7.printReverse();
        System.out.println("L8 should print 1 2: " + L8);
        System.out.print("L8 should print 2 1: ");
        L8.printReverse();
        
        System.out.println("\n**Testing isSorted");
        System.out.println("L7 should print false: " + L7.isSorted());
        System.out.println("L8 should print true: " + L8.isSorted());
        L8.removeFirst(); // edge cases: length == 1         
        System.out.println("L8 should print true: " + L8.isSorted());
        L8.removeFirst(); // edge cases: length == 0          
        System.out.println("L8 should print true: " + L8.isSorted());
        
        System.out.println("\n**Testing getIndex");
        L7.pointIterator();
        System.out.println("L7 should return 1: " + L7.getIndex());
        L7.advanceIterator();
        System.out.println("L7 should return 2: " + L7.getIndex());
        L7.removeIterator();
        try { 
        	System.out.println("L7 should throw NullPointerException (iterator == null): " + L7.getIndex());
        } catch(NullPointerException e) {
        	System.out.println(e.getMessage());
        }
        
        System.out.println("\n**Testing moveToIndex");
        L7.moveToIndex(2); // edge cases: last 
        System.out.println("L7 should print 3: " + L7.getIterator());
        L7.moveToIndex(1);
        System.out.println("L7 should print 7: " + L7.getIterator());
        try
        {
        	L7.moveToIndex(10);
        }catch (IndexOutOfBoundsException e) {
        	System.out.println(e.getMessage());
        }
        
        try
        {
        	L7.moveToIndex(-100);
        }catch (IndexOutOfBoundsException e) {
        	System.out.println(e.getMessage());
        }
        
        
        System.out.println("\n**Testing linearSearch");
        System.out.println("L7 should print 2: " + L7.linearSearch(3)); // find
        System.out.println("L7 should print -1: " + L7.linearSearch(10)); // not found
        
        
        System.out.println("\n**Testing binarySearch");
        L8.addLast(1);
        L8.addLast(2);
        L8.addLast(3);
        L8.addLast(4);
        L8.addLast(5);
        System.out.println("Here is L8's content: " + L8); 
        System.out.println("L8 should print 1: " + L8.binarySearch(1)); // find
        System.out.println("L8 should print 2: " + L8.binarySearch(2)); // find
        System.out.println("L8 should print 3: " + L8.binarySearch(3)); // find
        System.out.println("L8 should print 4: " + L8.binarySearch(4)); // find
        System.out.println("L8 should print 5: " + L8.binarySearch(5)); // find
        System.out.println("L8 should print -1: " + L8.binarySearch(100)); // NOT FOUND
        
	
		
		
		
		
		/******************* Lab 1 Test ********************/
		// each method must be tested thoroughly (3 tests in total for each method)
		
		System.out.println("\n******************* Lab 1 Test ********************\n");
		
		List<Integer> L = new List<Integer>();
		System.out.println("Should print nothing (an empty list): " + L); 
		
		System.out.println("**Testing addFirst**");
        L.addFirst(2); //Testing Edge case: length == 0
        System.out.println("Should print 2: " + L);
        L.addFirst(1); //Testing General case: length >= 1
        System.out.println("Should print 1 2: " + L);
        
        
        System.out.println("**Testing removeFirst**");
        L.removeFirst(); //Testing General case: length > 1
        System.out.println("Should print 2: " + L);
        L.removeFirst(); //Testing Edge case: length == 1
        System.out.println("Should print an new Line: " + L);
        System.out.println("Should print an error message for an empty List: ");
        try { //place in a try-catch so program does not end when exception thrown
            L.removeFirst(); //Testing Precondition: length == 0
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage()+"\n");
        }   
        
        
        System.out.println("**Testing addLast**");
        L.addLast(3); //Testing Edge case: length == 0
        System.out.println("Should print 3: " + L);
        L.addLast(4); //Testing General case: length >= 1
        System.out.println("Should print 3 4: " + L);
        
        
        System.out.println("**Testing removeLast**");
        L.removeLast(); //Testing General case: length > 1
        System.out.println("Should print 3: " + L);
        L.removeLast(); //Testing Edge case: length == 1
        System.out.println("Should print an new Line: " + L);
        System.out.println("Should print an error message for an empty List: ");
        try { //place in a try-catch so program does not end when exception thrown
            L.removeLast(); //Testing Precondition: length == 0
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage()+"\n");
        }   
        
        System.out.println("**Testing isEmpty**");
        List<String> L2 = new List<String>(); //Testing Edge case: length == 0
        System.out.println("Should print true: " + L2.isEmpty()  + "\n");
        L2.addFirst("-10"); //Testing General case: length >= 1
        System.out.println("Should print false: " + L2.isEmpty()  + "\n");
        
        
        System.out.println("**Testing getLength**");
        List<Double> L3 = new List<Double>(); //Testing Edge case: length == 0
        System.out.println("Should print 0: " + L3.getLength() + "\n");
        L3.addFirst(-5.0); //Testing General case: length >= 1
        System.out.println("Should print 1: " + L3.getLength()  + "\n");
        
        
        System.out.println("**Testing getFirst**");
        L3.addFirst(-4.0);
        //Testing General case: length > 1
        System.out.println("Should print -4: " + L3.getFirst() + "\n");
        L3.removeFirst(); 
        //Testing Edge case: length == 1
        System.out.println("Should print -5: " + L3.getFirst() + "\n");
        L3.removeFirst(); 
        System.out.println("Should print an error message for an empty List: ");
        try { //place in a try-catch so program does not end when exception thrown
            L3.getFirst(); //Testing Precondition: length == 0
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage()+"\n");
        }  
        
        
        System.out.println("**Testing getLast**");
        L3.addLast(-2.0);
        L3.addLast(-3.0);
        //Testing General case: length > 1
        System.out.println("Should print -3: " + L3.getLast() + "\n");
        L3.removeLast(); 
        //Testing Edge case: length == 1
        System.out.println("Should print -2: " + L3.getLast() + "\n");
        L3.removeFirst(); 
        System.out.println("Should print an error message for an empty List: ");
        try { //place in a try-catch so program does not end when exception thrown
            L3.getLast(); //Testing Precondition: length == 0
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage()+"\n");
        } 
        
        
        /**********************Lab 2 Test**************************************/        
        
		
		System.out.println("******************* Lab 2 Test ********************");

		List<Integer> L4 = new List<Integer>();
		System.out.println("Should print nothing (an empty list): " + L4); 
		
		System.out.println("**Testing addIterator**");
		try {
			L4.addIterator(2); //Testing Edge case: length == 0, should print an error message
		} catch(NullPointerException e) {System.out.println(e.getMessage());}
		L4.addFirst(2);
		L4.pointIterator();
		System.out.println("Should print 2: " + L4);
        L4.addIterator(1); //Testing Edge case: iterator == last
        System.out.println("Should print 2 1: " + L4);
        L4.addIterator(3); //Testing general case: 
        System.out.println("Should print 2 3 1: " + L4);
        L4.removeIterator(); // testing when iterator is null
        
        try
        {
        	L4.addIterator(10);        // should throw an error
        }
        catch (NullPointerException e) {System.out.println(e.getMessage());}
        
        
		System.out.println("**Testing advanceIterator**");
        try { // testing when iterator is null
			L4.advanceIterator(); // Should throw an error
        } catch (NullPointerException e) {System.out.println(e.getMessage());}
        System.out.println("Should print 3 1: " + L4);
        L4.pointIterator();
        System.out.println("Should print 3: " + L4.getIterator()); // before advancement
        L4.advanceIterator(); //Testing General case: length >= 1
        System.out.println("Should print 1: " + L4.getIterator());
        try { //Testing when iterator.next is null
        	L4.advanceIterator();        // should throw an error
        } catch (NullPointerException e) {System.out.println(e.getMessage());}
        
        
		System.out.println("\n**Testing reverseIterator**");
        L4.pointIterator();
        L4.advanceIterator();        
        L4.reverseIterator(); //Testing General case: length >= 1 
      
        System.out.println("Should print 3: " + L4.getIterator());
       
     
        L4.reverseIterator(); // Testing Exception case: iterator.prev == null
       
        System.out.println("Should print error message when iterator is null");
        try {
        	L4.reverseIterator(); // Testing Exception case: iterator == null
        } catch(NullPointerException e) {System.out.println(e.getMessage());}
                
        
		System.out.println("**Testing offEnd**");
		L4.pointIterator(); 
		System.out.println("Should print false: " + L4.offEnd());
        L4.removeIterator(); 
        System.out.println("Should print true: " + L4.offEnd());
        

		System.out.println("\n**Testing removeIterator**");

        try {
			L4.removeIterator(); // Testing Exception case: length != 0
		} catch (NullPointerException e) { System.out.println(e.getMessage()); }
        L4.addFirst(5);
        try {
			L4.removeIterator(); // Testing Exception case: iterator == null
		} catch (NullPointerException e) { System.out.println(e.getMessage()); }
        L4.pointIterator();
        L4.removeIterator(); //Testing Edge case: length == 1
        System.out.print("Should print nothing: " + L4);
        L4.addFirst(1); // 1
        L4.addFirst(3); // 31
        L4.addFirst(6); // 631
        L4.pointIterator(); // point the iterator to the first element
        System.out.println("Should print 6: " + L4.getFirst()); // before removing
        L4.removeIterator();  // Testing edge case: iterator == first
        System.out.println("Should print 3: " + L4.getFirst()); // after removing
        L4.pointIterator(); 
        L4.advanceIterator();  
        L4.removeIterator();  // Testing edge case: iterator == last
        System.out.println("Should print 3: " + L4.getLast());    
        L4.addFirst(5); // 53
        L4.addFirst(6); // 653
        L4.addFirst(7); // 7653
        L4.pointIterator();
        L4.advanceIterator();
        System.out.println("Should print 7 6 5 3: " + L4); // before
        L4.removeIterator();  // Testing general case: 
        System.out.println("Should print 7 5 3: " + L4); // before

  		System.out.println("**Testing getIterator**");
        try {
			System.out.println(L4.getIterator()); // Testing Exception case: iterator == null
		} catch (NullPointerException e) { System.out.println(e.getMessage()); }
        L4.pointIterator(); // Testing the general case: iterator != null
        System.out.println("Should print 7: " + L4.getIterator());
        
        
        
     	List<Integer> L5;
     	List<Integer> L6 = new List<Integer>(); 
		System.out.println("**Testing copy constructor**");
        L5 = new List<Integer>(L6); //Testing Edge case: length == 0
        System.out.println("L6 should print nothing: " + L6);
        System.out.println("L5 should print nothing: " + L5);
        L5 = new List<Integer>(L4); //Testing General case: 
		System.out.println("L4 should print 7 5 3: " + L4);
        System.out.println("L5 should print 7 5 3: " + L5);
        
	}

}



/***************************
*************************************** Test Lab 4 ***************************************
**Testing printReverse
L7 should print 7 5 3: 7 5 3 

L7 should print 3 5 7: 3 5 7
L8 should print 1 2: 1 2 

L8 should print 2 1: 2 1

**Testing isSorted
L7 should print false: false
L8 should print true: true
L8 should print true: true
L8 should print true: true

**Testing getIndex
L7 should return 1: 1
L7 should return 2: 2
getIndex(): Can not get index. Iterator is null!

**Testing moveToIndex
L7 should print 3: 3
L7 should print 7: 7
moveToIndex(): Invalid index. Index is out of bounds. 
moveToIndex(): Invalid index. Index is out of bounds. 

**Testing linearSearch
L7 should print 2: 2
L7 should print -1: -1

**Testing binarySearch
Here is L8's content: 1 2 3 4 5 

L8 should print 1: 1
L8 should print 2: 2
L8 should print 3: 3
L8 should print 4: 4
L8 should print 5: 5
L8 should print -1: -1
*/

/******** Lab 1 TEST RUN RESULTS ********
******************* Lab 1 Test ********************

Should print nothing (an empty list): 

**Testing addFirst**
Should print 2: 2 

Should print 1 2: 1 2 

**Testing removeFirst**
Should print 2: 2 

Should print an new Line: 

Should print an error message for an empty List: 
removeFirst(): Cannot remove from an empty List!

**Testing addLast**
Should print 3: 3 

Should print 3 4: 3 4 

**Testing removeLast**
Should print 3: 3 

Should print an new Line: 

Should print an error message for an empty List: 
removeLast(): Cannot remove from an empty List!

**Testing isEmpty**
Should print true: true

Should print false: false

**Testing getLength**
Should print 0: 0

Should print 1: 1

**Testing getFirst**
Should print -4: -4.0

Should print -5: -5.0

Should print an error message for an empty List: 
getFirst(): List is Empty. No data to access!

**Testing getLast**
Should print -3: -3.0

Should print -2: -2.0

Should print an error message for an empty List: 
getLast(): List is Empty. No data to access!

 */

/******************* Lab 2 TEST RUN RESULTS ****************

******************* Lab 2 Test ********************
Should print nothing (an empty list): 

**Testing addIterator**
addIterator(): Location not provided, iterator is null!
Should print 2: 2 

Should print 2 1: 2 1 

Should print 2 3 1: 2 3 1 

addIterator(): Location not provided, iterator is null!
**Testing advanceIterator**
advanceIterator(): Location cannot advance, iterator is null!
Should print 3 1: 3 1 

Should print 3: 3
Should print 1: 1

**Testing reverseIterator**
Should print 3: 3
Should print error message when iterator is null
reverseIterator(): Location cannot reverse, iterator is null!
**Testing offEnd**
Should print false: false
Should print true: true

**Testing removeIterator**
removeIterator(): Iterator is not pointing to any element!
removeIterator(): Iterator is not pointing to any element!
Should print nothing: 1 
Should print 6: 6
Should print 3: 3
Should print 3: 1
Should print 7 6 5 3: 7 6 5 3 1 

Should print 7 5 3: 7 5 3 1 

**Testing getIterator**
getIterator(): iterator is not pointing to any element!
Should print 7: 7
**Testing copy constructor**
L6 should print nothing: 

L5 should print nothing: 

L4 should print 7 5 3: 7 5 3 1 

L5 should print 7 5 3: 7 5 3 1 


 */
 

