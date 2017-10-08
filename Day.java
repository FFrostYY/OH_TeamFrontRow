package App;
import java.util.*;

public class Day {

	private final int HOURS = 24;
	
	private boolean[] timetable = new boolean[HOURS];
	private List<Event> events;
	//TODO event types
	
	public Day()	//creates a list of events in a given day
	{
		events = new ArrayList<>();
	}
	
	public void addEvent(String name, int startTime, int endTime, String type) //adds event to a day
	{
		for(int i = startTime; i <= endTime; i++)
		{	
			this.timetable[i] = true;
			this.events.add(new Event(name, startTime, endTime, type));
		}
	}
	
	public Event getEvent(String name)
	{
		for(Event event : events)
		{
			if(event.getName().equals(name));
			{
				return event;
			}
		}
			System.out.println("No event of name " + name + " found.");
			return null;
	}
	
	@Override
	public String toString()
	{
		String rep = new String();
		
		for(Event event : this.events)
		{
			rep += event;
		}
		
		return rep;
	}
}
