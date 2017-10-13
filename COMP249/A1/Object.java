/**
 * @author Zhao Rui 40018813
 * COMP249
 * Assignment #1
 * Due date: September 23, 2016.
 */


/**
 * The "Object" class is where the objects of the two-dimensional array are created. 
 * In this class, a default constructor and a copy constructor are defined.
 * It also includes accessor and mutator methods and methods that determine the rocket result.
 * 
 */
public class Object {

private char value, owner;
private boolean ifOccupied;
private boolean getCalled;

/**
 * This is the default constructor.
 */
public Object()
{
	this.value='_';
	this.ifOccupied=false;
	this.getCalled=false;
}


/**
 * This is the copy constructor.
 * @param anotherObject The object from where the calling object will be copied.
 */
public Object(Object anotherObject)
{
	this.value=anotherObject.getValue();
	this.ifOccupied=anotherObject.getIfOccupied();
	this.owner=anotherObject.getOwner();
	
}

/**
 * Accessor method.
 * @return Returns the instance variable "value" of the calling object.
 */
public char getValue()
{
	return value;
}

/**
 * Accessor method.
 * @return Returns the instance variable "owner" of the calling object.
 */
public char getOwner()
{
	return owner;
}

/**
 * Accessor method.
 * @return Returns true if the position has been occupied.
 */
public boolean getIfOccupied()
{
	return ifOccupied;
}

/**
 * Accessor method.
 * @return Returns true if the position has been called.
 */
public boolean getCalled()
{
	return getCalled;
}

/**
 * Mutator method.
 * @param newValue The value that will be assigned to the "value" instance variable of the calling object.
 */
public void setValue(char newValue)
{
	value=newValue;
}

/**
 * Mutator method. 
 * @param newOwner The value that will be assigned to the "owner" instance variable of the calling object.
 */
public void setOwner(char newOwner)
{
	owner=newOwner;
}

/**
 * Mutator method. It will set the instance variable "ifOccupied" to be true.
 */
public void setOccupied()
{
	ifOccupied=true;
}

/**
 * Mutator method. It will set the instance variable "getCalled" to be true.
 */
public void setGetCalled()
{
  getCalled=true;	
}

/**
 * Mutator method.
 * Sets the object to be "ship" of the user.
 */
public void setObjectToShipByUser()
{
	this.value='s';
	this.owner='H';
	this.ifOccupied=true;
}

/**
 * Mutator method.
 * Sets the object to be "grenade" of the user.
 */
public void setObjectToGrenadeByUser()
{
	this.value='g';
	this.owner='H';
	this.ifOccupied=true;
}

/**
 * Mutator method.
 * Sets the object to be "ship" of the computer.
 */
public void setObjectToShipByComp()
{
	this.value='S';
	this.owner='C';
	this.ifOccupied=true;
}

/**
 * Mutator method.
 * Sets the object to be "grenade" of the computer.
 */
public void setObjectToGrenadeByComp()
{
	this.value='G';
	this.owner='C';
	this.ifOccupied=true;
}

/**
 * This method is used to determine if a user's ship had been hit.
 * @return Returns true if an user's ship has been hit for the first time.
 */
public boolean userShipGetHit()
{
	return ((value=='s'&&owner=='H'&&getCalled==false));
	
}

/**
 * This method is used to determine if a computer's ship had been hit.
 * @return Returns true if a computer's ship has been hit for the first time.
 */
public boolean compShipGetHit()
{
	return ((value=='S'&&owner=='C'&&getCalled==false));

}

/**
 * This method is used to determine if a user's grenade had been hit.
 * @return Returns true if an user's grenade has been hit for the first time.
 */
public boolean userGrenadeGetHit()
{
	return ((value=='g'&&owner=='H'&&getCalled==false));
	
}

/**
 * This method is used to determine if a computer's grenade had been hit.
 * @return Returns true if a computer's grenade has been hit for the first time.
 */
public boolean compGrenadeGetHit()
{
	return (value=='G'&&owner=='C'&&getCalled==false);

}

/**
 * This method is used to determine if an empty slot had been hit.
 * @return Returns true if a empty slot has been hit for the first time.
 */
public boolean emptyPositionGetHit()
{
	return (value=='_'&&getCalled==false);
}

/**
 * The toString method.
 */
public String toString()
{
	if(this.getOwner()!='H'&&this.getOwner()!='C')
	return ("This is an empty slot.");
	else 
	return ("There is a "+value+" in this slot that belongs to "+owner);
}
}
