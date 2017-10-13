package a3part1;
//---------------------------------------------------
//Assignment 3
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * abstract class Package
 * @author Rui Zhao
 *
 */
public abstract class Package {
	//instance variables
	private int trackingNumber;
	private double weight;
	private double shipCost;
	
	/**
	 * default constructor
	 */
	public Package()
	{
		trackingNumber=0;
		weight=0.0;
		shipCost=0.0;
	}
	
	/**
	 * constructor that takes parameters
	 * @param n trackingNumber
	 * @param w weight
	 */
	public Package(int n, double w)
	{
		trackingNumber=n;
		weight=w;
	}
	
	/**
	 * accessor method
	 * @return trackingNumber
	 */
	public int getTrackingNumber()
	{
		return trackingNumber;
	}
	
	/**
	 * mutator method
	 * @param l new trackingNumber
	 */
	public void setTrackingNumber(int l)
	{
		trackingNumber=l;
	}
	
	/**
	 * accessor method
	 * @return weight
	 */
	public double getWeight()
	{
		return weight;
	}
	
	/**
	 * mutator method
	 * @param newOne new Weight
	 */
	public void setWeight(double newOne)
	{
		weight=newOne;
	}
	
	/**
	 * abstract  method getShipCost
	 */
	public abstract double getShipCost();
	
	/**
	 * mutator method
	 * @param newOne new shipCost
	 */
	public void setShipCost(double newOne)
	{
		shipCost=newOne;
	}
	
	/**
	 * toOunces method
	 * will take a double number and convert it into ounce
	 * @param a weight in pound
	 * @return weight in ounce
	 */
	public double toOunces(double a)
	{
		return a*16.0;
	}
	
	/**
	 * toPounds method
	 * will take a double number and convert it into pound
	 * @param a weight in ounce
	 * @return weight in pound
	 */
	public double toPounds(double a)
	{
		return a/16.0;
	}
	
}//end of class
