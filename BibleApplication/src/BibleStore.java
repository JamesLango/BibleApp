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
			boolean nextChapter = true;
			boolean nextVerse = true;
		
			String[] file = files[i].getName().split(".txt");
			Book book = new Book(file[0]); // remove extension, and then use the first index (name)
			BookTree bookTree = new BookTree(book);
			books.put(book.getIdentifier(), bookTree);
			System.out.println("For book with name: " + book.getIdentifier());
			BufferedReader r = null;
			
			try {
				r = new BufferedReader(new FileReader(files[i]));
				String line = r.readLine(); // first line of the book (title)
				System.out.println(">> Currently storing book: " + line);
				
				line = r.readLine(); // < blank line
				
				String nextLine = r.readLine(); // < CHAPTER
				
				for(Integer j = 0; nextLine != null && line.trim().isEmpty() && nextChapter; j++) // while there is still a chapter in the book // the line is blank
				{
					String[] tmp = line.split(" ");
					while (!checkIfUpperCase(tmp[0])) { // check if the line starts with CHAPTER, else read next line until so
						line = nextLine;
						nextLine = r.readLine(); // line = chapter 2
						tmp = line.split(" ");
					}
					line = nextLine; // 1 once upon a time
					System.out.println("First line is: " + line);
					Chapter chapter = new Chapter(j.toString());
					bookTree.addChapter(chapter.getIdentifier());
					System.out.println("Currently storing chapter: " + bookTree.getChapter(j.toString())); // THIS IS ALWAYS 0??????????
					System.out.println(j);
					
					for (Integer k = 0; nextVerse && !line.trim().isEmpty(); k++) // there is still a verse left         ////// RETHINK:::::: readLine will move it on, 
					{		
						System.out.println("For verse: " + k);
						String verseLine = line; // this will be the line read in from processInput	
						String[] wordArr = verseLine.split(" "); // an array of all the words and the punctuation
						
						Verse verse = new Verse(verseLine, k.toString());
						bookTree.addVerse(verse.getVerse(), chapter.getIdentifier());		
								
						// if statement to check whether the word that has been scanned in is unique
									
						Word w = new Word("word");
									
						if(!words.containsKey(w.getString())) //
						{
							words.put(w.getString(), w);				
						}
						words.get(w.getString()).getWordObject().incrementWordCount();
						Location loc = new Location(book, chapter, verse);
						words.get(w.getString()).getWordObject().updateLocList(loc);
						
						line = r.readLine();
						if(line == null) {
						nextVerse = false;						
						}
						
					}
					if ((nextLine = r.readLine()) == null) {
						nextChapter = false;
					}
					//nextLine = r.readLine();//nextChapter = r.readLine();
				} 
				
			}
			catch(FileNotFoundException e) {
				
			}
			catch (IOException e) {
				
			}
			finally {
				try {
					if (r != null) {
						r.close();
					}
				}
				catch (Exception e) { }
			}
		}	 
		//checkBooksStored();
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
	
	private boolean checkIfUpperCase(String s) {
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

