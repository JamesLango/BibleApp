/**
 * Class to model each individual verse in the bible.
 * This will store each word of the verse. 
 */
public class Verse extends BibleComponent {
	private String line;
	
	public Verse(String index, String l)
	{
		super(index);
		line = l;
	}
	
	/**
	 * A method to add a word to this verse collection.
	 * @param The word to be added to the collection.
	 */
	
	public void addWord(String word)
	{
		line += word;	
	}
	
	public String getVerse()
	{
		return line;
	}
	
	public String toString() {
		return line;
	}


}
