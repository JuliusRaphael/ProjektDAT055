import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.util.*;
import java.util.*;
import java.util.*;

public class Gui extends JFrame{
		JPanel jp;
		JMenu fileMenu;
		JMenu helpMenu;
		JMenuBar menubar;
		JMenuItem quit;
		JMenuItem login;
		JMenuItem help;
		JLabel jl;
		JLabel jl2;
		JLabel jl3;
		JLabel jl4;
		JPanel queuePanel;
		JPanel votePanel;
		JPanel scorePanel;
		JPanel qOrderPanel;
		JPanel qOrderList;
		JPanel votingPanel;
		JPanel scores;
		Group group;
		ArrayList<JLabel> queueUsers;
		ArrayList<JLabel> highScoreUsers;
		ArrayList<JLabel> ratingLabels;
		ArrayList<JButton> votingButtons;
		
		public Gui(Group gr){
			this.group = gr;
			queueUsers = new ArrayList<>();
			votingButtons = new ArrayList<>();
			ratingLabels = new ArrayList<>();
			highScoreUsers = new ArrayList<>();
		}	
		
		
		
		public void makeFrame(){
			
			//MENUBAR
			makeMenuBar();
			
			//MAINWINDOW JPANEL 1,3 GRID
			jp = new JPanel(new GridLayout(1,3));
			
			//CREATE USER LABELS. SAVED IN queueUsers AND highScoreUsers
			makeUserLabels();
			
			//CREATES QUEUE
			makeQueue(queueUsers.size());
			
			//CREATE VOTING MENU
			makeVotingMenu();
			
			//CREATE HIGH SCORE LIST
			makeHighScore(highScoreUsers.size());
			
			setSize(1100,500);
			add(jp);
			pack();
			setVisible(true);
			
		}


		private void sendVote(int i) {
			System.out.println("Du gav tomas en: " + i);	
		}
		//CREATES THE PANEL AND LIST FOR HIGHSCORE
		private void makeHighScore(int noOfUsers) {
			
			scorePanel = new JPanel();
			scorePanel.setBorder(new EtchedBorder());
			scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
				jl3 = new JLabel("Fikascore");
				jl3.setBorder(new EtchedBorder());
				scores = new JPanel(new GridLayout(noOfUsers,3));
				scores.setBorder(new EtchedBorder());
				
				makeRatingLabels(noOfUsers);
				
				for(int i = 0; i < noOfUsers; i++) {
									
					
					scores.add(makePositionLabels(noOfUsers).get(i));
					scores.add(highScoreUsers.get(i));
					scores.add(ratingLabels.get(i));
				}
				
			scorePanel.add(jl3);
			scorePanel.add(scores);
			jp.add(scorePanel);
		}
		
		
		//CREATES POSITIONLABELS FOR HIGH SCORE
		private ArrayList<JLabel> makePositionLabels(int noOfLabels) {
			ArrayList<JLabel> labels = new ArrayList<>();
			for(int i = 1; i <= noOfLabels; i++) {
				JLabel temp = new JLabel(Integer.toString(i));
				labels.add(temp);
			}			
			return labels;
		}
		//CREATES SCORELABELS FOR HIGHSCORE
		private void makeRatingLabels(int noOFLabels) {
			
			for(User u: group.getUsers()) {
			
			JLabel temp = new JLabel(Integer.toString(u.getRating()));
			ratingLabels.add(temp);

			}
		}
		//CREATES USER LABELS
		private void makeUserLabels() {
					
			for(User u: group.getUsers()) {
				
				queueUsers.add(new JLabel(u.getID()));
				highScoreUsers.add(new JLabel(u.getID()));
				
			}	
		}
		//CREATES QUEUE PANEL AND ADDS USERLABELS
		private void makeQueue(int noOfUsers) {
			queuePanel = new JPanel();
			queuePanel.setLayout(new BoxLayout(queuePanel, BoxLayout.PAGE_AXIS));
			queuePanel.setBorder(new EtchedBorder());		
				jl = new JLabel("Kölista");
				jl.setBorder(new EtchedBorder());	
				
				qOrderPanel = new JPanel();
				qOrderPanel.setBorder(new EtchedBorder());	
				
					jl4 = new JLabel("Nästa");
					jl4.setBorder(new EtchedBorder());

				
					qOrderList = new JPanel(new GridLayout(noOfUsers,1));
					
						qOrderList.setBorder(new EtchedBorder());	
						qOrderList.setLayout(new BoxLayout(qOrderList, BoxLayout.PAGE_AXIS));
						for(JLabel label: queueUsers) {
							
							qOrderList.add(label);
						}
							
					
					qOrderPanel.add(jl4, JPanel.TOP_ALIGNMENT);
					qOrderPanel.add(qOrderList);
						
				queuePanel.add(jl);	
				queuePanel.add(qOrderPanel);
				jp.add(queuePanel);
		}
		//CREATES VOTING BUTTONS
		private void makeVotingButtons(int noOfButtons) {
			for(int i = 0; i < noOfButtons; i++) {
				final Integer innerMi = new Integer(i+1);
				JButton temp = new JButton(Integer.toString(i+1));
				
				temp.setPreferredSize(new Dimension(40,40));
				votingButtons.add(temp);
				votingPanel.add(temp);
				temp.addActionListener((e) -> {sendVote(innerMi);});
			}	
		}
		//CREATES VOTING MENU
		private void makeVotingMenu() {
			votePanel = new JPanel();
			votePanel.setBorder(new EtchedBorder());
			votePanel.setLayout(new BoxLayout(votePanel, BoxLayout.PAGE_AXIS));
			
			jl2 = new JLabel("Rösta på: ");
			jl2.setBorder(new EtchedBorder());	
			
			JPanel subHeadPanel = new JPanel();
			subHeadPanel.setBorder(new EtchedBorder());
			subHeadPanel.setLayout(new BoxLayout(subHeadPanel, BoxLayout.PAGE_AXIS));
			
			votingPanel = new JPanel(new GridLayout(1,5));
			votingPanel.setBorder(new EtchedBorder());
			makeVotingButtons(5);
				
			subHeadPanel.add(new JLabel("Tomas fika"));	
			subHeadPanel.add(votingPanel);
					
			votePanel.add(jl2);
			votePanel.add(subHeadPanel);
			votePanel.add(new JPanel());
			jp.add(votePanel);
			
		}
		//MAKES MENUBAR
		private void makeMenuBar() {
			
			fileMenu = new JMenu("File");
			login = new JMenuItem("Login");
			fileMenu.add(login);
			
			quit = new JMenuItem("Quit");
			fileMenu.add(quit);
		
			helpMenu = new JMenu("Help");
			help = new JMenuItem("Help");
			helpMenu.add(help);
		
			menubar = new JMenuBar();
			menubar.add(fileMenu);
			menubar.add(helpMenu);
			setJMenuBar(menubar);
		}
		
}
