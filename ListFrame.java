import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class ListFrame extends JFrame {
	teamFrame f;
 	JPanel p1,p2,p3;
 	JLabel l1,l2;
	static int i;
	static java.util.List<Tournament> to;

 	ListFrame(java.util.List<Tournament> tournaments) {
		to = tournaments;
		setTitle("List Teams");
       	setSize(400,800);
      	setLayout(new GridLayout(tournaments.size(), 1));
		for (i=0; i<tournaments.size();i++) {
			p1 = new JPanel();
			p2 = new JPanel();
			p3 = new JPanel();
			l1 = new JLabel((i+1)+". "+"Name: \t"+tournaments.get(i).getName());
			p1.add(l1);
			l2 = new JLabel("Deadline: \t"+tournaments.get(i).getDeadline());
			p2.add(l2);
			JButton b = new JButton("Edit Tournament");
			p3.add(b);
			b.addActionListener(new ActionListener() {
				final int j=i+1;
		   		public void actionPerformed(ActionEvent e) {
					f = new teamFrame(to.get(j-1));
					f.setVisible(true);
		   	 	}          
		  	});
			add(p1);
			add(p2);
			add(p3);
		}
	}
}
