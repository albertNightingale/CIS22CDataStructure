import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NarrowArtGallery {

	private static int[][] gallery;
	private static HashMap<galleryPenalty, Integer> penalties;
	private static int n;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String line = keyboard.readLine();
		n = Integer.parseInt(line.split(" ")[0]);
		int k = Integer.parseInt(line.split(" ")[1]);
		
		gallery = new int[n][2];
		penalties = new HashMap<galleryPenalty, Integer>();
		
		int idx = 0;
		while (idx < n)
		{
			line = keyboard.readLine();
			gallery[idx][0] = Integer.parseInt(line.split(" ")[0]);
			gallery[idx][1] = Integer.parseInt(line.split(" ")[1]);
			idx++;
		}
			
		System.out.println(maxValue(0, -1, k));
	}
	
	private static int maxValue(int r, int uncloseableRoom, int k)
	{
		galleryPenalty p = new galleryPenalty(r, uncloseableRoom, k);

		if (r == n)
		{
			return 0;
		}
		
		if (penalties.containsKey(p))
		{
			return penalties.get(p);
		}
		
		if (k==(n-r) && r < n)
		{
			if (uncloseableRoom == 0)
			{
				int max = gallery[r][0] + maxValue(r+1, 0, k-1);
				penalties.put(p, max);
				return max;
			}
			else if (uncloseableRoom == 1)
			{
				int max = gallery[r][1] + maxValue(r+1, 1, k-1);
				penalties.put(p, max);
				return max;
			}
			else  // for it be -1
			{
				int max0 = gallery[r][0] + maxValue(r+1, 0, k-1);
				int max1 = gallery[r][1] + maxValue(r+1, 1, k-1);
				int max = Math.max(max0, max1);
						
				penalties.put(p, max);
				return max;
			}
		}
		else // if (k < (n-r) && r < n)
		{
			if (uncloseableRoom == 0)
			{
				int max0 = gallery[r][0] + maxValue(r+1, 0, k-1);
				int max01 = gallery[r][0] + gallery[r][1] + maxValue(r+1, -1, k);
				int max = Math.max(max0, max01);
				penalties.put(p, max);
				return max;
			}
			else if (uncloseableRoom == 1)
			{
				int max1 = gallery[r][1] + maxValue(r+1, 1, k-1);
				int max01 = gallery[r][0] + gallery[r][1] + maxValue(r+1, -1, k);
				int max = Math.max(max1, max01);
				penalties.put(p, max);
				return max;
			}
			else  // for it be -1
			{
				int max0 = gallery[r][0] + maxValue(r+1, 0, k-1);
				int max1 = gallery[r][1] + maxValue(r+1, 1, k-1);
				int max01 = gallery[r][0] + gallery[r][1] + maxValue(r+1, -1, k);
				int max = Math.max(Math.max(max0, max1), max01);
				penalties.put(p, max);
				return max;
			}
		}
	}
}
