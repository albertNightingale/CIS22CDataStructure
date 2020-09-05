import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BackQueue {

	private static HashMap<Integer, LinkedList<Integer>> line = new HashMap<Integer, LinkedList<Integer>>();
	public static void main(String[] args) throws IOException 
	{
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String[] logistics = keyboard.readLine().split(" ");
		int customer = Integer.parseInt(logistics[0]);
		int openTime = Integer.parseInt(logistics[1]);
		
		for (int cnt = 0; cnt <= openTime; cnt++)
		{
			line.put(cnt, new LinkedList<Integer>());
		}
		
		// build map
		for (long j = 0; j < customer; j++)
		{
			String[] arr = keyboard.readLine().split(" ");
			int money = Integer.parseInt(arr[0]);
			int timeAwaiting = Integer.parseInt(arr[1]);
			
			line.get(timeAwaiting).add(money);
		} 
		
		// perform optimization
		System.out.println(optimize(openTime));
	}  
	
	private static int optimize(int openTime)
	{
		int sum = 0;
		int cnt = openTime;
		while (cnt >= 0)
		{
			LinkedList<Integer> money = line.get(cnt);
			int max = 0;
			
			for (Integer mon : money)
			{
				max = Math.max(max, mon);
			}
			
			sum += max;
			line.get(cnt).remove((Integer)max);
			cnt--;
			if (cnt >= 0)
				line.get(cnt).addAll(line.get(cnt + 1));
		}
		
		return sum;
	}
	
}
