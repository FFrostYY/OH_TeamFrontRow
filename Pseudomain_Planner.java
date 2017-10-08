package App;
import java.util.*;

public class Pseudomain_Planner {
	
	private Scanner input = new Scanner(System.in);
	private UserSystem userSystem;
	public Pseudomain_Planner()
	{
		userSystem = new UserSystem();
	}
	
	public void Pseudomain()
	{
		User parent;
		
		System.out.println("Please enter your name: \n");
		String name = input.nextLine();
		
		parent = login(name);
		
		System.out.println("1. Add event");
		System.out.println("2. Get an event");
		System.out.println("3. Print all events");
		
		int menuInput = input.nextInt();
		input.nextLine();
		while (menuInput != 0)
		{
			String eventName = new String();
			int day;
			int month;
			int year;
			int startTime;
			int endTime;
			String type = new String();
			switch(menuInput)
			{
			default:
				System.out.println("Invalid option.");
				break;
				
			case 1:
				System.out.println("Enter event name.\n");
				eventName = input.nextLine();
				
				System.out.println("Enter date: (D M Y format)\n");
				day = input.nextInt(); 
				month = input.nextInt();
				year = input.nextInt();
				input.nextLine();
				
				System.out.println("Enter start time: (HHMM format)\n");
				startTime = input.nextInt();
				input.nextLine();
				
				System.out.println("Enter start time: (HH MM format)\n");
				endTime = input.nextInt(); 
				input.nextLine();
				
				System.out.println("Enter event type(outdoor, indoor, food, social, misc)\n");

				type = input.next();
				input.nextLine();
				if(type.equals("outdoor") ||
				   type.equals("indoor") ||
				   type.equals("food") ||
				   type.equals("social") ||
				   type.equals("misc")) 
				{
					((Parent)parent).addEvent(eventName, day, month, year, startTime, endTime, type);
				}
				else
				{
					System.out.println("Invalid event type.");
				}
				
				break;
			case 2:
				System.out.println("Enter event name.\n");
				eventName = input.nextLine();
				
				System.out.println("Enter date: (D M Y format)\n");
				day = input.nextInt(); 
				month = input.nextInt();
				year = input.nextInt();
				input.nextLine();
				
				System.out.println(((Parent)parent).getEvent(day, month, name, year));
				
				break;
			case 3:
				((Parent)parent).printAllEvents();
				break;
			}
			menuInput = input.nextInt();
			input.nextLine();
		}
	}
	
	public Parent login(String name)
	{
		int login;
		System.out.println("Are you a new or existing user?");
		System.out.println("1. New");
		System.out.println("2. Existing");
		
		login = input.nextInt();
		input.nextLine();
		
		if(login == 1)
		{
			userSystem.registerParent(name);
			return (Parent) userSystem.retrieveUser(name);
		}
		else if(login == 2)
		{
			return (Parent) userSystem.retrieveUser(name);
		}
		else
		{
			System.out.println("Invalid option.");
			return login(name);
		}
	}
}
