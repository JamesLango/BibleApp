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
			while(!hasFile)// while a file hasn't been entered in.
			{
			fileInput();
			}
		userInput();
		}
	}
	
	/**
	 * Method that recieves user input, converts it to lower case and stores it in an array, this is then passed to the process command method.
	 */
	public static void userInput()
	{
		Scanner user_input = new Scanner(System.in);
		System.out.println("Please type your input. Type 'help' to display a help screen.");
		userInput = "";
		
		userInput = user_input.nextLine().toLowerCase();
		commandString = splitToArray(userInput);
		//commandString = userInput.split("[a-zA-Z']");
		processInput.processCommand(commandString);
		
	}
	
	/**
	 * Splits the string passed in to an array and returns it.
	 * @param s
	 * @return String[]
	 */
	public static String[] splitToArray(String s)
	{
		String stripped = s.replaceAll("\\p{Punct}+[']", "");
		return stripped.split("\\s");
	}
	
	/**
	 * Receives a file as input and passes it to the processFile method in ProcessInput.
	 */
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
		

		}
}



