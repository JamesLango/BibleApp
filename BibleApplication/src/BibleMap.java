import java.util.HashMap;

import java.util.HashSet;

/**
 * Class is used to model the entire bible collection.
 * The bible collection will consist of book, chapter and verse objects.
 *
 *
 * THIS ENTIRE CLASS NEEDS TO BE RETHOUGHT TO IMPLEMENT 
 * OUR DATA STRUCURE
 * 
 * SHOULD BE GENERIC SO WE CAN USE IT ELSEWHERE?
 */

public class BibleMap<T> {
	
	private HashMap<String, T> x; //name and type
	
	private HashMap<HashSet<String>, Word> words; // hmm...
	
	public BibleMap()
	{
		x = new HashMap<>();
		Node test = new Node
		
	}
	
	public void addBook(String name, T t) {
		x.put(name, t);
	}

}
