import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
 
public class TournamentInit {
    
   	private JFrame f,f1,f2;
   	private JPanel controlPanel,controlPanel2,controlPanel3;
	private java.util.List<Tournament> tournaments;
	private JButton createTournament,checkTournaments;

	private void removePanels() {
		f.remove(controlPanel);
		f.remove(controlPanel2);
		f.remove(controlPanel3);
	}
	private void createFrame() {
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
		   		f1 = new TournamentFrame(f,tournaments);
				removePanels();
		 	}
		});
		checkTournaments.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
        		f2 = new ListFrame(f,tournaments);
				removePanels();
      		}
   		});
      	controlPanel2.add(createTournament); 
	  	controlPanel3.add(checkTournaments);  
		f.add(controlPanel);
		f.add(controlPanel2);
		f.add(controlPanel3);
	}

  	public TournamentInit(){
		tournaments = new ArrayList<Tournament>();
      	f = new JFrame("Tournament Organizer");
      	createFrame();
      	f.setVisible(true);
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		try {
			fileIn = new FileInputStream("data.ser");
			in = new ObjectInputStream(fileIn);
			tournaments = (ArrayList<Tournament>) in.readObject();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();		
		}
		catch(IOException e) {}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (in != null) {
					in.close();
					fileIn.close();
				}
			}
			catch(IOException e) {
				e.printStackTrace();		
			}
		}
 	} 
	public TournamentInit(JFrame fr,java.util.List<Tournament> to) {
		tournaments = to;
		f = fr;
		createFrame();
		f.revalidate();
		f.repaint();
	}

	public static void main(String[] args){
      new TournamentInit();
   }
}
