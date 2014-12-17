/**
 * A class to model the location of a word in a specific book, chapter and verse.
 */
public class Location {
	
	// the book this location represents
	private Book book;
	// the chapter this location represents
	private Chapter chapter; 
	// the verse this chapter represents
	private Verse verse;
	
	public Location(Book b, Chapter c, Verse v)
	{
		book = b;
		chapter = c;
		verse = v;
	}
	
	/**
	 * Retrieve the name of the book stored in this location object.
	 * 
	 * @return The name of the book.
	 */
	public String getBookName()
	{
		return book.getIdentifier();
	}
	
	/**
	 * Retrieve the string representation of the content of the verse.
	 * 
	 * @return The content of the verse.
	 */
	public String getVerseString()
	{
		return verse.getValue();
	}
	
	/**
	 * Retrieve the string representation of the chapter's location (index)
	 * in the bible.
	 * 
	 * @return The index of this chapter.
	 */
	public String getChapterLocation()
	{
		return chapter.getIdentifier();
	}
	
	/**
	 * Retrieve the string representation of the verse's location (index)
	 * in the bible.
	 * 
	 * @return The index of this verse.
	 */
	public String getVerseLocation()
	{
		return verse.getIdentifier();
	}
	
	/**
	 * Retrieve the string representation of this location object.
	 * 
	 * @return The string representation of this object.
	 */
	public String toString() 
	{
		return getBookName() + " " + getChapterLocation() + ": " + getVerseLocation() + "\n";
	}
}
