import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
    
    private static List<HashMap<Integer, HashMap<Integer, Double>>> adjLists = new ArrayList<HashMap<Integer, HashMap<Integer, Double>>>();
    private static List<String[]> nmpairs = new ArrayList<String[]>();
    
    public static void main (String[] args) throws NumberFormatException, IOException {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = 0;
        
        while (cnt < 20) { // cases
            cnt ++;
            String[] cases = keyboard.readLine().split(" ");
            int n = Integer.parseInt(cases[0]);
            int m = Integer.parseInt(cases[1]);
            
            if (m==0 && n==0) { // cases end
                break;
            }
            else {
                // build up the adjList 
                HashMap<Integer, HashMap<Integer, Double>> adjList = new HashMap<Integer, HashMap<Integer, Double>>();
                for (int i = 0; i < n; i++) { // initial set up
                	adjList.put(i, new HashMap<Integer, Double>());
                }
                
                for (int i = 0; i < m; i++) { 
                    String[] list = keyboard.readLine().split(" ");
                    int v1 = Integer.parseInt(list[0]);
                    int v2 = Integer.parseInt(list[1]);
                    double e = Double.parseDouble(list[2]);
                    if (adjList.containsKey(v1)) { // already contains key
                        if (adjList.get(v1).containsKey(v2)) { // there already exists an edge between two vertices
                            if (adjList.get(v1).get(v2) < e) { // found a longer edge between two intersections out of multiple corridors
                                adjList.get(v1).replace(v2, e); // put it in
                            }
                            // else no need to insert them in as they are going to make him smaller. 
                        }
                        else {
                            adjList.get(v1).put(v2, e);
                        }
                    }
                    else {
                        adjList.put(v1, new HashMap<Integer, Double>());
                        adjList.get(v1).put(v2, e);
                    }
                    
                    /// values
                    if (adjList.containsKey(v2)) { // already contains key
                        if (adjList.get(v2).containsKey(v1)) { // there already exists an edge between two vertices
                            if (adjList.get(v2).get(v1) < e) { // found a longer edge between two intersections out of multiple corridors
                                adjList.get(v2).replace(v1, e); // put it in
                            }
                            // else no need to insert them in as they are going to make him smaller. 
                        }
                        else {
                            adjList.get(v2).put(v1, e);
                        }
                    }
                    else {
                        adjList.put(v2, new HashMap<Integer, Double>());
                        adjList.get(v2).put(v1, e);
                    }
                }
                
                adjLists.add(adjList);
            }
        }
        
        for (HashMap<Integer, HashMap<Integer, Double>> ls : adjLists) {
            // process the list
            Double endingScale;
            HashMap<Integer, Double> map = BFS(ls);
            endingScale = map.get(ls.size()-1); // n 
            
            // print out the value
            String val = endingScale.toString();
            if (val.length()<6) // 0.003, 0.2
            {
                for (int i = 0; i <= 6 - val.length() + 1; i++) {  
                    val += "0";
                } // 0.0030, 0.2000
            }
            else if (val.length()>6) // 0.001003, 0.723232
            {
                val = val.substring(0, 6); // 0.0010, 0.7232
            }
            System.out.println(val);
        }
    }
    
    private static HashMap<Integer, Double> BFS(HashMap<Integer, HashMap<Integer, Double>> adjList) {
        HashMap<Integer, Double> ratios = new HashMap<>();  // ratio loss 
        HashMap<Integer, Integer> prevs = new HashMap<>();
        HashSet<PQNode> existingNd = new HashSet<PQNode>();
        
        Comparator<PQNode> comp = new Comparator<PQNode>() {
            @Override
            public int compare(PQNode o1, PQNode o2) {
                return o1.compareTo(o2);
            }
        };
        
        PriorityQueue<PQNode> actions = new PriorityQueue<PQNode>(comp);
        
        for (Integer vertex: adjList.keySet()) {
            ratios.put(vertex, 0.0);
            prevs.put(vertex, null);
        }
        
        ratios.replace(0, 1.0);
        actions.add(new PQNode(0, 0.0));
        while(!actions.isEmpty()) {
            PQNode next = actions.poll(); // pull off the node with the lowest ratio loss
            
            if (existingNd.contains(next)) {
                continue;
            }
            else {
                existingNd.add(next);
            }
            
            Integer nextcor = next.getCor();
            HashMap<Integer, Double> child = adjList.get(nextcor); // get a list of edges pairs
            
            for(Integer cor : child.keySet()) { // a list of child nodes
                Double corRatio = ratios.get(cor);
                Double nextRatio = ratios.get(nextcor);
                
                if (corRatio < nextRatio * child.get(cor)) {
                    ratios.replace(cor, nextRatio * child.get(cor));
                    prevs.replace(cor, nextcor);
                    PQNode n = new PQNode(cor, round(1-ratios.get(cor), 4));
                    actions.add(n);
                }
            }
        }
        
        return ratios;
    }
    
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
