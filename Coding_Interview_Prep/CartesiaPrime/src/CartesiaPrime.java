import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class CartesiaPrime {

	public static HashSet<Coordinate> badGuys = new HashSet<Coordinate>();
	private static LinkedList<Coordinate> list = new LinkedList<Coordinate>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String[] initCoorLine = keyboard.readLine().split(" ");
		Coordinate initCoor = new Coordinate(Integer.parseInt(initCoorLine[0]), Integer.parseInt(initCoorLine[1]));
		String[] abcd = keyboard.readLine().split(" ");
		int a = Integer.parseInt(abcd[0]);
		int b = Integer.parseInt(abcd[1]);
		int c = Integer.parseInt(abcd[2]);
		int d = Integer.parseInt(abcd[3]);
		
		int attempt = Integer.parseInt(keyboard.readLine().strip());
		int badCount = Integer.parseInt(keyboard.readLine().strip());
		
		for (int i = 0; i < badCount; i++) {
			String[] badCoor = keyboard.readLine().split(" ");
			badGuys.add(new Coordinate(Integer.parseInt(badCoor[0]), Integer.parseInt(badCoor[1])));
		}
		
		String succeedMsg = "I had %d to spare! Beam me up Scotty!";
		String failedMsg = "You will be assimilated! Resistance is futile!";
		
		int result = solve(attempt, a, b, c, d, initCoor);
		String actualMsg = result>=0?String.format(succeedMsg, result):failedMsg;
		System.out.println(actualMsg);
		
	}
	
	/****
	 * 
	 * @return the amount of time left
	 */
	private static int solve(int attempt, int a, int b, int c, int d, Coordinate initCoor) {
		int att = 0;
		Coordinate initState = new Coordinate(initCoor.getX(), initCoor.getY()); // construct the starting coordinate
		
		list.add(initState); // manually adding the first state. 
		
		// repeat the process until attempts are over 
		do { 
			if (makeAttempt(att+1, a, b, c, d)) 
			{
				return attempt-att;
			}
			att++;
		} while (att <= attempt);
		
		return attempt-att-1;
	}
	
	/***
	 * 
	 * @param att
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param list
	 * @return true if attempt is successful, false if the attempt is unsuccessful
	 */
	private static boolean makeAttempt(int att, int a, int b, int c, int d) {
		LinkedList<Coordinate> ls = new LinkedList<Coordinate>();
		for (Coordinate coor : list) {
			if (coor.isFinalCoordinate())
				return true;
			if (!badGuys.contains(coor))
				ls.addAll(coor.nextCoordinate(a, b, c, d, att));
		}
		
		list = ls; // set list to ls and pass through the parameter
		return false;
	}
	
	

}
