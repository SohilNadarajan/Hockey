import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class Puck {
	
	PShape puck;
	int x, y, radius;
	int vx, vy;
	
	public Puck(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.vx = 0;
		this.vy = 0;
	}
	
	public void setup(PApplet drawer) {
		newPuck(drawer);
	}
	
	public void newPuck(PApplet drawer) {
		puck = drawer.createShape(PConstants.ELLIPSE, x, y , radius, radius);
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
		x += vx;
		y += vy;
	//	newPuck(drawer);
		if (x > 1275 - 50 || x < 0) {
			vx *= -1;   
			
		}
		if (y > 700 - 50 || y < 0) {
			vy *= -1;
		}
	}
	
	
	
	
	
	
	
	
	
}
