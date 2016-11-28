import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class AddPlayerFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2;
	JPanel p1,p2,p3,p4;
	Player p;
	static Team te;
	static Tournament to;
	static java.util.List<Tournament> tournaments;
	private JFrame f;

	public AddPlayerFrame(Tournament tour,Team t,JFrame fr,java.util.List<Tournament> tou) {
		f = fr;
		to = tour;
		tournaments = tou;
		te = t;
		f.setTitle("Add Player");
		f.setSize(600,400);
		f.setLayout(new GridLayout(4, 1));
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p4 = new JPanel();
		p4.setLayout(new FlowLayout());

		l1 = new JLabel("Name: ");
		t1 = new JTextField(20);
		p1.add(l1);
		p1.add(t1);
		l2 = new JLabel("Age: ");
		t2 = new JTextField(10);
		p1.add(l2);
		p1.add(t2);
		l3 = new JLabel("Height (cm): ");
		t3 = new JTextField(10);
		p2.add(l3);
		p2.add(t3);
		l4 = new JLabel("Weight (lbs): ");
		t4 = new JTextField(10);
		p2.add(l4);
		p2.add(t4);
		l5 = new JLabel("Gender (M/F/other): ");
		t5 = new JTextField(2);
		p2.add(l5);
		p2.add(t5);
		b1 = new JButton("Submit Player");
		b1.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				String name = t1.getText().trim();
				int age = Integer.parseInt(t2.getText().trim());
				float height = Float.valueOf(t3.getText().trim());
				float weight = Float.valueOf(t4.getText().trim());
				String gender = t5.getText().trim();
				p = new Player(name,gender,age,height,weight);
				te.addPlayer(p);
				removePanels();
				AddTeamFrame atf = new AddTeamFrame(to,f,tournaments);
		   	 }          
		 });
		b2 = new JButton("Back");
		b2.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				removePanels();
				AddTeamFrame atf = new AddTeamFrame(to,f,tournaments);
		   	}          
		});
		p3.add(b1);
		p4.add(b2);
	
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
}
