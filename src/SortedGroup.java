import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Alex Cherniak
 * @param <T>
 *this class represent a sorted group built of a generic type T
 *the sorted group is using an arraylist database
 */
public class SortedGroup<T extends Comparable<T>>
{
	/******************************************************************************************************************************
	 * Instance Variables
	 ******************************************************************************************************************************/
	
	private ArrayList<T> sortedList; //represents the sorted group of elements from type T
	
	/*******************************************************************************************************************************
	 * Constructors
	 *******************************************************************************************************************************/
	public SortedGroup() 
	{
		sortedList = new ArrayList<T>(); //create an empty list
	}
	
	
	
	/********************************************************************************************************************************
	 * Methods
	 *********************************************************************************************************************************/
	/*
	 * add sorted - will add an element to the sorted group
	 * the idea is to add an element to the end of the list , then swap with it all the elements that are "larger" than him -> bubble it to its place
	 */
	public void addSorted(T value)
	{
		sortedList.add(value);
		Comparable<T> cmp = (Comparable<T>)value;
		for(int i=sortedList.size()-1;i>0 && cmp.compareTo(sortedList.get(i-1))<0;i--)
		{
			Collections.swap(this.sortedList, i, i-1); //swap 2 elements till the last added value will get to his place in the sorted group
		}
	}
	
	/*
	 * below there is a private class for the iterator
	 * the class implements the basic methods of an iterator
	 */
	private class SortedListIterator implements Iterator<T>
	{
		int currentIndex;
		//constructor
		public SortedListIterator()
		{
			this.currentIndex = 0; //set the initial index
		}
		//override has next
		public boolean hasNext() 
		{
			return currentIndex < sortedList.size()-1;
		}
		//override next
		public T next() 
		{
			currentIndex++; //increment the current index
			return sortedList.get(currentIndex); //return the incremented index
		}
	}
	//iterator method
	public Iterator <T> iterator()
	{
		return new SortedListIterator();
	}
	
	/*
	 * remove method
	 * @return - the number of removed elements from the list
	 * after removal of the elements , the list stays sorted , no need to re-sort
	 */
	public int remove(T item)
	{
		int countRemoved = 0;
		for(int i=0;i<sortedList.size()-1;i++)
		{
			if(item.compareTo(sortedList.get(i)) == 0)
			{
				sortedList.remove(i); //remove the current elemnt
				i-=1; //reduce i by 1, so that after removing an element , the next one wont be skipped
				countRemoved++; //add the counter for removed items
			}
		}
		return countRemoved; //return the number of removed elements
	}
	

	/*
	 * getSortedList Method - will return an array list that is a sorted list
	 */
	public ArrayList<T> getSortedList()
	{
		ArrayList<T> newList = new ArrayList<T>(); //create a new list that we will return
		for(T i : sortedList)
		{
			newList.add(i); //add each element from sortedList to the new list
		}
		return newList;
	}
	
	public void printList()
	{
		for(int i=0;i<sortedList.size();i++)
		{
			System.out.println(i+1 + "." + sortedList.get(i));
		}
	}
}
