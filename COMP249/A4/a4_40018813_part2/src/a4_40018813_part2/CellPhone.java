package a4_40018813_part2;

import java.util.Scanner;

//---------------------------------------------------
//Assignment 4
//Part: 2
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * CellPhone class, which has four instance variables and getter and setter methods,
 * clone method, toSrting method and equals method
 * @author Rui Zhao
 *
 */
public class CellPhone implements Cloneable{

	private long serialNum;
	private String brand;
	private int year;
	private double price;

	/**
	 * default constructor
	 */
	public CellPhone()
	{
		serialNum=0;
		brand=null;
		year=0;
		price=0;
	}

	/**
	 * constructor with parameters
	 * @param serialNum serialNumber
	 * @param brand brand
	 * @param year creating year
	 * @param price price
	 */
	public CellPhone(long serialNum, String brand,  double price, int year) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	/**
	 * copy constructor
	 * @param anotherOne another object from CellPhone
	 * @param n new serialNum
	 */
	public CellPhone(CellPhone anotherOne, long n)
	{
		this.brand=anotherOne.brand;
		this.year=anotherOne.year;
		this.price=anotherOne.price;
		this.serialNum=n;
	}
	
	
	/**
	 * @return the serialNum
	 */
	public long getSerialNum() {
		return serialNum;
	}
	/**
	 * @param serialNum the serialNum to set
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * toString method
	 */
	public String toString() {
		return "[" + serialNum + ": " + brand + " " + price + " " + year + "]";
	}
	
	/**
	 * equals method
	 */
	public boolean equals(Object oneObject)
	{
		if(this==null||oneObject==null||this.getClass()!=oneObject.getClass())
			return false;
		else
		{
			CellPhone newOne=(CellPhone) oneObject;
			return (this.brand.equals(newOne.brand)&&this.price==newOne.price&&this.year==newOne.year);
		}
			
	}
	
	/**
	 * clone method
	 * @return the copy of calling object with new serialNum
	 */
	public CellPhone clone()
	{
	   Scanner input=new Scanner(System.in);
	   System.out.println("Please enter the new serial number.");
	   long serialNumber=input.nextLong();
	   if(this.serialNum==serialNumber)
	   {
		   System.out.println("The serial number that you entered is same with previous one, please enter again.");
		   clone();
	   }
	   return new CellPhone(this,serialNumber);
	}
	
	
}
