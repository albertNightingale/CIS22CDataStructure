import java.util.*;

public class GrammarSolver {

   private SortedMap <String, String[]> grammar; //is this how I declare a sortedmap, can't use the other way?

   public GrammarSolver(List<String> rules) {
      if (rules.size() == 0) { // what if rules == null
         throw new IllegalArgumentException();
      }
      grammar = new TreeMap<String, String[]>();  
      for (String line : rules) {
          String[] pieces = line.split("::=");
          //throw exception if there's repeated non-terminals
          if (grammar.containsKey(pieces[0])) {
            throw new IllegalArgumentException();
          }
          String[] terminals = pieces[1].split("\\s+"); 
          grammar.put(pieces[0], terminals); //can I use array or is it better to use set?
      }
   }
  
   public boolean grammarContains(String symbol) {
      return grammar.containsKey(symbol);
   }
  
   public String getSymbols() {
      return "" + grammar.keySet();
   }
  
   public String[] generate(String symbol, int times) {
      if (times < 0 || !grammarContains(symbol)) {
         throw new IllegalArgumentException();
      }
     
      String[] output = new String[times];
      for (int i = 0; i < times; i++) {
         
         output[i] = generate(symbol);
      }
     
      return output;
   }
   
   private String generate(String symbol) {
	   
	   ArrayList<String> terminals = new ArrayList<String>();
	   for (String term : grammar.get(symbol))
	   {
		   if (term.contains("|"))
		   {
			   String [] terminal = term.split("\\|"); // grammar.get(symbol) = [<det>, <noun>|<propnoun>]
			   for (String temp : terminal)
			   {
				   terminals.add(temp);
			   }
		   }
	   }
	   	   
	   int rand = (int)(Math.random() * terminals.size());	   
	   
	   if (!grammar.get(symbol)[0].startsWith("<"))  // sentence verbp verb run
	   {
		   return terminals.get(rand); // grammar.get(symbol)[rand];
	   }
	   else 
	   {
		   String text = ""; 
		   for (String term : grammar.get(symbol))
		   {
			   if (!term.contains("|"))
			   {
				   text += " " + generate(term); 
			   }
			   else 
			   {
				   text += " " + generate(terminals.get(rand)); 
			   }
		   }
		   return text;
	   }
   }
   
   
}
