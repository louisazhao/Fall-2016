package a3part1;
import java.util.Scanner;
//---------------------------------------------------
//Assignment 3
//Part: 1
//Written by: Rui Zhao 40018813
//-----------------------------------------------------

/**
 * CargoTest class, works as the diver
 * @author Rui Zhao
 *
 */
public class CargoTest {

	//instance variables
	public static int arrayIndex=0;
	private static Truck newTruck;
	
	/**
	 * main method
	 * @param args main method parameter
	 */
	public static void main(String[] args) {
		do{
		Scanner input=new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("  1. Start a cargo");
		System.out.println("  2. Load the truck with packages");
		System.out.println("  3. Unload a package");
		System.out.println("  4. The number of packages loaded");
		System.out.println("  5. The gross income earned by shipping of the cargo");
		System.out.println("  6. Weight the truck (after it has been completely loaded");
		System.out.println("  7. Drive the truck to destination");
		System.out.println("  0. To quit");
		System.out.println("Please enter your choice and press <Enter>");
		int choice1=input.nextInt();
		
		switch(choice1)
		{
		case 1://creat the truck
		{
			creatTruck();
			break;
		}
		case 2://load the truck
		{
			if(newTruck!=null)
			{
			char a='a';
			loadTruck();
			System.out.println("Want to load another one? Y/N");
			a=input.next().toUpperCase().charAt(0);
			while (a=='Y')
			{
				loadTruck();
				System.out.println("Want to load another one? Y/N");
				a=input.next().toUpperCase().charAt(0);
			}
			System.out.println("==================================================");
			System.out.println("Finish loading the truck.");
			System.out.println("==================================================");
			}
			else{
				System.out.println("You have not assigned a truck yet.");
			}
			break;
		}
		case 3://unload the truck
		{
			System.out.println("==================================================");
			System.out.println("The truck has been unloaded");
			System.out.println("Here is the information of unloaded packages.");
			System.out.println("==================================================");
			for (int i=0;i<arrayIndex;i++)
			{
				System.out.println(newTruck.packageArr[i]);
				newTruck.packageArr[i]=null;
			}
			System.out.println("\n==================================================\n");
			arrayIndex=0;
			break;
		}
		case 4://get the number of loaded packages
		{
			if(newTruck!=null)
			{
			newTruck.setNumberOfPackage(arrayIndex);
			System.out.println("\n====================================================================\n");
			System.out.println("The number of packages that have been loaded is "+newTruck.getNumberOfPackage());
			System.out.println("====================================================================\n");
			}
			else
			{
				System.out.println("You have not assigned a truck yet.");
			}
			break;
		}
		case 5://get the gross income earned by shipping the cargo
		{
			if(newTruck!=null)
			{
		    System.out.println("\n====================================================================\n");
			System.out.println("The gross income earned by shipping of the cargo is $"+newTruck.getGrossIncome());
			System.out.println("====================================================================\n");
			}
			else
			{
				System.out.println("You have not assigned a truck yet.");
			}
			break;
		}
		case 6://get the gross weight of the truck
		{
			if(newTruck!=null)
			{
			System.out.println("\n====================================================================\n");
			System.out.println("The grossweight of the truck is "+newTruck.getGrossWeight()+" pounds, that is "
					+Truck.toKilograms(newTruck.getGrossWeight())+" kilograms.");
			System.out.println("====================================================================\n");
			}
			else
			{
				System.out.println("You have not assigned a truck yet.");
			}
			break;
		}
		case 7://diver the truck
		{
			if(newTruck!=null)
			{
			System.out.println("\n====================================================================\n");
			System.out.println("The truck has been diven by "+newTruck.getDiverName()+" from "+newTruck.getOriCity()+" to "+newTruck.getDesCity()+".");
			System.out.println("====================================================================\n");
			}
			else
			{
				System.out.println("You have not assigned a truck yet.");
			}
			break;
		}
		case 0://exit
		{
			System.out.println("\n====================================================================\n");
			System.out.println("Thank you for using this program. Have a nice day!");
			System.out.println("====================================================================\n");
			System.exit(0);
		}
			
		}}
		while(true);

	}//End of main method

	/**
	 * creatTruck method
	 * will let the user enter information of the truck
	 * 
	 */
	private static void creatTruck()
	{

		newTruck=new Truck();
		Scanner input=new Scanner(System.in);
		char choice1='o';
		do
		{
		System.out.println("a. Diver name");
		System.out.println("b. Unload weight(kg;lb)");
		System.out.println("c. Originating city");
		System.out.println("d. Destination city");
		choice1=input.next().toLowerCase().charAt(0);
		switch(choice1)
		{
		case 'a':
		{
			System.out.println("Enter the diver's name");
			input.nextLine();
			String name=input.nextLine();
			newTruck.setDiverName(name);
			break;
		}
		case 'b':
		{
			System.out.println("Enter the unload weight");
			double weight=input.nextDouble();
			input.nextLine();
			System.out.println("Enter your measurement unit for this weight, kg for kilogram; lb for pound");
			String measurement= input.next();
			if(measurement.equalsIgnoreCase("kg"))
				{weight=Truck.toPounds(weight);}
			newTruck.setUnloadedWeight(weight);
			break;
		}
		case 'c':
		{
			System.out.println("Enter the originating city"); 
			input.nextLine();
			String oriCity=input.nextLine();
			newTruck.setOriCity(oriCity);
			break;
		}
		case 'd':
		{
			System.out.println("Enter the destination city");
			input.nextLine();
			String desCity=input.nextLine();
			newTruck.setDesCity(desCity);
			break;
		}
		}
		}
		while (newTruck.getDiverName()==null||newTruck.getOriCity()==null||newTruck.getDesCity()==null||newTruck.getUnloadedWeight()==0);

	}//end of creatTruck method
	
	
	/**
	 * loadTruck method
	 * let the user enter the trackingNumber weight of the package
	 * will find out the type of entered package according to the last digit of its tracking number
	 * if weight is less than the maximum possible weight, this package will be loaded, 
	 * otherwise, it will not be loaded, and its information will be displayed
	 */
	private static void loadTruck()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("a. Enter package tracking number");
		int trackingNumber=input.nextInt();
		int lastDigit=trackingNumber%10;
		if (lastDigit==0)//letter
		{
			Letter newLetter=null;
			try{
			newLetter=new Letter();
			newLetter.setTrackingNumber(trackingNumber);
			System.out.println("b. Enter package weight");
			double weight=input.nextDouble();
			System.out.println("Enter your measurement unit for this weight, oz for kilogram; lb for pound");
			String measurement= input.next();
			if(measurement.equalsIgnoreCase("oz"))
				{weight=newLetter.toPounds(weight);}
			newLetter.setWeight(weight);
			if(weight>Letter.MAX_WEIGHT_LETTER)
			{
				throw new PackageException("This package exceeds the maximum weight. Here is its information:");
			}
			System.out.println("c. Package shipping cost is $"+newLetter.getShipCost()+".");
			if ((arrayIndex>=Truck.MAX_NUMBER))
			{
				throw new PackageException("Truck has been fully loaded. This package is not loaded. Here is its information:");	
			}		
			else{
				newTruck.packageArr[arrayIndex]=newLetter;
				arrayIndex++;
			}
			
			}
			catch(PackageException e)
			{
				System.out.println("Problem with loading this package");
				System.out.println(e.getMessage());		
				System.out.println(newLetter);
			}
		}
		else if (lastDigit==1)//box
		{
			Box newBox=null;
			try{
			newBox=new Box();
			newBox.setTrackingNumber(trackingNumber);
			System.out.println("b. Enter package weight");
			double weight=input.nextDouble();
			System.out.println("Enter your measurement unit for this weight, oz for kilogram; lb for pound");
			String measurement= input.next();
			if(measurement.equalsIgnoreCase("oz"))
				{weight=newBox.toPounds(weight);}
			newBox.setWeight(weight);
			if(weight>Box.MAX_WEIGHT_BOX)
			{
				throw new PackageException("This package exceeds the maximum weight. Here is its information");
			}
			System.out.println("c. Package shipping cost is $"+newBox.getShipCost()+".");
			if (arrayIndex>=Truck.MAX_NUMBER)
			{
				throw new PackageException("Truck has been fully loaded. This package is not loaded. Here is its information");
			}
			else
			{
				newTruck.packageArr[arrayIndex]=newBox;
				arrayIndex++;
			}
			}
			catch(PackageException e)
			{
				System.out.println("Problem with loading this package");
				System.out.println(e.getMessage());		
				System.out.println(newBox);
			}
		}
		else if (lastDigit==2)//wooden crate
		{
			WoodenCrate newWoodenCrate=null;
			try{
			newWoodenCrate=new WoodenCrate();
			newWoodenCrate.setTrackingNumber(trackingNumber);
			System.out.println("b. Enter package weight");
			double weight=input.nextDouble();
			System.out.println("Enter your measurement unit for this weight, oz for kilogram; lb for pound");
			String measurement= input.next();
			if(measurement.equalsIgnoreCase("oz"))
				{weight=newWoodenCrate.toPounds(weight);}
			newWoodenCrate.setWeight(weight);
			if(weight>WoodenCrate.MAX_WEIGHT_WOODEN_CRATE)
			{
				throw new PackageException("This package exceeds the maximum weight. Here is its information");
			}
			System.out.println("c. Package shipping cost is $"+newWoodenCrate.getShipCost()+".");
			if (arrayIndex>=Truck.MAX_NUMBER)
			{
				throw new PackageException("Truck has been fully loaded. This package is not loaded. Here is its information");
			}
			else
			{
				newTruck.packageArr[arrayIndex]=newWoodenCrate;
				arrayIndex++;
			}
			}
			catch(PackageException e)
			{
				System.out.println("Problem with loading this package");
				System.out.println(e.getMessage());		
				System.out.println(newWoodenCrate);
			}
		}
		else if(lastDigit==3)//metal crate
		{
			MetalCrate newMetalCrate=null;
			try{
			newMetalCrate=new MetalCrate();
			newMetalCrate.setTrackingNumber(trackingNumber);
			System.out.println("b. Enter package weight");
			double weight=input.nextDouble();
			System.out.println("Enter your measurement unit for this weight, oz for kilogram; lb for pound");
			String measurement= input.next();
			if(measurement.equalsIgnoreCase("oz"))
				{weight=newMetalCrate.toPounds(weight);}	
			newMetalCrate.setWeight(weight);
			if(weight>MetalCrate.MAX_WEIGHT_METAL_CRATE)
			{
				throw new PackageException("This package exceeds the maximum weight. Here is its information");
			}
			System.out.println("c. Package shipping cost is $"+newMetalCrate.getShipCost()+".");
			if (arrayIndex>=Truck.MAX_NUMBER)
			{
				throw new PackageException("Truck has been fully loaded. This package is not loaded. Here is its information");
			}
			else
			{
				newTruck.packageArr[arrayIndex]=newMetalCrate;
				arrayIndex++;
			}
			}
			catch(PackageException e)
			{
				System.out.println("Problem with loading this package");
				System.out.println(e.getMessage());		
				System.out.println(newMetalCrate);
			}
		}
		else//unable to determine the type
		{
			double weight=0;
			String measurement=null;
			try{
				System.out.println("b. Enter package weight");
				weight=input.nextDouble();
				System.out.println("Enter your measurement unit for this weight, oz for kilogram; lb for pound");
			    measurement= input.next();	
				throw new PackageException("Unable to decide the package type. This pack will not be loaded.");
			}
			catch(PackageException e)
			{
				System.out.println(e.getMessage());
				System.out.println("Here is its information");
				System.out.println("The tracking number for this unknown package is "+trackingNumber+". Its weight is "+weight+measurement+".");
			}
			
		}		
	}//end of loadTruck method
	
	
}//End of the class
