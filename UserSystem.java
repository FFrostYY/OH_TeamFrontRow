package App;
import java.util.*;
public class UserSystem {
	private List<User> users;
	public UserSystem()
	{
		this.users = new ArrayList<>();
	}
	
	public void registerParent(String name) {
		User temp = new Parent (name);
		users.add(temp);	
	}

	public void registerChild(String name) {
		User temp = new Child(name);
		users.add(temp);
	}

	public List<User> getUsers() {
		return users;
	}

	public User retrieveUser(String name) {
		for(User u : users ) {
			if(name.equals(u.getName())) {
				return u;
			}
		}
		return null;
	} 

	public void removeUser(String name) {
		users.remove(retrieveUser(name));
	}
}



