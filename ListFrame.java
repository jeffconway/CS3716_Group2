import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

class ListFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TeamFrame f;
 	JPanel p1,fill,listPane;
 	JLabel l1,l2;
	static int i;
	static java.util.List<Tournament> to;

 	ListFrame(java.util.List<Tournament> tournaments) {
		to = tournaments;
		setTitle("List Teams");
       	setSize(400,800);
	listPane=new JPanel();
      	listPane.setLayout(new BoxLayout(listPane,BoxLayout.Y_AXIS));
		for (i=0; i<tournaments.size();i++) {
			p1 = new JPanel();
                        p1.setPreferredSize(new Dimension(400,65));
                        p1.setMaximumSize(p1.getPreferredSize());
			l1 = new JLabel((i+1)+". "+"Name: \t"+tournaments.get(i).getName());
			p1.add(l1);
			l2 = new JLabel("Deadline: \t"+tournaments.get(i).getDeadline());
			p1.add(l2);
			JButton b = new JButton("Edit Tournament");
			p1.add(b);
			b.addActionListener(new ActionListener() {
				final int j=i+1;
		   		public void actionPerformed(ActionEvent e) {
					f = new TeamFrame(to.get(j-1));
					f.setVisible(true);
		   	 	}          
		  	});
			listPane.add(p1);
		}

	Component glue = Box.createVerticalGlue();
	listPane.add(glue);
	add(listPane);
	}
}