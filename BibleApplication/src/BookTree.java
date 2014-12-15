import java.util.ArrayList;

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
	
	public void addChapter(Chapter c) { //private?
		bookRoot.addChild(c);
	}
	
	public void addVerse(Verse v, Chapter c) { //private?
		bookRoot.getChild(c).addChild(v);
	}
	
	public Book getBook() {
		return (Book) bookRoot.getComponent();
	}
	
	public Chapter getChapter(String c) { // parameters should be changed to take in a string
		return (Chapter) bookRoot.getChild(c).getComponent();
	}
			
	public Verse getVerse(String c, String v) { // parameters should be changed to take in a string
		return (Verse) bookRoot.getChild(c).getChild(v).getComponent();
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
		public Node<BibleComponent> getChild(String bibleComp) {
			if (children != null) {
				for (int i = 0; i < children.size(); i++) {
					if (children.get(i).getComponent().toString().equals(bibleComp)) {
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
