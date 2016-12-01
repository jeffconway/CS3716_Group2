import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class ScheduleFrame extends JFrame {
	JLabel j1,j2;
	JButton b1, ba;
	JPanel p1, p2;
	Divisions d1;
	JTextArea f1;
    Team t1;
    Match m1;
	SingleElimination s1;
	JFrame f;
	static java.util.List<Tournament> to;
	TournamentFrame tou1;   // JRadioButton single, division;
	
	
	public ScheduleFrame(Tournament tt,JFrame fra,java.util.List<Tournament> to){   // layout will be set up later
		f=fra;
		ba = new JButton("Back");												/*back button*/
		ba.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				removePanels(fra);
				TournamentInit lf = new TournamentInit(fra,to);
		   	}          
		});
		
		f.setTitle("Schedule Frame");
		f.setSize(600,400);
		p1 = new JPanel();
		j1 = new JLabel("Single Elimination Schedule: ");
		j2 = new JLabel("");
		
		//f1.setText.toString(s1.getSchedule(tt));

		String[] names = new String[tt.getTeams().size()];    // 
		SingleElimination s = new SingleElimination();
		s.setSchedule(tt);   // set the schedule for single elimination
		
		p1.add(j1);
		f.add(p1);
		
		for (int i=0; i<tt.getTeams().size(); i++) { 
			p2 = new JPanel();
			names[i] =  tt.getTeams().get(i).getTeamName();   // get the name of teams and store them in the name list
			j2.setText(names[i]);       // display each of team in the text area  to be displayed      
			p2.add(j2);
			f.add(p2);
		}
		
		
		f.revalidate();
		f.repaint();
	}
	private void removePanels(JFrame fra) {												/*removes the panels from the frame so the updated panels can be added*/
		fra.remove(listPane);
		fra.remove(p2);
	}
	
}