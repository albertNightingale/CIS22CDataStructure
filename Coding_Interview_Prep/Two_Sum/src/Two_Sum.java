import java.util.HashMap;

public class Two_Sum {

	public static void main(String[] args) {
		
		int[] testArr = {10, 15, 3, 7};
		int testk = 17;
		
		int[] result = twoSum(testArr, testk);
		for (Integer i : result) {
			System.out.println(i);
		}
	}
	
	public static int[] twoSum(int[] arr, int k) {
		
		HashMap<Integer, Integer> numDict = new HashMap<Integer, Integer>();
		
		for (int element : arr) {
			if (numDict.containsKey(k - element)) {
				int[] returnArr = { k-element, element };
				return returnArr;
			}
			else {
				numDict.put(element, k-element);
			}
		}
		
		return null;		
	}

}
