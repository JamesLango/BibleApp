
public abstract class BibleComponent {

	protected String identifier;
	
	public BibleComponent(String name)
	{
		identifier = name;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public abstract String toString();
	
	
	//words.contains(BibleComponent(String name));
}
