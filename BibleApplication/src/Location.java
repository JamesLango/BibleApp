/**
 * A class to model the location of a specific book, chapter or verse.
 * 
 */
public class Location {
	
	private String bookName;
	private String chapterNo; 
	private String verseNo;
	
	public Location(String b, String c, String v)
	{
		
	}
	

	

	public String getBookName()
	{
		return bookName;
	}
	
	public String getChapterLocation()
	{
		return chapterNo;
	}
	
	public String getVerseLocation()
	{
		return verseNo;
	}
}
