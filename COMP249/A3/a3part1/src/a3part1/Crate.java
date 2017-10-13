package a3part1;
//---------------------------------------------------
//Assignment 3
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * abstract class Crate, derived from Pakage class
 * @author Rui Zhao
 *
 */
public abstract class Crate extends Package{

	/**
	 * default constructor
	 */
	public Crate()
	{
		super();
	}
	
	/**
	 * constructor that takes parameters
	 * @param t trackingNumber
	 * @param w weight
	 */
	public Crate(int t,double w)
	{
		super(t,w);
	}

	/**
	 * abstract method getShipCost
	 */
	public abstract double getShipCost();

}
