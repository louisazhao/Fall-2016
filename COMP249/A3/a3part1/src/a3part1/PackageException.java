package a3part1;

//---------------------------------------------------
//Assignment 3
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * PackageException class, derived from Exception class
 * @author Rui Zhao
 *
 */
public class PackageException extends Exception{
	
	/**
	 * default constructor
	 */
	public PackageException()
	{
		super("Problem with loading the package");
	}
	
	/**
	 * constructor that takes a String as parameter
	 * @param s String
	 */
	public PackageException(String s)
	{
		super(s);
	}

	/**
	 * getMessage method
	 */
	public String getMessage()
	{
		return (super.getMessage());
	}
}
