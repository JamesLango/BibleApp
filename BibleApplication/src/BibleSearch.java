import java.util.ArrayList;
/*
 * Contains algorithms to search using input from the scanner class
 * through items in the bibleMap.
 */

public class BibleSearch {

	private BibleStore bible;
	
	public BibleSearch() {
		
		bible = new BibleStore();
		
		//bible.populate();
		
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
	
	public String getLocations(Word w) {
		return w.getLocationStrings();
	}
	
	// algorithms for retrieval omitted
}
