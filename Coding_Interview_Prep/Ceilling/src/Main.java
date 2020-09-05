import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	private static class Node {
		int val;
		Node left, right;
		protected Node(int val)
		{
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String[] logistics = keyboard.readLine().split(" ");
		ArrayList<Node> list = buildBST(keyboard, Integer.parseInt(logistics[0]), Integer.parseInt(logistics[1]));
		int samestruct = 1;
		
		boolean isNew = true;
		for (int i=1; i<list.size(); i++) {

			for (int j=0; j<i; j++) {
				if (isSame(list.get(i), list.get(j))) {
					isNew = false;
					break;
				}
			}

			if (isNew) samestruct++;
			isNew = true;

		}
		
		System.out.println(samestruct);
	}
	
	/***
	 * See if similar structure
	 * @param n1
	 * @param n2
	 * @return
	 */
	private static boolean isSame(Node n1, Node n2)
	{
		if ((n1==null&&n2!=null) || (n1!=null&&n2==null))
		{
			return false; // not the same
		}
		else if (n1 != null && n2 != null)
		{
			return isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
		}
		else
		{
			return true;
		}
	}
	
	private static ArrayList<Node> buildBST(BufferedReader keyboard, int listsize, int bstsize) throws IOException
	{

		ArrayList<Node> bstlist = new ArrayList<>();
		int cnt = 0;
		
		for (int j = 0; j < listsize; j++)
		{
			String[] arr = keyboard.readLine().split(" ");
			Node n = new Node(Integer.parseInt(arr[0]));
			for (int i = 1; i < bstsize; i++) // traverse through lists of inputs
			{
				insert(Integer.parseInt(arr[i]), n);  // insert the node to the bst
			}
			bstlist.add(n);  // adding nodes to the list
		} 
		
		
		keyboard.close();
		
		return bstlist;
	}
	
	
    private static void insert(int data, Node node) {
    
    	if (data <= node.val) {
    		if (node.left == null)
    			node.left = new Node(data);
    		else
    			insert(data, node.left);
    	}
    	else {
    		if (node.right == null)
    			node.right = new Node(data);
    		else
    			insert(data, node.right);
    	}
    }

}
