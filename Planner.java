package App;
import java.util.*;

public class Planner
{
	private final String OUTDOOR = "outdoor";
	private final String INDOOR = "indoor";
	private final String FOOD = "food";
	private final String SOCIAL = "social";
	private final String MISC = "misc";
	
	private List<Year> years;
	
	public Planner()
	{
		this.years = new ArrayList<>();
	}
	
	public void addEvent(String name, int day, int month, int year, int startTime, int endTime, String type)	//adds an actual event to the planner
	{
		if(type.equals(OUTDOOR)||
				type.equals(INDOOR)||
				type.equals(FOOD)||
				type.equals(SOCIAL)||
				type.equals(MISC))
		{

			for(Year yearIteration : this.years)
			{
				if(yearIteration.getYear() == year)
				{
					yearIteration.addEvent(name, day, month, startTime, endTime, type);
					return;
				}
			}
			Year newYear = new Year(year);
			newYear.createYear();
			this.years.add(newYear);
			Collections.sort(this.years);
			for(Year yearIteration : this.years)
			{
				if(yearIteration.getYear() == year)
				{
					yearIteration.addEvent(name, day, month, startTime, endTime, type);
					return;
				}
			}
		}
		else
		{
			System.out.println("Invalid type.");
			return;
		}
	}
	
	public Event getEvent(int day, int month, String name, int year)
	{
		for(Year yearIteration : this.years)
		{
			if(yearIteration.getYear() == year)
			{
				return yearIteration.getEvent(day, month, name);
			}
		}
		
		System.out.println("Event not found. Please check date and name.");
		return null;
	}
	
	public void printYear(int year)
	{
		for(Year yearIteration : this.years)
		{
			if(yearIteration.getYear() == year)
			{
				System.out.println(yearIteration);
			}
		}
	}
	
	public void printAll()
	{
		for(Year yearIteration : this.years)
		{
			System.out.println(yearIteration);
		}
	}
}