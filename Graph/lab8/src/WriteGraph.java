
/**
* Graph.java
* @author Mia Skinner
* @author Albert Liu
* CIS 22C, Lab 8
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WriteGraph {

	public static void main(String[] args) {

		WriteGraph wg = new WriteGraph();
	}
	
	private Graph graph;
	private ArrayList<String> operations = new ArrayList<String>();
	private Scanner scanner;
	public WriteGraph() {
		scanner = new Scanner(System.in);
		startApp();
	}

	private void getAndReadFile() {

		boolean readable = false;
		boolean doneLoadingGraph = false;
		File inputfilename = null;
		BufferedReader buff;
		FileReader file;

		System.out.print("Enter the name of the file containing the graph information: ");
		try {
			while (!readable) {
				// get valid filename		
				inputfilename = new File(scanner.next());
				readable = inputfilename.exists();

				if (!readable) {
					System.out.println("Invalid file name!\n");
					System.out.print("Please enter the name of the file: ");
				}
			}
			
			file = new FileReader(inputfilename);
			buff = new BufferedReader(file);
			String line;

			// when valid filename provided:
			System.out.printf("\n***Reading from %s***\n\n", inputfilename);

			line = buff.readLine();
			graph = new Graph(Integer.parseInt(line));
			
			while (readable) {
				line = buff.readLine();
				if (line == null) // finished reading
				{
					readable = false;
					break;
				}
				else if (line.equals("0 0")) {
					doneLoadingGraph = true;
				}
				else if (!doneLoadingGraph) {
					// split line at space to break apart vertices u & v
					String[] vertices = line.split(" ");
					int u = Integer.parseInt(vertices[0]);
					int v = Integer.parseInt(vertices[1]);
	
					// add undirected edge to graph
					//System.out.printf("u: %s, v: %s\n", u, v);
					graph.addUndirectedEdge(u, v);
				}
				else {
					// add Graph operations to ArrayList for later
					operations.add(line);
				}	
			}
			
			int last = operations.size() - 1;
			if (operations.get(last).equals("0 0")) {
				operations.remove(last);
			}
			buff.close();
		} catch (IOException e) {
			System.out.println("readfile(): Problem reading file. " + e.toString());
		}
	}

	public void saveToFile() {
		// TODO
		String outputFileName = "";
		boolean isinvalid = true; 
		FileWriter logOutput = null;
		PrintWriter printout = null; 

		System.out.print("Please enter the name of the output file: ");
		while (isinvalid)
		{	
			outputFileName = scanner.next();

			if (outputFileName.matches("^[A-Za-z0-9]+.txt$"))
			{
				try
				{
					logOutput = new FileWriter(outputFileName);
					printout = new PrintWriter(logOutput);
					isinvalid = false; 
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Invalid file name!\n");
				continue; 
			}
		}
		
		printout.print(graph.toString());
		
		
		int v1, v2; 
		for (String s : operations)
		{
			String [] val = s.split(" ");
			v1 = Integer.parseInt(val[0]); 
			v2 = Integer.parseInt(val[1]); 

			graph.BFS(v1);
			
			printout.printf("The distance from %d to %d: %s\n", v1, v2, graph.getDistance(v2));
			if (graph.getDistance(v2) != -1)
				printout.printf("A shortest path from %d to %d: %s\n", v1, v2, graph.printPath(v1, v2, ""));
			else
				printout.println(graph.printPath(v1, v2, ""));
				
		//"Please enter the name of the output file: "
		}
		try {
			logOutput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.printf("Thank you! Your Graph is now written to %s!\n", outputFileName);
	}

	/**
	 * Exits the WriteGraph App
	 */
	private void exit() {
		// System.out.println("\nGoodbye!");
		System.exit(0);
	}

	/**
	 * Starts the WriteGraph App
	 */
	private void startApp() {

		System.out.println("Welcome to WriteGraph!\n");
		getAndReadFile();
		saveToFile();
		exit();

	}
}
