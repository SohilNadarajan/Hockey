import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Hockey {
	
	
	public static void main(String args[]) {
		Board board = new Board();
		PApplet.runSketch(new String[]{""}, board);
		PSurfaceAWT surf = (PSurfaceAWT) board.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		
<<<<<<< HEAD
		window.setLocation(300, 100);
=======
		window.setLocation(0, 0);
>>>>>>> a02e11d6eb49bf86775d79b970823fbeb352e1a2
		window.setSize(1275, 700);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);
	}
}