import java.util.ArrayList;

/**
 * A class to model a single book in the bible collection.
 * This will hold many chapter objects.
 *
 */

public class Book extends BibleComponent {
	
	public Book (String name)
	{	
		super(name);
	}
	
	/**
	 * Return the string representation of this book object.
	 */
	public String toString() {
		return identifier;
	}
}
