import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class login {
    JFrame frame = new JFrame();
    String userID = JOptionPane.showInputDialog(frame, "Logga in här: ");
    


public String getLogin() {
	return this.userID;

	}
}