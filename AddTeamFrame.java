import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class AddTeamFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1;
	JTextField t1;
	JButton b1,b2,b3;
	JPanel p1,p3,p4;
	AddPlayerFrame f1;
	TeamFrame f2;
	static Tournament to;
	static java.util.List<Tournament> tournaments;
	static Team te;
	private JFrame f;

	public AddTeamFrame(Tournament t,JFrame fr,java.util.List<Tournament> tour) {
		f = fr;
		tournaments = tour;
		to = t;
		te = new Team("");
		f.setTitle("Add Team");
		f.setSize(600,400);
		f.setLayout(new GridLayout(4, 1));
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p4 = new JPanel();
		p4.setLayout(new FlowLayout());

		l1 = new JLabel("Team Name: ");
		t1 = new JTextField(20);
		p1.add(l1);
		p1.add(t1);
		b2 = new JButton("Submit Team");
		b2.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				String name = t1.getText().trim();
				te.setTeamName(name);
				to.addTeam(te);
				updateFile();
				removePanels();
				f2 = new TeamFrame(to,f,tournaments);
		   	 }          
		 });
		b3 = new JButton("Back");
		b3.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				removePanels();
				TeamFrame tf = new TeamFrame(to,f,tournaments);
		   	}          
		});
		p4.add(b3);
		p3.add(b2);
	
		f.add(p4);
		f.add(p1);
		f.add(p3);
		f.revalidate();
		f.repaint();
	}
	private void removePanels() {
		f.remove(p1);
		f.remove(p3);
		f.remove(p4);
	}
	private void updateFile() {
		try {
				FileOutputStream fileOut = new FileOutputStream("data.ser");
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
