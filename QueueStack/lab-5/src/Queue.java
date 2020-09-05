import java.util.NoSuchElementException;

/**
 * Queue.java
 * @author Mia Skinner
 * @author Albert Liu
 * CIS 22C Lab 5
 */

public class Queue {
    private Stack<String> s1; // the default stack 
    private Stack<String> s2; // always empty 
    
    /**Constructors**/
    
    /**
     * Default constructor for the
     * Queue class
     */
    public Queue() {
    	s1 = new Stack<String>(); 
    	s2 = new Stack<String>(); 
    }
    
    /**
     * Copy constructor for the
     * Queue class
     * @param q the original Queue
     * to copy
     */
    public Queue(Queue q) {
        s1 = new Stack<String>(q.s1);
        s2 = new Stack<String>(q.s2);
    }
    
    /**Mutators**/
    
    /**
     * Inserts new data to the end
     * of the Queue
     * @param data the value to insert
     */
    public void enqueue(String data) {
        s1.push(data);
    }
    
    /**
     * Removes data from the front
     * @precondition length != 0
     */
    public void dequeue() throws NoSuchElementException{
        
    	if (this.getSize() == 0)
    	{
    		throw new NoSuchElementException("dequeue(): Cannot remove from an empty queue"); 
    	}
    	
    	while(!s1.isEmpty())
    	{
    		s2.push(s1.peek());
    		s1.pop();
    	}
    	s2.pop();
    	while(!s2.isEmpty())
    	{
    		s1.push(s2.peek());
    		s2.pop();
    	}
    }
    
    /**
     * Appends the values of a
     * a new Queue onto the end
     * of this Queue
     * @param q the Queue whose
     * values to append
     */
    public void append(Queue q) {
        Queue copy = new Queue(q); 
        
    	while (!copy.isEmpty())
        {
        	s2.push(copy.s1.peek());
        	copy.s1.pop();
        }
    	while (!s2.isEmpty())
    	{
    		s1.push(s2.peek());
    		s2.pop();
    	}
    }
    
    /**Accessors**/
    
    /**
     * Returns the data at the front
     * @precondition length != 0
     * @return the front of the Queue
     */
    public String getFront() throws NoSuchElementException
    {
    	if (this.getSize() == 0)
    	{
    		throw new NoSuchElementException("getFront(): The queue does not have a front"); 
    	}
    	
    	String val; 
    	while (!s1.isEmpty())
        {
        	s2.push(s1.peek());
        	s1.pop();
        }
        val = s2.peek();
    	while(!s2.isEmpty())
    	{
    		s1.push(s2.peek());
    		s2.pop();
    	}
    	return val; 
    }
    
    /**
     * Returns the current size of
     * this Queue
     * @return the current size
     */
    public int getSize() {
        return s1.getLength(); 
    }
    
    /**
     * Returns whether this Queue is
     * currently empty
     * @return whether the Queue is empty
     */
    public boolean isEmpty() {
        return s1.isEmpty();
    }
    
    /**
     * Determines whether two Queues 
     * have the data stored in the same
     * order
     */
    @Override public boolean equals(Object o) {
        if (this == o)
        	return true;
        else if (!(o instanceof Queue))
        	return false;
        else
        {
        	Queue newqueue = (Queue)(o);
        	if (newqueue.getSize() != this.getSize())
        	{
        		return false;
        	}
        	else
        	{
        		while (!s1.isEmpty())
        		{
        			if (s1.peek() != newqueue.s1.peek())
        			{
        				return false; 
        			}

        			s2.push(s1.peek());
        			s1.pop();
        			newqueue.s2.push(newqueue.s1.peek());
        			newqueue.s1.pop();
        		}
        		
        		while (!s2.isEmpty())
        		{
        			s1.push(s2.peek());
        			s2.pop();
        			newqueue.s1.push(newqueue.s2.peek());
        			newqueue.s2.pop();
        		}
        	}
        }
        return true;
    }
    
    /**Additional Operations**/
    
    /**
     * Creates a String to store the values
     * the Queue,separated with spaces and 
     * ending with a new line character
     */
    @Override public String toString() {
        String val = ""; 
    	while (!s1.isEmpty())
        {
        	s2.push(s1.peek());
        	s1.pop();
        }
    	while(!s2.isEmpty())
    	{
    		s1.push(s2.peek());
        	val += s2.peek() + " "; 
    		s2.pop();
    	}
    	
    	return val;
    }
}

