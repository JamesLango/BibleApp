/**
 * Class to model each individual verse in the bible.
 * This will store each word of the verse. 
 */
public class Verse extends BibleComponent {
	// the line of the bible this verse contains
	private String line;
	
	public Verse(String l, String index)
	{
		super(index);
		line = l;
	}
	
	/**
	 * Retrieve the sentence this verse object contains.
	 * 
	 * @return The sentence in this verse.
	 */
	public String getValue()
	{
		return line;
	}
	
	/**
	 * Return the string representation of this verse object.
	 */
	public String toString() 
	{
		return identifier + " " + line;
	}


}
