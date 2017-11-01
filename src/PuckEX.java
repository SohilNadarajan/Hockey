import java.awt.Color;

import processing.core.PApplet;
import romwa.shapes.Circle;

public class PuckEX {
	
	Circle shape;
	double x, y, vx, vy;
	double angle0, v0; // Angle starts as radians
	int radius = 10;
	Color colorCB = Color.WHITE;

	public PuckEX(double x, double y, double angle, double v, Color color) {
		this.x = x;
		this.y = y;
		this.angle0 = angle;
		this.v0 = v;
		this.vx = (v0 * Math.cos(angle0));
		this.vy = -(v0 * Math.sin(angle0));
		this.colorCB = color;
		shape = new Circle(x, y, radius*2, Color.BLACK, colorCB, 2);
	}
	
	public void draw(PApplet drawer) {
		shape.draw(drawer);
	}

	public void act(PApplet drawer) {
		double dx = vx, dy = vy;
		if (shape.getY() + radius + vy >= drawer.height) { 	// Ball hits the bottom
			dy = drawer.height - radius  - shape.getY();
			vy *= -0.8;
		} else if (shape.getY() + vy < radius) { 			// Ball hits the top
			dy = radius - shape.getY();
			vy *= -0.8;
		}
		if (shape.getX() + radius + vx >= drawer.width) { 
			dx = drawer.width - radius - shape.getX();
			vx *= -1;
		}
		if (shape.getX() + vx < radius) {
			dx = radius - shape.getX();
			vx *= -1;
		}
		shape.moveBy(dx, dy);

		vy += 0.75;			// Gravitational acceleration
		if (shape.getY() == drawer.height - radius) {
			vx *= 0.95;		// Ground friction force, when vy is 0
		}
	}


	/*
	// Fields
	private Shape boundingShape;
	private double vx, vy;
	
	
	// Constructors
	public PhysicsShape(Shape boundingShape) {
		this.boundingShape = boundingShape;
		vx = 0;
		vy = 0;
	}
	
	

	// Methods
	public void draw(PApplet drawer) {
		boundingShape.draw(drawer);
		if (boundingShape.getX() > drawer.width || boundingShape.getX() < 0) {
			vx *= -1;
		}
		if (boundingShape.getY() > drawer.height || boundingShape.getY() < 0) {
			vy *= -1;
		}
	}
	
	public Shape getBoundingShape() {
		return boundingShape;
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	public void act() {
		boundingShape.moveBy(vx, vy);
	}
	*/
	
	
	
}



