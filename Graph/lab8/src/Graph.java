/**
* Graph.java
* @author Mia Skinner
* @author Albert Liu
* CIS 22C, Lab 8
*/

import java.util.ArrayList;

public class Graph {
    private int vertices;
    private int edges; 
    private ArrayList<List<Integer> > adj;
    private ArrayList<Character> color;
    private ArrayList<Integer> distance;
    private ArrayList<Integer> parent;
    
    /**Constructors*/

  /**
   * initializes an empty graph, with n vertices
   * and 0 edges
   * @param n the number of vertices in the graph
   */
    public Graph(int n) {
    	adj = new ArrayList<List<Integer>>();
    	color = new ArrayList<Character> ();
    	distance = new ArrayList<Integer>(); 
    	parent = new ArrayList<Integer>(); 
        vertices = n;
        edges = 0; 
        
        for (int i = 0; i <= n ; i ++)
        {
        	adj.add(new List<Integer>());
        	color.add('W');
        	distance.add(-1);
        	parent.add(0);
        }
    }
    
    /*** Accessors ***/
    
  /**
   * Returns the number of edges in the graph
   * @return the number of edges
   */
    public int getNumEdges() {
        return edges;
    }
    
    /**
     * Returns the number of vertices in the graph
     * @return the number of vertices
     */
    public int getNumVertices() {
        return vertices;
    }
    
    /**
     * returns whether the graph is empty (no vertices)
     * @return whether the graph is empty
     */
    public boolean isEmpty() {
        return vertices == 0;
    }

    /**
     * Returns the value of the distance[v]
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the distance of vertex v
     * @throws IndexOutOfBoundsException when 
     * the precondition is violated
     */
    public Integer getDistance(Integer v) throws IndexOutOfBoundsException{
        if (0 >= v || v > vertices)
        	throw new IndexOutOfBoundsException("getDistance(): the requested vertex is not in the graph. ");
    	return distance.get(v);
    }
    
    /**
     * Returns the value of the parent[v]
     * @param v a vertex in the graph
     * @precondition v <= vertices
     * @return the parent of vertex v
     * @throws IndexOutOfBoundsException when 
     * the precondition is violated
     */
    public Integer getParent(Integer v) throws IndexOutOfBoundsException {
        if (0 >= v || v > vertices)
        	throw new IndexOutOfBoundsException("getParent(): the requested vertex is not in the graph. ");
    	return parent.get(v);
    }
    
    /**
     * Returns the value of the color[v]
     * @param v a vertex in the graph
     * @precondition 0< v <= vertices
     * @return the color of vertex v
     * @throws IndexOutOfBoundsException when 
     * the precondition is violated
     */
    public Character getColor(Integer v) throws IndexOutOfBoundsException {
        if (0 >= v || v > vertices)
        	throw new IndexOutOfBoundsException("getColor(): the requested vertex is not in the graph. ");
    	return color.get(v);        
    }
    
    /*** Manipulation Procedures ***/
    
    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     * @precondition, 0 < u, v <= vertices
     * @throws IndexOutOfBounds exception when the precondition
     * is violated
     */
    public void addDirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
        if ((0 >= v || v > vertices) || (0 >= u || u > vertices))
        	throw new IndexOutOfBoundsException("addDirectedEdge(): At least one of the requested vertices is not in the graph. ");
    	
        if (adj.get(u).linearSearch(v) == -1)
        {
	        if (adj.get(u).isEmpty() || adj.get(u).getLast().compareTo(v) < 0) // insert at the last
	    	{
	    		adj.get(u).addLast(v);
	    	}
	    	else if (adj.get(u).getFirst().compareTo(v) > 0) // insert at the last
	    	{
	    		adj.get(u).addFirst(v);
	    	}
	    	else { // insert at the middle
	            while (adj.get(u).getIterator().compareTo(v) < 0)
	            {
	            	if (adj.get(u).getIterator().compareTo(v) > 0)
	            	{
	                    adj.get(u).reverseIterator();
	                	adj.get(u).addIterator(v);
	            		break; 
	            	}
	            	else if (adj.get(u).getIterator().compareTo(v) < 0)
	            		adj.get(u).advanceIterator();
	            	else
	            		break; 
	            }
	    	}
        
	        edges ++; 
        }
    }
    
    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     * and inserts u into the adjacent vertex list of v
     * @precondition, 0 < u, v <= vertices
     */
    public void addUndirectedEdge(Integer u, Integer v) {
        if ((0 >= v || v > vertices) || (0 >= u || u > vertices))
        	throw new IndexOutOfBoundsException("addUndirectedEdge(): At least one of the requested vertices is not in the graph. ");        
        
        if (adj.get(u).linearSearch(v) == -1)
        {
	    	if (adj.get(u).isEmpty() || adj.get(u).getLast().compareTo(v) < 0)  // adj is empty    
	    	{// insert at the last
	    		adj.get(u).addLast(v);
	    	}
	    	else if (adj.get(u).getFirst().compareTo(v) > 0) // insert at the last
	    	{
	    		adj.get(u).addFirst(v);
	    	}
	    	else { // insert at the middle
	            while (adj.get(u).getIterator().compareTo(v) < 0)
	            {
	            	if (adj.get(u).getIterator().compareTo(v) > 0)
	            	{
	                    adj.get(u).reverseIterator();
	                	adj.get(u).addIterator(v);
	            		break; 
	            	}
	            	else if (adj.get(u).getIterator().compareTo(v) < 0)
	            		adj.get(u).advanceIterator();
	            	else
	            		break; 
	            }
	    	}
        }
        else 
        {
        	return; 
        }
    	
        if (adj.get(v).linearSearch(u) == -1)
        {
	    	if (adj.get(v).isEmpty() || adj.get(v).getLast().compareTo(u) < 0) // insert at the last
	    	{
	    		adj.get(v).addLast(u);
	    	}
	    	else if (adj.get(v).getFirst().compareTo(u) > 0) // insert at the last
	    	{
	    		adj.get(v).addFirst(u);
	    	}
	    	else {   // insert at the middle 
	            while (adj.get(v).getIterator().compareTo(u) < 0) 
	            {
	            	if (adj.get(v).getIterator().compareTo(u) > 0)
	            	{
	                    adj.get(v).reverseIterator();
	                	adj.get(v).addIterator(u);
	            		break; 
	            	}
	            	else if (adj.get(v).getIterator().compareTo(u) < 0)
	            		adj.get(v).advanceIterator();
	            	else
	            		break; 
	            }
	    	}
        }
        else 
        {
        	return; 
        }
    	edges ++; 
    }
    
    /*** Additional Operations ***/
    
    /**
     * Creates a String representation of the Graph
     * Prints the adjacency list of each vertex in the graph,
     * vertex: <space separated list of adjacent vertices>
     */
    @Override public String toString() {
        String result = "";
        List<Integer> l;     
        for (int i = 1; i < adj.size(); i ++)
        {
        	l = adj.get(i); 
        	if (l.isEmpty())
        		result += (i) + ": - \n"; 
        	else 
        	{
        		result += (i) + ": " + l.toString();
        	}
        }
        return result;
    }
    
    
    
    /**
     * Prints the current values in the parallel ArrayLists
     * after executing BFS. First prints the heading:
     * v <tab> c <tab> p <tab> d
     * Then, prints out this information for each vertex in the graph
     * Note that this method is intended purely to help you debug your code
     */
    public void printBFS() {
        System.out.println("v\tc\tp\td");
        for (int i = 1; i <= vertices; i ++)
        {
        	System.out.printf("%d\t%s\t%d\t%d\n", i, color.get(i), parent.get(i), distance.get(i));
        }
    }
    
    /**
     * Performs breath first search on this Graph give a source vertex
     * @param source
     * @precondition graph must not be empty
     * @precondition source is a vertex in the graph
     * @throws IllegalStateException if the graph is empty
     * @throws IndexOutOfBoundsException when the source vertex 
     */

    public void BFS(Integer source) throws IllegalStateException,  IndexOutOfBoundsException{
        if (vertices == 0)
        	throw new IllegalStateException("BFS(): Unable to process the graph because it is empty");
        if ((0 >= source || source > vertices))
        	throw new IndexOutOfBoundsException("BFS(): At least one of the requested vertices is not in the graph. ");
        for (int i = 0; i <= vertices; i ++)
        {
        	color.set(i,'W');
        	distance.set(i, -1);
        	parent.set(i, 0);
        }
    	
    	List <Integer> queue = new List<Integer>();
    	Integer x; 
    	Integer adjval;
    	
    	color.set(source, 'G'); 
    	distance.set(source, 0); 
    	queue.addLast(source);
    	while (!queue.isEmpty())
    	{
    		x = queue.getFirst();
    		queue.removeFirst();
			adj.get(x).pointIterator();
    		for (int i = 0; i < adj.get(x).getLength(); i ++)
    		{
    			adjval = adj.get(x).getIterator(); 
    			if (color.get(adjval) == 'W')
    			{
    				color.set(adjval, 'G');
    				distance.set(adjval, distance.get(x)+1);
    				parent.set(adjval, x);
    				queue.addLast(adjval);
    			}
    			if (i < adj.get(x).getLength() - 1)
    				adj.get(x).advanceIterator();
    		}
			color.set(x, 'B'); 
    	}
    }
    
    /**
     * Recursive method to make a String containing the path 
     * from the source to the destination vertex
     * @param source the source vertex when performing BFS
     * @param destination the destination vertex
     * @param a String containing the path
     * @return a String containing the path
     */
    //Prints to the console or to an output file given the ostream parameter
    public String printPath(Integer source, Integer destination, String path) {
    	
    	
    	if (source == destination)
    		return source + " " + path;
    	else if (parent.get(destination) == 0)
    		return "No path from " + source + " to " + destination + " exists. "; 
    	else
    		return printPath(source, parent.get(destination), destination + " " + path);
    }
    
}
