/**
 * Class to test List.java
 * @author Mia Skinner
 * @author Albert Liu
 * CIS 22C, Lab 2
 */

import java.util.NoSuchElementException;

public class ListTest {

	public static void main(String[] args) {
		
		/******************* Lab 1 Test ********************/
		System.out.println("******************* Lab 1 Test ********************");
		// each method must be tested thoroughly (3 tests in total for each method)
		
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
        L.pointIterator(); // setting iterator to point to first
        L.removeFirst(); //Testing Edge case: length == 1
        System.out.println("Should print a new Line: " + L);
        System.out.println("Should print an error message that the iterator is not pointing to any element: ");
        try { 
            L.getIterator(); //Testing iterator set to null after first is removed (should throw Exception)
        } catch(NullPointerException e) {
            System.out.println(e.getMessage()+"\n");
        }   
        System.out.println("Should print an error message for an empty List: ");
        try { //place in a try-catch so program does not end when exception thrown
            L.removeFirst(); //Testing Precondition: length == 0
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage()+"\n");
        }   
        
        List<String> L2 = new List<String>();
        System.out.println("**Testing addLast**");
        L2.addLast("Hi"); //Testing Edge case: length == 0
        System.out.println("Should print Hi: " + L2);
        L2.addLast("Hello"); //Testing General case: length >= 1
        System.out.println("Should print Hi Hello: " + L2);
        
        
        System.out.println("**Testing removeLast**");
        L2.removeLast(); //Testing General case: length > 1
        System.out.println("Should print Hi: " + L2);
        L2.pointIterator(); // setting iterator to point to last element remaining
        L2.removeLast(); //Testing Edge case: length == 1
        System.out.println("Should print a new Line: " + L2);
        System.out.println("Should print an error message that the iterator is not pointing to any element: ");
        try { 
            L2.getIterator(); //Testing iterator set to null after last is removed (should throw Exception)
        } catch(NullPointerException e) {
            System.out.println(e.getMessage()+"\n");
        }   
        System.out.println("Should print an error message for an empty List: ");
        try { //place in a try-catch so program does not end when exception thrown
            L2.removeLast(); //Testing Precondition: length == 0
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage()+"\n");
        }   
        
        System.out.println("**Testing isEmpty**");
        List<Double> L3 = new List<Double>(); //Testing Edge case: length == 0
        System.out.println("Should print true: " + L3.isEmpty()  + "\n");
        L3.addFirst(10.22); //Testing General case: length >= 1
        System.out.println("Should print false: " + L3.isEmpty()  + "\n");
        
        
        
        System.out.println("**Testing getLength**");
        L3.removeFirst(); //Testing Edge case: length == 0
        System.out.println("Should print 0: " + L3.getLength() + "\n");
        L3.addFirst(-5.2); //Testing General case: length >= 1
        System.out.println("Should print 1: " + L3.getLength()  + "\n");
        
        
        System.out.println("**Testing getFirst**");
        L3.addFirst(-4.1);
        //Testing General case: length > 1
        System.out.println("Should print -4.1: " + L3.getFirst() + "\n");
        L3.removeFirst(); 
        //Testing Edge case: length == 1
        System.out.println("Should print -5.2: " + L3.getFirst() + "\n");
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
        System.out.println("Should print -3.0: " + L3.getLast() + "\n");
        L3.removeLast(); 
        //Testing Edge case: length == 1
        System.out.println("Should print -2.0: " + L3.getLast() + "\n");
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
        L4.addIterator(2); //Testing Edge case: length == 0
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
        L4.reverseIterator(); //Testing General case: length >= 1 
        System.out.println("Should print 3: " + L4.getIterator());
        try
        {
        	L4.reverseIterator(); // Testing Exception case: iterator.prev == null
        } catch(NullPointerException e) {System.out.println(e.getMessage()); }
        
        L4.removeIterator(); // remove the iterator
        try
        {
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
        
        /**********************Schedule App Test**************************************/        
		
        System.out.println("******************* Schedule App Test ********************");
        Schedule s = new Schedule();
	}

}


/**************** TEST RUN RESULTS ****************************************
******************* Lab 1 Test ********************
Should print nothing (an empty list): 

**Testing addFirst**
Should print 2: 2 

Should print 1 2: 1 2 

**Testing removeFirst**
Should print 2: 2 

Should print a new Line: 

Should print an error message that the iterator is not pointing to any element: 
getIterator(): iterator is not pointing to any element!

Should print an error message for an empty List: 
removeFirst(): Cannot remove from an empty List!

**Testing addLast**
Should print Hi: Hi 

Should print Hi Hello: Hi Hello 

**Testing removeLast**
Should print Hi: Hi 

Should print a new Line: 

Should print an error message that the iterator is not pointing to any element: 
getIterator(): iterator is not pointing to any element!

Should print an error message for an empty List: 
removeLast(): Cannot remove from an empty List!

**Testing isEmpty**
Should print true: true

Should print false: false

**Testing getLength**
Should print 0: 0

Should print 1: 1

**Testing getFirst**
Should print -4.1: -4.1

Should print -5.2: -5.2

Should print an error message for an empty List: 
getFirst(): List is Empty. No data to access!

**Testing getLast**
Should print -3.0: -3.0

Should print -2.0: -2.0

Should print an error message for an empty List: 
getLast(): List is Empty. No data to access!

******************* Lab 2 Test ********************
Should print nothing (an empty list): 

**Testing addIterator**
Should print 2: 2 

Should print 2 1: 2 1 

Should print 2 3 1: 2 3 1 

addIterator(): Location not provided, iterator is null!
**Testing advanceIterator**
advanceIterator(): Location cannot advance, iterator is null!
Should print 3 1: 3 1 

Should print 3: 3
Should print 1: 1
advanceIterator(): Location cannot advance, new location is null!

**Testing reverseIterator**
Should print 3: 3
advanceIterator(): Location cannot advance, new location is null!
advanceIterator(): Location cannot advance, iterator is null!
**Testing offEnd**
Should print false: false
Should print true: true

**Testing removeIterator**
removeIterator(): Iterator is not pointing to any element!
removeIterator(): Iterator is not pointing to any element!
Should print nothing: 
Should print 6: 6
Should print 3: 3
Should print 3: 3
Should print 7 6 5 3: 7 6 5 3 

Should print 7 5 3: 7 5 3 

**Testing getIterator**
getIterator(): iterator is not pointing to any element!
Should print 7: 7
**Testing copy constructor**
L6 should print nothing: 

L5 should print nothing: 

L4 should print 7 5 3: 7 5 3 

L5 should print 7 5 3: 7 5 3 

******************* Schedule App Test ********************
Welcome to the Scheduler App!

You have no upcoming events!

Select from the following options: 
A: Add an event
R: Remove an event
X: Exit

Enter your choice: A

Please enter an event: Walk dog

Your Current Schedule: 

1. Walk dog

Select from the following options: 
A: Add an event
R: Remove an event
X: Exit

Enter your choice: A

Please enter an event: Make dinner

You just added the following event to your schedule: make dinner

Your Current Schedule: 

1. Make dinner
2. Walk dog

Would you like to move this event up in your schedule
(Y/N): Y
Enter the number of places: 1

Your Current Schedule: 

1. Walk dog
2. Make dinner

Select from the following options: 
A: Add an event
R: Remove an event
X: Exit

Enter your choice: A

Please enter an event: Grade labs

You just added the following event to your schedule: Grade labs

Your Current Schedule: 

1. Grade labs
2. Walk dog
3. Make dinner

Would you like to move this event up in your schedule
(Y/N): Y
Enter the number of places: 10
Sorry that input is invalid! 

Enter the number of places: 18
Sorry that input is invalid! 

Enter the number of places: 2

Your Current Schedule: 

1. Walk dog
2. Make dinner
3. Grade labs

Select from the following options: 
A: Add an event
R: Remove an event
X: Exit

Enter your choice: R
Enter the number of the event to remove: 2

Removing: Make dinner

Your Current Schedule: 

1. Walk dog
2. Grade labs

Select from the following options: 
A: Add an event
R: Remove an event
X: Exit

Enter your choice: X

Goodbye!
*/