import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class Puck {
	
	PShape puck;
	int x, y, radius;
	int vx, vy, vxm, vym;
	
	public Puck(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.vx = 0;
		this.vy = 0;
		this.vxm = 1;
		this.vym = 1;
	}
	
	public void setup(PApplet drawer) {
		newPuck(drawer);
	}
	
	public void newPuck(PApplet drawer) {
		puck = drawer.createShape(PConstants.ELLIPSE, x, y , radius*2, radius*2);
		puck.setFill(200);
		puck.setStrokeWeight(2);
	}
	
	public void draw(PApplet drawer) {
		drawer.shape(puck);
		act(drawer);
	}
	
	public void setVelocity(int vx, int vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	public void act(PApplet drawer) {
		if ((x > drawer.width - radius || x < radius) && (y >= 2*drawer.height/9 && y <= 5*drawer.height/9)) {
			vxm *= 1;
			vym *= 1;
		}
		else if ((x > drawer.width - radius) || (x < radius)) {
			vxm *= -1;   
		}
		else if ((y > drawer.height - radius) || (y < radius)) {
			vym *= -1;   
		}
		
		x += vx * vxm;
		y += vy * vym;
		
		newPuck(drawer);
		
	}
	
	
	
	
	
	
	
	
	
}
