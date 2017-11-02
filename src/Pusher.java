
import java.awt.Color;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class Pusher {

	PShape pusher;
	int x, y, radius;

	
	public Pusher(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}


	public void setup(PApplet drawer) {
		boundary(drawer);

		pusher = drawer.createShape(PConstants.ELLIPSE, x, y, radius*2, radius*2);
		pusher.setFill(drawer.color(Color.red.getRGB()));
		pusher.setStrokeWeight(2);
	}

	public void boundary(PApplet drawer) {
		if (x < drawer.width/2) {
			if (x <= radius) {
				x = radius;
			}
			if (x >= drawer.width/2 - radius) {
				x = drawer.width/2 - radius;
			}
			if (y <= radius) {
				y = radius;
			}
			if (y >= drawer.height - radius) {
				y = drawer.height - radius;
			}
		}
	}

	public void draw(PApplet drawer) {
		setup(drawer);
		drawer.shape(pusher);
	}
}
