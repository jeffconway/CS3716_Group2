import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class TeamFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel name,deadline;
	JButton b1,b2,b3,b4;
	JComboBox<?> cb;
	JPanel p1,p2,p3,p4;
	AddTeamFrame f1;
	static Tournament to;
	static java.util.List<Tournament> tournaments;
	private JFrame f;
	
	TeamFrame(Tournament t,JFrame fr,java.util.List<Tournament> tour) {
		f = fr;
		tournaments = tour;
		to = t;
		f.setTitle("Manage Teams");
		f.setSize(400,600);
   		f.setLayout(new GridLayout(4, 1));
		p1 = new JPanel();
      	p1.setLayout(new FlowLayout());
		p2 = new JPanel();
      	p2.setLayout(new FlowLayout());
		p3 = new JPanel();
      	p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
		p4 = new JPanel();
		p4.setLayout(new FlowLayout());

		name = new JLabel("Name: " + t.getName());
		deadline = new JLabel("Deadline: " + t.getDeadline());
		String[] names = new String[t.getTeams().size()];
		for (int i=0; i<t.getTeams().size(); i++) {
			names[i] = t.getTeams().get(i).getTeamName();
		}
		cb = new JComboBox<Object>(names);
		b1 = new JButton("Add Team");
		b1.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				removePanels();
				f1 = new AddTeamFrame(to,f,tournaments);
		   	}          
		});
		b2 = new JButton("Edit Team");
		b2.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				//edit team here
		   	}          
		});
		b3 = new JButton("Back");
		b3.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				removePanels();
				ListFrame lf = new ListFrame(f,tournaments);
		   	}          
		});
		b4 = new JButton("Delete");
		b4.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				tournaments.remove(to);
				updateFile();
				removePanels();
				ListFrame lf = new ListFrame(f,tournaments);
		   	}          
		});
		for (int i=0; i<t.getTeams().size();i++) {
			JLabel temp = new JLabel((i+1)+". Name: "+t.getTeams().get(i).getTeamName());
			p3.add(temp);
		} 
		
		p4.add(b3);
		p4.add(b4);		
		p1.add(name);
		p1.add(deadline);
		p2.add(b1);	
		p2.add(cb);
		p2.add(b2);
		f.add(p4);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.revalidate();
		f.repaint();
	}
	private void removePanels() {
		f.remove(p1);
		f.remove(p2);
		f.remove(p3);
		f.remove(p4);
	}
	private void updateFile() {
		try {
				FileOutputStream fileOut = new FileOutputStream("data.txt");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(tournaments);
				out.close();
				fileOut.close();
			}
			catch(FileNotFoundException ex) {
				ex.printStackTrace();		
			}
			catch(IOException ex) {
				ex.printStackTrace();		
			}
	}
}
