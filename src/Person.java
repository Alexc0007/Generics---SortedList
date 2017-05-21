
/**
 * @author Alex Cherniak
 *this class represents a person that implements the interface comparable
 *person comparison is performed by its birth date
 */

public class Person implements Comparable<Person>
{
	/***********************************************************************************************************************************
	 * Instance Variables
	 ***********************************************************************************************************************************/
	private String name;
	private int id;
	private Date birthDate;

	/************************************************************************************************************************************
	 * Constructors
	 ************************************************************************************************************************************/
	public Person(String name , int id , Date date)
	{
		this.name = name;
		this.id = id;
		this.birthDate = date;
	}
	
	/*************************************************************************************************************************************
	 * Methods
	 *************************************************************************************************************************************/
	public String toString()
	{
		return "name: " + name + "\nID: " + id + "\nBirthDate: "+ birthDate.toString();
	}
	
	public static <T extends Comparable<T>> SortedGroup<T> reduce(SortedGroup<T> list , T x)
	{
		/*
		 * list - is a sorted list
		 * x - is a value of type T that can be compare to items that sits in the list
		 * goal - return a list with objects that are smaller than x 
		 */
		SortedGroup<T> reducedList = new SortedGroup<>(); //create a new reduced list to store the new values on
		for(int i=0;i<list.getSortedList().size()-1;i++)
		{
			if(list.getSortedList().get(i).compareTo(x) < 0) //value on index i of the list is smaller than x -> then need to add it to reduced list
			{
				reducedList.addSorted(list.getSortedList().get(i));
			}
		}
		return reducedList; //return the reduced list
	}

	/*
	 * override the compareTo method
	 * comparison is based on date compareTo method
	 */
	public int compareTo(Person person) 
	{
		if(this.birthDate.compareTo(person.birthDate) > 0)
			return 1; //person is prior to this person
		if(this.birthDate.compareTo(person.birthDate) < 0)
			return -1; //this person is prior to person
		return 0; //persons are equal by birth date
	}
}
