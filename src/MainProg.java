import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * @author Alex Cherniak
 *this is the main for the sorted group assignment - here we will test all the methods from SortedGroup
 */
public class MainProg 
{
	public static void main(String[] args) 
	{
		SortedGroup<Person> personList = new SortedGroup<>(); //create an empty list of persons
		
		//create persons
		Person danny = new Person("Danny", 12345, new Date(1,1,2000));
		Person john = new Person("John", 12346, new Date(1,3,2000));
		Person oliver = new Person("Oliver", 12347, new Date(5, 4, 2010));
		Person barry = new Person("Barry", 12348, new Date(10, 9, 2007));
		Person sansa = new Person("Sansa", 12348, new Date(24, 6, 2005));
		
		// add the persons to the sorted list
		personList.addSorted(sansa);
		personList.addSorted(oliver);
		System.out.println("printing current list(2 elements):");
		personList.printList();
		System.out.println(); //empty line
		personList.addSorted(danny);
		personList.addSorted(john);
		System.out.println("printing current list(4 elements):");
		personList.printList();
		System.out.println(); //emtpy line
		personList.addSorted(sansa);
		personList.addSorted(barry);
		System.out.println("printing current list(6 elements):");
		personList.printList();
		
		//after we checked that the list is ok and sorted correctly
		//we will now remove an element from the list
		
		personList.remove(john);
		System.out.println();
		System.out.println("printing list after removing john(5 elements)");
		personList.printList();
		
		//now that remove method worked successfully , we will add 2 persons that were born before year 2000
		//and print the reduced list
		
		personList.addSorted(new Person("Ned", 123459, new Date(5, 5, 1986)));
		personList.addSorted(new Person("Joffrey", 123459, new Date(8, 6, 1980)));
		
		SortedGroup<Person> reducedList = new SortedGroup<>();
		reducedList = Person.reduce(personList, danny); //since danny was born on 1.1.2000 -> only Joffrey and Ned should appear on the reduced list
		System.out.println();
		System.out.println("will now print the reduced list");
		reducedList.printList();
		System.out.println(); //empty line
		
		//now testing the iterator
		java.util.Iterator<Person> runner = personList.iterator();
		System.out.println("Iterator Test");
		while(runner.hasNext())
		{
			System.out.println(runner.next());
		}
		
		
		System.out.println("\nAll Tests Passed Successfully - Bye Bye");
	}

}
