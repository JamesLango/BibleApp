import java.util.ArrayList;

/**
 * A class to model the algorithms to search through the bible data structure.
 */
public class BibleSearch {

	// the object containing the representation and data structure for the bible
	private BibleStore bStore;
	
	public BibleSearch() 
	{
		bStore = new BibleStore();		
	}
	
	/**
	 * Retrieve the string representation of all the verses where a specified word occurs.
	 * 
	 * @param w The word.
	 * @return The string representation of all the verses in which this word occurs.
	 */
	public String getVerses(String w)
	{
		ArrayList<Location> locs = new ArrayList<Location>();
		Word word = bStore.getWords().get(w);
		locs = word.getLocationList();
		String verses = "";
		 
		for (int i = 0; i < locs.size(); i++)
		{
			verses += locs.get(i).getVerseString() + "\n";
		}
		return verses;	
	}
	
	public int getWordCount(String w) {
		return bStore.getWords().get(w).getWordObject().getCount();
	}
	
	public boolean containsWord(String s) {
		return bStore.getWords().containsKey(s);
	}
	
	public String getLocations(String w) {
		Word word = bStore.getWords().get(w);
		return word.getLocationStrings();
	}
	
	public String findVerse(String book, String chapter, String verse) {
		// Job 4:11
		//Book b = bStore.getBible().get(book).getBook();
		Integer v = Integer.valueOf(verse);
		return bStore.getBookTree(book).getChapter(chapter).getVerseChildren().get(v).getValue();
	}
	
	public String findRange(String book, String chapter, String firstVerse, String endVerse) {
		// Job 4:11-14
		Integer f = Integer.valueOf(firstVerse);
		Integer e = Integer.valueOf(endVerse);
		String result = "";
		
		for(Integer i = f; i<=e; i++ )
		{
		String iStr = i.toString();
		
		result +=findVerse(book, chapter, iStr) + "\n";
		
		}
		return result;
	}
	
	public String findChapter(String book, String chapter) {
		// Job 4
		String chapterOutput = "";
		 
		System.out.println("The book is :" + book);
		System.out.println("The chapter is :" + chapter);
		ArrayList<BibleComponent> verses = new ArrayList<BibleComponent>();
	
		verses = bStore.getBookTree(book).getChapterChildren(chapter);
		
		for (int i = 0; i < verses.size(); i++) {
			 chapterOutput += verses.get(i).getIdentifier() + " hi " + verses.get(i).toString() + "\n";
		}
		
		return chapterOutput;
	}
	
	public BibleStore getBibleStore() {
		return bStore;
	}
	
	public int getChapterSize(String book, String chapter) {
		return bStore.getBookTree(book).getBookChildren(book).size();
	}
	
	public int getVerseSize(String book, String chapter) {
		return bStore.getBookTree(book).getChapterChildren(chapter).size();
	}
}
