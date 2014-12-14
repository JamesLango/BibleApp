import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
// Folder name check it is directory
// if location of folder given is valid.

public class ProcessInput
{
private final String[] validCommands = {"help", "exit", "count", "verses", "location", "findChapter", "findRange", "findVerse"};
private String commandWord;
private BibleStore bStore;
private String commandArr[];
private boolean running = true;


	public ProcessInput()
	{
	//wordSet = bs.getMap();
	}


	public void processCommand(String[] commandArr)
	{
		commandWord = commandArr[0];
		this.commandArr = commandArr;
		
		if(validCommand())
		{
			if(commandWord.equals("help"))
			{
				outputHelp();
			}
			
			else if (commandWord.equals("exit"))
			{
				exit(); 
			}
			
			else if(commandWord.equals("count"))
			{
				if(this.commandArr[1] != null)
				{
					// if(bStore.containsWord(commandArr[1]))
					{
						//System.out.print((bStore.get(commandString[1])).getWordCount());
					}
					
					//else
					{
						System.out.print("The word was not found.");
					}
				}
				
				else
				{
					//errorMessage();
				}
					
				}
			}
			
			else if(commandWord.equals("verses"))
			{
				//if(bStore.containsWord(commandArr[1]))
					{
						System.out.print(bStore.getWord(commandArr[1]).getVerses()); // >>>>need a method in Word to output the verses 
						// fix
					}
					
					//else
					{
						System.out.print("The word was not found.");
					}
			}
					
			else if(commandWord.equals("location"))
			{
				//if(bStore.containsKey(commandArr[1]))
				{
					//System.out.print(bStore.getLocation(commandArr[1]).getVerses()); // need a method in Word to output the verses 
				}
					
				//else
				{
					System.out.print("The word was not found.");
				}	
			}
			
			
	}
	
	
	public void outputHelp()
	{
		System.out.println("To use this program please take note and make use of the following commands,");
		System.out.println("please ensure to use the actual words instead of the place holder values given,");
		System.out.println("which are in <angle brackets> These are used as a technique used to show the user the format in which ");
		System.out.println("the program expects to receive input.");
		System.out.println("To view this message again at any point please type help.");
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
		System.out.println("That command could not be recognised. Please try again. Type "help" for a help menu.");
	}
	
	
	
	public boolean validCommand()
	{
		for(int i=0; i<=validCommands.length; i++)
		{
			if(commandWord.equals(validCommands[i]))
			{
				return true;	
			}
		}
		
		return false;
	}
}
