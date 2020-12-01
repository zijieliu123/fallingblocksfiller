
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocksFiller extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50;

	// instance variables (what kind of data structure should we use?)
	private int[] x = new int [NUMBLOCKS];
	private int[] y = new int [NUMBLOCKS];
	private int[] speed = new int [NUMBLOCKS];
	
	// your code here
	
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		
		// your code here
		for (int i = 0; i < x.length; i++) {
			x[i] = (int)(Math.random()*WIDTH);
			y[i] = (int)(Math.random()*HEIGHT);
			speed[i] = (int)(Math.random()*8+2);
		}
		
		
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {
		// your code here
		
		for (int i = 0; i < x.length; i++) {
 		
		if (y[i] <= HEIGHT) {
 			y[i] += speed[i];
		}
		
		else {
			y[i] = -50;
			x[i] = (int)(Math.random()*WIDTH);
		}
		
		}
	
	
	}
	
	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// color the rectangles blue - you can change this
		g.setColor(Color.blue);
		
		// draw your rectangles here! 
		for (int i = 0; i < x.length; i++) {
			g.fillRect(x[i], y[i], 10, 10);
		}
		
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocksFiller() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocksFiller();
	}

}