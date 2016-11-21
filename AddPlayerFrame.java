import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class AddPlayerFrame extends JFrame {
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton b1;
	JPanel p1,p2,p3;
	static Team te;

	public AddPlayerFrame(Team t) {
		te = t;
		setTitle("Add Team");
		setSize(600,400);
		setLayout(new GridLayout(3, 1));
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());

		l1 = new JLabel("Name: ");
		t1 = new JTextField(20);
		p1.add(l1);
		p1.add(t1);
		l2 = new JLabel("Age: ");
		t2 = new JTextField(10);
		p1.add(l2);
		p1.add(t2);
		l3 = new JLabel("Height: ");
		t3 = new JTextField(10);
		p2.add(l3);
		p2.add(t3);
		l4 = new JLabel("Weight: ");
		t4 = new JTextField(10);
		p2.add(l4);
		p2.add(t4);
		l5 = new JLabel("Gender: ");
		t5 = new JTextField(2);
		p2.add(l5);
		p2.add(t5);
		b1 = new JButton("Submit Player");
		b1.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				
		   	 }          
		 });
		p3.add(b1);
	
		add(p1);
		add(p2);
		add(p3);
	}
}
