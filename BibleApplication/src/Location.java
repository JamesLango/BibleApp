/**
 * A class to model the location of a specific book, chapter or verse.
 * 
 */
public class Location {
	
	private Book book;
	private Chapter chapter; 
	private Verse verse;
	
	public Location(Book b, Chapter c, Verse v)
	{
		book = b;
		chapter = c;
		verse = v;
	}
	
	public String getBookName()
	{
		return book.getIdentifier();
	}
	
	public String getChapterLocation()
	{
		return chapter.getIdentifier();
	}
	
	public String getVerseLocation()
	{
		return verse.getIdentifier();
	}
	
	public Book getBook() {
		return book;
	}
	
	public Chapter getChapter() {
		return chapter;
	}
	
	public Verse getVerse() {
		return verse;
	}

	public String toString() {
		return getBookName() + " " + getChapterLocation() + ": " + getVerseLocation() + "\n";
	}
}
