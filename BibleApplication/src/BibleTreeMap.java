import java.util.HashMap;
import java.util.HashSet;

public class BibleTreeMap {
	// a collection of trees, which contain the books, chapters and verses of the bible
	private HashMap<String, BookTree> bibles;
	// a hashset of the unique words in the bible
	private HashSet<Word> words;
	
	public BibleTreeMap() {
		bibles = new HashMap<String, BookTree>(); // key is the bible name, so KJBible
		
		//eachBible.populate();
		
		
	}
	
}
