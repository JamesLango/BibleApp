import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

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
		
		for (int i = 0; i < files.length; i++) // while there is still a book 
		{
			String[] file = files[i].getName().split(".txt");
			Book book = new Book(file[0]);
			BookTree bookTree = new BookTree(book);
			books.put(book.getIdentifier(), bookTree);
			
			//System.out.println(books.containsKey("Ken1")); // checks
			//System.out.println(books.containsKey("Ken2"));//
			//System.out.println(books.containsKey("Peter"));//
		
		
			
		
			/*BufferedReader reader = new BufferedReader(new FileReader(files[i]));
			String line = reader.readLine();
			while (line!= null) {}*/
					
			BufferedReader r = new BufferedReader(new FileReader(files[i]));
			String line = r.readLine(); // first line of the book (title)
			
			
		
			for(Integer j = 0; r.readLine() != null; i++) // while there is still a chapter in the book
			{
				
				Chapter c = new Chapter(j.toString());
				bookTree.addChapter(c);
						
				for (Integer k = 0; r.readLine() != null; i++) // there is still a verse left         ////// RETHINK:::::: readLine will move it on, 
				{		
					String verseLine = line; // this will be the line read in from processInput	
						
					Verse v = new Verse(k.toString(),verseLine);
					bookTree.addVerse(v,c);		
							
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
				}
			}	
		}	
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
