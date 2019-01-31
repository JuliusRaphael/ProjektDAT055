import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;


public class Gui extends JFrame implements ActionListener{
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
		JPanel quenePanel;
		JPanel votePanel;
		JPanel scorePanel;
		JPanel qOrderPanel;
		JPanel qOrderList;
		JPanel voteButtons;
		JPanel scores;
		JButton b1,b2,b3,b4,b5;
		
		public Gui(){

			
			//MENUBAR
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
			
			//MAINWINDOW JPANEL 1,3 GRID
			jp = new JPanel(new GridLayout(1,3));
			
			//THREE Panels for 
			
			//Queuelist
			quenePanel = new JPanel();
			quenePanel.setLayout(new BoxLayout(quenePanel, BoxLayout.PAGE_AXIS));
			quenePanel.setBorder(new EtchedBorder());		
				jl = new JLabel("Kölista");
				jl.setBorder(new EtchedBorder());	
				
				qOrderPanel = new JPanel();
				qOrderPanel.setBorder(new EtchedBorder());	
				
					jl4 = new JLabel("Nästa");
					jl4.setBorder(new EtchedBorder());

				
					qOrderList = new JPanel(new GridLayout(5,1));
					
						qOrderList.setBorder(new EtchedBorder());	
						//qOrderList.setLayout(new BoxLayout(qOrderList, BoxLayout.PAGE_AXIS));
						qOrderList.add(new JLabel("Mellard"));
						qOrderList.add(new JLabel("Alex"));
						qOrderList.add(new JLabel("Julius"));
						qOrderList.add(new JLabel("Berko"));
						qOrderList.add(new JLabel("Tomas"));
					
					qOrderPanel.add(jl4, JPanel.TOP_ALIGNMENT);
					qOrderPanel.add(qOrderList);
						
				quenePanel.add(jl);	
				quenePanel.add(qOrderPanel);
			
			//Voting menu
			votePanel = new JPanel();
			votePanel.setBorder(new EtchedBorder());
			votePanel.setLayout(new BoxLayout(votePanel, BoxLayout.PAGE_AXIS));
			
				jl2 = new JLabel("Rösta på:");
				jl2.setBorder(new EtchedBorder());	
				
				JPanel subHeadPanel = new JPanel();
				subHeadPanel.setBorder(new EtchedBorder());
				subHeadPanel.setLayout(new BoxLayout(subHeadPanel, BoxLayout.PAGE_AXIS));
				
				voteButtons = new JPanel(new GridLayout(1,5));
				voteButtons.setBorder(new EtchedBorder());
					b1 = new JButton("1"); b1.setPreferredSize(new Dimension(40,40));
					b2 = new JButton("2"); b2.setPreferredSize(new Dimension(40,40));
					b3 = new JButton("3"); b3.setPreferredSize(new Dimension(40,40));
					b4 = new JButton("4"); b4.setPreferredSize(new Dimension(40,40));
					b5 = new JButton("5"); b5.setPreferredSize(new Dimension(40,40));
					b5.addActionListener(this);
				
					voteButtons.add(b1);voteButtons.add(b2);voteButtons.add(b3);
					voteButtons.add(b4);voteButtons.add(b5);
					
				subHeadPanel.add(new JLabel("Tomas fika"));	
				subHeadPanel.add(voteButtons);
					
			votePanel.add(jl2);
			votePanel.add(subHeadPanel);
			votePanel.add(new JPanel());


			
			
			//Highscore
			scorePanel = new JPanel();
			scorePanel.setBorder(new EtchedBorder());
			scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.PAGE_AXIS));
				jl3 = new JLabel("Fikascore:");
				jl3.setBorder(new EtchedBorder());
				scores = new JPanel(new GridLayout(5,3));
				scores.setBorder(new EtchedBorder());
					scores.add(new JLabel("1."));scores.add(new JLabel("Tomas"));scores.add(new JLabel("1000"));
					scores.add(new JLabel("2."));scores.add(new JLabel("Alex"));scores.add(new JLabel("700"));
					scores.add(new JLabel("3."));scores.add(new JLabel("Mellard"));scores.add(new JLabel("200."));
					scores.add(new JLabel("4."));scores.add(new JLabel("Berko"));scores.add(new JLabel("100"));
					scores.add(new JLabel("5."));scores.add(new JLabel("Julius"));scores.add(new JLabel("100"));
					
				
			scorePanel.add(jl3);
			scorePanel.add(scores);
			
			jp.add(quenePanel);jp.add(votePanel);jp.add(scorePanel);
			
			
			setSize(1100,500);
			add(jp);
			setVisible(true);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Du gav tomas en 5a!");
			
		}

}
