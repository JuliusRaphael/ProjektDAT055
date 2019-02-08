import java.io.*;
import java.util.ArrayList;
public class Server {
	Group g;
	public Server(Group g) {
		this.g = g;
	}
	public Server() {
		
	}
	public void load() {
		try {
			BufferedReader reader =
			new BufferedReader(
			new FileReader("SavedFika"));
			String line = reader.readLine();
			while(line != null) {
			
			if(line!=null) {
			String[] user = line.split("[,]");
			g.addUser(user[0], Integer.parseInt(user[1]) , Boolean.parseBoolean(user[2]));
			}
			line = reader.readLine();
			
			}
			reader.close();
			}
			catch(FileNotFoundException e) {
			//the specified file could not be found
			}
			catch(IOException e) {
			//something went wrong with reading or closing
			}
	}
	
	public void save() {
		try {
		    
		     
		    FileWriter fileWriter = new FileWriter("SavedFika");
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    ArrayList<User> users = g.getUsers();
		    for(User u : users) {
		    printWriter.printf(u.getID()+ ","+ u.getRating()+","+u.isHasVoted());
		    printWriter.printf("\n");
		    }
		    printWriter.close();
			}
			catch(IOException e) {
			
			}
	}
}
