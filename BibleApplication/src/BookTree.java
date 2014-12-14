import java.util.ArrayList;

import java.util.HashMap;

/**
 * 
 *
 */
public class BookTree { // implements Iterable<> {
	
	// the root of this book tree - the topmost element
	private Node<BibleComponent> bookRoot;
	
	/**
	 * 
	 */
	public BookTree(Book b) {
		
		bookRoot = new Node<BibleComponent>(b);
		
	}
	
	private void addChapter(Chapter c) {
		bookRoot.addChild(c);
	}
	
	private void addVerse(Verse v, Chapter c) {
		bookRoot.getChild(c).addChild(v);
	}
	
	public Book getBook() {
		return (Book) bookRoot.getComponent();
	}
	
	public Chapter getChapter(Chapter c) { // parameters should be changed to take in a string
		return (Chapter) bookRoot.getChild(c).getComponent();
	}
			
	public Verse getVerse(Chapter c, Verse v) { // parameters should be changed to take in a string
		return (Verse) bookRoot.getChild(c).getChild(v).getComponent();
	}
	
	public void populate() {
		
		// Adding stuff to the bible
		// things in "quotation marks" are variables/conditions that should be in java
		// but are written in pseudo java for the time being.

		//for (int i = 0; "input has next file (book)"; i++)
		//{
		
		// create a new book object and add it to the bibleMap
		// might need to get book name and pass as a parameter to the book object
		// so this can be retrieved later on in the algorithm.

		//Book b = new Book("bookName");
		//bibleMap.addBook(b);

			//for(int j = 0; "book has another chapter"; i++)
			//{
			
			// create a new chapter object and add this to a collection
			// within the book object.
			// j is passed in as a parameter so that when the chapter is
			//created it knows its own index.
			// Chapter has "CHAPTER _" delimited so that it is a 
			// "pure" chapter.
			
			//Chapter c = new Chapter(j);
			//b.addChapter(c);
			
				//for (int k = 0; "chapter has another verse"; i++)
				//{
				
				// create a new verse object and add this to a collection
				// within the chapter object.
				// k is passed in as a parameter so that when it is created 
				// the verse object knows its own index.
				// scanned in line ("line") has line number delimited so that it is a 
				// "pure" string. 
				
				//Verse v = new Verse(k,line);
				//c.addVerse(v);
				//Location l = new Location(b.getName(), j, k);		
				
				// if statement to check whether the word that has been scanned in is unique
				
				//if("the word passed in is unique")
				//{
					// new word is created.
					// individual string object (after line has been delimited to words)
					// passed in as a string to the word object.
					
					//Word w = new Word("word");
					
					// the words locationList (array of Location objects) is updated with the location 
					// created above.
					//The words count field is also incremented.
					
					//w.updateLocationList(l);
					//w.incrementCount();
				//}
				//}
			//}
		}	

	
	
	/**
	 * 
	 */
	public static class Node<BibleComponent> {
	
		public BibleComponent partOfBible; // change name
		public ArrayList<Node<BibleComponent>> children;
				
		public Node(BibleComponent comp) {
			children = null;
			partOfBible = comp;
		}
		
		public void addChild(BibleComponent n) {
			Node<BibleComponent> newNode = new Node<BibleComponent>(n);
			children.add(newNode);
		}
			
		public ArrayList<Node<BibleComponent>> getChildren() {
			return children;
		}
		
		/**
		 * 
		 * @param b The bible component to get, if it is a child.
		 * @return the Node matching the bible component required.
		 */
		public Node<BibleComponent> getChild(BibleComponent b) {
			if (children != null) {
				for (int i = 0; i < children.size(); i++) {
					if (children.get(i).getComponent() == b) {
						return children.get(i);
					}
				}
	
			}
			return null;
		}
		
		/**
		 * 
		 * @return The bible component stored in this node.
		 */
		public BibleComponent getComponent() {
			return partOfBible;
		}
	}

	//public Iterator<> iterate() {
	//	return null; //
	//}
}

/**
 * Make book object
 * Make Root node
 * Assign book object to root node.
 * 
 * make chapter object
 * add child node to superNode 
 * assign chapter object to new child node.
 */
