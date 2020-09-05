import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GalaxyQuest {
	
	private static class Pnt {
		private long x, y;
		
		public Pnt(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
		protected boolean isDisLess(Pnt p, long dis) {
			return (Math.pow(p.x-this.x, 2) + Math.pow(p.y-this.y, 2)) <= Math.pow(dis, 2);
		}
	}
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String[] logistics = keyboard.readLine().split(" ");
		long dis = Long.parseLong(logistics[0]);
		long starnum = Long.parseLong(logistics[1]);
		ArrayList<Pnt> stars = new ArrayList<Pnt>();
		
		// build arraylist
		for (long j = 0; j < starnum; j++)
		{
			String[] arr = keyboard.readLine().split(" ");
			stars.add(new Pnt(Long.parseLong(arr[0]), Long.parseLong(arr[1])));
		} 
		
		System.out.println(findMajority(dis, stars));
	}
	
	private static String findMajority(long dis, ArrayList<Pnt> stars) {
		
		if (stars.size()==1) {
			return "NO";
		}
		
		Pnt champion = stars.get(0);
		int cnt = 1;
		
		for (int i = 1; i < stars.size(); i++) {
			if (champion==null) { // if champion is cleared
				cnt=1;
				champion=stars.get(i);
				continue;
			}
			
			if (champion.isDisLess(stars.get(i), dis)) {
				cnt++;
			}
			else {
				cnt--;
				if (cnt==0) 
					champion=null;
			}
		}
		
		if (champion==null) {
			return "NO";		
		}
		else {
			long ct = 0;
			for(Pnt star: stars) {
				if (champion.isDisLess(star, dis)) {
					ct++;
				}
			}
			if (ct > stars.size()/2) {
				return Long.toString(ct);
			}
			else {
				return "NO";
			}
		}
	}
	
}
