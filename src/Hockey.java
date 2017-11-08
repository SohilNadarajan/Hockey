import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Hockey extends PApplet {
	
	public static void main(String args[]) {
		
		
		MainMenu board = new MainMenu();
//		Board board = new Board();
//		BoardAI board = new BoardAI();
		
		
		PApplet.runSketch(new String[]{""}, board);
		PSurfaceAWT surf = (PSurfaceAWT) board.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		
//		window.setLocation(0, 0);
		window.setLocation(300, 100);
		
		window.setSize(1275, 700);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);
	}
}