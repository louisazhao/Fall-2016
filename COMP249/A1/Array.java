/**
 * @author Zhao Rui 40018813
 * COMP249
 * Assignment #1
 * Due date: September 23, 2016.
 */


import java.util.Scanner;
import java.util.Random;

/**
 * This class is where the array is filled with objects. It also includes display methods,
 * methods that allow user and computer to place their ships and grenades. 
 * In this class, there are also methods that launches rockets by two parties and methods 
 * that evaluate the results of rockets.
 */
public class Array {
	
public static final int totalNumberOfShips=6;
public static final int totalNumberOfGrenades=4;
private static int userShipLeft=6;
private static int compShipLeft=6;
	

	
	/**
	 * This method is to fill the original array with underscores.
	 * @param a This array will be filled with underscores.
	 */
	public static void fillBattle(Object [][] a)
	{
		for (int row=0; row<a.length; row++)
			for (int column=0; column<a[row].length; column++)
				a[row][column]=new Object();
	}

	
	/**
	 * This is the display method for the array, no matter the object has been called or not.
	 * @param a The array that will be displayed.
	 */
	public static void showBattle(Object [][] a)
	{
	int row,column;
	for (row=0; row<a.length; row++)
		{for (column=0; column<a[row].length; column++)
			System.out.print(a[row][column].getValue()+"  ");
	System.out.println();}
	}
	    

	/**
	 * This is the display method, which will only display the object that has been called.
	 * @param a The array that will be displayed.
	 */
	public static void showBattleCalled(Object[][]a)
	{
		int row,column;
		for (row=0; row<a.length; row++)
		{for (column=0; column<a[row].length; column++)
	      if(a[row][column].getCalled())
	    	  System.out.print(a[row][column].getValue()+"  ");
	      else
	    	  System.out.print('_'+"  ");
		System.out.println();
		}
	}


	/**
	 * This method reads the user's input and according to the input, it will place user's ships and
	 * grenades on the corresponding positions. If the user's input is out of grid or the position has
	 * been occupied, there will be a waring massage and then the user has to enter one more time.
	 */
	public static void userInput()
	{	
	Scanner keyboard=new Scanner(System.in);

		int shipUsed=1, grenadeUsed=1;
		while (shipUsed<=totalNumberOfShips)
		{
			System.out.println("Please enter the coordinates of your ship #"+shipUsed);
			String input=keyboard.nextLine();
			char columnInput=input.toUpperCase().charAt(0);
			int rowInput=Integer.parseInt(input.substring(1));
			if (inTheGrid(columnInput,rowInput)&&Battle.getBattleArray()[rowInput-1][charToIndex(columnInput)].getIfOccupied()==false)
			{
			System.out.println("Your ship #"+shipUsed+" has been put in "+columnInput+rowInput);
			shipUsed++;
			Battle.getBattleArray()[rowInput-1][charToIndex(columnInput)].setObjectToShipByUser();
			}
			
			else if(inTheGrid(columnInput,rowInput)==false)
			{
				System.out.println("Invalid input.You should enter a coordinate within the 8*8 grid. Please try again.");
				
			}
			else if (Battle.getBattleArray()[rowInput-1][charToIndex(columnInput)].getIfOccupied()==true)
			{
				System.out.println("You have put a ship or a grenade in this position. Please try again.");
			}
		}
		while (grenadeUsed<=totalNumberOfGrenades)
		{
			System.out.println("Please enter the coordinates of your Grenade #"+grenadeUsed);
			String input=keyboard.nextLine();
			char columnInput=input.toUpperCase().charAt(0);
			int rowInput=Integer.parseInt(input.substring(1));
			if (inTheGrid(columnInput,rowInput)&&Battle.getBattleArray()[rowInput-1][charToIndex(columnInput)].getIfOccupied()==false)
			{
			System.out.println("Your grenade #"+grenadeUsed+" has been put in "+columnInput+rowInput);
			grenadeUsed++;
			Battle.getBattleArray()[rowInput-1][charToIndex(columnInput)].setObjectToGrenadeByUser();
			}
			
			else if(inTheGrid(columnInput,rowInput)==false)
			{
				System.out.println("Invalid input.You should enter a coordinate within the 8*8 grid. Please try again.");	
			}
			else if (Battle.getBattleArray()[rowInput-1][charToIndex(columnInput)].getIfOccupied()==true)
				System.out.println("You have put a ship or a grenade in this position. Please try again.");
		}	
	}

	/**
	 * In this method the computer will randomly generate an integer between 0 and 8. And place its ships
	 * and grenades on corresponding positions if these positions have not been occupied yet. 
	 */
	public static void computerInput()
	{
		Random randomInt=new Random();
		int shipUsed=1, grenadeUsed=1;
		while (shipUsed<=totalNumberOfShips)
		{
			int index1=randomInt.nextInt(8);
			int index2=randomInt.nextInt(8);
			if (Battle.getBattleArray()[index1][index2].getIfOccupied()==false)
			{
				shipUsed++;
				Battle.getBattleArray()[index1][index2].setObjectToShipByComp();
			}		
		}	
		while (grenadeUsed<=totalNumberOfGrenades)
		{
			int index1=randomInt.nextInt(8);
			int index2=randomInt.nextInt(8);
			if (Battle.getBattleArray()[index1][index2].getIfOccupied()==false)
			{
				grenadeUsed++;
				Battle.getBattleArray()[index1][index2].setObjectToGrenadeByComp();
			}		
		}
	}

	/**
	 * This method reads the user's input and launch a rocket to the position, then invoke the result method 
	 * to see the result.
	 */
	public static void userRocket()
	{

		Scanner keyboard=new Scanner(System.in);
		System.out.println("Enter the position of your rocket:");
		String input=keyboard.nextLine();
		char columnInput=input.toUpperCase().charAt(0);
		int rowInput=Integer.parseInt(input.substring(1)); 
		if (inTheGrid(columnInput,rowInput))
		userRocketResult(rowInput-1,charToIndex(columnInput));
		else
			{System.out.println("Out of grid, please try again!");
			userRocket();
			}
	}

	/**
	 * In this method the computer will randomly generate integers and launch his rocket, and then 
	 * invoke the result method to see what's the result.
	 */
	public static void compRocket()
	{
	    Random randomInt=new Random();
		int index1=randomInt.nextInt(8);
		int index2=randomInt.nextInt(8);
		System.out.println("The computer has launched his rocket");
		System.out.println("Here is the result.");
		compRocketResult(index1,index2);
		
	}

	/**
	 * This method evaluates the user's rocket result. Note: if a grenade is hit, the computer will 
	 * launch two rockets in next turn.
	 * @param input1 Row index.
	 * @param input2 Column index.
	 */
	private static void userRocketResult(int input1,int input2)
	{
		if(Battle.getBattleArray()[input1][input2].compShipGetHit())
		{compShipLeft--;
		Battle.getBattleArray()[input1][input2].setGetCalled();
		System.out.println("Hit computer's ship");
		showBattleCalled(Battle.getBattleArray());
		}
	    else if(Battle.getBattleArray()[input1][input2].userShipGetHit())
	    {
		userShipLeft--;
		Battle.getBattleArray()[input1][input2].setGetCalled();
		System.out.println("Hit your own ship");
		showBattleCalled(Battle.getBattleArray());
	    }
	    else if (Battle.getBattleArray()[input1][input2].compGrenadeGetHit()
			||Battle.getBattleArray()[input1][input2].userGrenadeGetHit())
	    {
	    	Battle.getBattleArray()[input1][input2].setGetCalled();
		  System.out.println("Boom! Grenade explode!");
		  showBattleCalled(Battle.getBattleArray());
		  compRocket();
	    }
	    else if (Battle.getBattleArray()[input1][input2].emptyPositionGetHit())
	    {
	    	Battle.getBattleArray()[input1][input2].setGetCalled();
	    	Battle.getBattleArray()[input1][input2].setValue('*');
		  System.out.println("Empty slot. You hit Nothing.");
		  showBattleCalled(Battle.getBattleArray());
	    }
	    else if (Battle.getBattleArray()[input1][input2].getCalled())
	    {
		  System.out.println("Postion has been hit before!");
		  showBattleCalled(Battle.getBattleArray());
	    }
	}

	/**
	 * This method evaluates the computer's rocket result. It's almost the same as the user's 
	 * rocket result method, except the display content. 
	 * @param input1 Row index.
	 * @param input2 Column index.
	 */
	private static void compRocketResult(int input1,int input2)
	{
		if(Battle.getBattleArray()[input1][input2].compShipGetHit())
		{compShipLeft--;
		Battle.getBattleArray()[input1][input2].setGetCalled();
		System.out.println("The computer has hit is own ship");
		showBattleCalled(Battle.getBattleArray());
		}
	    else if(Battle.getBattleArray()[input1][input2].userShipGetHit())
	    {
		userShipLeft--;
		Battle.getBattleArray()[input1][input2].setGetCalled();
		System.out.println("The computer has hit one of your ship");
		showBattleCalled(Battle.getBattleArray());
	    }
	    else if (Battle.getBattleArray()[input1][input2].compGrenadeGetHit()
			||Battle.getBattleArray()[input1][input2].userGrenadeGetHit())
	    {
	    	Battle.getBattleArray()[input1][input2].setGetCalled();
		  System.out.println("Wow, the computer has hit a grenade!");
		  showBattleCalled(Battle.getBattleArray());
		  userRocket();
	    }
	    else if (Battle.getBattleArray()[input1][input2].emptyPositionGetHit())
	    {
	    	Battle.getBattleArray()[input1][input2].setGetCalled();
	    	Battle.getBattleArray()[input1][input2].setValue('*');
		  System.out.println("The computer hit an empty slot.");
		  showBattleCalled(Battle.getBattleArray());
	    }
	    else if (Battle.getBattleArray()[input1][input2].getCalled())
	    {
		  System.out.println("The computer has hit a slot that has been called before.");
		  showBattleCalled(Battle.getBattleArray());
	    }
	}

	
	/**
	 * This method evaluates if the user's input is in the grid.
	 * @param input1 Char input, the column index.
	 * @param input2 integer input, the row index.
	 * @return Returns true if the input is in the grid.
	 */
	private static boolean inTheGrid(char input1, int input2)
	{

			return ((input1=='A'||input1=='B'||input1=='C'||input1=='D'||input1=='E'||input1=='F'||input1=='G'||input1=='H')&&(input2==1||input2==2
					||input2==3||input2==4||input2==5||input2==6||input2==7||input2==8));

	}

	/**
	 * This method transfers the char input into index.
	 * @param input Char input.
	 * @return Returns the integer index.
	 */
	private static int charToIndex(char input)
	{
		int index=0;
		switch (input)
		{
		case 'A':
			index=0;
			break;
		case 'B':
			index=1;
			break;
		case 'C':
			index=2;
			break;
		case 'D':
			index=3;
			break;
		case 'E':
			index=4;
			break;
		case 'F':
			index=5;
			break;
		case 'G':
			index=6;
			break;
		case 'H':
			index=7;
			break;
		}
		return index;
	}
	
/**
 * Accessor method
 * @return the numbers of user's ships that have not been hit.
 */
public static int getUserShipLeft()
{
	return userShipLeft;
}

/**
 * Accessor method
 * @return the numbers of computer's ships that have not been hit.
 */
public static int getCompShipLeft()
{
	return compShipLeft;
}

	
	
	
	
	
	
}
