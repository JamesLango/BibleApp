import java.util.HashMap;
/**
 * A class to model an individual chapter within a book.
 * A chapter will hold multiple Verses.
 *
 */
public class Chapter {
	
	private HashMap<Integer, Verse> verses;
	
	public Chapter()
	{
		verses = new HashMap<>();
	}
	
	/**
	 * A method to store a verse within this chapter object.
	 * @param verse number.
	 * @param verse to be added.
	 */
	
	public void addVerse(Integer verseNo, Verse verseObj)
	{
		verses.put(verseNo, verseObj);
	}
	
	/**
	 * A method to retrieve a specific verse within this chapter object.
	 * @param verse number.
	 * @return verse to be retrieved.
	 */
	
	public Verse getVerse(Integer verseNo)
	{
		return verses.get(verseNo);
	}

}
