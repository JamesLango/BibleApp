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
		//System.out.println("Book ID : " + bookRoot.getComponent().getIdentifier());
		
	}
	
	public void addChapter(Chapter c) { 
		//Chapter chapter = new Chapter(c);
		//System.out.println("Chapter index is " + c);
		//System.out.println(chapter.toString());
		bookRoot.addChild(c);
	}
	
	public void addVerse(Verse v, String c) { 
		
		bookRoot.getChild(c).addChild(v);
		System.out.println("The verse is stored as: " + v.getIdentifier());
	}
	
	public Book getBook() {
		return (Book) bookRoot.getComponent();
	}
	
	public Chapter getChapter(String c) { // parameters should be changed to take in a string
		return (Chapter) bookRoot.getChild(c).getComponent();
	}
			

	
	public ArrayList<BibleComponent> getBookChildren(String b) {
		return bookRoot.getChildren();
	}
	
	public ArrayList<BibleComponent> getChapterChildren(String c) {
		return bookRoot.getChild(c).getChildren();
		
	
	}
		
	/**
	 * 
	 */
	public static class Node<BibleComponent> {
	
		public BibleComponent partOfBible; // change name
		public ArrayList<Node<BibleComponent>> children;
				
		public Node(BibleComponent comp) {
			children = new ArrayList<Node<BibleComponent>>();
			partOfBible = comp;
		}
		
		public void addChild(BibleComponent n) {
			Node<BibleComponent> newNode = new Node<BibleComponent>(n);
			//System.out.println("New child being added:" + newNode.getComponent());
			children.add(newNode);
		}
			
		public ArrayList<BibleComponent> getChildren() {
			ArrayList<BibleComponent> childComps = new ArrayList<BibleComponent>();
			for (int i = 0; i < children.size(); i++) {
				BibleComponent bc = children.get(i).getComponent();
				childComps.add(bc);
				
			}
			return childComps;
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
