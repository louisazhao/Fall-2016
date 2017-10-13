package a3part1;
//---------------------------------------------------
//Assignment 3
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * MetalCrate class, derived from Crate class
 * @author sony
 *
 */
public class MetalCrate extends Crate {

public static final double MAX_WEIGHT_METAL_CRATE=100.0;

	/**
	 * default constructor
	 */
	public MetalCrate()
	{
		super();
	}
	
	/**
	 * constructor that takes parameters
	 * @param t trackingNumber
	 * @param w weight
	 */
	public MetalCrate(int t, double w)
	{
		super(t,w);
	}
	
	/**
	 * copy constructor
	 * @param anotherOne another object of MetalCrate
	 */
	public MetalCrate(MetalCrate anotherOne)
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
	 * will calculate shipCost according to weight
	 */
	public double getShipCost()
	{
		this.setShipCost(3.0*this.getWeight());
		return (3.0*this.getWeight());
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return("Metal crate with weight "+this.getWeight()+" pounds. Tracking number is "+this.getTrackingNumber()+".");
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
			MetalCrate newOne=(MetalCrate)anotherOne;
			return(this.getTrackingNumber()==newOne.getTrackingNumber()&&this.getWeight()==newOne.getWeight()&&this.getShipCost()==newOne.getShipCost());
		}
	}
	

}//end of class
