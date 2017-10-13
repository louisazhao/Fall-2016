package a3part1;

//---------------------------------------------------
//Assignment 3
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * Letter class, derived from Package class
 * @author Rui Zhao
 *
 */
public class Letter extends Package{
	
	public static final double MAX_WEIGHT_LETTER=2.0;
	
	/**
	 * default constructor
	 */
	public Letter()
	{
		super();
	}
	
	/**
	 * constructor that takes parameters
	 * @param t trackingNumber
	 * @param w weight
	 */
	public Letter(int t, double w)
	{
		super(t,w);
	}
	
	/**
	 * copy constructor
	 * @param anotherOne another object of Letter
	 */
	public Letter(Letter anotherOne)
	{
		if (anotherOne!=null)
		{
		this.setTrackingNumber(anotherOne.getTrackingNumber());
		this.setWeight(anotherOne.getWeight());
		this.setShipCost(anotherOne.getShipCost());
		}
	}
	
	/**
	 * getShipCost method
	 * will calculate the shipCost according to weight
	 */
	public double getShipCost()
	{
		this.setShipCost(0.05*toOunces(getWeight()));
		return (0.05*toOunces(getWeight()));
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return("Letter with weight "+this.toOunces(getWeight())+" ounces. Tracking number is "+this.getTrackingNumber()
		+".");
	}
	
	/**
	 * equals method
	 */
	public boolean equals(Object anotherOne)
	{
		if(this==null||anotherOne==null)
			return false;
		else if (this.getClass()!=anotherOne.getClass())
			return false;
		else{
			Letter newOne=(Letter)anotherOne;
			return(this.getTrackingNumber()==newOne.getTrackingNumber()&&this.getWeight()==newOne.getWeight()&&this.getShipCost()==newOne.getShipCost());
		}
	}
	

}
