import java.awt.*; 
import javax.swing.*;

class TeamFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel name,deadline;
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
		p1.add(name);
		p2.add(deadline);
		add(p1);
		add(p2);
	}
}