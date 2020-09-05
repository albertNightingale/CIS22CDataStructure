/*****
 *  StackTest.java
 * @author Albert Liu (Jiaming)
 * @author Mia Skinner
 */

import java.util.NoSuchElementException;

public class StackTest {
	
	public static void main(String [] args) {
	
	/******************* STACK Test ********************/
	// each method must be tested thoroughly (2-3 tests for each method)
	
	System.out.println("******************* STACK Test ********************");
	
	Stack<Integer> s = new Stack<Integer>();

	System.out.println("Should print nothing (an empty list): " + s);
	
	System.out.println("**Testing push**");
    s.push(2); //Testing Edge case: length == 0
    System.out.println("Should print 2: " + s);
    s.push(1); //Testing General case: length >= 1
    System.out.println("Should print 1 2: " + s);
    s.push(-1); //Testing General case: length >= 1
    System.out.println("Should print -1 1 2: " + s);
    
    
    System.out.println("\n**Testing pop**");
    s.pop(); //Testing General case: length > 0
    System.out.print("Should print 1 2: " + s);
    s.pop(); //Testing General case: length > 0
    System.out.print("Should print 2: " + s);
    s.pop(); //Testing General case: length > 0
    System.out.print("Should print an new Line: " + s);
    System.out.print("Should print an error message for an empty List: ");
    try { //place in a try-catch so program does not end when exception thrown
        s.pop(); //Testing Precondition: length == 0
    } catch(NoSuchElementException e) {
        System.out.println(e.getMessage()+"\n");
    }   
    
    
    System.out.println("**Testing peek**");
    System.out.print("Should print an error message for an empty List: ");
    try 
    {
    	System.out.println(s.peek()); //Testing Exception case
    } catch (NoSuchElementException e) { System.out.println(e.getMessage()); }
    s.push(10);
    s.peek(); //Testing General case: length >= 1
    System.out.println("Should print 10: " + s);
    
    
    System.out.println("**Testing isEmpty**");
    Stack<Double> s1 = new Stack<Double>(); 
    System.out.println("Should print true: " + s1.isEmpty()); 
    System.out.println("Should print false: " + s.isEmpty());
    
   
    System.out.println("\n**Testing getLength**");
    System.out.println("Should print 0: " + s1.getLength());
    System.out.println("Should print 1: " + s.getLength());
    s1.push(5.0);
    System.out.println("Should print 1: " + s1.getLength());
    
 
    
    System.out.println("\n**Testing equals**");
    
    // Testing case 1: comparing with itself 
    System.out.println("Should print true: " + s1.equals(s1));
    // Testing case 2: comparing with the different type 
    Stack<Integer> s2 = new Stack<Integer>();  
    System.out.println("Should print false: " + s1.equals(s2));
    // Testing case 2: Comparing the same content
    Stack<Integer> s3 = new Stack<Integer>();
    s2.push(50);
    System.out.println("Should print false: " + s2.equals(s3));
    s3.push(50);
    System.out.println("Should print true: " + s2.equals(s3));

	}
}

/*******
******************* STACK Test ********************
Should print nothing (an empty list): 

**Testing push**
Should print 2: 2 

Should print 1 2: 1 2 

Should print -1 1 2: -1 1 2 


**Testing pop**
Should print 1 2: 1 2 
Should print 2: 2 
Should print an new Line: 
Should print an error message for an empty List: pop(): Nothing available to remove from stack.

**Testing peek**
Should print an error message for an empty List: peek(): The front is not being assigned and the list is empty!
Should print 10: 10 

**Testing isEmpty**
Should print true: true
Should print false: false

**Testing getLength**
Should print 0: 0
Should print 1: 1
Should print 1: 1

**Testing equals**
Should print true: true
Should print false: false
Should print false: false
Should print true: true
*/

