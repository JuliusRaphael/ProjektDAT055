

import java.util.*;

public class Group {
	private ArrayList<User> users;
	private Vote v;
	
	public Group(){
		this.users = new ArrayList<User>();  
		this.v 	   = new Vote();
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public Vote getV() {
		return v;
	}

	public void setV(Vote v) {
		this.v = v;
	}
	
	
}
