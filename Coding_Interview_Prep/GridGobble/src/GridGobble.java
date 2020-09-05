import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridGobble {
	
	private static int[][] score;
	private static int[][] grid;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String line = keyboard.readLine();
		int spaceidx = line.indexOf(" ");
		int row = Integer.parseInt(line.substring(0, spaceidx));
		int col = Integer.parseInt(line.substring(spaceidx + 1));
		grid = new int[row][col];
		score = new int[row][col];

		// init everything to zero
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				score[x][y] = 0;
			}
		}
		
		int cnt = 0;
		while (cnt < row) {
			String[] rowValue = keyboard.readLine().split(" ");
			for (int i = 0; i < col; i++)
			{
				grid[cnt][i] = Integer.parseInt(rowValue[i]);
			}
			cnt++;
		}
		
		System.out.println(compute(row, col));
	}
	
	private static int compute(final int row, final int col) {
		int max = -1; 
		// traverse through the last row of the 2D array, 
		// find the starting point that will generate the maximum profit
		for (int c = 0; c < col; c++) { 
			int val = getMax(row, col, row-1, c);
			if (val > max) 
			{
				max = val;
			}
		}
		
		return max;
	}
	
	private static int getMax(final int row, final int col, int rowidx, int colidx) {
		if (rowidx==0)
		{
			return grid[rowidx][colidx];
		}
		
		if (score[rowidx][colidx] != 0)
		{
			return score[rowidx][colidx]; 
		}
		else
		{
			// the next row index
			int nextrowidx = rowidx-1;
			
			// the current value
			int currentValue = grid[rowidx][colidx];
			
			// left column and right column index
			int leftCol = goLeft(col, colidx);
			int rightCol = goRight(col, colidx);
			
			// value on the left
			int leftValue = grid[nextrowidx][leftCol];
			int rightValue = grid[nextrowidx][rightCol];
			
			int leftMax = currentValue - leftValue - leftValue + getMax(row, col, nextrowidx, leftCol);
			int rightMax = currentValue - rightValue - rightValue + getMax(row, col, nextrowidx, rightCol);
			int upMax = currentValue + getMax(row, col, nextrowidx, goUp(colidx));
			int max = Math.max(leftMax, Math.max(rightMax, upMax));  // get the max value of the three
			
			score[rowidx][colidx]=max;
			return max;
		}
		
	}
	
	private static int goLeft(int colcnt, int colidx) {
		if (colidx==0) // go around to the size-1 index
			return colcnt-1;
		else 
			return colidx-1;
	}
	
	private static int goUp(int colidx) {
		return colidx; // no change
	}
	
	private static int goRight(int colcnt, int colidx) {
		if (colidx==colcnt-1) // go around to zero index
			return 0;
		else 
			return colidx+1;
	}
}
