
import java.awt.Color;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class TableDesigns {

	PShape goal1, goal2;
	int x, y, radius;

	
	public TableDesigns() {		
	}

	public void setup(PApplet drawer) {
		goal1 = drawer.createShape(PConstants.RECT, 0, drawer.height/5, 10, 3*drawer.height/5);
		goal1.setFill(0);
		goal2 = drawer.createShape(PConstants.RECT, drawer.width - 10, drawer.height/5, 
				10, 3*drawer.height/5);
		goal2.setFill(0);
	}

	public void draw(PApplet drawer) {
		setup(drawer);
		drawer.shape(goal1);
		drawer.shape(goal2);
	}
}
