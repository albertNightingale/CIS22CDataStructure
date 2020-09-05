/* @author Albert Liu
 * @date 12/26/2019
 * A dependency graph is a table with three columns
 * 1. the first column is the data itself
 * 2. the third column is a list of objects that the data is depending on, also known as dependees
 * 3. the second column is a list of objects that points to/depends on the data, also known as dependents 
 */

import java.util.HashMap; 
import java.util.HashSet; 

public class DependencyGraph<T extends Comparable<T>> {

	private class Node{
		T data;
		HashSet<T> dependents;
		HashSet<T> dependees;
		
		private Node(T data)
		{
			this.data = data; 
			dependents = new HashSet<T>();
			dependees = new HashSet<T>();
		}
		
		private Node(T data, HashSet<T> dependents, HashSet<T> dependees)
		{
			this.data = data;
			this.dependents = new HashSet<T>(dependents);
			this.dependees = new HashSet<T>(dependees);
		}
	}
	
	HashMap<T, Node> dependencygraph;
	
	public DependencyGraph()
	{
		dependencygraph = new HashMap<T, Node>();
	}
	
	/*******
	 * Add the dependency relationship by 
	 * adding dend to nd's dependents list
	 * and adding the nd to dend's dependees list 
	 * @param nd
	 * @param dend
	 * @exception IllegalArgumentException: when either elements passed into the parameter is invalid
	 */
	public void addDependency(T nd, T dend)
	{
		if (nd == null || dend == null)
		{
			throw new IllegalArgumentException("AddDependency(): Arguments may not be null");
		}
		else
		{
			// add dend to the dependent HashSet
			if (dependencygraph.containsKey(nd))   {
				Node n = new Node(nd, dependencygraph.get(nd).dependents, dependencygraph.get(nd).dependees);
				n.dependents.add(dend); 
				dependencygraph.put(nd, n);
			}
			else {
				Node n = new Node(nd);
				n.dependents.add(dend); 
				dependencygraph.put(nd, n);
			}
			
			// add nd to the dependee HashSet
			if (dependencygraph.containsKey(dend)) {
				Node n = new Node(dend, dependencygraph.get(dend).dependents, dependencygraph.get(dend).dependees);
				n.dependees.add(nd);
				dependencygraph.put(dend, n);
			}
			else {
				Node n = new Node(dend);
				n.dependees.add(nd);
				dependencygraph.put(dend, n);
			}
		}
	}
	
	/*********
	 * Remove the graph dependency relationship between nd and dend by
	 * removing dend from nd's dependents list
	 * removing nd from dend;s dependees list
	 * @param nd
	 * @param dend
	 * @exception IllegalArgumentException: when either elements passed into the paramater is invalid
	 */
	public void removeDependency(T nd, T dend)
	{
		if (nd == null || dend == null) {
			throw new IllegalArgumentException("removeDependency(): parameters is null. ");
		}
		else if (!dependencygraph.containsKey(nd) || !dependencygraph.containsKey(dend))
		{
			throw new IllegalArgumentException("removeDependency(): elements do not exist within the database. "); 
		}
		else {
			Node n1 = new Node(nd, dependencygraph.get(nd).dependents, dependencygraph.get(nd).dependees);
			n1.dependents.remove(dend);
			dependencygraph.put(nd, n1);
			
			Node n2 = new Node(dend, dependencygraph.get(dend).dependents, dependencygraph.get(dend).dependees);
			n2.dependees.remove(nd);
			dependencygraph.put(dend, n2);
		}
	}


	/******
	 * Replace dependees of nd with a new list of dependees
	 * Old dependency relationships that are not exiting 
	 * in new dependency relationships will be removed 
	 * @param nd
	 * @param newDependees
	 */
	public void replaceDependees(T nd, List<T> newDependees)
	{
		
	}
	
	/*****
	 * Replace dependents of nd with a new list of dependents
	 * Old dependency relationships that are not exiting 
	 * in new dependency relationships will be removed
	 * @param nd
	 * @param newDependents
	 */
	public void replaceDependents(T nd, List<T> newDependents)
	{
		
	}
	
	/*****
	 * remove the data from the dependencygraph, if it exists. 
	 * @throws IllegalArgumentException if the data does not exist. 
	 * if the data exists in the dependencygraph, 
	 * all dependency with that data will be removed as well. 
	 * @param nd
	 */
	public void removeData(T nd)
	{
		
	}
	
	/*****
	 * insert the data into the dependency graph, if it does not exist
	 * do nothing if the data is already existing in the graph
	 * @param nd
	 */
	public void insertData(T nd)
	{
		
	}
	
	/******
	 * clear all elements and dependencies from the dependencygraph
	 * leaving an empty dependency graph
	 */
	public void clearData()
	{
		
	}
	
	/****
	 * clear all dependencies within the elements of the dependencygraph
	 */
	public void clearDependency()
	{
		
	}
	
	
	/*******
	 * combine two dependencygraphs into one, 
	 * merging together the dependencies relationships of elements that are the same
	 * for the same elements inside of the dependencygraph, 
	 * combine the dependency relationship of elements
	 * @param dg
	 */
	public void combineGraph(DependencyGraph dg)
	{
		
	}
	
	
	
	
}
