import java.util.HashMap;

/**
 * A class to model a single book in the bible collection.
 * This will hold many chapter objects.
 *
 */

public class Book {
	
	private HashMap<Integer,Chapter> chapters;
	
	public Book ()
	{	
		chapters = new HashMap<>();
	}

	/**
	 * A method to add chapters to the chapters collection hashmap.
	 * @param chapter number.
	 * @param chapter to be added.
	 */
	public void addChapter(Integer chapNo, Chapter chapObj)
	{
	chapters.put(chapNo, chapObj);
	}
	
	/**
	 * A method to retrieve a specific chapter from the collection and return it.
	 * @param chapter number to be retrieved.
	 * @return chapter object referenced by chapter number.
	 */
	public Chapter getChapter(Integer chapNo)
	{
		return chapters.get(chapNo);	
	}
}
