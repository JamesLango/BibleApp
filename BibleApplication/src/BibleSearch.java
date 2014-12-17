import java.util.ArrayList;
/*
 * Contains algorithms to search using input from the scanner class
 * through items in the bibleMap.
 */

public class BibleSearch {

	private BibleStore bStore;
	
	public BibleSearch() {
		
		bStore = new BibleStore();		
	}
	
	public String getVerses(String w) {
		
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
	
		System.out.println(bStore.getBookTree(book)==null);
		verses = bStore.getBible().get(book).getChapterChildren(chapter);
		
		for (int i = 0; i < verses.size(); i++) {
			 chapterOutput += verses.get(i).getIdentifier() + " " + verses.get(i).toString() + "\n";
		}
		
		return chapterOutput;
	}
	
	public BibleStore getBibleStore() {
		return bStore;
	}
	
	public void getWords() {
		bStore.wordList();
	}
	
	// algorithms for retrieval omitted
}
