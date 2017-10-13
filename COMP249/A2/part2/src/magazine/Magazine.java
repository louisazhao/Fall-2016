package magazine;

import paperPublication.PaperPublication;
//---------------------------------------------------
//Assignment 2
//Part: 2
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

public class Magazine extends PaperPublication{

	/**
	 * Two enum classes 
	 *
	 */
	public enum PaperQuality{HIGH,NORMAL,LOW};
	public enum IssueFrequency{WEEKLY,MONTHLY,YEARLY};
	PaperQuality paper;
	IssueFrequency frequency;
	
	/**
	 * Default constructor
	 */
	public Magazine()
	{
		super();
		this.paper=null;
		this.frequency=null;
	}
	
	/**
	 * Constructor with parameters
	 * @param p price
	 * @param n numberOfPages
	 * @param q1 paperQuality
	 * @param i1 issueFrequency
	 */
	public Magazine(double p, int n, PaperQuality q1, IssueFrequency i1)
	{
		super(p,n);
		this.paper=q1;
		this.frequency=i1;
	}
	
	/**
	 * copy constructor
	 * @param anotherOne passed object
	 */
	public Magazine(Magazine anotherOne)
	{
		super(anotherOne.getPrice(),anotherOne.getNumberOfPages());
		this.paper=anotherOne.paper;
		this.frequency=anotherOne.frequency;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return "This magazine has "+this.getNumberOfPages()+" pages, and it costs "+this.getPrice()+
				"$. It is printed with the "+this.paper+" qulity paper. And it is published "+
				this.frequency+".";
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
			Magazine m=(Magazine) oneObject;
			return (this.getPrice()==m.getPrice()&&this.getNumberOfPages()==m.getNumberOfPages()
					&&this.paper.equals(m.paper)&&this.frequency.equals(m.frequency));
		}
	}
	
	/**
	 * clone method 
	 *create and return a new Magazine using the copy constructor
	 */
	public Magazine clone()
	{
		return new Magazine(this);
	}
	

}//End of Magazine class
