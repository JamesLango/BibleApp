/**
 * A class to model the location of a specific book, chapter or verse.
 * 
 */
public class Location {
	
	private String bookName;
	private int chapterNo;
	private int verseNo;
	
	public Location(String b, int c, int v)
	{
		
	}
	

	

	public String getBookName()
	{
		return bookName;
	}
	
	public int getChapterLocation()
	{
		return chapterNo;
	}
	
	public int getVerseLocation()
	{
		return verseNo;
	}
}
