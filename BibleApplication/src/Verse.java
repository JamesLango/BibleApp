import java.util.ArrayList;
/**
 * Class to model each individual verse in the bible.
 * This will store each word of the verse. 
 */
public class Verse {
	private String words;
	
	public Verse()
	{
		words = "";
	}
	
	/**
	 * A method to add a word to this verse collection.
	 * @param The word to be added to the collection.
	 */
	
	public void addWord(String word)
	{
		words += word;	
	}
	
	public String getVerse()
	{
		return words;
	}

}
