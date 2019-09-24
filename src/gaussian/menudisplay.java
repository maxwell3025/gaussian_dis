package gaussian;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class menudisplay extends JPanel implements ActionListener {
	// initializes comps
	JLabel pointslabel = new JLabel("enter amount of sample points:", JLabel.CENTER);
	JLabel depthlabel = new JLabel("enter iterations:", JLabel.CENTER);
	JTextField points = new JTextField();
	JTextField depth = new JTextField();

	public menudisplay() {
		// makes layout
		setLayout(new GridLayout(2, 2));
		// sets fonts for labels
		pointslabel.setFont(new Font("yee", 20, 20));
		depthlabel.setFont(new Font(null, 20, 20));
		// adds comps to screen
		add(pointslabel);
		add(points);
		add(depthlabel);
		add(depth);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
