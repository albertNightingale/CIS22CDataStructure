/*****
 * Stores a user scheduler inside of the link list
 * @author Mia Skinner
 * @author Albert Liu
 * CIS 22C, Lab 7
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MovieDatabase {
	
	private Hash<Movie> movietable;
	private Scanner scanner;
	private int numBuckets;
	
	
	/**
     * Instantiates a new Schedule with default values
     * @postcondition instantiates new List and Scanner, runs program
     */
	public MovieDatabase(String fname) {
		scanner = new Scanner(System.in);
		readfile(fname);
		startApp();
	}
	
	private void readfile(String inputfilename)
	{
		try 
		{
			FileReader file = new FileReader(inputfilename);
			BufferedReader buff = new BufferedReader(file);
			
			/*// used to find number of buckets needed
			Path path = Paths.get("./"+inputfilename);
			int lines = (int) Files.lines(path).count();
			numBuckets = (lines/5) * 2;
			*/
			numBuckets = 26; // Mentioned in notes, matching output (but would be higher normally)
			movietable = new Hash<Movie>(numBuckets);
			
			boolean readable = true; 
			
			String line; 
			
			while (readable) 
			{
				line = buff.readLine();
				if (line == null) // finished reading
				{
					readable = false;
					break;
				}
				String title = line;		
				String director = buff.readLine();
				int year = Integer.parseInt(buff.readLine());
				double gross = Double.parseDouble(buff.readLine());
				buff.readLine(); 
				
				Movie movie = new Movie(title, director, year, gross);
				movietable.insert(movie);
			
			} 
			buff.close();
		}
		catch (IOException e) {
			System.out.println("readfile(): Problem reading file. " + e.toString());
		}
	}
	
	/**
	 * Prints menu of user choices and collects and validates input
	 */
	private void printMenu() {
		System.out.println("\nPlease select from one of the following options:\n");
		System.out.println("A: Add a Movie");
		System.out.println("D: Display all Movies");
		System.out.println("R: Remove a Movie");
		System.out.println("S: Search for a Movie");
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
				addMovie();
				break;
			case "D":
				displayMovies();
				break;
			case "R":
				removeMovie();
				break;
			case "S":
				searchMovie();
				break;
			case "X":
				exit();
				break;
			default:
				System.out.println("\nInvalid Selection!");
		}
	}
	
	/**
	 * Prints all movies in database
	 */
	private void displayMovies() {
		System.out.println("Displaying Movie Database: \n");
		//movietable.printTable();  //prints the wrong type - must you printBucket
		for (int i = 0; i < numBuckets; i++) {
			movietable.printBucket(i);
		}
		System.out.println("\nEnd of database!");
	}
	
	/**
	 * Add a user-defined event to List, allows user to move event up in schedule
	 * @postcondition List.getLength() increases by 1
	 */
	private void addMovie() {
		String title;
		String director;
		int year;
		double gross;
		System.out.println("\nAdding a movie!");
		System.out.print("\nEnter the title: ");
		title = scanner.nextLine();
		System.out.print("Enter the director: ");
		director = scanner.nextLine();
		System.out.print("Enter the year: ");
		year = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter the gross in millions: $");
		gross = Double.parseDouble(scanner.nextLine());
		
		Movie newMovie = new Movie(title, director, year, gross);
		movietable.insert(newMovie);
		
		System.out.printf("\n%s was added!\n", title);
		
	}
	
	// searching for a movie by title and director
	private void searchMovie() {
		String title;
		String director;
		System.out.println("\nSearching for a movie!");
		System.out.print("\nEnter the title: ");
		title = scanner.nextLine();
		System.out.print("Enter the director: ");
		director = scanner.nextLine();
		
		boolean isHere = searchMovie(title, director);
		if (isHere)
			System.out.printf("\n%s is in the database!\n", title);
		else
			System.out.printf("\n%s is not in the database.\n", title);
	}
	
	// helper method for searching for a movie by title and director
	private boolean searchMovie(String title, String director) {
		Movie mov = new Movie (title, director, 0, 0.0); 
		if (movietable.search(mov) == -1)
			return false;  
		else 
			return true;
    }	
	
	/**
	 * User selects event to remove
	 * @precondition List.getLength() > 0
	 * @postcondition List.getLength() decreases by 1
	 */
	private void removeMovie() {
		String title;
		String director;

		System.out.println("\nRemoving a movie!");
		System.out.print("\nEnter the title: ");
		title = scanner.nextLine();
		System.out.print("Enter the director: ");
		director = scanner.nextLine();
				
		Movie removeMovie = new Movie(title, director, 0, 0.0);
		if (movietable.search(removeMovie) >= 0) {
			movietable.remove(removeMovie);
			
			System.out.printf("\n%s was removed!\n", title);
		}
		else {
			System.out.printf("\nI cannot find %s in the database.\n", title);
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
		
		System.out.println("Welcome to the Bond Movie Database!");
		
		while(true) {
			printMenu();
		}
		
	}
	
	public static void main(String[] args) {
		
		MovieDatabase movies = new MovieDatabase("movies.txt");
		
	}
}
/****** TEST CODE
Welcome to the Bond Movie Database!

Please select from one of the following options:

A: Add a Movie
D: Display all Movies
R: Remove a Movie
S: Search for a Movie
X: Exit

Enter your choice: Z

Invalid Selection!

Please select from one of the following options:

A: Add a Movie
D: Display all Movies
R: Remove a Movie
S: Search for a Movie
X: Exit

Enter your choice: A

Adding a movie!

Enter the title: Austin Powers: International Man of Mystery
Enter the director: Jay Roach
Enter the year: 1997
Enter the gross in millions: $67.7

Austin Powers: International Man of Mystery was added!

Please select from one of the following options:

A: Add a Movie
D: Display all Movies
R: Remove a Movie
S: Search for a Movie
X: Exit

Enter your choice: D
Displaying Movie Database: 

Printing bucket #0:



Printing bucket #1:

Title: Quantum of Solace
Director: Marc Forster
Year: 2008
Gross in Millions: $586.1



Printing bucket #2:



Printing bucket #3:

Title: From Russia with Love
Director: Terence Young
Year: 1963
Gross in Millions: $79.0

Title: Casino Royale
Director: Ken Hughes
Year: 1967
Gross in Millions: $41.7



Printing bucket #4:

Title: The Man with the Golden Gun
Director: Guy Hamilton
Year: 1974
Gross in Millions: $97.6

Title: Casino Royale
Director: Martin Campbell
Year: 2006
Gross in Millions: $600.0



Printing bucket #5:



Printing bucket #6:

Title: Die Another Day
Director: Lee Tamahori
Year: 2002
Gross in Millions: $435.0



Printing bucket #7:



Printing bucket #8:



Printing bucket #9:

Title: Goldeneye
Director: Martin Campbell
Year: 1995
Gross in Millions: $355.0



Printing bucket #10:

Title: You Only Live Twice
Director: Lewis Gilbert
Year: 1967
Gross in Millions: $111.6



Printing bucket #11:

Title: Dr No
Director: Terence Young
Year: 1962
Gross in Millions: $59.5



Printing bucket #12:

Title: Octopussy
Director: John Glen
Year: 1983
Gross in Millions: $187.5



Printing bucket #13:

Title: Thunderball
Director: Kevin McClory
Year: 1965
Gross in Millions: $141.2

Title: Skyfall
Director: Sam Mendes
Year: 2012
Gross in Millions: $1109.0

Title: Spectre
Director: Sam Mendes
Year: 2015
Gross in Millions: $880.7



Printing bucket #14:

Title: A View to Kill
Director: John Glen
Year: 1985
Gross in Millions: $152.4



Printing bucket #15:

Title: Never Say Never Again
Director: Irvin Kirshner
Year: 1983
Gross in Millions: $160.0

Title: Licence to Kill
Director: John Glen
Year: 1989
Gross in Millions: $156.1

Title: Tomorrow Never Dies
Director: Roger Spottiswoode
Year: 1997
Gross in Millions: $333.0



Printing bucket #16:

Title: Goldfinger
Director: Guy Hamilton 
Year: 1964
Gross in Millions: $125.0

Title: The Spy Who Loved Me
Director: Lewis Gilbert
Year: 1977
Gross in Millions: $185.4



Printing bucket #17:

Title: Live and Let Die
Director: Guy Hamilton
Year: 1973
Gross in Millions: $161.8

Title: The World is Not Enough
Director: Michael Apted
Year: 1999
Gross in Millions: $362.0



Printing bucket #18:



Printing bucket #19:

Title: On Her Majesty's Secret Service
Director: Peter R. Hunt
Year: 1969
Gross in Millions: $82.0

Title: Moonraker
Director: Lewis Gilbert
Year: 1979
Gross in Millions: $210.3

Title: Austin Powers: International Man of Mystery
Director: Jay Roach
Year: 1997
Gross in Millions: $67.7



Printing bucket #20:



Printing bucket #21:

Title: Diamonds are Forever
Director: Guy Hamilton
Year: 1971
Gross in Millions: $116.0



Printing bucket #22:



Printing bucket #23:

Title: For Your Eyes Only
Director: John Glen
Year: 1981
Gross in Millions: $195.3



Printing bucket #24:

Title: The Living Daylights
Director: John Glen
Year: 1987
Gross in Millions: $191.2



Printing bucket #25:




End of database!

Please select from one of the following options:

A: Add a Movie
D: Display all Movies
R: Remove a Movie
S: Search for a Movie
X: Exit

Enter your choice: R

Removing a movie!

Enter the title: Moonraker
Enter the director: Lewis Gilbert

Moonraker was removed!

Please select from one of the following options:

A: Add a Movie
D: Display all Movies
R: Remove a Movie
S: Search for a Movie
X: Exit

Enter your choice: S

Searching for a movie!

Enter the title: Moonraker
Enter the director: Lewis Gilbert

Moonraker is not in the database.

Please select from one of the following options:

A: Add a Movie
D: Display all Movies
R: Remove a Movie
S: Search for a Movie
X: Exit

Enter your choice: R

Removing a movie!

Enter the title: Moonraker
Enter the director: Lewis Gilbert

I cannot find Moonraker in the database.

Please select from one of the following options:

A: Add a Movie
D: Display all Movies
R: Remove a Movie
S: Search for a Movie
X: Exit

Enter your choice: S

Searching for a movie!

Enter the title: Casino Royale
Enter the director: Ken Hughes

Casino Royale is in the database!

Please select from one of the following options:

A: Add a Movie
D: Display all Movies
R: Remove a Movie
S: Search for a Movie
X: Exit

Enter your choice: Z

Invalid Selection!

Please select from one of the following options:

A: Add a Movie
D: Display all Movies
R: Remove a Movie
S: Search for a Movie
X: Exit

Enter your choice: Z

Invalid Selection!

Please select from one of the following options:

A: Add a Movie
D: Display all Movies
R: Remove a Movie
S: Search for a Movie
X: Exit

Enter your choice: X

Goodbye!
*/
