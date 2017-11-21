import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Hockey extends PApplet {
	
	private JFrame window;
	
	private JPanel cardPanel;
	
	private OptionPanel panel1;    
	private Board board;
	
	private PSurfaceAWT.SmoothCanvas canvas;

	
	public static void main(String args[]) {
		
//		MainMenu board = new MainMenu();
//		Board board = new Board();
//		BoardAI board = new BoardAI();
		EverythingBoard board = new EverythingBoard();
		
		PApplet.runSketch(new String[]{""}, board);
		PSurfaceAWT surf = (PSurfaceAWT) board.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		
		window.setLocation(0, 0);
//		window.setLocation(300, 100);
		
		window.setSize(1275, 700);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);		
	}
	
//	public Hockey() { 
//		
////		MainMenu board = new MainMenu();
//		Board board = new Board();
////		BoardAI board = new BoardAI();
//				
//		PApplet.runSketch(new String[]{""}, board);
//		PSurfaceAWT surf = (PSurfaceAWT) board.getSurface();
//		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
//		JFrame window = (JFrame)canvas.getFrame();
//		
//		window.setLocation(0, 0);
////		window.setLocation(300, 100);
//		
//		window.setSize(1275, 700);
//		window.setMinimumSize(new Dimension(100,100));
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setResizable(true);
//		window.setVisible(true);	
//		
//		cardPanel = new JPanel();
//	    CardLayout cl = new CardLayout();
//	    cardPanel.setLayout(cl);
//	    
//	    window.getContentPane().removeAll();
//	    
//		panel1 = new OptionPanel(this);    
//	    board = new Board();
//	    
//	    cardPanel.add(panel1,"1");
//	    cardPanel.add(canvas,"2");
//	    
//	    window.setLayout(new BorderLayout());
//	    
//	    window.add(cardPanel);
//	    window.revalidate();
//	}
//	
//	public static void main(String[] args) {
//		Hockey h = new Hockey();
//	}
//	
//	
//	public void changePanel() {
//		((CardLayout)cardPanel.getLayout()).next(cardPanel);
//		canvas.requestFocus();
//	}
	
}