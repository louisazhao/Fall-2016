package paperPublication;

//---------------------------------------------------
//Assignment 2
//Part: 2
//Written by: Rui Zhao 40018813
//-----------------------------------------------------


public class PaperPublication {

    /**
     * Instance variables
     *All instance variables are private and can only be accessed by accessor method.
     */
	private double price;
	private int numberOfPages;

	/**
	 * default constructor
	 */
	public PaperPublication()	
	{
		this.price=0.0;
		this.numberOfPages=0;
	}
	
	/**
	 * constructor with parameters
	 * @param p price
	 * @param n numberOfPages
	 */
	public PaperPublication(double p, int n)
	{
		this.price=p;
		this.numberOfPages=n;
	}
	
	/**
	 * copy constructor
	 * @param anotherOne passed object
	 */
	public PaperPublication(PaperPublication anotherOne)
	{
		if(anotherOne!=null)
		{
		this.price=anotherOne.getPrice();
		this.numberOfPages=anotherOne.getNumberOfPages();
		}
	}
	
	/**
	 * Accessor method
	 * @return price
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * Accessor method
	 * @return numberOfPages
	 */
	public int getNumberOfPages()
	{
		return numberOfPages;
	}
	
	/**
	 * mutator method
	 * @param newPrice new Price
	 */
	public void setPrice(double newPrice)
	{
		this.price=newPrice;
	}
	
	/**
	 * mutator method
	 * @param newNumberOfPages new numberOfPages
	 */
	public void setNumberOfPages(int newNumberOfPages)
	{
		this.numberOfPages=newNumberOfPages;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return "This paper publication has "+getNumberOfPages()+", and costs "+getPrice()+"$.";
	}
	
	/**
	 * equals method
	 * returns false when the passed object is null or belongs to different class from the calling object
	 * returns true when the two objects belong to the same class and have the same value for every attribute
	 */
	public boolean equals(Object oneObject)
	{
		if (oneObject==null||this==null||this.getClass()!=oneObject.getClass())
		{
			return false;
		}
		else 
		{
			PaperPublication p=(PaperPublication) oneObject;
			return (this.price==p.price&&this.numberOfPages==p.numberOfPages);
		}
	}
	
	/**
	 * clone method
	 * create and return a new PaperPublication using the copy constructor
	 */
	public PaperPublication clone()
	{
		return new PaperPublication(this);
	}
	
	
}//End of PaperPublication class
