/**
 * Defines the a singly-linked list class
 * @author Mia Skinner
 * @author Albert Liu
 */

import java.util.NoSuchElementException;

public class List {
	
    private class Node {
        private int data;
        private Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private int length;
    private Node first;
    private Node last;
    
    /****CONSTRUCTOR****/
    
    /**
     * Instantiates a new List with default values
     * @postcondition length = 0, first = null, last = null
     */
    public List() {
    	
    	this.length = 0;
    	this.first = null;
    	this.last = null;
 
    }
    
    /****ACCESSORS****/
    
    /**
     * Returns the value stored in the first node
     * @precondition length > 0, first != null
     * @return the integer value stored at node first
     * @throws NoSuchElementException when precondition is violated
     */
    public int getFirst() throws NoSuchElementException{
    	
    	if (first == null || length == 0) {
    		throw new NoSuchElementException("getFirst(): List is Empty. No data to access!");
    	}
        return first.data;
    }
    
    /**
     * Returns the value stored in the last node
     * @precondition length > 0, last != null
     * @return the integer value stored in the node last
     * @throws NoSuchElementException when precondition is violated
     */
    public int getLast() throws NoSuchElementException{
    	
    	if (last == null || length == 0) {
    		throw new NoSuchElementException("getLast(): List is Empty. No data to access!");
    	}
        return last.data;
    }
    
    /**
     * Returns the current length of the list
     * @return the length of the list from 0 to n
     */
    public int getLength() {
        return this.length;
    }
    
    /**
     * Returns whether the list is currently empty
     * @return whether the list is empty
     */
    public boolean isEmpty() {
       return length == 0;
    }
    
    /****MUTATORS****/
    
    /**
     * Creates a new first element
     * @param data the data to insert at the 
     * front of the list
     * @postcondition length > 0, last & first != null, first.data = add.data
     */
    public void addFirst(int data) {
        
    	Node add = new Node(data);
    	if (first == null) {
    		first = last = add;
    	}
    	else {
    		add.next = first;		
    		first = add;
    	}
    	length++;
    }
    
    /**
     * Creates a new last element
     * @param data the data to insert at the 
     * end of the list
     * @postcondition length > 0, last & first != null, last.data = add.data
     */
    public void addLast(int data) {
        
    	Node add = new Node(data);
    	if (last == null)
    		first = last = add; 
    	else {
    		last.next = add;
    		last = add;
    	}
    	length++; 
    }
    
    /**
    * removes the element at the front of the list
    * @precondition length != 0
    * @postcondition length = length - 1, first = first.next
    * @throws NoSuchElementException when precondition is violated
    */
    public void removeFirst() throws NoSuchElementException{
    	if (length == 0)
    		throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
    	else if (length == 1)
    		first = last = null; 
    	else
    		first = first.next;
    	length --; 
    }
    
    /**
     * removes the element at the end of the list
     * @precondition length != 0
     * @postcondition length--, last = previous element
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeLast() throws NoSuchElementException{
        if (length == 0)
        	throw new NoSuchElementException("removeLast(): Cannot remove from an empty List!");
        else if (length == 1)
        	first = last = null;
        else
        {
        	Node getlast = first;            
            
        	while(getlast.next != last)
            	getlast = getlast.next; 
        	last = getlast; 
        	getlast.next = null; 
        }
        length--; 
    }
    
    /****ADDITIONAL OPERATIONS****/
    
    /**
     * List with each value separated by a blank space
     * At the end of the List a new line
     * @return the List as a String for display
     */
    @Override public String toString() {
    	String result = "";
    	Node temp = first;
    	while(temp!= null)
    	{
    		// For the purposes of this Lab, we will simply have the data items displayed on a single line, each separated by a blank space.
    		result += temp.data + " ";
    		temp = temp.next; 
    	}
    	result += "\n";
       return result;
    }
    

}

