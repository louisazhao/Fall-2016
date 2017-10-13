package a3part2;

//---------------------------------------------------
//Assignment 3
//Part: 2
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * DuplicateSerialNumberException is a derived class from Exception class
 * It has two constructors, and a getMessage method.
 * @author Rui Zhao
 *
 */
public class DuplicateSerialNumberException extends Exception{
	
	//default constructor, using "super"
	public DuplicateSerialNumberException()
	{
		super("Duolicate serial number detected!");
	}
	
	//constructor that is able to take a string as parameter, using "super"
	public DuplicateSerialNumberException(String s)
	{
		super(s);
	}
	
	//getMessage method
	public String getMessage()
	{
		return super.getMessage();
	}

}
