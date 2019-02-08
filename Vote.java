
public class Vote {
	private User current;
	private int noOfVotes;
	private int currRating;
	
	public Vote(){
	}
	
	public User getCurrent() {
		return current;
	}
	public void setCurrent(User current) {
		this.current = current;
	}
	public int getNoOfVotes() {
		return noOfVotes;
	}
	public void setNoOfVotes(int noOfVotes) {
		this.noOfVotes = noOfVotes;
	}
	public int getCurrRating() {
		return currRating;
	}
	public void setCurrRating(int currRating) {
		this.currRating = currRating;
	}
	//new
	public void resetAll() {
		this.currRating = 0;
		this.noOfVotes = 0;
	}
	
	public int calculate() {
		return currRating / noOfVotes;
	}

}
