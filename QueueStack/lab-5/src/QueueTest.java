import java.util.NoSuchElementException;

/**
 * QueueTest.java
 * @author Albert Liu
 * @author Mia Skinner
 * CIS 22C Lab 5
 */

public class QueueTest {
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println("**Testing enqueue()**");
        q.enqueue("1");
        System.out.println("Should print 1: " + q);
        q.enqueue("2");
        System.out.println("Should print 1 2: " + q);
        q.enqueue("3");
        System.out.println("Should print 1 2 3: " + q);
        q.enqueue("4");
        System.out.println("Should print 1 2 3 4: " + q);
        q.enqueue("5");
        System.out.println("Should print 1 2 3 4 5: " + q);
        
        
        System.out.println("\n**Testing dequeue()**");
        q.dequeue();
        System.out.println("Should print 2 3 4 5: " + q);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println("Should print NOTHING: " + q);
        try
        {
        	q.dequeue();
        } catch (NoSuchElementException e) 
        {System.out.println(e.getMessage());}
        
        
        System.out.println("\n**Testing isEmpty()**");
        Queue q2 = new Queue();
        System.out.println("Should print true: " + q2.isEmpty());
        q.enqueue("nothing");
        System.out.println("Should print false: " + q.isEmpty());
        q2.enqueue("dog");
        System.out.println("Should print false: " + q2.isEmpty());
        q.dequeue();
        System.out.println("Should print true: " + q.isEmpty());
        q2.dequeue();
        
        
        System.out.println("\n**Testing append()**");
        q.enqueue("2");
        q.enqueue("3");
        q2.enqueue("A");
        q2.enqueue("B");
        q2.enqueue("C");
        q2.enqueue("D");
        q.append(q2);
        System.out.println("Should print 2 3 A B C D: " + q);
        
        Queue q4 = new Queue();
        q4.enqueue("1");
        q4.enqueue("2");
        q4.enqueue("3");
        q4.enqueue("4");
        Queue q5 = new Queue();
        q5.enqueue("5");
        q5.enqueue("6");
        q5.enqueue("7");
        q4.append(q5);
        System.out.println("Should print 1 2 3 4 5 6 7: " + q4);
        
        q5 = new Queue(); 
        q4.append(q5);
        System.out.println("Should print 1 2 3 4 5 6 7: " + q4);

        q5.append(q4);
        System.out.println("Should print 1 2 3 4 5 6 7: " + q5);
        
        System.out.println("\n**Testing getFront()**");
        System.out.println(q2);
        System.out.println("Should print A: " + q2.getFront());
        q2.dequeue();
        System.out.println("Should print B: " + q2.getFront());
        q2.dequeue();
        q2.dequeue();
        q2.dequeue();
        try
        {
        	System.out.println(q2.getFront());
        } catch(NoSuchElementException e)
        {System.out.println(e.getMessage());}
        
        
        System.out.println("\n**Testing getSize()**");
        System.out.println("Should print 6: " + q.getSize());
        System.out.println("Should print 0: " + q2.getSize());
        System.out.println("Should print 7: " + q5.getSize());

        
        System.out.println("\n**Testing equals()**");
        System.out.println("Should print true: " + q2.equals(q2));
        System.out.println("Should print false: " + q.equals(q2));
        q2.enqueue("2");
        q2.enqueue("3");
        q2.enqueue("A");
        q2.enqueue("B");
        q2.enqueue("C");
        q2.enqueue("D");
        System.out.println("Should print true: " + q.equals(q2));
        System.out.println("Should print false: " + q.equals(new Stack<Integer>()));
        Queue q3 = new Queue();
        q = new Queue(); 
        System.out.println("Should print true: " + (q3.equals(q)==q.equals(q3)));


        System.out.println("\n**Testing Copy Constructor**");
        q2.dequeue();
        q2.dequeue();
        q3 = new Queue(q2);
        System.out.println("Should print A B C D: " + q3);
        q3.enqueue("E");
        q3.enqueue("F");
        q = new Queue(new Queue());
        System.out.println("Should print NOTHING: " + q);

        System.out.println("\nTesting for Deep Copy:");
        System.out.println("Should print A B C D E F: " + q3);
        System.out.println("Should print A B C D: " + q2);
        q3 = new Queue(q);
        System.out.println("Should print NOTHING: " + q3);
        System.out.println("Should print A B C D: " + q2);
    }
}



/*****************************************Lab 5 test code***********************************************************
**Testing enqueue()**
Should print 1: 1 
Should print 1 2: 1 2 
Should print 1 2 3: 1 2 3 
Should print 1 2 3 4: 1 2 3 4 
Should print 1 2 3 4 5: 1 2 3 4 5 

**Testing dequeue()**
Should print 2 3 4 5: 2 3 4 5 
Should print NOTHING: 
dequeue(): Cannot remove from an empty queue

**Testing isEmpty()**
Should print true: true
Should print false: false
Should print false: false
Should print true: true

**Testing append()**
Should print 2 3 A B C D: 2 3 A B C D 
Should print 1 2 3 4 5 6 7: 1 2 3 4 5 6 7 
Should print 1 2 3 4 5 6 7: 1 2 3 4 5 6 7 
Should print 1 2 3 4 5 6 7: 1 2 3 4 5 6 7 

**Testing getFront()**
A B C D 
Should print A: A
Should print B: B
getFront(): The queue does not have a front

**Testing getSize()**
Should print 6: 6
Should print 0: 0
Should print 7: 7

**Testing equals()**
Should print true: true
Should print false: false
Should print true: true
Should print false: false
Should print true: true

**Testing Copy Constructor**
Should print A B C D: A B C D 
Should print NOTHING: 

Testing for Deep Copy:
Should print A B C D E F: A B C D E F 
Should print A B C D: A B C D 
Should print NOTHING: 
Should print A B C D: A B C D 

*/
