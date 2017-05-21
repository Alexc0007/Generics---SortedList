
/**
 * @author Alex Cherniak
 *this class represents a Date
 * ***no input check - assumption is that inserted date is viable ***
 */
public class Date implements Comparable
{
	/*********************************************************************************************************************************
	 * Instance Variables
	 *********************************************************************************************************************************/
	private int day;
	private int month;
	private int year;
	
	/**********************************************************************************************************************************
	 * Constructor
	 **********************************************************************************************************************************/
	public Date(int day , int month , int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/***********************************************************************************************************************************
	 * Methods
	 ***********************************************************************************************************************************/
	/*
	 * override compareTo
	 */
	public int compareTo(Object date) 
	{
		Date inputDate = (Date) date;
		
		if(this.year > inputDate.year)
		{
			return 1;
		}
		if(this.year < inputDate.year)
		{
			return -1;
		}
		if(this.month > inputDate.month)
		{
			return 1;
		}
		if(this.month < inputDate.month)
		{
			return -1;
		}
		if(this.day > inputDate.day)
		{
			return 1;
		}
		if(this.day < inputDate.day)
		{
			return -1;
		}
		return 0; //dates are equal
	}
	
	public String toString()
	{
		// dd/mm/yyyy
		return day+"/"+month+"/"+year;
	}
	
	/***********************************************************************************************************************************
	 * Getters / Setters
	 ***********************************************************************************************************************************/
	public int getDay() 
	{
		return day;
	}

	public void setDay(int day) 
	{
		this.day = day;
	}

	public int getMonth() 
	{
		return month;
	}

	public void setMonth(int month) 
	{
		this.month = month;
	}

	public int getYear() 
	{
		return year;
	}

	public void setYear(int year) 
	{
		this.year = year;
	}

	
	
	
}
