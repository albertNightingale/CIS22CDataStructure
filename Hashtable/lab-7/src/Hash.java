/**
* Hash.java
* @author Mia Skinner
* @author Jiaming Liu
* CIS 22C, Lab 7
*/
import java.util.ArrayList;
	
public class Hash<T extends Comparable<T>> {
	
	private int numElements;
	private ArrayList<List<T>> Table;
	
	/**
	* Constructor for the Hash.java
	* class. Initializes the Table to
	* be sized according to value passed
	* in as a parameter
	* Inserts size empty Lists into the
	* table. Sets numElements to 0
	* @param size the table size
	*/
	public Hash(int size) {
		numElements = 0;
		Table = new ArrayList<List<T>>(size);
		for (int i=0; i < size; i++) {
			Table.add(i, new List<T>());
		}
	}
	
	/**Accessors*/
	
	/**
	* Returns the hash value in the Table
	* for a given key by taking modulus
	* of the hashCode value for that key
	* and the size of the table
	* @param t the key
	* @return the index in the Table
	*/
	private int hash(T t) {
		
		if (t == null) // edge case 
			return -1;
	    int code = t.hashCode();
		return code % Table.size();
	}
	
	/**
	* Counts the number of keys at this index
	* @param index the index in the Table
	* @precondition 0 <= index < Table.length
	* @return the count of keys at this index
	* @throws IndexOutOfBoundsException
	*/
	public int countBucket(int index) throws IndexOutOfBoundsException{
	    if (index < 0 || index >= Table.size())
	    	throw new IndexOutOfBoundsException ("countBucket(): Index is not in the range of the table"); 
		return Table.get(index).getLength();
	}
	
	/**
	* Returns total number of keys in the Table
	* @return total number of keys
	*/
	public int getNumElements() {
	    return numElements;
	}
	
	/**
	* Searches for a specified key in the Table
	* @param t the key to search for
	* @return the index in the Table (0 to Table.length - 1)
	* or -1 if t is not in the Table
	*/
	public int search(T t) {
	    
		if (numElements == 0) {
			return -1;
		}
		
		int idx = hash(t); 
		
		if (idx != -1 && Table.get(idx).linearSearch(t) != -1)
		{
			return idx;
		}
		else
		{
			return -1; 
		}
	}
	
	
	/**Manipulation Procedures*/
	
	/**
	* Inserts a new key in the Table
	* calls the hash method to determine placement
	* @param t the key to insert
	*/
	public void insert(T t) 
	{ 
		int idx = hash(t);

		if (idx != -1) // skip if t is null 
		{
			Table.get(idx).addLast(t); 
			numElements ++; 
		}
	} 
	
	
	/**
	* removes the key t from the Table
	* calls the hash method on the key to
	* determine correct placement
	* has no effect if t is not in
	* the Table
	* @param t the key to remove
	*/
	public void remove(T t) {
		int idx = hash(t);
		int listindex; 
		if (idx != -1)
		{
			listindex = Table.get(idx).linearSearch(t);
			if (listindex != -1) // the element in the list is found
			{
				Table.get(idx).moveToIndex(listindex); // go to the index
				Table.get(idx).removeIterator();  // remove the element from the list
				if (Table.get(idx).getLength() == 0) 
					Table.set(idx, null); 
				numElements--; 
			}
		}
	}
		
	/**Additional Methods*/
	
	/**
	* Prints all the keys at a specified
	* bucket in the Table. Each key displayed
	* on its own line, with a blank line 
	* separating each key
	* Above the keys, prints the message
	* "Printing bucket #<bucket>:"
	* Note that there is no <> in the output
	* @param bucket the index in the Table
	*/
	public void printBucket(int bucket) {
		List<T> templist = Table.get(bucket);
		System.out.printf("Printing bucket #%d:\n\n", bucket);
		if (templist.isEmpty())
			System.out.println("\n");
		else 
		{
			templist.pointIterator();
			for (int i = 0; i < templist.getLength(); i++)
			{
				System.out.println(templist.getIterator() + "\n");
				templist.advanceIterator();
			}
			System.out.println("\n");
		}
	}
	
	/**
	* Prints the first key at each bucket
	* along with a count of the total keys
	* with the message "+ <count> -1 more 
	* at this bucket." Each bucket separated
	* with to blank lines. When the bucket is 
	* empty, prints the message "This bucket
	* is empty." followed by two blank lines
	*/
	public void printTable()
	{
		for (int i = 0; i < Table.size(); i++) {
			System.out.printf("Bucket: %d \n", i);
			if (Table.get(i).isEmpty()) {
				System.out.println("This bucket is empty.\n\n");
			}
			else {
				System.out.println(Table.get(i).getFirst().toString());
				System.out.printf("+ %d more at this bucket\n\n\n", countBucket(i) - 1);
			}
		}
	}
}

















