public class Hack {
	public static void main(String[] args) {
		String temp = "!spawn-AI=lapabot_repair:%d:%d";
		String result = ""; 
		
		for (int i = 0; i < 150; i++)
		{
			for (int j = 0; j < 150; j++) {
				result += String.format(temp, i, j); 
			}
		}
		
		System.out.println(result);
	}
}
