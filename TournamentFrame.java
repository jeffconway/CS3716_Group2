import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TournamentFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField name,deadline, location, maxTeams;
	JLabel nLabel,dLabel, lLabel, mLabel, errorLabel;
	JButton submit;
	JPanel p1,p2,p3;
	static java.util.List<Tournament> to;

	TournamentFrame(java.util.List<Tournament> tour) {
		to = tour;
		nLabel = new JLabel("Enter Name: ");
		name = new JTextField(20);
		dLabel = new JLabel("Enter Deadline: ");
		deadline = new JTextField(10);
		lLabel = new JLabel("Enter Location: ");
		location = new JTextField(20);
		mLabel = new JLabel("Enter Maximum Number Teams: ");
		maxTeams = new JTextField(10);
		submit = new JButton("Submit");
		errorLabel = new JLabel("");
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
       			if ((name.getText().trim().isEmpty()) || (deadline.getText().trim().isEmpty()) || (location.getText().trim().isEmpty()) || (maxTeams.getText().trim().isEmpty())) {
       				errorLabel.setForeground(Color.RED);
       				errorLabel.setText("Must fill out all fields to create Tournament!");
       				p3.add(errorLabel);
       			}
       			else {
	           		JOptionPane.showMessageDialog(null, "Tournament Created!");
					String n = name.getText();
					String d = deadline.getText();
					Tournament t = new Tournament(d,n);
					to.add(t);
					//System.out.println("Name: " + tour.get(0).getName());
					//System.out.println("Deadline: " + tournaments.get(0).getDeadline());
					dispose();
       			}
       	 	}          
      	});

		p1.add(nLabel);		
		p1.add(name);	
		p2.add(dLabel);	
		p2.add(deadline);
		p1.add(lLabel);		
		p1.add(location);	
		p2.add(mLabel);	
		p2.add(maxTeams);
		p3.add(submit);	
		p3.add(errorLabel);

		add(p1);
		add(p2);	
		add(p3);
	}
}