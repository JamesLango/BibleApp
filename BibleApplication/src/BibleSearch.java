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
		ArrayList<Location> locs = new ArrayList<Location>(); // create a new collection of locations
		Word word = bStore.getWords().get(w); // retrieve the word with the key "w"
		locs = word.getLocationList(); // get the location list contained in the word object
		String verses = "";
		 
		for (int i = 0; i < locs.size(); i++)
		{
			verses += locs.get(i).getVerseString() + "\n"; // go through the location list, and store in a string
		}
		return verses;	
	}
	
	/**
	 * Retrieve the number of times a specified word has occurred in the bible.
	 * 
	 * @param w The word.
	 * @return The number of times this word has been counted in the bible.
	 */
	public int getWordCount(String w) 
	{
		return bStore.getWords().get(w).getWordObject().getCount();
	}
	
	/**
	 * Retrieve whether the bible contains a specified word.
	 * 
	 * @param s The word to check.
	 * @return true If the bible does contain the word.
	 */
	public boolean containsWord(String s) 
	{
		return bStore.getWords().containsKey(s);
	}
	
	/**
	 * Retrieve the string representation of the locations a specified word occurs.
	 * Output format: Book Chapter: Verse
	 * @param w The word.
	 * @return The string representation of each location the word is found at.
	 */
	public String getLocations(String w) 
	{
		Word word = bStore.getWords().get(w);
		return word.getLocationStrings();
	}
	
	/**
	 * Retrieve the verse as a string representation at a specific location in the bible.
	 * Input format: Job 4:11
	 * 
	 * @param book The book the verse is in.
 	 * @param chapter The chapter the verse is in.
	 * @param verse The specified verse to find.
	 * @return The string of the line of the verse contained at the specific location.
	 */
	public String findVerse(String book, String chapter, String verse) 
	{
		Integer v = Integer.valueOf(verse);
		return bStore.getBookTree(book).getChapter(chapter).getVerseChildren().get(v).getValue();
	}
	
	/**
	 * Retrieve the string representation of the verses found between a range of verse numbers
	 * within the bible, inside a specified book and chapter.
	 * Input format: Job 4:11-14
	 * 
	 * @param book The book the verses are in.
	 * @param chapter The chapter the verses are in.
	 * @param firstVerse The first verse to find.
	 * @param endVerse The last verse to find.
	 * @return
	 */
	public String findRange(String book, String chapter, String firstVerse, String endVerse) 
	{
		Integer f = Integer.valueOf(firstVerse); // convert the firstverse string value to an integer to process
		Integer e = Integer.valueOf(endVerse); // convert the endverse string value to an integer to process
		String result = "";
		
		for(Integer i = f; i <= e; i++) // go through the range of verses from the first to the last specified
		{
			String iStr = i.toString();
			result +=findVerse(book, chapter, iStr) + "\n";
		}
		return result;
	}
	
	/**
	 * Retrieve the string representation of a specified chapter, and output all the verses in this chapter.
	 * Input format: Job 4
	 * 
	 * @param book The book this chapter is in.
	 * @param chapter The chapter to retrieve.
	 * @return The string representation of all the verses in the specified chapter.
	 */
	public String findChapter(String book, String chapter) 
	{
		String chapterOutput = "";
		ArrayList<BibleComponent> verses = new ArrayList<BibleComponent>(); // create a new collection to store the verses
		verses = bStore.getBookTree(book).getChapterChildren(chapter); // retrieve the children from the chapter object
		
		for (int i = 0; i < verses.size(); i++) 
		{
			 chapterOutput += verses.get(i).getIdentifier() + " hi " + verses.get(i).toString() + "\n";
		}
		return chapterOutput;
	}
	
	/**
	 * Retrieve the bibleStore object contained within this class, used to search upon.
	 * 
	 * @return The bibleStore object.
	 */
	public BibleStore getBibleStore() 
	{
		return bStore;
	}
}
