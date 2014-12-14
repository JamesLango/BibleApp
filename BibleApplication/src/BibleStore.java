import java.util.HashMap;
import java.util.HashSet;

public class BibleStore {
	// a collection of trees, which contain the books, chapters and verses of the bible
	private HashMap<String, BookTree> bibles;
	// a hashset of the unique words in the bible
	private HashMap<String, Word> words;
	
	public BibleStore() {
		bibles = new HashMap<String, BookTree>(); // key is the bible name, so KJBible
		words = new HashMap<String, Word>();
		
		populateBible();
	}
	public HashMap<String, Word> getMap()
	{
		return words;
	}
	
	private void populateBible() { // some how pass in the folder name to sort it out?
		
		
		// Adding stuff to the bible
		// things in "quotation marks" are variables/conditions that should be in java
		// but are written in pseudo java for the time being.

		for (int i = 0; "input has next file (book)"; i++)
		{
		
			// create a new book object and add it to the bibleMap
			// might need to get book name and pass as a parameter to the book object
			// so this can be retrieved later on in the algorithm.
	
			Book b = new Book("bookName");
			bibleMap.addBook(b);
	
			for(int j = 0; "book has another chapter"; i++)
			{
				
				// create a new chapter object and add this to a collection
				// within the book object.
				// j is passed in as a parameter so that when the chapter is
				//created it knows its own index.
				// Chapter has "CHAPTER _" delimited so that it is a 
				// "pure" chapter.
				
				Chapter c = new Chapter(j);
				b.addChapter(c);
				
				for (int k = 0; "chapter has another verse"; i++)
				{
					
					// create a new verse object and add this to a collection
					// within the chapter object.
					// k is passed in as a parameter so that when it is created 
					// the verse object knows its own index.
					// scanned in line ("line") has line number delimited so that it is a 
					// "pure" string. 
					
					Verse v = new Verse(k,line);
					c.addVerse(v);
					Location l = new Location(b.getName(), j, k);		
					
					// if statement to check whether the word that has been scanned in is unique
					
					Word w = new Word("word");
					
					if(!words.contains(w)) // WILL THIS WORK????
					{
						// new word is created.
						// individual string object (after line has been delimited to words)
						// passed in as a string to the word object.
						
						//Word w = new Word("word"); // added before the if statement to check if it exists
						
						words.add(w);
						
						// the words locationList (array of Location objects) is updated with the location 
						// created above.
						//The words count field is also incremented.
					}	
						w.updateLocationList(l);
						w.incrementWordCount();
					}
				}
			}	
		}
	}
	
}
