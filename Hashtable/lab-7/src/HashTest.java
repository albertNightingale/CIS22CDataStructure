/**
 * HashTest.java
 * @author Mia Skinner
 * @author Jiaming Liu
 * CIS 22C, Lab 7
 */

public class HashTest {
    public static void main(String[] args) {
         Hash<Movie> t = new Hash<Movie>(20);
         Movie bond1 = new Movie("Dr No", "Terence Young", 1962, 59.5);
         Movie bond2 = new Movie("From Russia with Love", "Terence Young", 1963, 79.0);
         Movie bond3 = new Movie("Goldfinger", "Guy Hamilton", 1964, 125.0);
         Movie bond4 = new Movie("Thunderball", "Kevin McClory", 1965, 141.2);
         Movie bond5 = new Movie("Casino Royale", "Ken Hughes", 1967, 41.7);
         Movie bond6 = new Movie("You Only Live Twice", "Lewis Gilbert", 1967, 111.6);
         Movie bond7 = new Movie("On Her Majesty's Secret Service", "Peter R. Hunt", 1969, 82.0);
         Movie bond8 = new Movie("Diamonds are Forever", "Guy Hamilton", 1971, 116.0);
         Movie bond9 = new Movie("Live and Let Die", "Guy Hamilton", 1973, 161.8);
         Movie bond10 = new Movie("The Man with the Golden Gun", "Guy Hamilton", 1974, 97.6);
         t.insert(bond1);
         t.insert(bond2);
         t.insert(bond3);
         t.insert(bond4);
         t.insert(bond5);
         t.insert(bond6);
         t.insert(bond7);
         t.insert(bond8);
         t.insert(bond9);
         t.insert(bond10);
         
         System.out.println("***Testing Insert and PrintTable***\n");
         
         t.printTable();
         
         System.out.println("***Testing PrintBucket***\n");
         
         t.printBucket(19);
         t.printBucket(17);
         
         System.out.println("***Testing CountBucket***\n");
         int count = t.countBucket(19);
         System.out.println("\nThere are " + count + " movies at bucket 19\n");
         int count1 = t.countBucket(17);
         System.out.println("There are " + count1 + " movies at bucket 17\n");
         try
         {
        	 int count2 = t.countBucket(-11); 
         }
         catch(IndexOutOfBoundsException e)
         {System.out.println(e.getMessage());}
         
         System.out.println("\n***Testing Search***\n");
         int index = t.search(bond9);
         if (index != -1) {
             System.out.println(bond9.getTitle() + " is stored at index " + index);
         } else {
             System.out.println(bond9.getTitle() + " is not stored in the table");
         }
         int index1 = t.search(new Movie("Lion King", "Disney", 1999, 77.9));
         if (index1 != -1) {
             System.out.println("Lion King is stored at index " + index);
         } else {
             System.out.println("Lion King is not stored in the table");
         }
       
         System.out.println("\n***Testing Remove***\n");
         t.remove(bond9);
         System.out.println(bond9.getTitle() + " should be removed from this index: ");
         t.printBucket(19);
         t.remove(bond9); 
         System.out.println("Index 19 will be Thunderball");
         t.printTable();
         
         System.out.println("\n***Testing getNumElements***\n");
         System.out.println("Should print 9: " + t.getNumElements());
         bond10 = new Movie("Lion King", "Disney", 1999, 77.9); 
         t.insert(bond10);
         System.out.println("Should print 10: " + t.getNumElements());
         t.remove(bond10);
         System.out.println("Should print 9: " + t.getNumElements());
         
         System.out.println("\n***Testing compareTo***\n");
         System.out.println("Should print -1: " + bond1.compareTo(bond2));
         System.out.println("Should print 1: " + bond2.compareTo(bond1));
         System.out.println("Should print 0: " + bond1.compareTo(bond1));
         
         System.out.println("\n***Testing hashCode***\n");
         System.out.println("Should print 15: " + bond1.hashCode()%20);
         System.out.println("Should print 9: " + bond8.hashCode()%20);
         
         System.out.println("\n***Testing equals***\n");
         System.out.println("Should print false: " + bond1.equals(bond2));
         System.out.println("Should print true: " + bond1.equals(bond1));         
         
         
    }
}

/*********


***Testing Insert and PrintTable***

Bucket: 0 
Title: You Only Live Twice
Director: Lewis Gilbert
Year: 1967
Gross in Millions: $111.6
+ 0 more at this bucket


Bucket: 1 
This bucket is empty.


Bucket: 2 
This bucket is empty.


Bucket: 3 
This bucket is empty.


Bucket: 4 
This bucket is empty.


Bucket: 5 
Title: On Her Majesty's Secret Service
Director: Peter R. Hunt
Year: 1969
Gross in Millions: $82.0
+ 0 more at this bucket


Bucket: 6 
Title: The Man with the Golden Gun
Director: Guy Hamilton
Year: 1974
Gross in Millions: $97.6
+ 0 more at this bucket


Bucket: 7 
Title: Casino Royale
Director: Ken Hughes
Year: 1967
Gross in Millions: $41.7
+ 0 more at this bucket


Bucket: 8 
This bucket is empty.


Bucket: 9 
Title: Diamonds are Forever
Director: Guy Hamilton
Year: 1971
Gross in Millions: $116.0
+ 0 more at this bucket


Bucket: 10 
This bucket is empty.


Bucket: 11 
This bucket is empty.


Bucket: 12 
This bucket is empty.


Bucket: 13 
Title: From Russia with Love
Director: Terence Young
Year: 1963
Gross in Millions: $79.0
+ 0 more at this bucket


Bucket: 14 
Title: Goldfinger
Director: Guy Hamilton
Year: 1964
Gross in Millions: $125.0
+ 0 more at this bucket


Bucket: 15 
Title: Dr No
Director: Terence Young
Year: 1962
Gross in Millions: $59.5
+ 0 more at this bucket


Bucket: 16 
This bucket is empty.


Bucket: 17 
This bucket is empty.


Bucket: 18 
This bucket is empty.


Bucket: 19 
Title: Thunderball
Director: Kevin McClory
Year: 1965
Gross in Millions: $141.2
+ 1 more at this bucket


***Testing PrintBucket***

Printing bucket #19:

Title: Thunderball
Director: Kevin McClory
Year: 1965
Gross in Millions: $141.2

Title: Live and Let Die
Director: Guy Hamilton
Year: 1973
Gross in Millions: $161.8



Printing bucket #17:



***Testing CountBucket***


There are 2 movies at bucket 19

There are 0 movies at bucket 17

countBucket(): Index is not in the range of the table

***Testing Search***

Live and Let Die is stored at index 19
Lion King is not stored in the table

***Testing Remove***

Live and Let Die should be removed from this index: 
Printing bucket #19:

Title: Thunderball
Director: Kevin McClory
Year: 1965
Gross in Millions: $141.2



Index 19 will be Thunderball
Bucket: 0 
Title: You Only Live Twice
Director: Lewis Gilbert
Year: 1967
Gross in Millions: $111.6
+ 0 more at this bucket


Bucket: 1 
This bucket is empty.


Bucket: 2 
This bucket is empty.


Bucket: 3 
This bucket is empty.


Bucket: 4 
This bucket is empty.


Bucket: 5 
Title: On Her Majesty's Secret Service
Director: Peter R. Hunt
Year: 1969
Gross in Millions: $82.0
+ 0 more at this bucket


Bucket: 6 
Title: The Man with the Golden Gun
Director: Guy Hamilton
Year: 1974
Gross in Millions: $97.6
+ 0 more at this bucket


Bucket: 7 
Title: Casino Royale
Director: Ken Hughes
Year: 1967
Gross in Millions: $41.7
+ 0 more at this bucket


Bucket: 8 
This bucket is empty.


Bucket: 9 
Title: Diamonds are Forever
Director: Guy Hamilton
Year: 1971
Gross in Millions: $116.0
+ 0 more at this bucket


Bucket: 10 
This bucket is empty.


Bucket: 11 
This bucket is empty.


Bucket: 12 
This bucket is empty.


Bucket: 13 
Title: From Russia with Love
Director: Terence Young
Year: 1963
Gross in Millions: $79.0
+ 0 more at this bucket


Bucket: 14 
Title: Goldfinger
Director: Guy Hamilton
Year: 1964
Gross in Millions: $125.0
+ 0 more at this bucket


Bucket: 15 
Title: Dr No
Director: Terence Young
Year: 1962
Gross in Millions: $59.5
+ 0 more at this bucket


Bucket: 16 
This bucket is empty.


Bucket: 17 
This bucket is empty.


Bucket: 18 
This bucket is empty.


Bucket: 19 
Title: Thunderball
Director: Kevin McClory
Year: 1965
Gross in Millions: $141.2
+ 0 more at this bucket



***Testing getNumElements***

Should print 9: 9
Should print 10: 10
Should print 9: 9

***Testing compareTo***

Should print -1: -1
Should print 1: 1
Should print 0: 0

***Testing hashCode***

Should print 15: 15
Should print 9: 9

***Testing equals***

Should print false: false
Should print true: true



*/