package book;

//---------------------------------------------------
//Assignment 2
//Part: 2
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

public class EducationalBook extends Book{
	
	/**
	 * instance variables
	//private instance variables can only be accessed by accessor method
	 */
	private int editionNumber;
	private String specialityField;
	
	/**
	 * default constructor
	 */
	public EducationalBook()
	{
		super();
		this.editionNumber=0;
		this.specialityField=null;
	}
	
	/**
	 * constructor with parameters
	 * @param p price
	 * @param n numberOfPages
	 * @param i ISBN
	 * @param y issueYear
	 * @param t title
	 * @param a authorName
	 * @param e editionNumber
	 * @param s specialityField
	 */
	public EducationalBook(double p, int n, long i,int y, String t, String a, int e, String s)
	{
		super(p,n,i,y,t,a);
		this.editionNumber=e;
		this.specialityField=s;
	}
	
	/**
	 * copy constructor
	 * @param anotherOne passed object
	 */
	public EducationalBook(EducationalBook anotherOne)
	{
		super(anotherOne.getPrice(),anotherOne.getNumberOfPages(),anotherOne.getISBN(),anotherOne.getIssueYear()
				,anotherOne.getTitle(),anotherOne.getAuthorName());
		this.editionNumber=anotherOne.getEditionNumber();
		this.specialityField=anotherOne.getSpeciality();
	}
	
	/**
	 * accessor method
	 * @return editionNumber
	 */
	public int getEditionNumber()
	{
		return editionNumber;
	}
	
	/**
	 * accessor method
	 * @return specialityField
	 */
	public String getSpeciality()
	{
		return specialityField;
	}
	
	/**
	 * mutator method
	 * @param newEdition new editionNumber
	 */
	public void setEditionNumber(int newEdition)
	{
		this.editionNumber=newEdition;
	}
	
	/**
	 * mutator method
	 * @param newSpeciality new specialityField
	 */
	public void setSpeciality(String newSpeciality)
	{
		if (newSpeciality!=null)
			this.specialityField=newSpeciality;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return "This educational book has "+getNumberOfPages()+" pages. It costs "+getPrice()+"$. Its ISBN is "+getISBN()
		+". It was published in "+getIssueYear()+" by the title \""+getTitle()+"\". Its author is "+getAuthorName()
		+". This is the "+this.editionNumber+" edition. Its speciality is "+this.specialityField+".";
	}
	
	/**
	 * equals method
	 *returns false when the passed object is null or belongs to different class from the calling object
	 *returns true when the two objects belong to the same class and have the same value for every attribute
	 */
	public boolean equals(Object oneObject)
	{
		if (this==null||oneObject==null||this.getClass()!=oneObject.getClass())
		return false;
	    else
	    	{
		      EducationalBook e=(EducationalBook) oneObject;
		      return (this.getPrice()==e.getPrice()&&this.getNumberOfPages()==e.getNumberOfPages()
				     &&this.getISBN()==e.getISBN()&&this.getIssueYear()==e.getIssueYear()&&
				     this.getTitle().equals(e.getTitle())&&this.getAuthorName().equals(e.getAuthorName())
				     &&this.editionNumber==e.editionNumber&&this.specialityField.equals(e.specialityField));
	        }
		
	}
	
	/**
	 * clone method
	 *create and return a new EducationalBook using copy constructor
	 */
	public EducationalBook clone()
	{
		return new EducationalBook(this);
	}
	
	

}//End of EducationalBook class
