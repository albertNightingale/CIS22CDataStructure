/**
* Graph.java
* @author Mia Skinner
* @author Albert Liu
* CIS 22C, Lab 8
*/

public class GraphTest {
	
	
	public static void main(String [] args)
	{
		System.out.println("******Graph Constructor********");
		Graph graph = new Graph(5);
		Graph graph1 = new Graph(0);
		System.out.println("Should print 0: " + graph.getParent(5));
		System.out.println("For each vertex (v) should print 'W' for color (c), 0 for parent (p), and -1 for distance (d): ");
		graph.printBFS(); 
		
		
		System.out.println("\n******getNumEdges*******");
		System.out.println("Should print 0: " + graph.getNumEdges());
		graph.addDirectedEdge(1, 2);
		graph.addDirectedEdge(1, 3);
		System.out.println("Should print 2: " + graph.getNumEdges());

		System.out.println("\n******getNumVertices******");
		System.out.println("Should print 5: " + graph.getNumVertices());
		System.out.println("Should print 0: " + graph1.getNumVertices());
		
		System.out.println("\n******isEmpty******");
		System.out.println("Should print false: " + graph.isEmpty());
		System.out.println("Should print true: " + graph1.isEmpty());
		
		System.out.println("\n******getDistance******");
		graph.BFS(1);
		System.out.println("Should print 1: " + graph.getDistance(2));
		System.out.println("Should print 0: " + graph.getDistance(1));
		System.out.println("Should throw an exception"); // testing the exception case 
 		try
		{
			System.out.println(graph.getDistance(10));
		} catch(IndexOutOfBoundsException e) {System.out.println(e.getMessage());}
		
 		
 		System.out.println("\n******getParent******");
		graph.BFS(1);
		System.out.println("Should print 1: " + graph.getParent(3));
		System.out.println("Should print 0: " + graph.getParent(1));
		System.out.println("Should throw an exception"); // testing the exception case 
 		try
		{
			System.out.println(graph.getParent(-10));
		}catch(IndexOutOfBoundsException e) {System.out.println(e.getMessage());}
 		
		
		System.out.println("\n******getColor*******");
		graph.addDirectedEdge(5, 2);
		graph.addUndirectedEdge(3, 2);
		System.out.println("Should print W: " + graph.getColor(5));
		graph.BFS(1);
		System.out.println("Should print B: " + graph.getColor(1));
		System.out.println("Should throw an exception"); // testing the exception case 
 		try
		{
			System.out.println(graph.getColor(-10));
		}catch(IndexOutOfBoundsException e) {System.out.println(e.getMessage());}
 		
 		
		System.out.println("\n******addDirectedEdge******");		
		graph1 = new Graph(5);
		graph1.addDirectedEdge(1, 2);
		graph1.addDirectedEdge(1, 3);
		graph1.addDirectedEdge(1, 4);
		graph1.addDirectedEdge(3, 2);
		graph1.addDirectedEdge(2, 3);
		graph1.addDirectedEdge(4, 4);
		graph1.addDirectedEdge(5, 2);
		
		System.out.println("Should print \n1: 2 3 4 \n" + 
				"2: 3 \n" + 
				"3: 2 \n" + 
				"4: 4 \n" + 
				"5: 2 \n--------\n" + graph1);
		
		System.out.println("Should throw an exception"); // testing the exception case 
		try {
			graph1.addDirectedEdge(20, 2);
		}catch(IndexOutOfBoundsException e) {System.out.println(e.getMessage());}

		
		System.out.println("\n******addUndirectedEdge******");
		graph = new Graph(8);
		graph.addUndirectedEdge(1, 2);
		graph.addUndirectedEdge(1, 3);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(2, 4);
		graph.addUndirectedEdge(3, 4);
		graph.addUndirectedEdge(2, 8);
		graph.addUndirectedEdge(5, 6);
		graph.addUndirectedEdge(6, 7);
		graph.addUndirectedEdge(7, 5);
		
		System.out.println("Should print \n1: 2 3 \n" + 
				"2: 1 3 4 8 \n" + 
				"3: 1 2 4 \n" + 
				"4: 2 3 \n" + 
				"5: 6 7 \n" + 
				"6: 5 7 \n" + 
				"7: 5 6 \n" + 
				"8: 2 \n--------\n" + graph);
		
		System.out.println("Should throw an exception"); // testing the exception case 
		try {
			graph.addUndirectedEdge(20, 2);
		}catch(IndexOutOfBoundsException e) {System.out.println(e.getMessage());}
		
		System.out.println("\n******@Override toString******");
		System.out.println("Should print \n1: 2 3 4 \n" + 
				"2: 3 \n" + 
				"3: 2 \n" + 
				"4: 4 \n" + 
				"5: 2 \n--------\n" + graph1);
		
		System.out.println("Should print \n1: 2 3 \n" + 
				"2: 1 3 4 8 \n" + 
				"3: 1 2 4 \n" + 
				"4: 2 3 \n" + 
				"5: 6 7 \n" + 
				"6: 5 7 \n" + 
				"7: 5 6 \n" + 
				"8: 2 \n--------\n" + graph);
		
		System.out.println("\n******printBFS******");
		//graph.BFS(source);
		graph = new Graph(5);
		System.out.println("Should print \nv	c	p	d\n" + 
				"1	W	0	-1\n" + 
				"2	W	0	-1\n" + 
				"3	W	0	-1\n" + 
				"4	W	0	-1\n" + 
				"5	W	0	-1\n--------");
		graph.printBFS();
		
		graph1.BFS(1);
		System.out.println("Should print \nv	c	p	d\n" + 
				"1	B	0	0\n" + 
				"2	B	1	1\n" + 
				"3	B	1	1\n" + 
				"4	B	1	1\n" + 
				"5	W	0	-1\n--------");
		graph1.printBFS();
		
		
		System.out.println("\n******BFS*******");
		graph1.BFS(5);
		System.out.println("Should print B: " + graph1.getColor(5));
		System.out.println("Should print W: " + graph1.getColor(1));
		System.out.println("Should print 5: " + graph1.getParent(2));
		System.out.println("Should print 1: " + graph1.getDistance(2));
		System.out.println("Should print -1: " + graph1.getDistance(1));
		Graph graph2 = new Graph(0);
		try
		{
			graph2.BFS(10);
		}
		catch(IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		try
		{
			graph.BFS(10);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n******printPath******");
		// graph = new Graph(7);
		//graph.addUndirectedEdge(u, v);
		
		System.out.println("Should print 5 2 3: " + graph1.printPath(5, 3,""));
		System.out.println("Should print 2 3 : " + graph1.printPath(2, 3,""));

	}
}


/**************
******Graph Constructor********
Should print 0: 0
For each vertex (v) should print 'W' for color (c), 0 for parent (p), and -1 for distance (d): 
v	c	p	d
1	W	0	-1
2	W	0	-1
3	W	0	-1
4	W	0	-1
5	W	0	-1

******getNumEdges*******
Should print 0: 0
Should print 2: 2

******getNumVertices******
Should print 5: 5
Should print 0: 0

******isEmpty******
Should print false: false
Should print true: true

******getDistance******
Should print 1: 1
Should print 0: 0
Should throw an exception
getDistance(): the requested vertex is not in the graph. 

******getParent******
Should print 1: 1
Should print 0: 0
Should throw an exception
getParent(): the requested vertex is not in the graph. 

******getColor*******
Should print W: W
Should print B: B
Should throw an exception
getColor(): the requested vertex is not in the graph. 

******addDirectedEdge******
Should print 
1: 2 3 4 
2: 3 
3: 2 
4: 4 
5: 2 
--------
1: 2 3 4 
2: 3 
3: 2 
4: 4 
5: 2 

Should throw an exception
addDirectedEdge(): At least one of the requested vertices is not in the graph. 

******addUndirectedEdge******
Should print 
1: 2 3 
2: 1 3 4 8 
3: 1 2 4 
4: 2 3 
5: 6 7 
6: 5 7 
7: 5 6 
8: 2 
--------
1: 2 3 
2: 1 3 4 8 
3: 1 2 4 
4: 2 3 
5: 6 7 
6: 5 7 
7: 5 6 
8: 2 

Should throw an exception
addUndirectedEdge(): At least one of the requested vertices is not in the graph. 

******@Override toString******
Should print 
1: 2 3 4 
2: 3 
3: 2 
4: 4 
5: 2 
--------
1: 2 3 4 
2: 3 
3: 2 
4: 4 
5: 2 

Should print 
1: 2 3 
2: 1 3 4 8 
3: 1 2 4 
4: 2 3 
5: 6 7 
6: 5 7 
7: 5 6 
8: 2 
--------
1: 2 3 
2: 1 3 4 8 
3: 1 2 4 
4: 2 3 
5: 6 7 
6: 5 7 
7: 5 6 
8: 2 


******printBFS******
Should print 
v	c	p	d
1	W	0	-1
2	W	0	-1
3	W	0	-1
4	W	0	-1
5	W	0	-1
--------
v	c	p	d
1	W	0	-1
2	W	0	-1
3	W	0	-1
4	W	0	-1
5	W	0	-1
Should print 
v	c	p	d
1	B	0	0
2	B	1	1
3	B	1	1
4	B	1	1
5	W	0	-1
--------
v	c	p	d
1	B	0	0
2	B	1	1
3	B	1	1
4	B	1	1
5	W	0	-1

******BFS*******
Should print B: B
Should print W: W
Should print 5: 5
Should print 1: 1
Should print -1: -1
BFS(): Unable to process the graph because it is empty
BFS(): At least one of the requested vertices is not in the graph. 

******printPath******
Should print 5 2 3: 5 2 3 
Should print 2 3 : 2 3 
*/