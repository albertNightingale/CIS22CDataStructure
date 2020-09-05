
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import org.apache.commons.lang3.time.StopWatch;
import java.util.concurrent.TimeUnit;


public class Main {

	// provide class-wide access because passing through 
	// method parameter takes time, making the experiment inaccurate. 
	private static HashSet<String> solution = new HashSet<String>(); 
	private static HashSet<String> rejected = new HashSet<String>();
	private static HashSet<String> dictionary = new HashSet<String>();
	
	
	public static void main(String[] args) throws IOException
	{
		// get set up info
		/*
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String[] firstline = keyboard.readLine().split(" ");
		int n = Integer.parseInt(firstline[0]);
		int k = Integer.parseInt(firstline[1]);
		*/
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		int n = 0;
		int k = 0;
		double currenttime;
		double prevtime = 0;
		////// 1. experiment with dynamic n and k = 5   ///// 
		// create words
		n = 4;
		k = 5;
		/*
		System.out.println("Estimate to 9th digit after decimal point in microseconds");
		System.out.println(String.format("n = dynamic; k = %s", k));
		System.out.println("size\t current time\t\t delta");
		
		
		while (true)
		{
			for (int i = 0; i < 1; i++)
				dictionary.add(generateRandomWords(k));
			
			currenttime = doTiming(n, k);
			System.out.println(n + "\t\t " + String.format("%.9f", currenttime) + "\t\t" + String.format("%.9f", currenttime-prevtime));
			prevtime = currenttime;
			n*=2;
		}
		*/
		
		
		////// 2. experiment with n = 2000 and dynamic k
		System.out.println("Estimate to 9th digit after decimal point in microseconds");
		n = 2000;
		k = 2;
		System.out.println(String.format("n = %s; k = dynamic", n));
		System.out.println("length\t\t current time\t\t delta");
		
		while (true)
		{
			for (int i = 0; i < 1; i++)
				dictionary.add(generateRandomWords(k));
			
			currenttime = doTiming(n, k);
			System.out.println(k + "\t\t " + String.format("%.9f", currenttime) + "\t\t" + String.format("%.9f", currenttime-prevtime));
			prevtime = currenttime;
			k++;
		}

	}
	
	private static double doTiming(int n, int k) throws IOException
	{		
        // Create a stopwatch
		StopWatch sw = new StopWatch();

        // Keep increasing the number of repetitions until one second elapses.
        double elapsed = 0;
        long repetitions = 1;
        
        do
        {
            repetitions *= 2;
            sw.start();
            for (long i = 0; i < repetitions; i++)
            {
            	calculateValue();
            }
            sw.stop();            
            elapsed += toMiliSec(sw.getTime(TimeUnit.NANOSECONDS));
            sw.reset();
        } while (elapsed < 1000);
        double totalAverage = elapsed / repetitions;

        // Create a stopwatch
        sw = new StopWatch();

        // Keep increasing the number of repetitions until one second elapses.
        elapsed = 0;
        repetitions = 1;
        do
        {
            repetitions *= 2;
            sw.start();
            for (long i = 0; i < repetitions; i++)
            {
            	
            }
            sw.stop();
            elapsed += toMiliSec(sw.getTime(TimeUnit.NANOSECONDS));
            sw.reset();
        } while (elapsed < 1000);
        double overheadAverage = elapsed / repetitions;
    
        // Return the difference
        return totalAverage - overheadAverage;
	}
	
	
	private static double toMiliSec(long nanosec)
	{
		return nanosec/1000000.0;
	}
	
	private static String generateRandomWords(int n)
	{
		String s = "";
		for (int i = 0; i < n; i++)
		{
			s += (char)((int)(Math.random()*26) + (int)'a');
		}
		return s;
	}
	
	private static void calculateValue() throws IOException
	{
		for (String s : dictionary)
		{
			char[] unsorted_value = s.toCharArray();
			Arrays.sort(unsorted_value);
			String value = new String(unsorted_value);
			
			if (solution.contains(value))
			{
				solution.remove(value);
				rejected.add(value);
			}
			else if (!rejected.contains(value))
			{
				solution.add(value);
			}
		}
		// return solution.size(); 
	}
	
	
	
	
}
