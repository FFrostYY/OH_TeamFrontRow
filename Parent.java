package App;

public class Parent extends User {
	
	private Planner planner;

	public Parent(String name)
	{
		super(name);
	}
	
	public void addEvent(String name, 
			int day, 
			int month, 
			int year, 
			int startTime, 
			int endTime, 
			String type)
	{
		this.planner.addEvent(name, day, month, year, startTime, endTime, type);
	}
	
	public Event getEvent(int day, int month, String name, int year)
	{
		return this.planner.getEvent(day, month, name, year);
	}
	
	public void printAllEvents()
	{
		this.planner.printAll();
	}
}
