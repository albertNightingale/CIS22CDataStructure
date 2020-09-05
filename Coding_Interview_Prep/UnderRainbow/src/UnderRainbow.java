import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UnderRainbow {

	private static LinkedList<Integer> distances = new LinkedList<Integer>();
	private static int[] leastPenalty;
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		int stops = Integer.parseInt(keyboard.readLine());
		leastPenalty = new int[stops + 1];
		
		int cnt = 0;
		while (cnt < stops + 1)
		{
			distances.add(Integer.parseInt(keyboard.readLine()));
			cnt ++;
		}
		System.out.println(penalty(stops));
	}
	
	private static int penalty(int stops)
	{
		for (int idx = stops; idx >= 0; idx--) // going from the end to the front
		{
			leastPenalty[idx] = penalty(stops, idx);
		}
		return leastPenalty[0];
	}
	
	private static int penalty(int stops, int idx)
	{
		if (idx == stops)
			return 0;
		
		Double minCost = Double.MAX_VALUE;
		for (int i = idx + 1; i <= stops; i++)
		{
			Double iCost = Math.pow(400-(distances.get(i)-distances.get(idx)), 2) + leastPenalty[i];
			if (iCost < minCost)
			{
				minCost = iCost;
			}
		}
		
		return minCost.intValue();
	}	
}
