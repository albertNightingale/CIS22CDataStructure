/**
 * Class to test List.java
 * @author Mia Skinner
 * @author Albert Liu
 */

import java.util.NoSuchElementException;

public class ListTest {

	public static void main(String[] args) {
		
		// each method must be tested thoroughly (3 tests in total for each method)
		
		List L = new List();
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
        List L2 = new List(); //Testing Edge case: length == 0
        System.out.println("Should print true: " + L2.isEmpty()  + "\n");
        L2.addFirst(-10); //Testing General case: length >= 1
        System.out.println("Should print false: " + L2.isEmpty()  + "\n");
        
        
        System.out.println("**Testing getLength**");
        List L3 = new List(); //Testing Edge case: length == 0
        System.out.println("Should print 0: " + L3.getLength() + "\n");
        L3.addFirst(-5); //Testing General case: length >= 1
        System.out.println("Should print 1: " + L3.getLength()  + "\n");
        
        
        System.out.println("**Testing getFirst**");
        L3.addFirst(-4);
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
        L3.addLast(-2);
        L3.addLast(-3);
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
		

	}

}

/******** TEST RUN RESULTS ********
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
Should print -4: -4

Should print -5: -5

Should print an error message for an empty List: 
getFirst(): List is Empty. No data to access!

**Testing getLast**
Should print -3: -3

Should print -2: -2

Should print an error message for an empty List: 
getLast(): List is Empty. No data to access!

 */
  
