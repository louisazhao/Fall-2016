package a4_40018813_part2;
//---------------------------------------------------
//Assignment 4
//Part: 2
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * diver class
 * @author Rui Zhao
 *
 */
public class CellListUtilization {

	/**
	 * main method
	 * @param args main method parameter
	 */
	public static void main(String[] args) {
		CellList listA=new CellList();
		CellList listB=new CellList();
		CellList listC;
		Scanner inputStream=null;
		try
		{
			inputStream=new Scanner(new FileInputStream("Cell_Info.txt"));
			fileToList(inputStream, listA);
			inputStream.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem with opening the file, program will terminate.");
			System.exit(0);
		}
		catch (IOException e)
		{
			System.out.println("Problem with reading the file, program will terminate.");
			System.exit(0);
		}
		
		
		listA.showContents();
		
		//prompt the user to search serial number in the list
		search(listA);
		System.out.println("Do you want to search another serial number? Y/N");
		Scanner input=new Scanner(System.in);
		char s='a';
		s=input.next().toUpperCase().charAt(0);
		while(s=='Y')
		{
			search(listA);
			System.out.println("Do you want to search another serial number? Y/N");
			s=input.next().toUpperCase().charAt(0);
		}
		
		//test the insertAtIndex method
		CellPhone newOne=new CellPhone(7684999, "Blackberry",460.98,2010);
		
		System.out.println("\n\nTest of insertAtIndex method:");
		System.out.println("1.Test if index is bigger than the size of list.");
		listA.insertAtIndex(newOne, 24);//test if index bigger than size
		System.out.println("2.Test if index is 0 (special case).");
		listA.insertAtIndex(newOne, 0);//test if index equals to 0, it's test of addToStart method too
		System.out.println("3.Test of general case.");
		listA.insertAtIndex(newOne, 5);//test to insert in the middle
		System.out.println("The result of above operations.");
		listA.showContents();
		
		System.out.println("\n\nTest of deleteFromIndex method.");
		System.out.println("1.Test if index is negative.");
		listA.deleteFromIndex(-1);//test if index is negative
		System.out.println("2.Test of general case.");
		listA.deleteFromIndex(5);//test delete in the middle
		System.out.println("3.Test if index is 0 (special case).");
		listA.deleteFromIndex(0);//test when index is 0, it's test of deleteFromStart method too
		System.out.println("The result of above operations.");
		listA.showContents();
		System.out.println("\n4. Test on an empty list.");
		listB.deleteFromIndex(0);
		
		System.out.println("\n\nTest of repalceAtIndex method.");
		System.out.println("1. Test if index is 0 (not a special case)");
		listA.replaceAtIndex(newOne, 0);//test if index equals to 0
		System.out.println("2.test of general case");
		listA.replaceAtIndex(newOne,2);//test if index is in the middle
		System.out.println("The result of above operations.");
		listA.showContents();
		System.out.println("\n3. Test on an empty list.");
		listB.replaceAtIndex(newOne, 3);//test if the list is empty
		listB.showContents();
		
		System.out.println("\n\nTest of copy constructor of CellList class");
		System.out.println("==============================================================================");
		listC=new CellList(listA);
		listC.showContents();
		
		System.out.println("\n\nTest of equals method of CellList class");
		System.out.println("==============================================================================");
		if(listC.equals(listA))
			System.out.println("ListA and ListC are equal by equals method.");
		else
			System.out.println("ListA and ListC are not equal by equals method.");
		if(listC.equals(listB))
			System.out.println("ListB and ListC are equal by equals method.");
		else
			System.out.println("ListB and ListC are not equal by equals method.");

	}//end of main method
	
	
	
	/**
	 * fileToList method
	 * copy information from a file into a linked list
	 * @param inputStream input file
	 * @param a list
	 * @throws IOException throws IOException
	 */
	public static void fileToList(Scanner inputStream, CellList a) throws IOException
	{
		while(inputStream.hasNextLine())
		{
			String line=inputStream.nextLine();
			Scanner lineScanner=new Scanner(line);
			long serialNumber=lineScanner.nextLong();
			String brand=lineScanner.next();
			double price=lineScanner.nextDouble();
			int year=lineScanner.nextInt();
			CellPhone newOne=new CellPhone(serialNumber,brand,price,year);
			if(!a.contains(serialNumber))
			{
				a.addToStart(newOne);
			}
		}	
	}
	
	/**
	 * search method
	 * prompt the user to do searching
	 * @param a list
	 */
	public static void search(CellList a)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter a serial number that you want to search:");
		long number=input.nextLong();
		a.contains(number);
	}
	

}//end of class
