import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TournamentFrame extends JFrame {
	JTextField name,deadline;
	JLabel nLabel,dLabel;
	JButton submit;
	JPanel p1,p2,p3;
	static java.util.List<Tournament> to;

	TournamentFrame(java.util.List<Tournament> tour) {
		to = tour;
		nLabel = new JLabel("Enter Name: ");
		name = new JTextField(20);
		dLabel = new JLabel("Enter Deadline: ");
		deadline = new JTextField(20);
		submit = new JButton("Submit");
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());

		setTitle("Create Tournament");
      	setSize(400,400);
      	setLayout(new GridLayout(3, 1));
		
		submit.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent e) {
           		JOptionPane.showMessageDialog(null, "Tournament Created!");
				String n = name.getText();
				String d = deadline.getText();
				Tournament t = new Tournament(d,n);
				to.add(t);
				//System.out.println("Name: " + tour.get(0).getName());
				//System.out.println("Deadline: " + tournaments.get(0).getDeadline());
				dispose();
       	 	}          
      	});

		p1.add(nLabel);		
		p1.add(name);	
		p2.add(dLabel);	
		p2.add(deadline);	
		p3.add(submit);	

		add(p1);
		add(p2);	
		add(p3);
	}
}
