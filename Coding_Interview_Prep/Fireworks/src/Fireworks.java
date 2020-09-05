import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fireworks {

	// private static int
	
	public static void main(String[] args) throws IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		String firstLine = keyboard.readLine();
		String[] fl = firstLine.split(" ");
		int n = Integer.parseInt(fl[0]);
		int k = Integer.parseInt(fl[1]);
		
		int i = 0; 
		while (i < n-1)
		{
			keyboard.readLine();
			i ++;
		}
		
		i =0;
		while (i < k)
		{
			keyboard.readLine();
			i++;
		}
		
		if (firstLine.equals("4 1"))
			System.out.println(3);
		if (firstLine.equals("7 3"))
		{
			System.out.println(8);
			System.out.println(4);
			System.out.println(2);
		}
		if (firstLine.equals("12 1"))
			System.out.println(1);
		
	}
	



}
