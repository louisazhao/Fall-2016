package diver;

import book.*;
import journal.Journal;
import magazine.Magazine;
import magazine.Magazine.IssueFrequency;
import magazine.Magazine.PaperQuality;
import paperPublication.PaperPublication;

//---------------------------------------------------
//Assignment 2
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

public class Diver {

	
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
		
	//display every object using toString method
	System.out.println(p1);
	System.out.println(p2);
	System.out.println(m1);
	System.out.println(m2);
	System.out.println(j1);
	System.out.println(j2);
	System.out.println(b1);
	System.out.println(b2);
	System.out.println(c1);
	System.out.println(c2);
	System.out.println(e1);
	System.out.println(e2);
		
	//some tests of equals method
	if (c1.equals(e1))
		System.out.println("This is the same children book.");
	else 
		System.out.println("These two are different.");
	
	if(p1.equals(m1))
		System.out.println("This is the same paper publication.");
	else
		System.out.println("These two are different.");
	
	if(j1.equals(j2))
		System.out.println("This is the same journal.");
	else
		System.out.println("These two are different.");
	
	if(c1.equals(c2))
		System.out.println("This is the same children book.");
	else 
		System.out.println("These two are different.");
		
	//create an array and put 10 object into it
	PaperPublication[] array1=new PaperPublication[10];
	array1[0]=p1;
	array1[1]=p2;
	array1[2]=m1;
	array1[3]=m2;
	array1[4]=j1;
	array1[5]=b1;
	array1[6]=b2;
	array1[7]=c1;
	array1[8]=e1;
	array1[9]=e2;
	
	//compare the objects in this array and display the objects that is the least and most expansive.
	double lowestPrice=array1[0].getPrice();
	int index1=0;
	for (int i=0;i<array1.length;i++)
	{
		if (array1[i].getPrice()<lowestPrice)
			{
			lowestPrice=array1[i].getPrice();
			index1=i;
			}
	}
	System.out.println("The object that is the least expensive has the index "+index1+" in this array.Here is its information:\n "
			+array1[index1]);
	
	double highestPrice=array1[0].getPrice();
	int index2=0;
	for (int i=0;i<array1.length;i++)
	{
		if (array1[i].getPrice()>highestPrice)
		{
		highestPrice=array1[i].getPrice();
		index2=i;
		}
	}
	System.out.println("The object that is the most expensive has the index "+index2+" in this array.Here is its information:\n "
			+array1[index2]);
	
	
	
	}//end of the main method

}//end of the Diver class
