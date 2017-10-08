package App;

public class Event {
	
	private String name;
	private int startTime;
	private int endTime;
	private String type;
	
	public Event(String name, int startTime, int endTime, String type)	//event information
	{
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getDuration(int startTime, int endTime)
	{
		return this.endTime - this.startTime;
	}
	
	@Override
	public String toString()
	{
		String rep = new String();
		rep += "Event " + this.getName() + "(" + this.getType() + ")\n";
		rep += "Starts: " + this.getStartTime() + " - Ends : " + this.getEndTime() + "\n";
		return rep;
	}
	
}
