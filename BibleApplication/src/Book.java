import java.util.ArrayList;

/**
 * A class to model a single book in the bible collection.
 * This will hold many chapter objects.
 *
 */

public class Book extends BibleComponent {
	
	//private ArrayList<Chapter> chapters; >> now in the tree
	
	public Book (String name)
	{	
		super(name);
		//chapters = new ArrayList<>();
	}
	
	/**
	 * A method to retrieve a specific chapter from the collection and return it.
	 * @param chapter number to be retrieved.
	 * @return chapter object referenced by chapter number.
	 */
	//public Chapter getChapter(Integer chapNo)
	//{
	//	return chapters.get(chapNo-1);	
	//}
}
