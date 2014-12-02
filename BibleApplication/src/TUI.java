/*
 * This class contains code that will take the input from the 
 * user so that it accessible by the scanner class. 
 * It will also allow the program to output text to the user interface.
 */
import java.util.Scanner;

public class TUI {
	
private static Scanner user_input;
private static String test;
	

	public TUI(){
	}
	
	public static void main(String[] args)
	{
		testInput();
	}
	
	public static void testInput()
	{
		Scanner user_input = new Scanner(System.in);
		System.out.println("Please enter test input");
		test = "";

		test = user_input.nextLine();
		
		System.out.print(test);
	}

}
