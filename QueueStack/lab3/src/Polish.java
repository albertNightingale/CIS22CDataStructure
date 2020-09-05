/*****
 * Polish.java
 * @author Albert Liu (Jiaming)
 * @author Mia Skinner
 */


import java.util.Scanner;

public class Polish {
	
	private int result;
	private Queue<String> operators;
	private Stack<Integer> numbers;
	private Queue<Integer> extra; 
	
	/** MAIN */
	
	public static void main(String [] args)
	{
		Polish calc = new Polish();
		calc.startApp();
	}

	/** CONSTRUCTORS */
	
	public Polish() {
		result = 0;
		
		operators = new Queue<String>();
		numbers = new Stack<Integer>();
		extra = new Queue<Integer>();
	}

	/** ACCESSORS */
	
	/**
	 * Returns calculation result
	 * @return result
	 */
	public int getResult() {
		return result;
	}
	
	/** MUTATORS */

	
	/**
	 * Calculates answer to Polish prefix notation equation
	 * @returns result: integer result of calculation
	 */
	private int calculate() {
		
		int n;
		String o;
		int temp;
		temp = numbers.peek();
		numbers.pop();
		
		while (!operators.isEmpty() && !numbers.isEmpty()) {
			
			n = numbers.peek();
			o = operators.getFront();
			
			switch(o) {
				case "+":
					temp = temp + n;
					break;
				
				case "-":
					temp = temp - n;
					break;
				case "/":
					temp = temp / n;
					break;
				case "*":
					temp = temp * n;
					break;

			}
			//System.out.println(temp);
			numbers.pop();
			operators.dequeue();

		}
		while (!operators.isEmpty() && !extra.isEmpty()) {
			
			n = extra.getFront();
			o = operators.getFront();
			
			switch(o) {
				case "+":
					temp = temp + n;
					break;
				
				case "-":
					temp = temp - n;
					break;
				case "/":
					temp = temp / n;
					break;
				case "*":
					temp = temp * n;
					break;

			}
			//System.out.println(temp);
			extra.dequeue();
			operators.dequeue();
			
		}
		
		result = temp;
		return result;
	}
	
	/**
	 * Parses input string into correct Stack/Queue for calculate() method
	 * @param s - String to parse into numbers, operators, and extra data structures
	 */
	private void readString(String s) {
		String[] n = s.split(" ");
		
		int i = n.length - 1; 
		while (Character.isDigit(n[i].charAt(0))) 
		{
			numbers.push(Integer.parseInt(n[i]));
			i --; 
		}
		
		for (; i >= 0; i--) {

			if (Character.isDigit(n[i].charAt(0)))
			{
				extra.enqueue(Integer.parseInt(n[i]));
			}
			else
			{
				operators.enqueue(n[i]);
			}
			
		}
	}
	
	
	/** OTHER METHODS */
	

	/**
	 * Starts the Polish Calculator application
	 */
	public void startApp()
	{
		String in;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome!\n");
		
		while(true) {
			System.out.print("Please enter an equation in Polish Notation or \"q\" to quit: ");
			in = scanner.nextLine();
			if (in.toUpperCase().equals("Q"))
			{
				System.out.println("\nGoodbye!");
				System.exit(0); 
			}
			
			readString(in);
			System.out.printf("The answer is: %d\n\n", calculate());
		}
	}
}
	

	
/*******
Welcome!

Please enter an equation in Polish Notation or "q" to quit: * 3 + 4 5 
The answer is: 27

Please enter an equation in Polish Notation or "q" to quit: - * - 9 2 3 4 
The answer is: 17

Please enter an equation in Polish Notation or "q" to quit: / * + 5 3 4 7
The answer is: 4

Please enter an equation in Polish Notation or "q" to quit: + 13 14
The answer is: 27

Please enter an equation in Polish Notation or "q" to quit: Q

Goodbye!
 */


