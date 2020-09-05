import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AutoSink {
	
	private static HashMap<String, LinkedList<String>> adjList = new HashMap<String, LinkedList<String>>();
	private static HashMap<String, City> cities = new HashMap<String, City>();
	private static ArrayList<String[]> trips = new ArrayList<String[]>(); 
	private static LinkedList<City> cityOdr = new LinkedList<City>();
	private static HashMap<String, Integer> cost = new HashMap<>();
	private static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(keyboard.readLine());
		for (int i = 0; i < n; i++) {
			String data = keyboard.readLine();
			adjList.put(data.split(" ")[0], new LinkedList<String>());
			cities.put(data.split(" ")[0], new City(data.split(" ")[0], Integer.parseInt(data.split(" ")[1])));
		}
		
		int h = Integer.parseInt(keyboard.readLine());
		for (int i = 0; i < h; i++) {
			String data = keyboard.readLine();
			adjList.get(data.split(" ")[0]).add(data.split(" ")[1]);  
		}
		
		int t = Integer.parseInt(keyboard.readLine());
		for (int i = 0; i < t; i++) {
			trips.add(keyboard.readLine().split(" "));
		}
		
		for (String [] pair: trips) {
			System.out.println(findBestPath(pair[0], pair[1]));
			cityOdr.clear();
			cost.clear();
		}
	}
	
	private static String findBestPath(String src, String dest) {
		DFS(src, dest);

		for(City city: cityOdr) { 
			if (city.getName().equals(dest)) { // toll fee to destination is 0
				cost.put(city.getName(), 0);
			}
			else if (city.getPostn() >= cities.get(dest).getPostn()) { // sink
				cost.put(city.getName(), 10000);
			}
			else { // cost is the minimum of all children 
				Integer minimum = 100000;
				for (String cityName: adjList.get(city.getName())) {
					minimum = Math.min(cost.get(cityName), minimum);
				}
				cost.put(city.getName(), minimum + city.getToll());
			}
		}
		
		if (!cost.get(src).equals(10000))
			return cost.get(src).toString();
		return "NO";
	}
	
	private static void DFS(String src, String dest) {

		for (City city: cities.values()) {
			city.setVisited(false);
		}
		
		for (City city : cities.values()) {
			if (!city.getVisited()) {
				explore(city, src, dest);
			}
		}
	}
	
	private static void explore(City city, String src, String dest) {
		city.setVisited(true); 
		previsit(city);
		for (String cn : adjList.get(city.getName())) {
			if (!cities.get(cn).getVisited()) { // is not visited
				explore(cities.get(cn), src, dest);
			}
		}
		postvisit(city, src, dest);
	}
	
	private static void previsit(City city) {
		city.setPren(++cnt);
	}
	
	private static void postvisit(City city, String src, String dest) {
		city.setPostn(++cnt); 
		cityOdr.add(city); // push to the queue
	}
}
