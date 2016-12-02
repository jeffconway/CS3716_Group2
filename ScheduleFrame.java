import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class ScheduleFrame extends JFrame {
	JLabel j1,j2;
	JButton b1, ba;
	JPanel p1, p2,p3;
	Divisions d1;
	JTextArea f1;
    Team t1;
    Match m1;
	SingleElimination s1;
	JFrame f;
	static java.util.List<Tournament> tournaments;
	TournamentFrame tou1;   // JRadioButton single, division;
	
	
	public ScheduleFrame(Tournament tt,JFrame fra,java.util.List<Tournament> to){   // layout will be set up later
		f=fra;
		tournaments = to;
		ba = new JButton("Back");												/*back button*/
		ba.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				removePanels(f);
				ListFrame lf = new ListFrame(f,tournaments);
		   	}          
		});
		
		f.setTitle("Schedule Frame");
		f.setSize(600,400);
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		j2 = new JLabel("");
		
		//f1.setText.toString(s1.getSchedule(tt));

		String[] names = new String[tt.getTeams().size()]; 
		if (tt.getFormat().getType().equals("s")) {
			j1 = new JLabel("Single Elimination Schedule: ");
			SingleElimination s = new SingleElimination();
			if (!tt.getMatched()) {
				tt.setMatched(true);
				s.setSchedule(tt);   // set the schedule for single elimination
			}
		}
		else if (tt.getFormat().getType().equals("d")) {
			j1 = new JLabel("Divisions Schedule: ");
			Divisions d = new Divisions();
			if (!tt.getMatched()) {
				tt.setMatched(true);
				d.setSchedule(tt);   // set the schedule for divisions
			}
		}
		
		p1.add(j1);
		p3.add(ba);
		f.add(p3);
		
		for (int i=0; i<tt.getMatches().size(); i++) { 
			names[i] =  tt.getMatches().get(i).getTeam1().getTeamName();    // get the name of teams and store them in the name list
			names[i+1] =  tt.getMatches().get(i).getTeam2().getTeamName();
			j2.setText(j2.getText()+" Match ["+names[i]+" .vs. "+names[i+1]+"] ");       // display each of team in the text area  to be displayed     
			p2.add(j2);
		}
		f.add(p1);
		f.add(p2);
		f.revalidate();
		f.repaint();
	}
	private void removePanels(JFrame f) {												/*removes the panels from the frame so the updated panels can be added*/
		f.remove(p1);
		f.remove(p2);
		f.remove(p3);
	}
	
}
