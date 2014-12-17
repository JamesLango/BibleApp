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
	 * Retrieve the value of this book object.
	 * 
	 * @return null
	 */
	public String getValue()
	{
		return null;
	}
	
	/**
	 * Return the string representation of this book object.
	 * 
	 * @return The string representation.
	 */
	public String toString() 
	{
		return identifier;
	}
}
