import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

class ListFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TeamFrame f;
 	JPanel p1,listPane;
	JButton ba;
 	JLabel l1,l2;
	static int i;
	static java.util.List<Tournament> to;
	private JFrame fra;

 	ListFrame(JFrame fr,java.util.List<Tournament> tournaments) {
		fra = fr;
		to = tournaments;
		fra.setTitle("List Teams");
       	fra.setSize(400,800);
		listPane=new JPanel();
      	listPane.setLayout(new BoxLayout(listPane,BoxLayout.Y_AXIS));
		ba = new JButton("Back");
		ba.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
				removePanels();
				TournamentInit lf = new TournamentInit(fra,to);
		   	}          
		});
		listPane.add(ba);
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
					removePanels();
					f = new TeamFrame(to.get(j-1),fra,to);
		   	 	}          
		  	});
			listPane.add(p1);
		}
		Component glue = Box.createVerticalGlue();
		listPane.add(glue);
		fra.add(listPane);
		fra.revalidate();
		fra.repaint();
	}
	private void removePanels() {
		fra.remove(listPane);
	}
}
