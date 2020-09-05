import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class NumberTheory {
	
	static LinkedList<String> inputData = new LinkedList<String>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String input = keyboard.readLine();
			if (input == null || input.isBlank())
				break;

			inputData.add(input);
		}
		
		while (!inputData.isEmpty()) {
			String data = inputData.removeFirst();
 			String[] splitInput = data.split(" ");
			
			switch(splitInput[0]) {
				case "gcd": 
					System.out.println(gcd(Long.parseLong(splitInput[1]), 
							Long.parseLong(splitInput[2])));
					break;
				case "exp":
					System.out.println(exp(Long.parseLong(splitInput[1]), 
							Long.parseLong(splitInput[2]), 
							Long.parseLong(splitInput[3])));
					break;
				case "inverse":
					System.out.println(inverse(Long.parseLong(splitInput[1]), 
							Long.parseLong(splitInput[2])));
					break;
				case "isprime":
					System.out.println(isPrime(Long.parseLong(splitInput[1])));
					break;
				case "key":
					System.out.println(rsa(Long.parseLong(splitInput[1]), 
							Long.parseLong(splitInput[2])));
					break;
				
			}
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	}
	
	private static String rsa(long p, long q) {
		long n = p*q;
		long t = (p-1)*(q-1);
		long e = 2;
		while (gcd(e, t)!=1) {
			e++;
		}
		
		long d = Long.parseLong(inverse(e, t));
		
		String returnData = "" + n;
		returnData += " " + e;
		returnData += " " + d;
		return returnData;
	}
	
	private static String isPrime(long n) {
		if (n < 60) {
			int cnt = 2;
			while (cnt < n) {
				if (exp(cnt, n-1, n)!=1)
				{
					return "no";
				}
				cnt ++;
			}
		}
		else {
			int cnt = 2;
			while (cnt < 60) {
				if (exp(cnt, n-1, n)!=1)
				{
					return "no";
				}
				cnt ++;
			}
		}
		return "yes";
	}
	
	private static String inverse(long a, long N) {
		long [] arr = ee(a, N);
		if (arr[2]==1) {
			Long val = mod(arr[0], N);
			return val.toString();
		}
		else {
			return "none";
		}
			
		
	}
	
	private static long[] ee(long a, long b) 
	{
		long [] arr = {1, 0, a};
		if (b==0)
			return arr;
		else
		{
			arr = ee(b, mod(a, b));
			long copy = arr[1];
			arr[1] = arr[0] - a/b*copy;
			arr[0] = copy;			
			return arr;
		}
	}
	
	private static long exp(long x, long y, long N) {
		if (y==0) 
		{
			return 1;
		}
		else 
		{
			long z = exp(x, y/2, N);
			if (mod(y, 2)==0)
				return mod(z * z, N);
			else 
				return mod(mod(x, N) * mod(z * z, N), N);
		}
	} 
	
	private static long gcd(long a, long b) {
		if (b==0) {
			return a;
		}
		else {
			return gcd(b, mod(a,b));
		}
		
	}
	
	private static long mod(long k, long n) {
		if (k >= 0) {
			return k % n;
		}
		else {
			return n + k % n;
		}
	}
}
