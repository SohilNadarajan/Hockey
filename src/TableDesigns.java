
import java.awt.Color;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class TableDesigns {

	PShape goal1, goal2;
	PShape centerLine, centerCircle;
	PShape goalBox1, goalBox2;
	
	public TableDesigns() {		
	}

	public void setup(PApplet drawer) {
		int goalLength = 5*drawer.height/9;
		int goalStartingPoint = 2*drawer.height/9;
		
		goal1 = drawer.createShape(PConstants.RECT, 0, goalStartingPoint, 10, goalLength);
		goal1.setFill(0);
		goal2 = drawer.createShape(PConstants.RECT, drawer.width - 10, goalStartingPoint, 
				10, goalLength);
		goal2.setFill(0);
		
		
		centerCircle = drawer.createShape(PConstants.ELLIPSE, drawer.width/2, drawer.height/2, 
				300, 300);
		centerCircle.setStroke(drawer.color(Color.blue.getRGB()));
		centerCircle.setFill(255);
		
		centerLine = drawer.createShape(PConstants.LINE, drawer.width/2, 0, 
				drawer.width/2, drawer.height);
		centerLine.setStroke(drawer.color(Color.red.getRGB()));
		
		goalBox1 = drawer.createShape(PConstants.ELLIPSE, 0, drawer.height/2, goalLength, goalLength);
		goalBox1.setStroke(drawer.color(Color.blue.getRGB()));
		goalBox1.setFill(255);
		goalBox2 = drawer.createShape(PConstants.ELLIPSE, drawer.width, drawer.height/2, goalLength, goalLength);
		goalBox2.setStroke(drawer.color(Color.blue.getRGB()));
		goalBox2.setFill(255);
	}

	public void draw(PApplet drawer) {
		setup(drawer);
		drawer.shape(goalBox1);
		drawer.shape(goalBox2);
		drawer.shape(centerCircle);
		drawer.shape(centerLine);
		drawer.shape(goal1);
		drawer.shape(goal2);
	}
}
