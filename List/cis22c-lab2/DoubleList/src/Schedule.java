/*****
 * Stores a user scheduler inside of the link list
 * @author Mia Skinner
 * @author Albert Liu
 * CIS 22C, Lab 2
 */

import java.util.*;

public class Schedule {
	
	List<String> list;
	Scanner scanner ;
	
	/**
     * Instantiates a new Schedule with default values
     * @postcondition instantiates new List and Scanner, runs program
     */
	public Schedule() {
		list = new List<String>(); 
		scanner = new Scanner(System.in);
		startApp();
	}
	
	/**
	 * Prints menu of user choices and collects and validates input
	 */
	private void printMenu() {
		System.out.println("\nSelect from the following options: ");
		System.out.println("A: Add an event");
		System.out.println("R: Remove an event");
		System.out.println("X: Exit\n");
		
		// get input
		System.out.print("Enter your choice: ");
		String s;
		s = scanner.nextLine().toUpperCase();
		//System.out.println();
		// send to method choice
		switch(s)
		{
			case "A":
				addEvent();
				break;
			case "R":
				removeEvent();
				break;
			case "X":
				exit();
				break;
			default:
				System.out.println("Error Input\n");
		}
	}
	
	/**
	 * Prints user's schedule
	 */
	private void printSchedule() {
		System.out.println("\nYour Current Schedule: \n");
		list.printNumberedList(); // print schedule
	}
	
	/**
	 * Add a user-defined event to List, allows user to move event up in schedule
	 * @postcondition List.getLength() increases by 1
	 */
	private void addEvent() {
		String in;
		System.out.print("\nPlease enter an event: ");
		in = scanner.nextLine();
		list.addFirst(in);
		if (list.getLength() <= 1) {
			printSchedule();
		}
		else {
			System.out.printf("\nYou just added the following event to your schedule: %s\n", in );
			printSchedule();
			
			String s;
			int posi = 0; 
			System.out.println("\nWould you like to move this event up in your schedule");
			System.out.print("(Y/N): ");
			s = scanner.nextLine().toUpperCase();
			if (s.equals("Y"))
			{	
				do
				{
					System.out.print("Enter the number of places: ");
					posi = scanner.nextInt();
					scanner.nextLine();
					
					if (1 > posi || posi > list.getLength() - 1)
					{
						System.out.println("Sorry that input is invalid! \n");
					}
				}
				while (1 > posi || posi > list.getLength() - 1); 
			}
			
			list.pointIterator();
			for (int i = 0; i < posi; i++)
			{
				list.advanceIterator();
			}
			list.addIterator(list.getFirst());
			list.removeFirst();
			printSchedule();
		}
	}
	
	/**
	 * User selects event to remove
	 * @precondition List.getLength() > 0
	 * @postcondition List.getLength() decreases by 1
	 */
	private void removeEvent() {
		int posi; 
		if (list.getLength() == 0) {
			System.out.println("There is nothing to remove yet!");
		}
		else {
			System.out.print("Enter the number of the event to remove: ");
			posi = scanner.nextInt();
			scanner.nextLine();
			if (posi > list.getLength()) {
				System.out.println("There is no event for that number.");
				removeEvent();
			}
			else {
			
				list.pointIterator();
				for (int i = 1; i < posi; i++)
				{
					list.advanceIterator();
				}
				System.out.printf("\nRemoving: %s\n", list.getIterator());
				list.removeIterator();
				printSchedule();
			}
		}	
	}
	
	/**
	 * Exits the Schedule App
	 */
	private void exit()
	{
		System.out.println("\nGoodbye!");
		System.exit(0);
	}
	
	/**
	 * Starts the Schedule App
	 */
	private void startApp(){
		
		System.out.println("Welcome to the Scheduler App!");
		System.out.println("\nYou have no upcoming events!");
		
		while(true) {
			printMenu();
		}
		
	}
	
}


