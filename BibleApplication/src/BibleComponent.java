/**
 * A class to model the components of a bible.
 *
 */
public abstract class BibleComponent {

	// the identifier for this component
	protected String identifier;
	
	public BibleComponent(String name)
	{
		identifier = name;
	}
	
	/**
	 * Retrieve the identifier for this component.
	 * 
	 * @return The identifier.
	 */
	public String getIdentifier() {
		return identifier;
	}
	
	/**
	 * Return a string representation of this component.
	 */
	public abstract String toString();
}
