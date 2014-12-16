import java.util.ArrayList;
/*
 * Contains algorithms to search using input from the scanner class
 * through items in the bibleMap.
 */

public class BibleSearch {

	private BibleStore bible;
	
	public BibleSearch() {
		
		bible = new BibleStore();		
	}
	
	public String getVerses(String w) {
		
		ArrayList<Location> locs = new ArrayList<Location>();
		Word word = bible.getWords().get(w);
		locs = word.getLocationList();
		String verses = "";
		 
		for (int i = 0; i < locs.size(); i++)
		{
			verses += bible.getVerseString(locs.get(i)) + "\n";
		}
		return verses;	
	}
	
	public int getWordCount(String w) {
		return bible.getWords().get(w).getWordObject().getCount();
	}
	
	public boolean containsWord(String s) {
		return bible.getWords().containsKey(s);
	}
	
	public String getLocations(String w) {
		Word word = bible.getWords().get(w);
		return word.getLocationStrings();
	}
	
	public String findVerse(String book, String chapter, String verse) {
		// Job 4:11
		Book b = bible.getBible().get(book).getBook();
		Chapter c = bible.getBible().get(book).getChapter(chapter);
		Verse v = bible.getBible().get(book).getVerse(chapter, verse);
		Location l = new Location(b,c,v);
		
		return bible.getVerseString(l) + "\n";
	}
	
	public String findRange(String book, String chapter, String firstVerse, String endVerse) {
		// Job 4:11-14
		int end = Integer.parseInt(endVerse);
		int current = Integer.parseInt(firstVerse);
		
		String range = "";
		
		for (int i = current; i < end; i++) {
			range += findVerse(book, chapter, Integer.toString(current)) + "\n";
		}
		
		return range;
	}
	
	public String findChapter(String book, String chapter) {
		// Job 4
		String chapterOutput = "";
		 
		System.out.println("The book is :" + book);
		System.out.println("The chapter is :" + chapter);
		ArrayList<BibleComponent> verses = new ArrayList<BibleComponent>();
	
		System.out.println(bible.getBookTree(book)==null);
		verses = bible.getBible().get(book).getChapterChildren(chapter);
		
		for (int i = 0; i < verses.size(); i++) {
			 chapterOutput += verses.get(i).getIdentifier() + " " + verses.get(i).toString() + "\n";
		}
		
		return chapterOutput;
	}
	
	public BibleStore getBibleStore() {
		return bible;
	}
	
	public void getWords() {
		bible.wordList();
	}
	
	// algorithms for retrieval omitted
}
