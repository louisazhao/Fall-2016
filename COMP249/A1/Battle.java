/**
 * @author Zhao Rui 40018813
 * COMP249
 * Assignment #1
 * Due date: September 23, 2016.
 */


/**
 * This class is where the main method is located, which is the driver of the game.
 * It also includes an accessor method to get the array.
 */
public class Battle {
public enum GridSize {MAX_ROW(8),MAX_COLUMN(8);
	private int value;
	private GridSize(int value){
		this.value=value;
	}
	public int getValue()
	{
		return value;
	}
}
private static Object[][]battleField;



/**
 * Main method.
 * @param args Main method parameter.
 */
	public static void main(String[] args) {
		battleField=new Object[GridSize.MAX_ROW.getValue()][GridSize.MAX_COLUMN.getValue()];
		Array.fillBattle(battleField);
		
		System.out.println("Hi,welcome to the Battleship game!");
		Array.userInput();
		Array.computerInput();
		System.out.println("Ok,the computer has put his ships and grenades at random. Let's play!");
		Array.showBattleCalled(battleField);
		
		while(Array.getUserShipLeft()>0&&Array.getCompShipLeft()>0)
		{
			Array.userRocket();
			Array.compRocket();
		}
		if (Array.getUserShipLeft()==0)
		{
			System.out.println("You lose! All your ships have been hit!");
			Array.showBattle(battleField);
			System.exit(0);
		}
		else if (Array.getCompShipLeft()==0)
		{
			System.out.println("You win! All the computer's ships have been hit! Congratulations!");
			Array.showBattle(battleField);
			System.exit(0);
		}
	}
	

/**
 * Accessor method.
 * @return Returns the array.
 */
public static Object[][] getBattleArray()
{
	Object[][]temp=new Object[GridSize.MAX_ROW.getValue()][GridSize.MAX_COLUMN.getValue()];
	for(int i=0; i<battleField.length;i++)
		for(int j=0;j<battleField[i].length;j++)
			temp[i][j]=battleField[i][j];
					return temp;
}






}
