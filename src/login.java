import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class login {
    JFrame frame = new JFrame();
    Group gr;
    String userID; 
    boolean loggedin = false;
    public login(Group gr) {
    	this.gr = gr;
    	
    }
    
    public void checklogin() {
    	userID = JOptionPane.showInputDialog(frame, "Logga in här: ");
    	ArrayList<User> users = gr.getUsers();
    	for(User u : users) {
    		if(u.getID().equals(userID)) {
    			loggedin=true;
    			break;
    		}    		
    	}
    	if(!loggedin) {
    		if (JOptionPane.showConfirmDialog(null, "Your login was not correct! Try again?", "WARNING",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {    
    		} else {
    			System.exit(0);
    		}
    	}
    }


public String getLogin() {
	return this.userID;

	}
public Boolean getLoggedIn() {
	return loggedin;

	}
}