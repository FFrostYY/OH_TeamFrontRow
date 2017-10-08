package App;
import java.util.*;

public class Year implements Comparable<Year>{
	private int year;
	private List<Day[]> monthList;		//list of months containing days containing events
    private int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public Year(int year)
	{
		this.year = year;
		this.monthList = new ArrayList<>();
	}
	
	public int getYear()
	{
		return this.year;
	}
	
	private boolean checkLeapYear()		//checks for leap years
	{
		if  ((this.year % 4 == 0) && (this.year % 100 != 0)) 
		{
			return true;
		}
        if  (this.year % 400 == 0) 
        {
        	return true;
        }
        return false;
	}
	public void createYear()	//Creates a year that holds months that hold days that hold events
	{
		for(int i = 0; i < days.length; i++)
		{
			int daysInAMonth = days[i];
			if(i==1)
			{
				if(this.checkLeapYear())
				{
					daysInAMonth = days[i] + 1;
				}
				else
				{
					daysInAMonth = days[i];
	
				}
			}
			Day[] a = new Day[daysInAMonth]; 
			this.monthList.add(i, a);
		}
	}
	public void addEvent(String name, int day, int month, int startTime, int endTime, String type)
	{
		this.monthList.get(month-1)[day].addEvent(name, startTime, endTime, type);
	}
	
	public int compareTo(Year otherYear)
	{
		if(this.year < otherYear.year)
		{
			return -1;
		}
		else if(this.year > otherYear.year)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public Event getEvent(int day, int month, String name)
	{
		if(this.monthList.get(month-1)[day].getEvent(name) != null)
		{
			return this.monthList.get(month-1)[day].getEvent(name);
		}
		else
		{
			System.out.println("Event not found. Please check day, month or name.");
			return null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Year other = (Year) obj;
		if (year != other.year)
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		String rep = new String();
		for(Day[] day : this.monthList)
		{
			for(int i=0; i<day.length; i++)
			{
				rep += day[i];
			}
		}
		
		return rep;
	}
}
