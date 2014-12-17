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
	
	public BookTree getBookTree(String b) {
		return books.get(b);
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
		//System.out.println("The number of files in the folder is: " + files.length);
		long startPop = System.currentTimeMillis();
		
		for (int i = 0; i < files.length; i++) // while there is still a book 
		{
			boolean nextChapter = true;
			boolean nextVerse = true;
		
			String[] file = files[i].getName().split(".txt");
			Book book = new Book(file[0].toLowerCase()); // remove extension, and then use the first index (name)
			BookTree bookTree = new BookTree(book);
			books.put(book.getIdentifier(), bookTree);
			//System.out.println("For book with name: " + book.getIdentifier());
			BufferedReader r = null;
			
			try {
				r = new BufferedReader(new FileReader(files[i]));
				String line = r.readLine(); // first line of the book (title)
				//System.out.println(">> Currently storing book: " + line);
				//
				line = r.readLine(); // < blank line
				
				String nextLine = r.readLine(); // < CHAPTER
				
				for(Integer j = 1; nextLine != null && line.trim().isEmpty() && nextChapter; j++) // while there is still a chapter in the book // the line is blank
				{
					String[] tmp = line.split(" ");
					while (!checkIfUpperCase(tmp[0])) { // check if the line starts with CHAPTER, else read next line until so
						line = nextLine;
						nextLine = r.readLine(); // line = chapter 2
						tmp = line.split(" ");
					}
					line = nextLine; // 1 once upon a time
					//System.out.println("First line is: " + line);
					Chapter chapter = new Chapter(j.toString());
					bookTree.addChapter(chapter);
					//System.out.println("Currently storing chapter: " + bookTree.getChapter(j.toString()));
					//System.out.println(j);
					
					for (Integer k = 0; nextVerse && !line.trim().isEmpty(); k++) // there is still a verse left   
					{		
						//System.out.println("For verse: " + k);
						String verseLine = line.replaceAll("\\p{Punct}+[']", "");; // this will be the line read in from processInput	
						String[] wordArr = verseLine.toLowerCase().split("[^a-z0-9']"); // an array of all the words 
						//String[] wordArr = verseLine.toLowerCase().split(" "); // an array of all the words and the punctuation
						
						
						Verse verse = new Verse(verseLine, k.toString());
						chapter.addVerse(verse);
						System.out.println(chapter.getVerseChildren().size());
						//bookTree.addVerse(verse, chapter.getIdentifier());		
								
						for (int m = 0; m < wordArr.length; m++) {			
							Word w = new Word(wordArr[m]);
										
							if(!words.containsKey(w.getString())) //
							{
								words.put(w.getString(), w);				
							}
							words.get(w.getString()).getWordObject().incrementWordCount();
							Location loc = new Location(book, chapter, verse);
							words.get(w.getString()).getWordObject().updateLocList(loc);
							//System.out.println(words.get(w.getString()));
						}
						
						
						line = r.readLine();
						if(line == null) {
							nextVerse = false;						
						}
						
					}
					if ((nextLine = r.readLine()) == null) {
						nextChapter = false;
					}
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
		
		long endPop = System.currentTimeMillis();
		long storageTime = endPop - startPop;
		
		System.out.println("It took: "+ storageTime+"ms to store the file.");
		
	}
	
	
	
	public boolean containsBook(String s) { 
		return books.containsKey(s);
	}
	
	//public boolean containsChapter(String b, String c) {
	//	return books.get(b).containsKey(c);
	//}
	
	public String getVerseString(Location l) {
		return l.getVerseString();
		//return books.get(l.getBookName()).getVerse(l.getChapterLocation(), l.getVerseLocation()).toString();
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
	
	public void wordList() {
		String wordList = "Here are the words: \n";
		String[] wordSet = (String[]) words.keySet().toArray();
		for (int i = 0; i < wordSet.length; i++) {
			wordList += wordSet[i] + "\n";
		}
		System.out.println(wordList + " " + words.size());
	}
}

