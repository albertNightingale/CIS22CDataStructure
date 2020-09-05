
public class galleryPenalty {
	int r;
	int uncloseable;
	int k;
		
	public galleryPenalty(int r, int uncloseable, int k)
	{
		this.k = k;
		this.r = r;
		this.uncloseable = uncloseable;
	}

	@Override
	public boolean equals(Object obj) {
		galleryPenalty p = (galleryPenalty)obj;
		return p.k==this.k && p.r == this.r && p.uncloseable == this.uncloseable;
	}
	
	@Override
	public int hashCode() {
		return r + 31 * k + 31 * 31 * uncloseable;
	}
}