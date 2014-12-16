import java.util.ArrayList;

/**
 * A class to model an individual chapter within a book.
 * A chapter will hold multiple Verses.
 *
 */
public class Chapter extends BibleComponent {
	
	public Chapter(String index)
	{
		super(index);
	}
	
	/**
	 * Return the string representation of this chapter object.
	 */
	public String toString() {
		return identifier;
	}
}
