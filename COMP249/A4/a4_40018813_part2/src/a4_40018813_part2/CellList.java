package a4_40018813_part2;
//---------------------------------------------------
//Assignment 4
//Part: 2
//Written by: Rui Zhao 40018813
//-----------------------------------------------------


import java.util.NoSuchElementException;

/**
 * CellList class, includes methods that creates and modifies linked list 
 * @author Rui Zhao
 *
 */
public class CellList implements Cloneable{
	
	/**
	 * CellNode class, inner class of CellList class
	 * creates the nodes
	 * @author Rui Zhao
	 *
	 */
	private class CellNode implements Cloneable{
		private CellPhone oneCellPhone;
		private CellNode next;
		
		/**
		 * default constructor
		 */
		public CellNode()
		{
			oneCellPhone=null;
			next=null;
		}
		
		/**
		 * constructor with parameters
		 * @param a object from CellPhone class
		 * @param b pointer of node
		 */
		public CellNode(CellPhone a, CellNode b)
		{
			this.oneCellPhone=a;
			this.next=b;
		}
		
		/**
		 * copy constructor
		 * create a deep copy using the clone method from CellPhone class
		 * @param anotherOne object from CellPhone class
		 */
		public CellNode(CellNode anotherOne)
		{
			this.oneCellPhone=anotherOne.oneCellPhone.clone();
			this.next=anotherOne.next;
		}

		/**
		 * @return the oneCellPhone
		 * may result privacy a leak,because this method gives the reference of CellPhone,
		 * and can't use clone method to avoid the problem,otherwise you will get an object with different serialNumber
		 * because once the clone method is called, you have to give a new serial number
		 */
		public CellPhone getOneCellPhone() {
			return oneCellPhone;
		}

		/**
		 * @param oneCellPhone the oneCellPhone to set
		 */
		public void setOneCellPhone(CellPhone oneCellPhone) {
			this.oneCellPhone = oneCellPhone;
		}

		/**
		 * @return the oneCellNode
		 */
		public CellNode getNext() {
			return next;
		}

		/**
		 * @param oneCellNode the oneCellNode to set
		 */
		public void setNext(CellNode oneCellNode) {
			this.next = oneCellNode;
		}
		
		/**
		 * clone method
		 * @param serialNumber
		 * @return a deep copy using copy constructor
		 */
		public CellNode clone()
		{
			return new CellNode(this);
		}
		
	}//end of inner class
	
	/**
	 * start of CellList class
	 */
	private CellNode head;
	private int size;
	
	/**
	 * default constructor
	 */
	public CellList()
	{
		head=null;
		size=0;
	}
	
	/**
	 * copy constructor
	 * @param anotherOne another object from CellList class
	 */
	public CellList(CellList anotherOne)
	{
		size=anotherOne.size;//size is same as the passed object
		if (anotherOne.head==null)//special case:the passed list is empty
			{
			head=null;
			}
		else
		{
			head=null;
			CellNode t1=anotherOne.head,t2=null;
			while (t1!=null)
			{
				if(head==null)
				{
				head=new CellNode(t1);//using copy constructor to create a deep copy of the CellPhone object
				t2=head;	
				}
				else
				{
					t2.next=new CellNode(t1);//using copy constructor to create a deep copy of the CellPhone object
					t2=t2.next;
				}
				t1=t1.next;
			}
			t2=null;
		}
	}
	
	/**
	 * addToStart method
	 * add a node to the beginning of the list, increasing the size by 1
	 * @param aCellPhone an object from CellPhone class
	 */
	public void addToStart(CellPhone aCellPhone)
	{
		head=new CellNode(aCellPhone, head);
		size++;	
	}
	
	/**
	 * insertAtIndex method
	 * insert a node at an index
	 * when index is negative or bigger than the size of the list, an exception will be thrown
	 * special cases:1.index equals to 0.(invoke addToStart method) 
	 * @param a an object from CellPhone class
	 * @param index the position
	 */
	public void insertAtIndex(CellPhone a, int index)
	{ 
		try
		{
		if (index<0||index>(this.size-1))
				throw new NoSuchElementException("Out of the bound of current list!");
		
		if(index==0)
			      addToStart(a);
		else
		{
			CellNode temp=head;
			for (int i=0;i<(index-1);i++)
			{
				temp=temp.next;
			}
			temp.next=new CellNode(a, temp.next);
			temp=null;
			size++;
		}
		}
		catch (NoSuchElementException e)
		{
			System.out.println("==============================================================================");
			System.out.println(e.getMessage());
			System.out.println("The information has not been inserted.");
			System.out.println("==============================================================================");
		}
		
	}
	
	/**
	 * deleteFromIndex method
	 * deletes a node from index
	 * when index is negative or bigger than the size of the list, an exception will be thrown
	 * special case:1.index is 0 (deleteFromStart method will be executed)
	 * @param index the position
	 */
	public void deleteFromIndex(int index)
	{
		try
		{
		if (index<0||index>(this.size-1))
			throw new NoSuchElementException("Out of the bound of current list!");
		
		if(index==0)
			deleteFromStart();//deleteFromStart method will verify if the list is empty or not
		else
		{
			CellNode temp=head;
			for (int i=0;i<index-1;i++)
			{
				temp=temp.next;
			}
			temp.next=temp.next.next;
			temp=null;
			size--;
		}
		}
		catch (NoSuchElementException e)
		{
			System.out.println("==============================================================================");
			System.out.println(e.getMessage());
			System.out.println("No information has been deleted.");
			System.out.println("==============================================================================");
		}
	}
	
	/**
	 * deleteFromStart method
	 * will be tested in deleteFromIndex method
	 */
	public void deleteFromStart()
	{
		if(head==null)
			return;
		head=head.next;
		size--;
	}
	
	/**
	 * replaceAtIndex method
	 * replaces a node at given index
	 * when index is illegal or the list is empty, do nothing
	 * @param a an object from CellPhone class
	 * @param index the position
	 */
	public void replaceAtIndex(CellPhone a, int index)
	{
		if (index<0||index>(this.size-1))
			return;
		if (head==null)
			return;
		else
		{
			CellNode temp=head;
			for(int i=0;i<index;i++)
			{
				temp=temp.next;
			}
			temp.oneCellPhone=a;
		}
	}
	
	/**
	 * find method
	 * this method is defined to be a private method,and works as a helping method to contains method
	 * in this way, possible privacy leak will be avoided(because we will never return the reference)
	 * loop through the list to find the node that has the given serialNumber,
	 * calculate the number of iterations
	 * Special case:1.list is empty
	 * @param serialNumber serialNumber
	 * @return pointer or null
	 */
	private CellNode find(long serialNumber)
	{
		int iteration=0;
		if (head==null)
		{
			iteration++;
			return null;
		}
		else
		{
			CellNode temp=head;
			while(temp!=null&&temp.oneCellPhone.getSerialNum()!=serialNumber)
			{
				temp=temp.next;
				iteration++;
			}
			System.out.println("The number of iteration performed is "+iteration+".");
			if (temp==null)
			{	
				return null;
			}
			else
			{
				return temp;
			}
		}
	}
	
	/**
	 * contains method
	 * @param serialNumber serialNumber
	 * @return true if given serialNum is found in the list
	 */
	public boolean contains(long serialNumber)
	{
		if (find(serialNumber)==null)
		{
			System.out.println("No same serial number can be found.");
			return false;
		}
		else
		{
		System.out.println("Same serial number is found, here is the information:");
		System.out.println(find(serialNumber).oneCellPhone);	
		return true;	
		}
		
	}

	/**
	 * showContents method
	 */
	public void showContents()
	{
		if (head==null)
		{
			System.out.println("==============================================================================");
			System.out.println("There is nothing to display, the list is empty.");
			System.out.println("==============================================================================");
		}
		else
		{
		CellNode temp=head;
		System.out.println("==============================================================================");
		System.out.println("The current size of the list is "+size+". Here are the contents of the list:");
		System.out.println("==============================================================================");
		while(temp!=null)
		{
			System.out.println(temp.oneCellPhone+" ---> ");
			temp=temp.next;
		}
		}
	}
	
	/**
	 * equals method
	 * @param anotherOne another CellList
	 * @return true if two lists are same
	 */
	public boolean equals(CellList anotherOne)
	{
		if(this==null||anotherOne==null)
			return false;
		if(this.size!=anotherOne.size)
			return false;
		else
		{
			CellNode m=this.head;
			CellNode n=anotherOne.head;
			while(m!=null&&n!=null)
			{
				if(m.oneCellPhone.equals(n.oneCellPhone))
				{
					m=m.next;
					n=n.next;
				}
				else
					return false;
			}
			return true;
		}	
	}
}//end of class
