

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

	//temp method?
	public void setUsers(ArrayList<User> list) {
		this.users = list;
	}
	public Vote getV() {
		return v;
	}
	public void setV(Vote v) {
		this.v = v;
	}
	
	//new classes
	
	
	//nollställa noOfVotes, currentUser och ratings
	public void resetVote(User u) {
		v.setCurrent(u);
		v.resetAll();
	}
	
	//sätta hasVoted till false hos alla user
	public void resetHasVoted () {
		for(User u: users) {
			u.setHasVoted(false);
		}
	}
	
	
	//hämtar nästa user som ska ha med fika
	public void nextUser() {
		//ändra nextUser i kölista
		Collections.rotate(users, users.size()-1);
	}
	
	//sätta igång ny fikaveckan
	public void nextFika() {
		/*
		 * v.calculate();
		 * nextUser();
		 * resetHasVoted();
		 * resetVote();
		 */
	}
	
	//temp
	public void printAll() {
		for (User u: users) {
			System.out.println(u.getID());
		}
	}
}
