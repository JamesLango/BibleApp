import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
// Folder name check it is directory
// if location of folder given is valid.

public class ProcessInput
{
private final String[] validCommands = {"help", "exit", "count", "verses", "location", "findchapter", "findRange", "findVerse"};
private String commandWord;
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
		//System.out.println(commandArr[1] + " " + commandArr[2]);
		
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
						System.out.print((bSearch.getWordCount(commandArr[1])));
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
			}
			
			if(commandWord.equals("verses"))
			{
				if(bSearch.containsWord(commandArr[1]))
				{
					bSearch.getVerses(commandArr[1]);
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
					System.out.print(bSearch.getLocations(commandArr[1]));
				}
					
				else
				{
					System.out.print("The word was not found.");
				}	
			}
		
			if(commandWord.equals("findChapter"))
			{
				if(commandArr[1]!=null && commandArr[2]!=null)
				{
					System.out.println(bSearch.findChapter(commandArr[1], commandArr[2]));
				}
				
				else
				{
					errorMessage();
				}
			}
		
			if(commandWord.equals("findRange"))
			{
				if(commandArr[1]!=null && commandArr[2]!=null && commandArr[3]!=null && commandArr[4]!=null)
				{
					System.out.println(bSearch.findRange(commandArr[1],commandArr[2],commandArr[3],commandArr[4]));
				}
				
				else
				{
					errorMessage();
				}
			}
		
			
			
			
	}
	
	public void processFile(String folder)
	{
		bSearch.getBibleStore().populateBible(folder);
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
