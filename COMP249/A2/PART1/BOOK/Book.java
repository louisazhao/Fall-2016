package book;

import paperPublication.PaperPublication;

//---------------------------------------------------
//Assignment 2
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

public class Book extends PaperPublication{
	
	/**
	 * instance variables
	 *all instance variables are protected and can be seen by the child class and friend class
	 */
	protected long ISBN;
	protected int issueYear;
	protected String title;
	protected String authorName;
	
	/**
	 * default constructor
	 */
	public Book()
	{
		super();
		ISBN=0;
		issueYear=0;
		title=null;
		authorName=null;
	}
	
	/**
	 * constructor with parameters
	 * @param p price
	 * @param n numberOfPages
	 * @param i ISBN
	 * @param y issueYear
	 * @param t title
	 * @param a authorName
	 */
	public Book(double p, int n, long i,int y, String t, String a)
	{
		super(p,n);
		this.ISBN=i;
		this.issueYear=y;
		this.title=t;
		this.authorName=a;
	}
	
	/**
	 * copy constructor
	 * @param anotherBook passed object
	 */
	public Book(Book anotherBook)
	{
		super(anotherBook.getPrice(),anotherBook.getNumberOfPages());
		this.ISBN=anotherBook.getISBN();
		this.issueYear=anotherBook.getIssueYear();
		this.title=anotherBook.getTitle();
		this.authorName=anotherBook.getAuthorName();
	}
	
	/**
	 * accessor method
	 * @return ISBN
	 */
	public long getISBN()
	{
		return ISBN;
	}
	
	/**
	 * accessor method
	 * @return issueYear
	 */
	public int getIssueYear()
	{
		return issueYear;
	}
	
	/**
	 * accessor method
	 * @return title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * accessor method
	 * @return authorName
	 */
	public String getAuthorName()
	{
		return authorName;
	}
	
	/**
	 * mutator method
	 * @param newISBN new ISBN
	 */
	public void setISBN(long newISBN)
	{
		this.ISBN=newISBN;
	}
	
	/**
	 * mutator method
	 * @param newIssueYear new issueYear
	 */
	public void setIssueYear(int newIssueYear)
	{
		this.issueYear=newIssueYear;
	}
	
	/**
	 * mutator method
	 * @param newTitle new title
	 */
	public void setTitle(String newTitle)
	{
		this.title=newTitle;
	}
	
	/**
	 * mutator method
	 * @param newAuthor new authorName
	 */
	public void setAuthorName(String newAuthor)
	{
		this.authorName=newAuthor;
	}

	/**
	 * toString method
	 */
	public String toString()
	{
		return "This book has "+getNumberOfPages()+" pages, and it costs "+getPrice()+"$. Its ISBN is "+getISBN()
		+". It was published in "+getIssueYear()+" by the title \""+getTitle()+"\". Its author is "+getAuthorName()+".";
	}
	
	/**
	 * equals method
	 *returns false when the passed object is null or belongs to different class from the calling object
	 *returns true when the two objects belong to the same class and have the same value for every attribute
	 */
	public boolean equals(Object oneObject)
	{
		if(oneObject==null||this==null||this.getClass()!=oneObject.getClass())
			return false;
	    else 
		{
			Book b=(Book) oneObject;
		    return (this.getPrice()==b.getPrice()&&this.getNumberOfPages()==b.getNumberOfPages()&&this.ISBN==
		    		b.ISBN&&this.issueYear==b.issueYear&&this.title.equals(b.title)&&
		    		this.authorName.equals(b.authorName));
		}
	}
	
}//End of Book class
