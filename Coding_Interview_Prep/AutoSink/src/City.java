	


public class City {
	private String name;
	private int toll;
	private int pren, postn;
	private boolean visited = false;
	private int dis;
	
	protected City(String name, int toll) {
		this.name = name;
		this.toll = toll;
	}
	
	protected City(String name) {
		this.name = name;
		this.toll = 0;
	}
	
	public int getDis() {
		return dis;
	}
	
	public void setDis(int dis) {
		this.dis = dis;
	}
	
	public boolean getVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public int getPren() {
		return pren;
	}

	public void setPren(int pren) {
		this.pren = pren;
	}

	public int getPostn() {
		return postn;
	}

	public void setPostn(int postn) {
		this.postn = postn;
	}

	public void setToll(int toll) {
		this.toll = toll;
	}

	public String getName() {
		return name;
	}
	
	public int getToll() {
		return toll;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
}