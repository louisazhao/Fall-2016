package book;


//---------------------------------------------------
//Assignment 2
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

public class ChildrenBook extends Book{
	
	/**
	 * instance variable 
	 *private instance variable, can only be accessed by accessor method
	 */
	private int minAge;
	
	/**
	 * default constructor
	 */
	public ChildrenBook()
	{
		super();
		minAge=0;
	}
	
	/**
	 * constructor with parameters
	 * @param p price
	 * @param n numberOfPages
	 * @param i ISBN
	 * @param y issueYear
	 * @param t title
	 * @param a authorName
	 * @param age minAge
	 */
	public ChildrenBook(double p, int n, long i,int y, String t, String a, int age)
	{
		super(p,n,i,y,t,a);
		this.minAge=age;
	}
	
	/**
	 * copy constructor
	 * @param anotherOne passed object
	 */
	public ChildrenBook(ChildrenBook anotherOne)
	{
		super(anotherOne.getPrice(),anotherOne.getNumberOfPages(),anotherOne.getISBN(),anotherOne.getIssueYear()
				,anotherOne.getTitle(),anotherOne.getAuthorName());
		this.minAge=anotherOne.minAge;	
	}
	
	/**
	 * accessor method
	 * @return minAge
	 */
	public int getMinAge()
	{
		return minAge;
	}
	
	/**
	 * mutator method
	 * @param newAge new minAge
	 */
	public void setMinAge(int newAge)
	{
		this.minAge=newAge;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return "This children book has "+getNumberOfPages()+" pages, and it costs "+getPrice()+"$. Its ISBN is "+getISBN()
		+". It was published in "+getIssueYear()+" by the title \""+getTitle()+"\". Its author is "+getAuthorName()
		+". It is suitable for age "+this.minAge+" and up.";
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
			ChildrenBook c=(ChildrenBook) oneObject;
			return (this.getPrice()==c.getPrice()&&this.getNumberOfPages()==c.getNumberOfPages()
					&&this.getISBN()==c.getISBN()&&this.getIssueYear()==c.getIssueYear()&&
					this.getTitle().equals(c.getTitle())&&this.getAuthorName().equals(c.getAuthorName())
					&&this.minAge==c.minAge);
		}
	}

	
}//End of ChildrenBook class
