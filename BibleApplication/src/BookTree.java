import java.util.ArrayList;

/**
 * A class to model the underlying data structure to store the bible, storing
 * its many components within a tree structure using nodes. This allows fast
 * and efficient retrieval of elements within the data structure.
 *
 */
public class BookTree {
	
	// the root of this book tree - the topmost element
	private Node<BibleComponent> bookRoot;
	
	public BookTree(Book b) 
	{
		bookRoot = new Node<BibleComponent>(b);	// initialise the root of the tree data structure
	}
	
	/** 
	 * Add a chapter node to the data structure, as a child of the root.
	 * 
	 * @param c The chapter object to store in the data structure.
	 */
	public void addChapter(Chapter c) 
	{ 
		bookRoot.addChild(c);
	}
	
	/**
	 * Add a verse node to the data structure, as a child of a chapter node.
	 * 
	 * @param v The verse to add to the data structure.
	 * @param c The chapter to add the verse as a child of.
	 */
	public void addVerse(Verse v, String c) 
	{ 
		bookRoot.getChild(c).addChild(v);
	}
	
	/**
	 * Retrieve the book stored at the root of the data structure.
	 * 
	 * @return The book at the root of the structure.
	 */
	public Book getBook() 
	{
		return (Book) bookRoot.getComponent();
	}
	
	/**
	 * Retrieve the chapter stored as a child of the root.
	 * 
	 * @param c The chapter identifier of the chapter to retrieve.
	 * @return The chapter object retrieved.
	 */
	public Chapter getChapter(String c) 
	{
		return (Chapter) bookRoot.getChild(c).getComponent();
	}
		
	/**
	 * Retrieve the collection of the child nodes of the root.
	 * 
	 * @param b The book identifier of the root.
	 * @return The collection of children of the root.
	 */
	public ArrayList<BibleComponent> getBookChildren(String b) 
	{
		return bookRoot.getChildren();
	}
	
	/**
	 * Retrieve the collection of the child nodes of a specified chapter node.
	 * 
	 * @param c The chapter identifier of the child of the root.
	 * @return The collection of the children of the chapter.
	 */
	public ArrayList<BibleComponent> getChapterChildren(String c) 
	{
		return bookRoot.getChild(c).getChildren();
	}
		
	/**
	 * A static nested class to represent a node in the tree data structure for
	 * the bible. It uses the abstract class BibleComponent to effectively handle all
	 * component types of the bible.
	 */
	public static class Node<BibleComponent> 
	{
		// the part of the bible (e.g. Book, Chapter, Verse)
		public BibleComponent partOfBible;
		// the collection of nodes this node keeps track of as children
		public ArrayList<Node<BibleComponent>> children;
				
		public Node(BibleComponent comp) 
		{
			children = new ArrayList<Node<BibleComponent>>();
			partOfBible = comp;
		}
		
		/**
		 * Add a child to the collection of children nodes this object keeps track of.
		 * 
		 * @param n The component to add as a child node.
		 */
		public void addChild(BibleComponent n) 
		{
			Node<BibleComponent> newNode = new Node<BibleComponent>(n);
			children.add(newNode);
		}
			
		/**
		 * Retrieve the collection of child nodes this node keeps track of.
		 * 
		 * @return The children of this node.
		 */
		public ArrayList<BibleComponent> getChildren() 
		{
			ArrayList<BibleComponent> childComps = new ArrayList<BibleComponent>();
			for (int i = 0; i < children.size(); i++) 
			{
				BibleComponent bc = children.get(i).getComponent();
				childComps.add(bc);	
			}
			return childComps;
		}
		
		/**
		 * Retrieve a specific child node of this node.
		 * 
		 * @param b The bible component to get, if it is a child.
		 * @return the Node matching the bible component required.
		 */
		public Node<BibleComponent> getChild(String bibleComp) 
		{
			if (children != null) 
			{
				for (int i = 0; i < children.size(); i++) 
				{
					if (children.get(i).getComponent().toString().equals(bibleComp)) 
					{
						return children.get(i);
					}
				}
	
			}
			return null;
		}
		
		/**
		 * Retrieve the bible component this node stores as an element.
		 * 
		 * @return The bible component stored in this node.
		 */
		public BibleComponent getComponent() 
		{
			return partOfBible;
		}
	}
}
