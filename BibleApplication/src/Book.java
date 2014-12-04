import java.util.ArrayList;

/**
 * A class to model a single book in the bible collection.
 * This will hold many chapter objects.
 *
 */

public class Book {
	
	private ArrayList<Chapter> chapters;
	private String name;
	
	public Book (String name)
	{	
		this.name = name;
		chapters = new ArrayList<>();
	}

	/**
	 * A method to add chapters to the chapters collection ArrayList.
	 * @param chapter number.
	 * @param chapter to be added.
	 */
	public void addChapter(Chapter chapObj)
	{
		chapters.add(chapObj);
	}
	
	/**
	 * A method to retrieve a specific chapter from the collection and return it.
	 * @param chapter number to be retrieved.
	 * @return chapter object referenced by chapter number.
	 */
	public Chapter getChapter(Integer chapNo)
	{
		return chapters.get(chapNo-1);	
	}
}
