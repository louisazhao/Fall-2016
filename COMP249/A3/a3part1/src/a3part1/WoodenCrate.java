package a3part1;
//---------------------------------------------------
//Assignment 3
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * WoodenCrate class, derived from Crate class
 * @author Rui Zhao
 *
 */
public class WoodenCrate extends Crate {
	
public static final double MAX_WEIGHT_WOODEN_CRATE=80.0;

	/**
	 * default constructor
	 */
	public WoodenCrate()
	{
		super();
	}
	
	/**
	 * constructor that takes parameters
	 * @param t trackingNumber
	 * @param w weight
	 */
	public WoodenCrate(int t, double w)
	{
		super(t,w);
	}
	
	/**
	 * copy constructor
	 * @param anotherOne another object of WoodenCrate
	 */
	public WoodenCrate(WoodenCrate anotherOne)
	{
		if(anotherOne!=null)
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
		this.setShipCost(2.50*this.getWeight());
		return (2.50*this.getWeight());
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return("Wooden crate with weight "+this.getWeight()+" pounds. Tracking number is "+this.getTrackingNumber()+".");
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
			WoodenCrate newOne=(WoodenCrate)anotherOne;
			return(this.getTrackingNumber()==newOne.getTrackingNumber()&&this.getWeight()==newOne.getWeight()&&this.getShipCost()==newOne.getShipCost());
		}
	}
	

}//end of class
