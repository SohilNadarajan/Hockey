
import java.awt.Color;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class TableDesigns {

	PShape goal1, goal2;
	PShape centerLine, centerCircle;
	
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
		
		centerLine = drawer.createShape(PConstants.LINE, drawer.width/2, 0, 
				drawer.width/2, drawer.height);
		centerLine.setStroke(drawer.color(Color.red.getRGB()));

	}

	public void draw(PApplet drawer) {
		setup(drawer);
		drawer.shape(goal1);
		drawer.shape(goal2);
		drawer.shape(centerCircle);
		drawer.shape(centerLine);
	}
}
