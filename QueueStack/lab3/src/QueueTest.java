/**
 * QueueTest.java
 * @author Albert Liu (Jiaming)
 * @author Mia Skinner
 */

import java.util.NoSuchElementException;

public class QueueTest {
	public static void main(String [] args)
	{
		/******************* QUEUE Test ********************/
		// each method must be tested thoroughly (3 tests in total for each method)
		
		System.out.println("******************* QUEUE Test ********************");
		
		Queue<Integer> q = new Queue<Integer>();

		System.out.println("Should print nothing (an empty list): " + q); 
		
		System.out.println("**Testing enQueue**");
        q.enqueue(2); //Testing Edge case: length == 0
        System.out.print("Should print 2: " + q);
        q.enqueue(1); //Testing General case: length >= 1
        System.out.print("Should print 2 1: " + q);
        q.enqueue(-1); //Testing General case: length >= 1
        System.out.print("Should print 2 1 -1: " + q);
        
        
        System.out.println("\n**Testing deQueue**");
        q.dequeue(); //Testing General case: length > 0
        System.out.print("Should print 1 -1: " + q);
        q.dequeue(); //Testing General case: length > 0
        System.out.print("Should print -1: " + q);
        q.dequeue(); //Testing General case: length > 0
        System.out.print("Should print an new Line: " + q);
        System.out.print("Should print an error message for an empty List: ");
        try { //place in a try-catch so program does not end when exception thrown
            q.dequeue(); //Testing Precondition: length == 0
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage()+"\n");
        }   
        
        
        System.out.println("**Testing getFront**");
        System.out.print("Should print an error message for an empty List: ");
        try 
        {
        	System.out.println(q.getFront()); //Testing Exception case
        } catch (NoSuchElementException e) { System.out.println(e.getMessage()); }
        q.enqueue(10);
        q.getFront(); //Testing General case: length >= 1
        System.out.println("Should print 10: " + q);
        
        
        System.out.println("**Testing isEmpty**");
        Queue<Double> q1 = new Queue<Double>(); 
        System.out.println("Should print true: " + q1.isEmpty()); 
        System.out.println("Should print false: " + q.isEmpty());
        
       
        System.out.println("\n**Testing getLength**");
        System.out.println("Should print 0: " + q1.getLength());
        System.out.println("Should print 1: " + q.getLength());
        q1.enqueue(5.0);
        System.out.println("Should print 1: " + q1.getLength());
        
     
        
        System.out.println("\n**Testing equals**");
        
        // Testing case 1: comparing with itself 
        System.out.println("Should print true: " + q1.equals(q1));
        // Testing case 2: comparing with the different type 
        Queue<Integer> q2 = new Queue<Integer>();  
        System.out.println("Should print false: " + q1.equals(q2));
        // Testing case 2: Comparing the same content
        Queue<Integer> q3 = new Queue<Integer>();
        q2.enqueue(50);
        System.out.println("Should print false: " + q2.equals(q3));
        q3.enqueue(50);
        System.out.println("Should print true: " + q2.equals(q3));
	}
}

/************
******************* QUEUE Test ********************
Should print nothing (an empty list): 

**Testing enQueue**
Should print 2: 2 
Should print 2 1: 2 1 
Should print 2 1 -1: 2 1 -1 

**Testing deQueue**
Should print 2 1: 1 -1 
Should print 2: -1 
Should print an new Line: 
Should print an error message for an empty List: dequeue(): Can't remove from an empty queue

**Testing getFront**
Should print an error message for an empty List: getFront(): The front is not being assigned and the list is empty!
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
