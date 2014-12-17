import java.util.ArrayList;

/**
 * A class to model an individual chapter within a book.
 * A chapter will hold multiple Verses.
 */
public class Chapter extends BibleComponent {
	
	// a collection of the verses this chapter object contains
	private ArrayList<Verse> verses;
	
	public Chapter(String index)
	{
		super(index);
		verses = new ArrayList<Verse>();
	}
	
	/**
	 * Add a verse object to the collection of verses this chapter contains.
	 * 
	 * @param verseObj The verse to add to the collection.
	 */
	public void addVerse(Verse verseObj)
	{
		verses.add(verseObj);
	}
	
	/**
	 * Retrieve the verse at a specified index in the collection of verses
	 * this chapter contains.
	 * 
	 * @param verseNo The index number to find the verse at.
	 * 
	 * @return The verse object at the specified index.
	 */
	public Verse getVerse(Integer verseNo) 
	{
		return verses.get(verseNo);
	}
	
	/**
	 * Retrieve the collection of verses this chapter object contains.
	 * 
	 * @return The collection of verses.
	 */
	public ArrayList<Verse> getVerseChildren() 
	{
		return verses;
	}
	
	/**
	 * Return the string representation of this chapter object.
	 * 
	 * @return The string representation of this chapter object
	 */
	public String toString() 
	{
		return identifier;
	}
	
	/** 
	 * Retrieve the value of this chapter object.
	 * 
	 * @return null
	 */
	public String getValue()
	{
		return null;
	}
}
