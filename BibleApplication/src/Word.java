import java.util.ArrayList;


public class Word {
	
	private String wordValue;
	private int wordCount = 0;
	
	private ArrayList<Location> locationList;
	
	public Word(String word)
	{	
		wordValue = word;
		locationList = new ArrayList<>();
			
	}
	
	public void updateLocList(Location l)
	{
		locationList.add(l);
	}

	public void incrementWordCount()
	{
		wordCount++;
	}
	
	
	public String getString() {
		return wordValue;
	}
	
	public Word getWordObject() {
		return this;
	}
	
	/**
	 * 
	 */
	public String toString()
	{
		return wordValue;
	}
	
	public int getCount() {
		return wordCount;
	}
	
	public ArrayList<Location> getLocationList()
	{
		return locationList;
	}
	
	public String getLocationStrings() 
	{
		String locs = "";
		
		for (int i = 0; i < locationList.size(); i++) 
		{
			locs += locationList.get(i).toString() + "\n"; // go through tree
		}
		
		return locs;
	}
}
