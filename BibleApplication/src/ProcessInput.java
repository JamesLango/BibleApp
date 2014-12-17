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
	// the bibleSearch object to retrieve data based on input
	private BibleSearch bSearch;
	// the string of the input commands
	private String[] commandArr;
	// whether the program is still running
	private boolean running = true;
	// if an error has occurred - set as false if something is output
	private boolean error = true;

	public ProcessInput()
	{
		bSearch = new BibleSearch();
	}

	/**
	 * Process the input strings from the user.
	 * 
	 * @param commandArr The string array of user input words.
	 */
	public void processCommand(String[] commandArr)
	{
		commandWord = commandArr[0];
		this.commandArr = commandArr;
		
		
		if(validCommand()) // check if the command word is valid
		{
			if(commandWord.equals("help"))
			{
				outputHelp();
			}
			
			if (commandWord.equals("exit"))
			{
				exit(); 
			}
			
			// accepts the input count plus the word to search, will not allow anything other than
			// command <word> the word must be in the bSearch object.
			else if(commandWord.equals("count")) // check if the command word is count
			{
				if(commandArr.length == 2) // ensures there are two commands entered
				{		
					if (this.commandArr[1] != null) // ensures command word is not null
					{
						if(bSearch.containsWord(commandArr[1])) // ensures the word being searched for exists
						{
							long start = System.nanoTime();
							int retrieval = bSearch.getWordCount(commandArr[1]); // retrieves the word from bSearch.
							long end = System.nanoTime();
							
							System.out.println(commandArr[1]+" appears: " + retrieval +" times.");
							
							long retrieve = end - start;
							System.out.println("That command took: "+retrieve/1000+"ms.");
							error = false;
						}
						
						else
						{
							System.out.print("The word was not found.");
						}
					}
				}		
			}
			
			// Retrieves verses that contain the word submitted after this command.
			else if(commandWord.equals("verses"))
			{ 
				if (commandArr.length == 2) // if there are two commands entered.
				{
					if(bSearch.containsWord(commandArr[1])) // if the word being searched for exists.
					{
						long start = System.nanoTime();
						String retrieval = bSearch.getVerses(commandArr[1]); // retrieve the word being searched for.
						long end = System.nanoTime();
						long retrieve = end - start;
						
						System.out.println("The verses in which "+commandArr[1] + " occurs:\n"+retrieval);
	
						System.out.println("That command took: "+retrieve/1000+"ms.");
						
						error = false;
					}
						
					else
					{
						System.out.print("The word was not found.");
					}
				}
			}
			
			// retrieves the all the locations of the word specified after this command.
			if(commandWord.equals("location"))
			{ 
				if (commandArr.length == 2) // ensures there is two commands.
				{
					if(bSearch.containsWord(commandArr[1])) // if the word being searched for exists.
					{
						System.out.print("Retrieving location of:"+commandArr[1]+"\n");
					
						long start = System.currentTimeMillis();
						String retrieval = bSearch.getLocations(commandArr[1]); // retrieve the locations.
						long end = System.currentTimeMillis();
						
						long retrieve = end - start;
						
						System.out.print("Locations in which "+commandArr[1]+ " occurs:\n"+retrieval);
						System.out.println("That command took: "+ retrieve +"ms.");
						
						error = false;
					}
						
					else
					{
						System.out.print("The word was not found.");
					}	
				}
			}
		
			// find the chapter specified in the book and chapter value after this command word.
			if(commandWord.equals("findchapter")) // if the correct command is entered.
			{
				if (commandArr.length == 3) // if there are three commands entered 
				{
					if (bSearch.getBibleStore().containsBook(commandArr[1]) && bSearch.getBibleStore().containsChapter(commandArr[1], commandArr[2]))//if the book and chapter both exists.
					{
						if(commandArr[1]!=null && commandArr[2]!=null) // if both the words entered are not null
						{
							long start = System.nanoTime();
							String retrieval = bSearch.findChapter(commandArr[1], commandArr[2]); // retrieve the chapter
							long end = System.nanoTime();
							
							long retrieve = end - start;
							System.out.print("That command took: "+retrieve+"ms.\n");
							System.out.println("The verse you were looking for: \n" + retrieval+"\n");
							
							error = false;
						}
					}
				}
			}
			
			//find a range of verses specified in the book, chapter and between the verses specified.
			if(commandWord.equals("findrange")) //if the correct commandword is input
			{
				if (commandArr.length == 5) // there must be 5 commands.
				{
					if (bSearch.getBibleStore().containsBook(commandArr[1]) && bSearch.getBibleStore().containsChapter(commandArr[1], commandArr[2])) // if the book and chapter exist.
					{
						if(commandArr[1]!=null && commandArr[2]!=null && commandArr[3]!=null && commandArr[4]!=null) // if all the command entered are not null.
						{
							long start = System.nanoTime();
							String retrieval = bSearch.findRange(commandArr[1],commandArr[2],commandArr[3],commandArr[4]); // retrieve the range of verses
							long end = System.nanoTime();
							
							long retrieve = end - start;
							System.out.println("That command took: "+retrieve+"ms.\n");
							System.out.println("The verses you were looking for :\n" + retrieval + "\n");
							error = false;
							
						}
					}
				}
			}
			
			// finds the verse specified after the command word, book and chapter.
			if(commandWord.equals("findverse")) // if the correct command word is entered
			{
				if (commandArr.length == 4) // correct amount of commands entered
				{
					if (bSearch.getBibleStore().containsBook(commandArr[1]) && bSearch.getBibleStore().containsChapter(commandArr[1], commandArr[2])) // if the book and chapter exist.
					{
						if(commandArr[1]!=null && commandArr[2]!=null && commandArr[3]!=null) // if all of the commands are not null.
						{
							long start = System.nanoTime();
							String retrieval = bSearch.findVerse(commandArr[1],commandArr[2],commandArr[3]); // retireve the verse.
							long end = System.nanoTime();
							
							long retrieve = end - start;
							System.out.println("The verse that you were looking for: \n" +retrieval+"\n");
							System.out.println("That command took :" +retrieve+"ms.\n");
							error = false;
						}
					}
				}
			}
		}
		
		if (error) 
		{
			errorMessage(); // outputs an error message if the user made an error typing it in.
		}
	}
		
	/**
	 * Passes in the folder that the user types into the TUI and is used to populate each bookTree object.
	 * @param folder
	 */
	public void processFile(String folder)
	{
		bSearch.getBibleStore().populateBible(folder);
	}
	
	/**
	 * Method used to output the help method when the uses needs help.
	 */
	public void outputHelp()
	{
		System.out.println("|********************************************************************************************************|");
		System.out.println("| To use this program please take note and make use of the following commands,                           |");
		System.out.println("| please ensure to use the actual words instead of the place holder values given,                        |");
		System.out.println("| which are in <angle brackets> These are used as a technique used to show the user the format in which  |");
		System.out.println("| the program expects to receive input.                                                                  |");
		System.out.println("| To view this message again at any point please type help.                                              |");
		System.out.println("| Type exit to exit this program.                                                                        |");
		System.out.println("|                                                                                                        |");
		System.out.println("| Please ensure you remove the angle brackets which are just placeholders, and ensure you include spaces |");
		System.out.println("| between the different search terms.															         |");
		System.out.println("|                                                                                                        |");
		System.out.println("| Type count <word> to view the amount of times that word has occured.                                   |");
		System.out.println("| Type verses <word> to view the verses in which a certain word occurs.                                  |");
		System.out.println("| Type location <word> to view a list of all the locations in which the specified word occurs.           |");
		System.out.println("| Type findChapter <Book Chapter> to view a complete chapter at that location.                           |");
		System.out.println("| Type findVerse <Book Chapter Verse> to display a specific verse at that location.                      |");
		System.out.println("| Type findRange <Book Chapter startVerse endVerse> to display a list of verses within that range.       |");
		System.out.println("**********************************************************************************************************");
	}
	
	
	/**
	 * Method to take the program out of its running loop, once running becomes false the program ceases to run.
	 */
	public void exit()
	{
		running = false;
	}
	
	/**
	 * Decides whether the program is still running or not.
	 * @return running
	 */
	public boolean running()
	{
		return running;
	}
	
	/**
	 * Outputs an error message to tell the user they have made a mistake.
	 */
	public void errorMessage()
	{
		System.out.println("That command could not be recognised. Please try again. Type 'help' for a help menu.");
	}
	
	
	/**
	 * This method is used to decide whether the value of commandWord is a correct command from the array of validCommands 
	 * to decide whether the command word used is valid.
	 * @return boolean
	 */
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
