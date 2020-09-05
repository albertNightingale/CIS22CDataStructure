import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RumorMill {
	
	private static HashMap<String, LinkedList<String>> adjList = new HashMap<String, LinkedList<String>>();
	private static ArrayList<String> simulations = new ArrayList<String>();
	
	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(keyboard.readLine());
		for (int i = 0; i < n; i++) {
			String data = keyboard.readLine();
			adjList.put(data, new LinkedList<String>());
		}
		
		int h = Integer.parseInt(keyboard.readLine()); 
		for (int i = 0; i < h; i++) {
			String data = keyboard.readLine();
			String name1 = data.split(" ")[0];
			String name2 = data.split(" ")[1];
			adjList.get(name1).add(name2);
			adjList.get(name2).add(name1);  
		}
		
		int t = Integer.parseInt(keyboard.readLine()); // numbers of times of simulation
		for (int i = 0; i < t; i++) {
			simulations.add(keyboard.readLine());
		}
		
		for (String start: simulations) {
			HashMap<String, Integer> dists = BFS(n, start);
			ArrayList<String> datas = new ArrayList<>();
			String output = ""; 
			int layer = 0;
			int cnt = 0;
			// traverse through each layer of the graph in the hashtable, 
			// and add them to the list
			while (cnt < n) { 
				// go through each vertex, if that vertex has the layer, add to the list
				for (String node : dists.keySet()) { 
					if (dists.get(node) == layer) {
						datas.add(node);
						cnt++;
					}
				}
				layer++;
								
				Collections.sort(datas);  // sort the datas in ascending order for the expected output
				for (int i = 0; i < datas.size(); i++)
				{
					output += datas.get(i) + " ";
				}
				datas.clear();
			}
			System.out.println(output.trim()); // print out the output that is out of excessive spaces around it
			
			
//			HashMap<Integer, LinkedList<String>> reversed = new HashMap<Integer, LinkedList<String>>();
//			
//			for (String vertex: dists.keySet()) {
//				int layer = dists.get(vertex);
//				if (reversed.containsKey(layer)) {
//					reversed.get(layer).add(vertex); // add the vertex into the appropriate bucket of distances
//				}
//				else {
//					LinkedList<String> q = new LinkedList<String>();
//					q.add(vertex);
//					reversed.put(layer, q);
//				}
//			}
//			
//			int layer = 0;
//			int cnt = 0;
//			String data = "";
//			while (layer < n && cnt < n) {
//				System.out.println(layer);
//				for (String val : reversed.get(layer))
//				{
//					data += val + " ";
//					cnt++;
//				}
//				layer++;
//			}
//			System.out.println(data.trim());
		}
	}
	
	private static HashMap<String, Integer> BFS(int n, String start) {
		HashMap<String, Integer> dists = new HashMap<>();
		HashMap<String, String> prevs = new HashMap<>();
		
		Queue<String> actions = new LinkedList<String>();
		
		for (String node: adjList.keySet()) {
			dists.put(node, 2000);
			prevs.put(node, null);
		}
		
		dists.replace(start, 0);
		actions.add(start);
		
		while(!actions.isEmpty()) {
			String next = actions.poll();
			for(int i = 0; i < adjList.get(next).size(); i++) { // adjList.get(next).get(i) is u's nodes, or v. 
				String child = adjList.get(next).get(i);
				if (dists.get(child) == 2000) { // if u is not visited
					actions.add(child); // add the u's nodes(v) to processing queue
					dists.replace(child, dists.get(next)+1);
//					prevs.replace(child, next);
				}
			}
		}
		
		return dists;
	}
	
}