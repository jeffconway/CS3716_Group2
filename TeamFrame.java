import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

class TeamFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel name,deadline;
	JButton b1,b2;
	JComboBox cb;
	JPanel p1,p2;
	
	TeamFrame(Tournament t) {
		setTitle("Edit Team");
		setSize(400,400);
   		setLayout(new GridLayout(2, 1));
		p1 = new JPanel();
      	p1.setLayout(new FlowLayout());
		p2 = new JPanel();
      	p2.setLayout(new FlowLayout());

		name = new JLabel("Name: " + t.getName());
		deadline = new JLabel("Deadline: " + t.getDeadline());
		String[] names = new String[t.getTeams().size()];
		for (int i=0; i<t.getTeams().size(); i++) {
			names[i] = t.getTeams().get(i).getTeamName();
		}
		cb = new JComboBox(names);
		b1 = new JButton("Add Team");
		b1.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(this,"Add Team!");
		   	 }          
		 });
		b2 = new JButton("Edit Team");
		b2.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(this,"Edit Team!");
		   	 }          
		 });
		

		p1.add(name);
		p1.add(deadline);
		p2.add(b1);	
		p2.add(cb);
		p2.add(b2);
		add(p1);
		add(p2);
	}
}
