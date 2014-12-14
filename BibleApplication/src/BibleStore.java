import java.util.HashMap;

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
	
	public HashMap<String, Word> getMap() {
		return words;
	}
	
	public Word getWord(String w) {
		return words.get(w).getWordObject();
	}
	
	private void populateBible() { // some how pass in the folder name to sort it out?
		
		for (int i = 0; "input has next file (book)"; i++)
		{
			Book book = new Book("bookName");
			BookTree bookTree = new BookTree(book);
			bibles.put(book.getIdentifier(), bookTree);
		
			for(Integer j = 0; "book has another chapter"; i++)
			{
				
				Chapter c = new Chapter(j.toString());
				bookTree.addChapter(c);
						
				for (Integer k = 0; "chapter has another verse"; i++)
				{		
					String line = ""; // this will be the line read in from processInput	
						
					Verse v = new Verse(k.toString(),line);
					bookTree.addVerse(v,c);
					
					Location l = new Location(book.getIdentifier(), c.getIdentifier(), v.getIdentifier());		
							
					// if statement to check whether the word that has been scanned in is unique
								
					Word w = new Word("word");
								
					if(!words.containsKey(w.getString())) //
					{
						//Word w = new Word("word"); // added before the if statement to check if it exists
						words.put(w.getString(), w);				
					}
					words.get(w.getString()).getWordObject().incrementWordCount();
					words.get(w.getString()).getWordObject().updateLocList();
				}
			}	
		}	
	}
	
	public int getWordCount(String w) {
		return words.get(w).getWordObject().getCount();
	}
	
	public boolean containsWord(String s) {
		return words.containsKey(s);
	}
	
	public void containsBibleComponent(String s) { //boolean
		//return bibles.containsKey(s); ///////////////////////////////////////////
	}
	
	
public void populate() { // change method name
		
	}
	
	private void addBook(Book b) {
		//
	}
	
	private void addChapter(Chapter c) {
		
	}
	
	private void addVerse(Verse v) {
	
	}
	
	private void addWord() {
		
	}
}
