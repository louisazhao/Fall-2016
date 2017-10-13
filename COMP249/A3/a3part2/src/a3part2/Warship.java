package a3part2;

//---------------------------------------------------
//Assignment 3
//Part: 2
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**The Warship class has 6 private instance variables and 3 constructors,
 * which are default constructor, constructor that takes parameters and copy constructor.
 * It also has corresponding accessor and mutator methods for all instance variables.
 * In the end it has a toString() method and an equals() method.
 * @author Rui Zhao
 *
 */
public class Warship {

	//instance variables
	private long serialNumber;
	private String name;
	private int creationYear;
	private String ownerCountry;
	private double price;
	private int speed;
	
	//default constructor
	public Warship()
	{
		this.serialNumber=0;
		this.name=null;
		this.creationYear=0;
		this.ownerCountry=null;
		this.price=0.0;
		this.speed=0;
	}
	
	//constructor that takes parameters
	public Warship(long s, String n, int c, String o, double p, int speed)
	{
		this.serialNumber=s;
		this.name=n;
		this.creationYear=c;
		this.ownerCountry=o;
		this.price=p;
		this.speed=speed;
	}
	
	//copy constructor
	public Warship(Warship anotherOne)
	{
		this.serialNumber=anotherOne.serialNumber;
		this.name=anotherOne.name;
		this.creationYear=anotherOne.creationYear;
		this.ownerCountry=anotherOne.ownerCountry;
		this.price=anotherOne.price;
		this.speed=anotherOne.speed;
	}
	
	//accessor and mutator methods
	public long getSerialNumber()
	{
		return serialNumber;
	}
	
	public void setSerialNumber(long newOne)
	{
		this.serialNumber=newOne;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String newOne)
	{
		this.name=newOne;
	}
	
	public int getCreationYear()
	{
		return creationYear;
	}
	
	public void setCreationYear(int newOne)
	{
		this.creationYear=newOne;
	}
	
	public String getOwnerCountry()
	{
		return ownerCountry;
	}
	
	public void setOwnerCountry(String newOne)
	{
		this.ownerCountry=newOne;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double newOne)
	{
		this.price=newOne;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int newOne)
	{
		this.speed=newOne;
	}
	
	//toString method
	public String toString()
	{
		return ("This warship named "+name+" is belonged to "+ownerCountry+". It was built in "+creationYear+", its serial number is "
				+serialNumber+". Its speed is "+speed+". Its price is "+price+".");
	}
	
	//equals method
	public boolean equals(Object anotherOne)
	{
		if (anotherOne==null)
			return false;
		else if(anotherOne.getClass()!=this.getClass())
			return false;
		else
		{
			Warship anotherWarship=(Warship)anotherOne;
			return (serialNumber==anotherWarship.serialNumber&&name.equals(anotherWarship.name)&&creationYear==anotherWarship.creationYear
					&&ownerCountry.equals(anotherWarship.ownerCountry)&&price==anotherWarship.price&&speed==anotherWarship.speed);
		}
	}
}
