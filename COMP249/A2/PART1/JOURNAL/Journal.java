package journal;

import paperPublication.PaperPublication;

//---------------------------------------------------
//Assignment 2
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

public class Journal extends PaperPublication{
	
	/**
	 * instance variables
	 *all instance variables are private and can only be accessed by accessor methods
	 */
	private int issueNumber;
	private String specialityField;
	
	/**
	 * default constructor
	 */
	public Journal()
	{
		super();
		this.issueNumber=0;
		this.specialityField=null;
	}
	
	/**
	 * constructor with parameters
	 * @param p price
	 * @param n numberOfPages
	 * @param i issueNumber
	 * @param s specialityField
	 */
	public Journal(double p, int n, int i, String s)
	{
		super(p,n);
		this.issueNumber=i;
		this.specialityField=s;
	}
	
	/**
	 * copy constructor
	 * @param anotherOne passed object
	 */
	public Journal(Journal anotherOne)
	{
		super(anotherOne.getPrice(),anotherOne.getNumberOfPages());
		this.issueNumber=anotherOne.getIssueNumber();
		this.specialityField=anotherOne.getSpecialityField();
	}
	
	/**
	 * accessor method
	 * @return issueNumber
	 */
	public int getIssueNumber()
	{
		return issueNumber;
	}
	
	/**
	 * accessor method
	 * @return specialityField
	 */
	public String getSpecialityField()
	{
		return specialityField;
	}
	
	/**
	 * mutator method
	 * @param newIssueNumber  new issue  number
	 */
	public void setIssueNumber(int newIssueNumber)
	{
		this.issueNumber=newIssueNumber;
	}
	
	/**
	 * mutator method
	 * @param newSpeciality new specialityField
	 */
	public void setSpecialityField(String newSpeciality)
	{
		this.specialityField=newSpeciality;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return "This journal has "+getNumberOfPages()+", and it costs "+getPrice()+"$. Its issue number is "
				+getIssueNumber()+". Its speciality field is "+getSpecialityField()+".";
	}
	
	/**
	 * equals method
	 *returns false when the passed object is null or belongs to different class from the calling object
	 *returns true when the two objects belong to the same class and have the same value for every attribute
	 */
	public boolean equals(Object oneObject)
	{
		if (this==null||oneObject==null||this.getClass()!=oneObject.getClass())
		{
			return false;
		}
		else
		{
			Journal j=(Journal) oneObject;
			return (this.getPrice()==j.getPrice()&&this.getNumberOfPages()==j.getNumberOfPages()&&
					this.issueNumber==j.issueNumber&&this.specialityField.equals(j.specialityField));
		}
	}

}//End of Journal class
