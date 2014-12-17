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
		verses = new ArrayList<Verse>();
	}
	
	public void addVerse(Verse verseObj)
	{
		verses.add(verseObj);
	}
	
	public Verse getVerse(Integer verseNo) {
		return verses.get(verseNo);
	}
	
	public ArrayList<Verse> getVerseChildren() {
		return verses;
	}
	/**
	 * Return the string representation of this chapter object.
	 */
	public String toString() {
		return identifier;
	}
	public String getValue()
	{
		return null;
	}
}
