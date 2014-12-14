import java.util.ArrayList;
/**
 * A class to model an individual chapter within a book.
 * A chapter will hold multiple Verses.
 *
 */
public class Chapter extends BibleComponent {
	
	private ArrayList<Verse> verses;
	
	public Chapter(String index)
	{
		super(index);
		verses = new ArrayList<>();
	}
	
	/**
	 * A method to store a verse within this chapter object.
	 * @param verse number.
	 * @param verse to be added.
	 */
	
	public void addVerse(Verse verseObj)
	{
		verses.add(verseObj);
	}
	
	/**
	 * A method to retrieve a specific verse within this chapter object.
	 * @param verse number.
	 * @return verse to be retrieved.
	 */
	
	public Verse getVerse(Integer verseNo)
	{
		return verses.get(verseNo-1);
	}

}
