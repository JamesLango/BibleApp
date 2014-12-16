import java.io.File;
import java.util.Scanner;

/*
 * This class contains code that will take the input from the 
 * user so that it accessible by the scanner class. 
 * It will also allow the program to output text to the user interface.
 */


public class TUI {
	
	private static String userInput;
	private static String[] commandString;
	private String commandWord;
	private static String fileLocation;
	private Scanner user_input;
	private static ProcessInput processInput;
	private static boolean hasFile=false;
	
	public static void main(String[] args)
	{
		processInput = new ProcessInput();
		
		while(processInput.running())
		{
			while(!hasFile)
			{
			fileInput();
			}
		testInput();
		}
	}
	
	public static void testInput()
	{
		Scanner user_input = new Scanner(System.in);
		System.out.println("Please enter test input");
		userInput = "";
		
		userInput = user_input.nextLine().toLowerCase();
		commandString = splitToArray(userInput);
		//commandString = userInput.split("[a-zA-Z']");
		processInput.processCommand(commandString);
		
	}
	
	public static String[] splitToArray(String s)
	{
		return userInput.split("\\s");
	}
	
	public static void fileInput()
	{
		Scanner user_input = new Scanner(System.in);
		System.out.println("Please enter file location:\n");
		fileLocation = "";
		fileLocation = user_input.nextLine();
		final File folder = new File(fileLocation);
		
		if(folder.isDirectory())
		{
		processInput.processFile(fileLocation);
		hasFile = true;
		}
		else
		{
			System.out.print("File not recognised please try again.\n");
		}
		
		//System.out.print(fileLocation);
		//System.out.print(folder.isDirectory());
		//for (final File fileEntry : folder.listFiles()) {
	    //System.out.println("FileEntry Directory "+fileEntry);
		}
}



