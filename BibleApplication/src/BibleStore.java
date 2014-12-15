import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BibleStore {
	// a collection of trees, which contain the books, chapters and verses of the bible
	private HashMap<String, BookTree> books;
	// a hashset of the unique words in the bible
	private HashMap<String, Word> words;
	private File bibleSource;
	private Scanner s;
	
	public BibleStore() {
		books = new HashMap<String, BookTree>(); // key is the bible name, so KJBible
		words = new HashMap<String, Word>();
	}
	
	public HashMap<String, Word> getWords() {
		return words;
	}
	
	public HashMap<String, BookTree> getBible() {
		return books;
	}
	
	public Word getWord(String w) {
		return words.get(w).getWordObject();
	}
	
	public void populateBible(String f) { // some how pass in the folder name to sort it out?
		
		File bibleSource = new File(f);
		File[] files = bibleSource.listFiles();
		System.out.println("The number of files in the folder is: " + files.length);
		
		for (int i = 0; i < files.length; i++) // while there is still a book 
		{
			String[] file = files[i].getName().split(".txt");
			Book book = new Book(file[0]); // remove extension, and then use the first index (name)
			BookTree bookTree = new BookTree(book);
			books.put(book.getIdentifier(), bookTree);
			System.out.println("For book with name: " + file[i]);
			
			
			
			try {
				
				BufferedReader r = new BufferedReader(new FileReader(files[i]));
				String line = r.readLine(); // first line of the book (title)
				System.out.println("The Title of this book is: " + line);
				for(Integer j = 0; ; j++) // while there is still a chapter in the book <<<<<<<< FIND CONDITION
				{
					String[] tmp = line.split(" ");
					while (!tmp[0].equals("CHAPTER")) { // check if the line starts with CHAPTER, else read next line until so
						line = r.readLine();
						tmp = line.split(" ");
					}
					line = r.readLine(); // first verse
					bookTree.addChapter(j.toString());
					System.out.println("For Chapter stored: " + bookTree.getChapter(j.toString()));
					
					for (Integer k = 0; !line.trim().isEmpty(); k++) // there is still a verse left         ////// RETHINK:::::: readLine will move it on, 
					{		
						System.out.println("The current value of LINE is: " + line);
						String verseLine = line; // this will be the line read in from processInput	
						String[] wordArr = verseLine.split(" "); // an array of all the words and the punctuation
						System.out.println("VerseLine = " + verseLine);
						
						bookTree.addVerse(verseLine, j.toString());		
								
						// if statement to check whether the word that has been scanned in is unique
									
						Word w = new Word("word");
									
						if(!words.containsKey(w.getString())) //
						{
							//Word w = new Word("word"); // added before the if statement to check if it exists
							words.put(w.getString(), w);				
						}
						words.get(w.getString()).getWordObject().incrementWordCount();
						//Location loc = new Location(book.getIdentifier(), c.getIdentifier(), v.getIdentifier());
						//words.get(w.getString()).getWordObject().updateLocList(loc);
						//System.out.println(verseLine);
						
						line = r.readLine();
						System.out.println();
					} 
					r.close();
				}
			}
			
			
			catch(FileNotFoundException e) {
				
			}
			catch (IOException e) {
				
			}
			
		/*BufferedReader reader = new BufferedReader(new FileReader(files[i]));
		String line = reader.readLine();
		while (line!= null) {}*/
		checkBooksStored();
		}
	}
	
	public String findNextChapter() {
		return null;
	}
	
	
	
	public void checkBooksStored() {
		System.out.println(books.containsKey("Ken1") + "Ken1"); // checks
		System.out.println(books.containsKey("Ken2") + "Ken2");//
		System.out.println(books.containsKey("Peter") + "Peter");//
	}
	
	
	public boolean containsBook(String s) { 
		return books.containsKey(s);
	}
	
	//public boolean containsChapter(String b, String c) {
	//	return books.get(b).containsKey(c);
	//}
	
	public String getVerseString(Location l) {
		return books.get(l.getBookName()).getVerse(l.getChapterLocation(), l.getVerseLocation()).toString();
		// physical 
	}	
}
