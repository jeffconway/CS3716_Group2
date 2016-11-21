import java.awt.*; 
import javax.swing.*;
import java.util.*;

class ListFrame extends JFrame
{
  JPanel p1,p2;
  JLabel l1,l2;

  ListFrame(java.util.List<Tournament> list)
  {
        setSize(400,800);
      	setLayout(new GridLayout(list.size(), 1));
	for (int i=0; i<list.size();i++) {
		p1 = new JPanel();
		p2 = new JPanel();
		l1 = new JLabel((i+1)+". "+"Name: \t"+list.get(i).getName());
		p1.add(l1);
		l2 = new JLabel("Deadline: \t"+list.get(i).getDeadline());
		p2.add(l2);
		add(p1);
		add(p2);
	}
  }

}
