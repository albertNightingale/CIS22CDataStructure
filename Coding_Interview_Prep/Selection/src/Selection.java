
public class Selection {
	
	private static int select(int[] a, int[] b, int k) 
	{
		return select(a, 0, a.length-1, b, 0, b.length-1, k); 
	}
	
	/*
	select (A, B, k)
    return select(A, 0, |A|-1, B, 0, |B|-1, k)

	select(A, loA, hiA, B, loB, hiB, k)
	    // A[loA..hiA] is empty
	    if (hiA < loA)
	        return B[k-loA]
	    // B[loB..hiB] is empty
	    if (hiB < loB)
	        return A[k-loB]
	    // Get the midpoints of A[loA..hiA] and B[loB..hiB]
	    i = (loA+hiA)/2
	    j = (loB+hiB)/2
	    // Figure out which one of four cases apply
	    if (A[i] > B[j])
	        if (k <= i+j)
	            return select(A, $1, $2, B, $3, $4, k);
	        else
	            return select(A, $5, $6, B, $7, $8, k);           
	    else
	        if (k <= i+j)
	            return select(A, $9, $10, B, $11, $12, k);
	        else
	            return select(A, $13, $14, B, $15, $16, k);
    */
	private static int select (int[] a, int loA, int hiA, int[] b, int loB, int hiB, int k)
	{
		if (hiA < loA) // A[loA..hiA] is empty
		{
			return b[k-loA];
		} 
	    if (hiB < loB) // B[loB..hiB] is empty
	    {
	        return a[k-loB];
	    }
	    int i = (loA+hiA)/2; // Get the midpoints of A[loA..hiA] and B[loB..hiB]
	    int j = (loB+hiB)/2;
	    
	    // Figure out which one of four cases apply
	    if (a[i] > b[j]) // b[j] is smaller
	        if (k <= i+j)
	            return select(a, loA, i-1, b, loB, hiB, k); // left of a[i], or in b
	        else
	            return select(a, loA, hiA, b, j+1, hiB, k); // right of a[i], or in b          
	    else
	        if (k <= i+j) // a[i] is smaller
	            return select(a, loA, hiA, b, loB, j-1, k); // left of b[j] or in a
	        else
	            return select(a, i+1, hiA, b, loB, hiB, k); // right of b[j] or in a
	}
	
	
	
	public static void main (String[] args)
	{
		int a[] ={1, 3, 5, 6, 7};
		int b[] ={2, 4, 8, 9, 10, 12, 13};
//		int a[] = {2, 5, 7, 10, 22};
//		int b[] = {7, 8, 9, 13, 14};
		int k = 6;
		
		int val = select(a, b, k);
		System.out.println(val);
	}
}
