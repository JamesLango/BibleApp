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
	private Scanner user_input;
	private static ProcessInput processInput;
	
	public static void main(String[] args)
	{
		processInput = new ProcessInput();
		
		while(processInput.running())
		{
		testInput();
		}
	}
	
	public static void testInput()
	{
		Scanner user_input = new Scanner(System.in);
		System.out.println("Please enter test input");
		userInput = "";
		
		userInput = user_input.nextLine();
		commandString = splitToArray(userInput);
		processInput.processCommand(commandString);
		
	}
	
	public static String[] splitToArray(String s)
	{
		return userInput.split("\\s");
	}

}
