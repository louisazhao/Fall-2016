package a3part2;

//---------------------------------------------------
//Assignment 3
//Part: 2
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * WarshipInventory1 class, works as the diver
 * It reads data from a file of warship information, and correct duplicate numbers.
 * The store the correct information to another file. Then it will display the original file and the correct file.
 * @author Rui Zhao
 *
 */
public class WarshipInventory1 {
	//static array 
	private static Warship[] wsArr;

	//main method
	public static void main(String[] args) {
		System.out.println("Please enter the name of output file, which will have correct information:");
		Scanner input=new Scanner(System.in);
		String fileName;
		fileName=input.nextLine();
		File newFile=new File(fileName);
		while (newFile.exists())//if the file with the name entered by user exists, this will promote user enter another one
		{
			System.out.println("Error: There is an existing file called "+fileName);
			System.out.println("The file has already has a size of "+ newFile.length()+" bytes.");
			System.out.println("Please enter another file name to create:");
		    fileName=input.nextLine();
			newFile=new File(fileName);
		}
		
		
		Scanner inputStream = null;
		PrintWriter outputStream=null;
		System.out.println("Attempting to open file Initial_Warship_Info.txt\n");
		
		try{   //3 cases
			inputStream=new Scanner(new FileInputStream("Initial_Warship_Info.txt"));
			System.out.println("Detecting number of records in file Initial_Warship_Info.txt\n");
			int size=getArraySize(inputStream);
			wsArr=new Warship[size];
			if(size==0)//if the file has no data, system will terminate with this information
				{
					System.out.println("The file is empty. No need to do correction");
					System.out.println("Program will terminate.");
					inputStream.close();
					System.exit(0);
				}
					
			else if (size==1)//if the file has one record, system will terminate with this information
				{
					System.out.println("The file only has the imformation of one warship. No need to do correction");
					System.out.println("Program will terminate.");
					inputStream.close();
					System.exit(0);
				}
				
			else 
				{
					System.out.println("The file has "+size+" records.");
					//if the file has more than one record, fixInventory() method will be executed
					inputStream.close();
					try{
						inputStream=new Scanner(new FileInputStream("Initial_Warship_Info.txt"));
						outputStream=new PrintWriter(new FileOutputStream(newFile));
						fixInventory(inputStream, outputStream);
						inputStream.close();
						outputStream.close();
					}
					catch (FileNotFoundException e){
						System.out.println("Problem with opening file "+fileName+". Program will terminate.");
						System.exit(0);
					}
					catch (IOException e)
					{
						System.out.println("Error has occured while reading from files. Program will terminate.");
						System.exit(0);
					}
				
					//display the data of the original file
					System.out.println("All duplicate serial numbers have been corrected, and the correct information has been saved.\n");
					System.out.println("Here are the contents of file Initial_Warship_Info.txt AFTER copying operation\n");
					System.out.println("================================================================================\n");
					try
					{
						inputStream=new Scanner(new FileInputStream("Initial_Warship_Info.txt"));
						displayFileContent(inputStream);
					}
					catch (FileNotFoundException e){
						System.out.println("Problem with opening file. Program will terminate.");
						System.exit(0);}
					catch (IOException e){
						System.out.println("Error has occured while reading from file Initial_Warship_Info.txt. Program will terminate.");
						System.exit(0);
					}
					
					//diplay the data of the correct file
					System.out.println("Here are the contents of file "+ fileName+"\n");
					System.out.println("================================================================================\n");
					try{
						inputStream=new Scanner(new FileInputStream(newFile));
						displayFileContent(inputStream);
					}
					catch (FileNotFoundException e){
						System.out.println("Problem with opening file "+fileName+". Program will terminate.");
						System.exit(0);
					}
					catch (IOException e){
						System.out.println("Error has occured while reading from file "+fileName +". Program will terminate.");
						System.exit(0);
					}
				}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Problem with opening file. Program will terminate.");
			System.exit(0);
		}
		catch (IOException e)
		{
			System.out.println("Error occured while reading from keyboard.");
			System.out.println("Program will terminate.");
			System.exit(0);	
		}
		System.out.println("\n================================================================================");
		System.out.println("Thank you for using this program. Have a nice day!");
		input.close();
		
}//End of main method
		

	//fixInventory method
	public static void fixInventory(Scanner inputStream, PrintWriter outputStream) throws IOException
	{
	
		for (int i=0;i<wsArr.length;i++)
		{ 
			wsArr[i]=new Warship();//fill the array with empty objects using default constructor
			String line=inputStream.nextLine();
			Scanner line_Scanner=new Scanner(line);
			line_Scanner.useDelimiter(" ");
			wsArr[i].setSerialNumber(Long.parseLong(line_Scanner.next()));
			wsArr[i].setName(line_Scanner.next());
			wsArr[i].setCreationYear(Integer.parseInt(line_Scanner.next()));
			wsArr[i].setOwnerCountry(line_Scanner.next());
			wsArr[i].setPrice(Double.parseDouble(line_Scanner.next()));
			wsArr[i].setSpeed(Integer.parseInt(line_Scanner.next()));
			line_Scanner.close();//reading records from original file and then copy them into the array
		}

		//invoke duplicateNumberCorrector method, check any duplicate serial numbers from original file
		//then ask user to enter new numbers. If the new serial number entered is still a duplicate one,
		//ask the user to enter again, until a correct one has been entered.
		try{
			duplicateNumberCorrector(wsArr);
		}
		catch (IOException e)
		{
			System.out.println("Error occured while reading from keyboard.");
			System.out.println("Program will terminate.");
			System.exit(0);	
		}
		//write the correct information into the new file
		for (int i=0;i<wsArr.length;i++)
		{
			outputStream.println(wsArr[i].getSerialNumber()+" "+wsArr[i].getName()+" "+wsArr[i].getCreationYear()+" "
		+wsArr[i].getOwnerCountry()+" "+wsArr[i].getPrice()+" "+wsArr[i].getSpeed()+" ");
		}
	}//end of fixInventory method
	
	//displayFileContent method
	public static void displayFileContent(Scanner inputStream) throws IOException
	{
		while (inputStream.hasNextLine())
		{
			String line=inputStream.nextLine();
			Scanner line_Scanner=new Scanner(line);
			line_Scanner.useDelimiter(" ");
			while (line_Scanner.hasNext())
			{
				System.out.print(line_Scanner.next()+" ");
			}
			System.out.println("\n");
			line_Scanner.close();
		}
		inputStream.close();
	}
	
	
	//getArraySize method
	//get the size of the array according to the number of lines in the file
	private static int getArraySize(Scanner inputStream) throws IOException
	{
		int count=0;
		while(inputStream.hasNextLine())
			{
			count++;
			inputStream.nextLine();
			}
		return count;
	}
	
	//duplicateNumberCorrector method
	//go through the original file and find all duplicate serial numbers then ask user to enter new numbers
	//then the duplicateInputCorrect method will be executed to check if the newly entered serial number is
	//also duplicate to previous ones. If so, ask user to enter again, util a correct one has been entered.
	public static void duplicateNumberCorrector(Warship[] wsArr) throws IOException
	{
		Scanner input=new Scanner(System.in);
		long newSerialNumber=0;
		int index=0;
		for (int i=0;i<wsArr.length;i++)
		{
			index=i+1;
			while (index<wsArr.length)
			{
			
				if (wsArr[i].getSerialNumber()==wsArr[index].getSerialNumber())
				{
						duplicateInputCorrector(index);
						//ask the user to enter new serial number and then check if the newly entered number is a good one		
						index++;
				}
				else
				{
					index++;
				}
			}
		}
	}//end of duplicateNumberCorrector method
	
		
	private static void duplicateInputCorrector(int a) //will handle the DuplicateNumberException by itself
	{
		Scanner input=new Scanner(System.in);
		long newSerialNumber=0;
		System.out.println("Duplicate serial number "+wsArr[a].getSerialNumber()+" detected in record "
				+(a+1)+".Please enter the correct serial number.");	
		try{
		newSerialNumber=input.nextLong();
		for (int i=0;i<wsArr.length;i++)
		{	
				if (newSerialNumber==wsArr[i].getSerialNumber())
				{
				throw new DuplicateSerialNumberException("Initial apperance of serial number "+wsArr[i].getSerialNumber()+" detected in record #"+(i+1));
				//throw DuplicateSerialNumberException if the newly entered one is still duplicate
				}
		}
		wsArr[a].setSerialNumber(newSerialNumber);//otherwise store the correct number
		}
		catch (DuplicateSerialNumberException e)
		{
			System.out.println("Attemp of duplicate Entry to a previous record.");  
			System.out.println(e.getMessage());
			System.out.println("Error...Dupilcate Entry of serial number. The entered serial number exists for  another record.");
			System.out.println("Duplicate serial number "+wsArr[a].getSerialNumber()+" detected in record "
					+(a+1)+".Please enter the correct serial number.");
			newSerialNumber=input.nextLong();
			boolean done=false;
				while (!done)
				//using a while loop to handle the exception, if the user continuously enter duplicate number, the program will go on forever.
				{
					try
					{
						for (int i=0;i<wsArr.length;i++)
						{	
							if (newSerialNumber==wsArr[i].getSerialNumber())
							{
							throw new DuplicateSerialNumberException("Initial apperance of serial number "+wsArr[i].getSerialNumber()+" detected in record #"+(i+1));
							}
						}
					    wsArr[a].setSerialNumber(newSerialNumber);
					    done=true;
				    }
					catch(DuplicateSerialNumberException e1)
					{
						System.out.println("Attemp of duplicate Entry to a previous record.");  
						System.out.println(e1.getMessage());
						System.out.println("Error...Dupilcate Entry of serial number. The entered serial number exists for  another record.");
						System.out.println("Duplicate serial number "+wsArr[a].getSerialNumber()+" detected in record "
								+(a+1)+".Please enter the correct serial number.");
						newSerialNumber=input.nextLong();
					}
				}
			}
	}//end of duplicateInputCorrector method
	
}//end of the class

