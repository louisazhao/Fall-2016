package a4_40018813_part1;

//---------------------------------------------------
//Assignment 4
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * Word class, which implements Comparable interface
 * also use generic to compare two objects from Word class
 * @author Rui Zhao
 *
 */
public class Word implements Comparable<Word>{
	
	//instance variables
	private String content;
	private int frequency;
	
	/**
	 * default constructor
	 */
	public Word()
	{
		content=null;
		frequency=0;
	}
	
	/**
	 * constructor that takes parameters
	 * @param s a string
	 */
	public Word(String s)
	{
		content=s;
		frequency=1;
	}
	
	/**
	 * copy constructor
	 * @param anotherOne another object
	 */
	public Word(Word anotherOne)
	{
		content=anotherOne.content;
		frequency=anotherOne.frequency;
	}
	
	/**
	 * getLength method
	 * @return the length of the content string
	 */
	public int getLength()
	{
		return content.length();
	}
	
	/**
	 * increment method will increase the object's frequency by 1
	 */
	public void increment()
	{
		frequency++;
	}
	
	/**
	 * accessor method
	 * @return content
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * accessor method
	 * @return frequency
	 */
	public int getFrequency()
	{
		return frequency;
	}
	
	/**
	 * mutator method
	 * @param s another string
	 */
	public void setContent(String s)
	{
		content=s;
	}
	
	/**
	 * mutator method
	 * @param i another frequency
	 */
	public void setFrequency(int i)
	{
		frequency=i;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return ("Word \""+content+"\" appears "+ frequency+" times.");
	}
	
	/**
	 * equals method
	 * returns true if two objects are from same class and have same content string
	 */
	public boolean equals(Object anotherOne)
	{
		if(this==null||anotherOne==null||this.getClass()!=anotherOne.getClass())
			return false;
		else
		{
			Word newOne=(Word) anotherOne;
			return (this.content.equals(newOne.content));//two words are equal as long as they have the same content
		}
	}
	
	/**
	 * implement compareTo method from interface
	 */
	public int compareTo(Word anotherOne)
	{
		return (content.compareTo(anotherOne.content));
	}
	
	/**
	 * follow method
	 * verify if an object follows another one according to their content string
	 * @param anotherOne another object from Word class
	 * @return boolean value
	 */
	public boolean follow (Word anotherOne)
	{
		return (content.compareTo(anotherOne.content)>0);
	}

}
