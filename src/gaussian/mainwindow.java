package gaussian;

import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class mainwindow extends JFrame implements ActionListener {
	menudisplay menu = new menudisplay();

	public mainwindow() {

		// adds startup menu
		add(menu);
		menu.points.addActionListener(this);
		menu.depth.addActionListener(this);
		// initializing stuff
		setSize(1000, 100);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		//resizes and repositions frame
		setSize(1080, 720);
		setLocationRelativeTo(null);
		// gets values
		int depth = Integer.parseInt(menu.depth.getText());
		int points = Integer.parseInt(menu.points.getText());
		// corrects for depth
		int newpoints = points / depth;
		// swaps panels
		getContentPane().removeAll();
		getContentPane().invalidate();
		display content = new display(newpoints, depth);
		add(content);
		getContentPane().add(content);
		getContentPane().revalidate();
	}
}
