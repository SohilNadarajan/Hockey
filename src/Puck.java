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
	
	public void print() {
		System.out.println(this.x + ", " + this.y + " : " + this.vx + ", "+ 
	this.vy + " : " + this.vxm + ", " + this.vym);
	}
	
	public void act(PApplet drawer) {
//		if ((x > drawer.width - radius || x < radius) && 
//				(y >= 2.0*drawer.height/9 && y <= 7.0*drawer.height/9)) {
//			vxm *= 1;
//			vym *= 1;
//		}
		 if (x > drawer.width - radius) {
			//vxm *= -1;
			 vx *= -1;
			x = drawer.width - radius;
		} else if (x < radius) {
	    		//vxm *= -1;
			vx *= -1;
	    		x = radius;
	    } else if (y > drawer.height - radius) {
			//vym *= -1;
	    		vy *= -1;
			y = drawer.height - radius;
		} else if (y < radius) {
			//vym *= -1;
			vy *= -1;
			y = radius;
		}

		x += vx ;//* vxm;
		y += vy ;//* vym;
		newPuck(drawer);		
	}
	
	
	
	
	
	
	
	
	
}
