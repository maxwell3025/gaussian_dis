package gaussian;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class display extends JPanel {
	int[] values;
	BufferedImage screen;
	Graphics2D graphics;

	public display(int samples, int layers) {
		values = new int[samples * layers];
		gendata(0, values, layers, samples);
		setBackground(new Color(255, 255, 255));
		//borders:)
		Border b = BorderFactory.createLineBorder(new Color(0,255,255));
		Border a = BorderFactory.createLineBorder(new Color(255,0,0));
		Border lev1 = BorderFactory.createCompoundBorder(a,b);
		Border lev2 = BorderFactory.createCompoundBorder(lev1,lev1);
		Border lev3 = BorderFactory.createCompoundBorder(lev2,lev2);
		Border lev4 = BorderFactory.createCompoundBorder(lev3,lev3);
		Border lev5 = BorderFactory.createCompoundBorder(lev4,lev4);
		Border lev6 = BorderFactory.createCompoundBorder(lev5,lev5);
		Border lev7 = BorderFactory.createCompoundBorder(lev6,lev6);
		Border lev8 = BorderFactory.createCompoundBorder(lev7,lev7);
		Border lev9 = BorderFactory.createCompoundBorder(lev8,lev8);
		setBorder(lev4);
		setVisible(true);
	}

	public void gendata(int startpoint, int[] target, int thickness, int size) {
		if (thickness == 0) {
			target[startpoint]++;
		} else {
			for (int i = 0; i < size; i++) {
				gendata(startpoint + i, target, thickness - 1, size);
			}
		}
	}

	public int findmax(int[] in) {
		int current = in[0];
		for (int i = 1; i < in.length; i++) {
			if (current < in[i]) {
				current = in[i];
			}
		}
		return current;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//generates canvas
		screen = new BufferedImage(getWidth(),getHeight() , BufferedImage.TYPE_INT_RGB);
		graphics = screen.createGraphics();
		//draws background
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, screen.getWidth(), screen.getHeight());
		graphics.setColor(Color.BLACK);
		//finds graph raw dimensions
		double graphheight = findmax(values);
		double graphwidth = values.length;
		//calculates aspect ratios 
		double ratioy = (double)getHeight()/(double)graphheight;
		double ratiox = (double)graphwidth/(double)getWidth();
		//draws graph to canvas
		for (int i = 1; i < getWidth(); i++) {
			int top = (int)Math.max((values[(int)Math.floor(i*ratiox)]*ratioy),Math.floor(values[(int)((i-1)*ratiox)]*ratioy));
			int bottom = (int)Math.min((values[(int)Math.floor(i*ratiox)]*ratioy),Math.floor(values[(int)((i-1)*ratiox)]*ratioy));
			graphics.drawRect(i, screen.getHeight()-top, 0, top-bottom);
		}
		//copies canvas to screen
		g.drawImage(screen, 0, 0, getWidth(),getHeight(),null);
	}

}
