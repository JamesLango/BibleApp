import java.util.ArrayList;

/**
 * A class to model a unique word read in from the bible.
 */
public class Word {
	
	// the string representation of the word
	private String wordValue;
	// how many times the word occurs in the bible
	private int wordCount = 0;
	// a collection of all the locations in the bible where this word can be found
	private ArrayList<Location> locationList;
	
	public Word(String word)
	{	
		wordValue = word;
		locationList = new ArrayList<>();
	}
	
	/**
	 * Add a location to the collection of locations this word appears in.
	 * 
	 * @param l The location this object appears. 
	 */
	public void updateLocList(Location l)
	{
		locationList.add(l);
	}

	/**
	 * Increment the number of times this word has occurred.
	 */
	public void incrementWordCount()
	{
		wordCount++;
	}
	
	/**
	 * Retrieve the reference to this object.
	 * 
	 * @return This object.
	 */
	public Word getWordObject() 
	{
		return this;
	}
	
	/**
	 * Retrieve the number of times this word has occurred in the bible.
	 * 
	 * @return The counter for this word.
	 */
	public int getCount() 
	{
		return wordCount;
	}
	
	/**
	 * Retrieve the collection of locations this word has been found in the bible.
	 * 
	 * @return The Location collection.
	 */
	public ArrayList<Location> getLocationList()
	{
		return locationList;
	}
	
	/**
	 * Retrieve the string representation for the locations this word object can
	 * be found in the bible.
	 * 	
	 * @return A string representation of all the locations.
	 */
	public String getLocationStrings() 
	{
		String locs = "";
		
		for (int i = 0; i < locationList.size(); i++) 
		{
			locs += locationList.get(i).toString() + "\n";
		}
		return locs;
	}
	
	/**
	 * Retrieve the string representation of this word object.
	 * 
	 * @return The word itself.
	 */
	public String toString()
	{
		return wordValue;
	}
}