package a4_40018813_part1;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.text.DecimalFormat;

//---------------------------------------------------
//Assignment 4
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * test class, works as driver
 * @author Rui Zhao
 *
 */
public class Test {
	
	private static int numberOfWordToken,numberOfHappax,numberOfStopWord,wordType;
	private static ArrayList<Word> originalArr;

	/**
	 * main method
	 * @param args main method parameter
	 */
	public static void main(String[] args) {
		System.out.println("Please enter the name of the file, on which you want to test Zipf's law.");
		Scanner input=new Scanner(System.in);
		String filename=input.nextLine();	
		Scanner inputStream=null;
		originalArr=new ArrayList<Word>();	
		try
		{
			inputStream=new Scanner(new FileInputStream(filename));
			while (inputStream.hasNext())
			{
				String oneString=inputStream.next();
				if (isWord(oneString))
				{
					Word newOne=new Word(oneString);
				    originalArr.add(newOne);
				    numberOfWordToken++;
				}	
			}
		}
		catch(FileNotFoundException e)//handle the FileNotFoundException
		{
			System.out.println("Problem with opening the file,system will terminate.");
			System.exit(0);
		}
		catch(IOException e1)//handle IPException
		{
			System.out.println("Problem with reading the file,system will terminate.");
			System.exit(0);
		}
		inputStream.close();

		deleteDuplicate(originalArr);
		sortArr(originalArr);
		calculate(originalArr);
		displayArr(originalArr);
		
		DecimalFormat df=new DecimalFormat("#0.00");
		double perOfHappax=(double)numberOfHappax/wordType*100;
		double perOfStop=(double)numberOfStopWord/wordType*100;
		double happaxAccount=(double)numberOfHappax/numberOfWordToken*100;
		double stopAccount=(double)numberOfStopWord/numberOfWordToken*100;
		
		System.out.println("Number of word tokens: "+numberOfWordToken);
		System.out.println("Number of word types: "+wordType);
		
		
		System.out.println("\nNumber of Happax: "+numberOfHappax);
		System.out.println("% of Happax: "+df.format(perOfHappax)+"%.");
		System.out.println("Happax account for: "+df.format(happaxAccount)+"% of the text.");
		
		System.out.println("\nNumber of stop words: "+numberOfStopWord);
		System.out.println("% of Happax: "+df.format(perOfStop)+"%.");
		System.out.println("Stop words account for: "+df.format(stopAccount)+"% of the text.");
		
	}//end of main

	/**
	 * isWord method
	 * verify if a string only contains letters
	 * @param s string
	 * @return true if only contains letters
	 */
	public static boolean isWord(String s)//to verify if the string read by Scanner is a word or not
	{
		char [] chars=s.toCharArray();
		for(char c : chars)
		{
			if(!Character.isLetter(c))
				{return false;}
		}
		return true;
	}
	
	/**
	 * displayArr method
	 * @param a ArrayList
	 */
	public static void displayArr(ArrayList<Word> a)
	{
		System.out.println("-------------------------------------------------");
		System.out.println("Rank            Frequency               Word");
		System.out.println("-------------------------------------------------");
		for(int i=0;i<a.size();i++)
			{
			System.out.printf("%-20d",(i+1));
			System.out.printf("%-20d",a.get(i).getFrequency());
			System.out.println(a.get(i).getContent());
			}
		System.out.println("-------------------------------------------------");
	}
	
	/**
	 * deleteDuplicate method
	 * detect duplicate entries in arrayList, delete them and increase the frequency
	 * @param a arrayList
	 */
	public static void deleteDuplicate(ArrayList<Word> a)
	{
		for (int i=0;i<a.size();i++)
		{
			for (int j=i+1;j<a.size();j++)
			{
				if (a.get(i).equals(a.get(j)))
						{
					       a.get(i).increment();//if duplicate, delete from arrayList and increase frequency
					       a.remove(j);
						}
			}
		}
		wordType=a.size();
	}
	
	/**
	 * sortArr method
	 * sort the arrayList according to the frequency of the objects
	 * if two objects have same frequency, sort them according to alphabet order
	 * @param a arrayList
	 */
	public static void sortArr(ArrayList<Word> a)
	{
		for (int i=0;i<a.size();i++)
		{
			for (int j=i+1;j<a.size();j++)
			{
				if (a.get(i).getFrequency()<a.get(j).getFrequency())
				{
					Word w=new Word(a.get(j));
					a.remove(j);
					a.add(i,w);
				}
				else if(a.get(i).getFrequency()==a.get(j).getFrequency())
				{
					if (a.get(i).follow(a.get(j)))
					{
						Word w=new Word(a.get(j));
						a.remove(j);
						a.add(i,w);
					}
				}
			}	
		}
	}
	
	/**
	 * calculate method
	 * calculate the number of stop words and happax
	 * if a word have less than or equal to 4 letters and it appears more than 10 times, it's a stop word
	 * otherwise, it's happax
	 * @param a arrayList
	 */
	public static void calculate(ArrayList<Word> a)
	{
		for (Word w: a)
		{
			if(w.getLength()<=4&&w.getFrequency()>=10)
			{
				numberOfStopWord++;
			}
			else
				numberOfHappax++;
		}
	}
}//end of class
