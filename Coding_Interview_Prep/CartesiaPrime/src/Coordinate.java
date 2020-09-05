import java.util.LinkedList;

public class Coordinate {
	
	private int x;
	private int y;
	
	public Coordinate() {
		// TODO Auto-generated constructor stub
	}
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj.hashCode()==this.hashCode();
	}
	
	@Override
	public int hashCode() {
		return 31 * x + 31 * 31 * y;
	}
	
	public boolean isFinalCoordinate() {
		return x==0 && y==0;
	}
	
	public Coordinate add(Coordinate rhs) {
		return new Coordinate(this.x + rhs.x, this.y + rhs.y);
	}
	
	public LinkedList<Coordinate> nextCoordinate(int a, int b, int c, int d, int attempt) {
		LinkedList<Coordinate> coors = new LinkedList<Coordinate>();
		
		Coordinate posXPosYCoor = this.add(new Coordinate(mod(a * attempt, b), mod(c * attempt, d)));
		coors.add(posXPosYCoor);
		Coordinate posXNegYState = this.add(new Coordinate(mod(a * attempt, b), - mod(c * attempt, d)));
		coors.add(posXNegYState);
		Coordinate negXPosYState = this.add(new Coordinate(- mod(a * attempt, b), mod(c * attempt, d)));
		coors.add(negXPosYState);
		Coordinate negXNegYState = this.add(new Coordinate(- mod(a * attempt, b), - mod(c * attempt, d)));
		coors.add(negXNegYState);

		return coors;
	}
	
	private static int mod(int k, int n) {
		if (k >= 0) {
			return k % n;
		}
		else {
			return n + k % n;
		}
	}
}
