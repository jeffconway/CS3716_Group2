import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

 
public class TournamentInit {
    
   	private JFrame f,f1,f2;
   	private JPanel controlPanel,controlPanel2,controlPanel3;
	private java.util.List<Tournament> tournaments = new ArrayList<Tournament>();
	private JButton createTournament,checkTournaments;

  	public TournamentInit(){
      	f = new JFrame("Tournament Organizer");
      	f.setSize(400,400);
   		f.setLayout(new GridLayout(4, 1));
   		f.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent windowEvent){
          		System.exit(0);
       		}        
  		});    
		controlPanel = new JPanel();
      	controlPanel.setLayout(new FlowLayout());
		controlPanel2 = new JPanel();
    	controlPanel2.setLayout(new FlowLayout());
		controlPanel3 = new JPanel();
    	controlPanel3.setLayout(new FlowLayout());
		createTournament = new JButton("Create Tournament");
		checkTournaments = new JButton("Check Tournaments");
		createTournament.setHorizontalTextPosition(SwingConstants.LEFT);   	
		createTournament.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		   		tournamentGUI();
		 	}
		});
		checkTournaments.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
        		listGUI();
      		}
   		});
      	controlPanel2.add(createTournament); 
	  	controlPanel3.add(checkTournaments);  
		f.add(controlPanel);
		f.add(controlPanel2);
		f.add(controlPanel3);     
      	f.setVisible(true); 
 	} 
	private void tournamentGUI() {
		f1 = new TournamentFrame(tournaments);
		f1.setVisible(true);
	}
	private void listGUI() { 
		f2 = new ListFrame(tournaments);
		f2.setVisible(true);
	}

	public static void main(String[] args){
      new TournamentInit();
   }
}