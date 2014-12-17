import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A class to carry out storage and retrieval functions on the underlying data 
 * structure for the bible.
 */
public class BibleStore {
	// a collection of trees, which contain the books, chapters and verses of the bible
	private HashMap<String, BookTree> books;
	// a collection of the unique words in the bible, with a string representation, and word object
	private HashMap<String, Word> words;
	
	public BibleStore() 
	{
		books = new HashMap<String, BookTree>(); // key is the book name
		words = new HashMap<String, Word>();
	}
	
	/**
	 * Retrieve the book tree object at a specific location in the books collection.
	 * 
	 * @param b The name of the book to retrieve (the key).
	 * @return The book tree associated with this key.
	 */
	public BookTree getBookTree(String b) 
	{
		return books.get(b);
	}
	
	/**
	 * Retrieve the collection of unique words stored in the bible.
	 * 
	 * @return The collection of unique words in the bible.
	 */
	public HashMap<String, Word> getWords() 
	{
		return words;
	}
	
	/**
	 * Retrieve the collection of the books stored in the bible.
	 * 
	 * @return The collection of books, represented by book trees.
	 */
	public HashMap<String, BookTree> getBible() 
	{
		return books;
	}
	
	/**
	 * Retrieve the word object represented by a specified string.
	 * 
	 * @param w The word representation.
	 * @return The word object associated with this represenation.
	 */
	public Word getWord(String w) 
	{
		return words.get(w).getWordObject();
	}
	
	/**
	 * Read in all books in the folder, and store in the underlying data structure.
	 * 
	 * @param f The string name of the folder location to read in the bible files.
	 */
	public void populateBible(String f) {
		
		File bibleSource = new File(f);
		File[] files = bibleSource.listFiles();
		long startPop = System.currentTimeMillis(); // start recording the store time
		
		for (int i = 1; i < files.length; i++) // while there is still a book (file) in the folder
		{
			boolean nextChapter = true; // indicate if there is still a next chapter to be read in
			boolean nextVerse = true; // indicate if there is still a next verse to be read in
		
			String[] file = files[i].getName().split(".txt"); // remove the extension
			Book book = new Book(file[0].toLowerCase()); // use the first index (name) as the name of the book object
			BookTree bookTree = new BookTree(book); // create a new tree object with this book
			books.put(book.getIdentifier(), bookTree);
			BufferedReader r = null;
			
			try {
				r = new BufferedReader(new FileReader(files[i])); 
				String line = r.readLine(); // first line of the book (title)
				
				line = r.readLine(); // move pointer on
				
				String nextLine = r.readLine(); 
				
				for(Integer j = 1; nextLine != null && line.trim().isEmpty() && nextChapter; j++) // while there is still a chapter in the book/the line is blank
				{
					String[] tmp = line.split(" "); // split the line into strings to see if the first word is the start of a chapter
					while (!checkIfUpperCase(tmp[0])) { // check if the line starts with CHAPTER, else read next line until so
						line = nextLine;
						nextLine = r.readLine();
						tmp = line.split(" ");
					}
					line = nextLine; // move pointer on
					Chapter chapter = new Chapter(j.toString()); // create a new chapter object with this index as the identifier
					bookTree.addChapter(chapter); // add the chapter to the data structure
					
					for (Integer k = 1; nextVerse && !line.trim().isEmpty(); k++) // there is still a verse left   
					{		
						String verseLine = line.replaceAll("\\p{Punct}+[']", ""); // replaces all punctuation in the line except apostrophes with no space (removes)
						String[] wordArr = verseLine.toLowerCase().split("[^a-z0-9']"); // an array of all the words, splitting around the words
						
						Verse verse = new Verse(verseLine, k.toString()); 	// create a new verse object
						chapter.addVerse(verse); 							// add this verse object to the chapter
						bookTree.addVerse(verse, chapter.getIdentifier());	// add the verse to the data structure
								
						for (int m = 0; m < wordArr.length; m++) // while there is still a word in the array to read in 
						{ 
							Word w = new Word(wordArr[m]); // create a new word object
										
							if(!words.containsKey(w.toString())) // if this is not already contained in the collection...
							{
								words.put(w.toString(), w);		 //... add it to the collection
							}
							words.get(w.toString()).getWordObject().incrementWordCount(); // increment the word count regardless
							Location loc = new Location(book, chapter, verse); // update the location list for the word object
							words.get(w.toString()).getWordObject().updateLocList(loc);
						}
						
						line = r.readLine(); // move pointer on
						
						if(line == null) // if the next line is null, there are no more verses to read in
						{
							nextVerse = false;						
						}
						
					}
					if ((nextLine = r.readLine()) == null) { // if the line ahead at the end of a chapter is null, it is the end of the file
						nextChapter = false;
					}
				} 
				
			}
			catch(FileNotFoundException e) {}
			catch (IOException e) {}
			finally 
			{
				try 
				{
					if (r != null) 
					{
						r.close();
					}
				}
				catch (Exception e) { }
			}
		}	
		
		long endPop = System.currentTimeMillis(); // calculate the storage time
		long storageTime = endPop - startPop;
		
		System.out.println("It took: "+ storageTime +"ms to store the file.");
	}
	
	/**
	 * Retrieve whether or not the book is stored in the data structure.
	 * 
	 * @param s The name of the book.
	 * @return true If the book is stored.
	 */
	public boolean containsBook(String s) 
	{ 
		return books.containsKey(s);
	}
	
	/**
	 * Retrieve the string representation of the verse at a specified location.
	 * 
	 * @param l The location where the verse should be found.
	 * @return The string representation of the verse at the location.
	 */
	public String getVerseString(Location l) 
	{
		return l.getVerseString();
	}
	
	/**
	 * Check if the string passed in is all UPPERCASE.
	 * 
	 * @param s The string to check.
	 * @return true If the string is all uppercase.
	 */
	private boolean checkIfUpperCase(String s) 
	{
		char[] word = s.toCharArray();
		for (int i = 0; i < word.length; i++) 
		{
			if (!Character.isUpperCase(s.charAt(i))) 
			{
				return false;
			}
		}
		return true;
	}
}