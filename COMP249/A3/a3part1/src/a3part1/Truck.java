package a3part1;
//---------------------------------------------------
//Assignment 3
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * Truck class has 3 constructors, accessor and mutator methods and toString method.
 * @author Rui Zhao
 *
 */
public class Truck {

	//instance variables
	public static final int MAX_NUMBER=5;
	private String diverName, oriCity, desCity;
	private int numberOfPackage;
	private double grossWeight, unloadedWeight;
	Package[] packageArr=new Package[MAX_NUMBER];
	private double grossIncome;
	
	/**
	 * default constructor
	 */
	public Truck()
	{
		this.diverName=null;
		this.oriCity=null;
		this.desCity=null;
		this.unloadedWeight=0;
	}
	
	/**
	 * constructor that takes parameters
	 * @param name diver's name
	 * @param oriCity originating city
	 * @param desCity destination city
	 * @param w weight
	 */
	public Truck(String name, String oriCity, String desCity, double w)
	{
		this.diverName=name;
		this.oriCity=oriCity;
		this.desCity=desCity;
		this.unloadedWeight=w;
	}
	
	/**
	 * copy constructor
	 * @param anotherOne another object of Truck
	 */
	public Truck(Truck anotherOne)
	{
		this.diverName=anotherOne.diverName;
		this.oriCity=anotherOne.oriCity;
		this.desCity=anotherOne.desCity;
		this.unloadedWeight=anotherOne.unloadedWeight;
	}
	
	/**
	 * accessor method
	 * @return diverName
	 */
	public String getDiverName()
	{
		return diverName;
	}
	
	/**
	 * mutator method
	 * @param s new diverName
	 */
	public void setDiverName(String s)
	{
		this.diverName=s;
	}
	
	/**
	 * accessor method
	 * @return oriCity
	 */
	public String getOriCity()
	{
		return oriCity;
	}
	
	/**
	 * mutator method
	 * @param s new oriCity
	 */
	public void setOriCity(String s)
	{
		this.oriCity=s;
	}
	
	/**
	 * accessor method
	 * @return desCity
	 */
	public String getDesCity()
	{
		return desCity;
	}
	
	/**
	 * mutator method
	 * @param s new desCity
	 */
	public void setDesCity(String s)
	{
		this.desCity=s;
	}
	
	/**
	 * accessor method
	 * @return unloadedWeight
	 */
	public double getUnloadedWeight()
	{
		return unloadedWeight;
	}
	
	/**
	 * mutator method
	 * @param w new unloadedWeight
	 */
	public void setUnloadedWeight(double w)
	{
		this.unloadedWeight=w;
	}
	
	/**
	 * accessor method
	 * @return numberOfPackage
	 */
	public int getNumberOfPackage()
	{
		return numberOfPackage;
	}
	/**
	 * mutator method
	 * @param n new numberOfPackage
	 */
	public void setNumberOfPackage(int n)
	{
		this.numberOfPackage=n;
	}
	
	/**
	 * getGrossWeight method
	 * will calculate the grossWeight of the truck, which include the unload weight of the truck 
	 * and total weight of loaded packages
	 * @return grossWeight
	 */
	public double getGrossWeight()
	{
		grossWeight=unloadedWeight;
		for(int i=0;i<CargoTest.arrayIndex;i++)
		{
			
			grossWeight+=packageArr[i].getWeight();
		}
		return grossWeight;
	}

	/**
	 * getGrossIncome method
	 * will calculate the total shipping cost of loaded packages
	 * @return grossIncome
	 */
	public double getGrossIncome()
	{
		for(int i=0;i<CargoTest.arrayIndex;i++)
		{
			grossIncome+=packageArr[i].getShipCost();
		}
		return grossIncome;
	}

	/**
	 * toKilograms method
	 * will take a double number and convert to kilogram
	 * @param a weight in pound
	 * @return weight in kilogram
	 */
	public static double toKilograms(double a)
	{
		return a/2.2046;
	}
	
	/**
	 * toPounds method
	 * will take a double number and convert it to pound
	 * @param a weight in kilogram
	 * @return weight in pound
	 */
	public static double toPounds(double a)
	{
		return a*2.2046;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return ("This truck has been assigned "+diverName+" as its diver. Its unloaded weight is "+unloadedWeight+" pounds, that is "+
	toKilograms(unloadedWeight)+" kilograms. After loaded, its gross weight is "+grossWeight+" pounds, that is "
	+toKilograms(grossWeight)+" kilograms. The gross income earned by this truck during this shipment is $"+grossIncome+".");
	}
}

