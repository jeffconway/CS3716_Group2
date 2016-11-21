import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class AddTeamFrame extends JFrame {
	JLabel l1;
	JTextField t1;
	JButton b1,b2;
	JPanel p1,p2,p3;
	AddPlayerFrame f1;
	static Team te = new Team("");

	public AddTeamFrame(Tournament t) {
		setTitle("Add Team");
		setSize(600,400);
		setLayout(new GridLayout(3, 1));
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());

		l1 = new JLabel("Team Name: ");
		t1 = new JTextField(20);
		p1.add(l1);
		p1.add(t1);
		b1 = new JButton("Add Player");
		b1.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				f1 = new AddPlayerFrame(te);
				f1.setVisible(true);
		   	 }          
		 });
		p2.add(b1);
		b2 = new JButton("Submit Team");
		p3.add(b2);
	
		add(p1);
		add(p2);
		add(p3);
	}
}
