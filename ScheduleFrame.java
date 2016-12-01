import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class ScheduleFrame extends JFrame {
	JLabel j1,j2;
	JButton b1;
	JPanel p1;
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

		f.setTitle("Schedule Frame");
		
		f.setSize(600,400);
		
		p1=new JPanel();
		
		j1= new JLabel("Single Elimination Schedule: ");
		
		f1 = new JTextArea();    // single elimination schedule to be displayed in here
		
		//f1.setText.toString(s1.getSchedule(tt));

		String[] names = new String[tt.getTeams().size()];    // 
		SingleElimination s = new SingleElimination();
		s.setSchedule(tt);   // set the schedule for single elimination
		
		for (int i=0; i<tt.getTeams().size(); i++) { 
			names[i] =  tt.getTeams().get(i).getTeamName();   // get the name of teams and store them in the name list
			f1.setText(names[i]);       // display each of team in the text area  to be displayed      
			
		}
		
		
		p1.add(j1);
		
		p1.add(f1);
		f.add(p1);
		f.revalidate();
		f.repaint();
	}
	
	
}
