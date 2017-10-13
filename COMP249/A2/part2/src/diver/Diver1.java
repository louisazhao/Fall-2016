package diver;

import book.*;
import journal.Journal;
import magazine.Magazine;
import magazine.Magazine.IssueFrequency;
import magazine.Magazine.PaperQuality;
import paperPublication.PaperPublication;

//---------------------------------------------------
//Assignment 2
//Part: 2
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

public class Diver1 {

	/**
	 * copyBooks method
	 * @param anotherArray passed array
	 * @return copiedArray
	 */
	public static PaperPublication[] copyBooks(PaperPublication[] anotherArray)
	{
		PaperPublication[] copiedArray=new PaperPublication[anotherArray.length];
		for (int i=0;i<copiedArray.length;i++)
		{
			copiedArray[i]= anotherArray[i].clone();
			//create each object of the copied array using the clone method in corresponding class
			//which will invoke the corresponding copy constructor
		}
		return copiedArray;
	}
	
	/**
	 * displayArray method
	 * @param p passed array
	 */
	public static void displayArray(PaperPublication[] p)
	{
		System.out.println("\nHere is the information of paper publications in this array:");
		for (int i = 0; i < p.length; i++)
		{
			System.out.println((i+1) + ". " + p[i]);
			//using loop and the toString method, display every element in the passed array
		}
	}
	
	/**
	 * main method
	 * @param args main method parameter
	 */
	public static void main(String[] args) {
		//create 2 objects from each class, in total 12 objects
	PaperPublication p1=new PaperPublication(50.83,360),
			         p2=new PaperPublication(31.98, 478);
	
	Magazine m1=new Magazine(21.78, 56, PaperQuality.NORMAL, IssueFrequency.WEEKLY),
			m2=new Magazine (34.90, 78, PaperQuality.HIGH, IssueFrequency.MONTHLY);
	
	Journal j1=new Journal(57.89, 120, 76574, "engineering"),
			j2=new Journal(j1);
	
	Book b1=new Book(47.79, 230, 6452894, 2000, "Java Instruction", "Adam King"),
		b2= new Book(67.83, 1908, 7234974, 1997, "Harry Potter", "J.K.Rowling");
	
	ChildrenBook c1=new ChildrenBook(34.68, 590, 2342487, 2011, "Little bunny", "Jane Wills", 5),
			     c2=new ChildrenBook(c1);
	
	EducationalBook e1=new EducationalBook(26.78, 780, 2348759, 2001,"Basic Chemistry", "Willam Chen", 2, "Chemistry"),
			        e2=new EducationalBook(45.90,1090, 1315789, 2016, "Introduction To Modern Art", "James Kim",1,"Arts");
		
	
	//create an array and put 12 objects into it
	PaperPublication[] array2=new PaperPublication[12];
	array2[0]=p1;
	array2[1]=p2;
	array2[2]=m1;
	array2[3]=m2;
	array2[4]=j1;
	array2[5]=j2;
	array2[6]=b1;
	array2[7]=b2;
	array2[8]=c1;
	array2[9]=c2;
	array2[10]=e1;
	array2[11]=e2;
	
	//using copyBooks method to create a copy of the array2
	PaperPublication [] array3=copyBooks(array2);
	
	//display array2 and array3 using displayArray method
	//by using the clone method, we could make a correct copy of the passed array
	displayArray(array2);
	displayArray(array3);
	

	}//end of the main method

}//end of the Diver class
