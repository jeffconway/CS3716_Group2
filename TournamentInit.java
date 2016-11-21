import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

 
public class TournamentInit {
    
   	private JFrame f,f1,f2;
   	private JPanel controlPanel,controlPanel2,controlPanel3;
	private java.util.List<Tournament> tournaments = new ArrayList();
	private JTextField name, deadline;

   public TournamentInit(){
      prepareGUI();
   }

	private void prepareGUI(){
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

		f.add(controlPanel);
		f.add(controlPanel2);
		f.add(controlPanel3);
      	f.setVisible(true);  
   }  

	private void tournamentGUI() {
		f1 = new TournamentFrame(tournaments);
		f1.setVisible(true);
	}

	private void checkGUI() { 
		f2 = new JFrame("Tournament List");
		f2.setSize(400,800);
      	f2.setLayout(new GridLayout(tournaments.size(), 1));
		for (int i=0; i<tournaments.size();i++) {
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JLabel l1 = new JLabel((i+1)+". "+"Name: \t"+tournaments.get(i).getName());
			p1.add(l1);
			JLabel l2 = new JLabel("Deadline: \t"+tournaments.get(i).getDeadline());
			p2.add(l2);
			f2.add(p1);
			f2.add(p2);
		}
		f2.setVisible(true);
	}

	   private void TournamentInit(){
;
		  JButton createTournament = new JButton("Create Tournament");
		  JButton checkTournaments = new JButton("Check Tournaments");
		  createTournament.setHorizontalTextPosition(SwingConstants.LEFT);   

		  createTournament.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
		        tournamentGUI();
		     }
		  });
	
		checkTournaments.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            checkGUI();
         }
      });

      controlPanel2.add(createTournament); 
	  controlPanel3.add(checkTournaments);       

      f.setVisible(true);  
   }

	public static void main(String[] args){
      TournamentInit  init = new TournamentInit();      
      init.TournamentInit();
   }
}
