/**
 * Stack.java
 * @author Albert Liu (Jiaming)
 * @author Mia Skinner
 */

import java.util.NoSuchElementException;

public class Stack<T> {
    private class Node {
        private T data;
        private Node next;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private int length;
    private Node top;
    
    /****CONSTRUCTORS****/
    
    /**
     * Default constructor for the Stack class
     * @postcondition a new Stack object with all fields
     * assigned default values
     */
    public Stack() {
    	length = 0;
    	top = null;
    }
    
    /**
     * Copy constructor for the Stack class
     * @param original the Stack to copy
     * @postcondition a new Stack object which is
     * an identical, but distinct, copy of original
     */
    public Stack(Stack<T> original) {
    	if (original.isEmpty())
    	{
    		top = null;
    		length = 0;
    	}
    	else
    	{
    		Node temp = original.top; 
    		
    		for (int i = 0; i < original.getLength(); i ++)
    		{
    			this.push(temp.data);
    			temp = temp.next;
    		}
    	}
    }
    
    /****ACCESSORS****/
    
    /**
     * Returns the value stored at the top
     * of the Stack
     * @return the value at the top of the Stack
     * @precondition !isEmpty()
     * @throws NoSuchElementException when the
     * precondition is violated
     */
    public T peek() throws NoSuchElementException {
    	if (isEmpty())
    		throw new NoSuchElementException("peek(): The front is not being assigned and the list is empty!");
       return top.data;

    }
    
    /**
     * Returns the length of the Stack
     * @return the length from 0 to n
     */
    public int getLength() {
        return length;
    }
    
    /**
     * Determines whether a Stack is empty
     * @return whether the Stack is empty
     */
    public boolean isEmpty() {
        return (length == 0);
    }
    
    /**
     * Determines whether two Stacks contain
     * the same values in the same order
     * @param Q the Stack to compare to this
     * @return whether Q and this are equal
     */
    @Override public boolean equals(Object o) {

    	 if (this == o)
         	return true;
         else if (!(o instanceof Stack))
         	return false;
         else
         {
         	Stack<T> newstack = (Stack<T>)(o);
         	if (newstack.getLength() != this.getLength())
         	{
         		return false;
         	}
         	else
         	{
         		Node temp1 = this.top;
         		Node temp = newstack.top;
         		while (temp != null)
         		{
         			if (temp.data != temp1.data)
         			{
         				return false; 
         			}
         			temp1 = temp1.next;
         			temp = temp.next;
         		}
         	}
         }
         	
     	return true;

    }
    
    /****MUTATORS****/
    
    /**
     * Inserts a new value at the top of
     * the Stack
     * @param data the new data to insert
     * @postcondition a new node at the end
     * of the Stack
     */
    public void push(T data) { 
    	Node n = new Node(data);
    	n.next = top;
    	top = n;
    	length++;
    	
    }
    
    /**
     * Removes the top element of the Stack
     * @precondition !isEmpty()
     * @throws NoSuchElementException when
     * the precondition is violated
     * @postcondition the top element has 
     * been removed
     */
    public void pop() throws NoSuchElementException{
    	if (isEmpty())
    		throw new NoSuchElementException("pop(): Nothing available to remove from stack.");
    	else {
    		top = top.next;
    		length--;
    	}
    	
    }
    
    /****ADDITONAL OPERATIONS****/
    
    /**
     * Returns the values stored in the Stack
     * as a String, separated by a blank space
     * with a new line character at the end
     * @return a String of Stack values
     */
    public String toString() {
        String result = "";
        Node iter = top;
        
        while (iter != null)
        {
        	result += iter.data + " ";
        	iter = iter.next;
        }
        result += "\n";
        
        return result;
    }    
    
}
