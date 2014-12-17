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
	public String getIdentifier() 
	{
		return identifier;
	}
	
	/**
	 * Retrieve the value of this bible component object in String representation.
	 * 
	 * @return The string representation of the value of this object.
	 */
	public abstract String getValue();
	
	/**
	 * Return a string representation of this component.
	 */
	public abstract String toString();
}
