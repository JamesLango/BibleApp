import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

/**
 * A class to process the user input from the TUI, and use it to subsequently run retrieval commands on
 * the underlying bible data structure.
 */
public class ProcessInput
{
	// an array of the valid commands the program accepts
	private final String[] validCommands = {"help", "exit", "count", "verses", "location", "findchapter", "findrange", "findverse"};
	// the first word in the array is the command word
	private String commandWord;
	//
	private BibleSearch bSearch;
	private String commandArr[];
	private boolean running = true;


	public ProcessInput()
	{
		bSearch = new BibleSearch();
	}


	public void processCommand(String[] commandArr)
	{
		commandWord = commandArr[0];
		this.commandArr = commandArr;
		System.out.println(commandWord);
		
		if(validCommand())
		{
			if(commandWord.equals("help"))
			{
				outputHelp();
			}
			
			if (commandWord.equals("exit"))
			{
				exit(); 
			}
			
			
			if(commandWord.equals("count"))
			{
				if(this.commandArr[1] != null)
				{
					if(bSearch.containsWord(commandArr[1]))
					{
						long start = System.nanoTime();
						System.out.println(commandArr[1]+" appears: " + (bSearch.getWordCount(commandArr[1]))+" times.");
						long end = System.nanoTime();
						long retrieve = end - start;
						System.out.println("That command took: "+retrieve/1000+"ms.");
					}
					
					else
					{
						System.out.print("The word was not found.");
					}
				}
				
				else
				{
					errorMessage();
				}
					
			}
			
			if(commandWord.equals("verses"))
			{
				if(bSearch.containsWord(commandArr[1]))
				{
					long start = System.nanoTime();
					String retrieval = bSearch.getVerses(commandArr[1]);
					long end = System.nanoTime();
					long retrieve = end - start;
					
					System.out.println("The verses in which "+commandArr[1] + " occurs:\n"+retrieval);

					System.out.println("That command took: "+retrieve/1000+"ms.");
				}
					
				else
				{
					System.out.print("The word was not found.");
				}
			}
					
			if(commandWord.equals("location"))
			{
				System.out.print("Retrieving location of:"+commandArr[1]+"\n");
				if(bSearch.containsWord(commandArr[1]))
				{
					long start = System.currentTimeMillis();
					String retrieval = bSearch.getLocations(commandArr[1]);
					long end = System.currentTimeMillis();
					
					long retrieve = end - start;
					
					System.out.print("Locations in which "+commandArr[1]+ " occurs:\n"+retrieval);
					System.out.println("That command took: "+ retrieve +"ms.");
					
				}
					
				else
				{
					System.out.print("The word was not found.");
				}	
			}
		
			if(commandWord.equals("findchapter"))
			{
				if(commandArr.length == 3 && commandArr[1]!=null && commandArr[2]!=null)
				{
					System.out.println(bSearch.findChapter(commandArr[1], commandArr[2]));
				}		
				else
				{
						errorMessage();
				}
			}
		
			if(commandWord.equals("findrange"))
			{
				if(commandArr.length == 5 && commandArr[1]!=null && commandArr[2]!=null && commandArr[3]!=null && commandArr[4]!=null)
				{
					System.out.println(bSearch.findRange(commandArr[1],commandArr[2],commandArr[3],commandArr[4]));
				}
				
				else
				{
					errorMessage();
				}
			}
			
			if(commandWord.equals("findverse"))
			{
				if(commandArr.length == 4 && commandArr[1]!=null && commandArr[2]!=null && commandArr[3]!=null)
				{
					System.out.println(bSearch.findVerse(commandArr[1],commandArr[2],commandArr[3]));
				}
				
				else
				{
					errorMessage();
				}
			}
	}
		else {
			errorMessage();
		}
	}
	
	public void processFile(String folder)
	{
		bSearch.getBibleStore().populateBible(folder);
	}
	
	
	public void outputHelp()
	{
		System.out.println("|********************************************************************************************************|");
		System.out.println("| To use this program please take note and make use of the following commands,                           |");
		System.out.println("| please ensure to use the actual words instead of the place holder values given,                        |");
		System.out.println("| which are in <angle brackets> These are used as a technique used to show the user the format in which  |");
		System.out.println("| the program expects to receive input.                                                                  |");
		System.out.println("| To view this message again at any point please type help.                                              |");
		System.out.println("| Type exit to exit this program.                                                                        |");
		System.out.println("| Type count <word> to view the amount of times that word has occured.                                   |");
		System.out.println("| Type verses <word> to view the verses in which a certain word occurs.                                  |");
		System.out.println("| Type location <word> to view a list of all the locations in which the specified word occurs.           |");
		System.out.println("| Type findChapter <Book Chapter> to view a complete chapter at that location.                           |");
		System.out.println("| Type findVerse <Book Chapter: Verse> to display a specific verse at that location.                     |");
		System.out.println("| Type findRange <Book Chapter: startVerse - endVerse> to display a list of verses within that range.    |");
		System.out.println("**********************************************************************************************************");
	}
	
	
	
	public void exit()
	{
		running = false;
	}
	
	public boolean running()
	{
		return running;
	}
	
	public void errorMessage()
	{
		System.out.println("That command could not be recognised. Please try again. Type 'help' for a help menu.");
	}
	
	
	
	public boolean validCommand()
	{
		for(int i=0; i<validCommands.length; i++)
		{
			if(commandWord.equals(validCommands[i]))
			{
				return true;	
			}
		}
		
		return false;
	}
}
