import processing.core.PApplet;
import processing.core.PFont;

public class Board extends PApplet {
	private Pusher pusherLeft, pusherRight;
	private Puck puck;
	private TableDesigns table;
	boolean[] keys = new boolean[9];
	
	public Board() {
		puck = new Puck(500, 500, 25);
		pusherLeft = new Pusher(100, 350, 50);
		pusherRight = new Pusher(1169, 350, 50);
		table = new TableDesigns();
	}

	public void draw() {
		background(255);
		table.draw(this);
		
		act();
		
		pusherLeft.draw(this);
		pusherRight.draw(this);
		
		puck.draw(this);
		puck.setVelocity(5, 5);
		puck.act(this);
		
//		collisionDetection();
		
//		PFont font = createFont("Arial", 75);
//		if (piece1.Xlife == 100) {
//			textFont(font);
//			text("PLAYER X WINS!", 300, 75);
//		}
//		if (piece1.Xlife == 0) {
//			textFont(font);
//			text("PLAYER SQUARE WINS!", 200, 75);
//		}

	}
	
	public void setup() {
		puck.setup(this);
	}
	
	int speed = 20;
	public void act() {
		if (keys[0] == true) {
			pusherLeft.y -= speed;
		}
		if (keys[1] == true) {
			pusherLeft.x -= speed;
		}
		if (keys[2] == true) {
			pusherLeft.y += speed;
		}
		if (keys[3] == true) {
			pusherLeft.x += speed;
		}
		if (keys[4] == true) {
			pusherRight.x -= speed;
		}
		if (keys[5] == true) {
			pusherRight.y -= speed;
		}
		if (keys[6] == true) {
			pusherRight.x += speed;
		}
		if (keys[7] == true) {
			pusherRight.y += speed;
		}
	}
	
	public void keyPressed() {
		if (key == 'w') {
			keys[0] = true;
		}
		if (key == 'a') {
			keys[1] = true;
		}
		if (key == 's') {
			keys[2] = true;
		}
		if (key == 'd') {
			keys[3] = true;
		}
		if (this.keyCode == 37) {
			keys[4] = true;
		}
		if (this.keyCode == 38) {
			keys[5] = true;
		}
		if (this.keyCode == 39) {
			keys[6] = true;
		}
		if (this.keyCode == 40) {
			keys[7] = true;
		}
		if (key == 'r') {
			keys[8] = true;			
		}
		if (keys[8]) {
//			RESTART KEY
		}
	}

	public void keyReleased() {
		if (key == 'w') {
			keys[0] = false;
		}
		if (key == 'a') {
			keys[1] = false;
		}
		if (key == 's') {
			keys[2] = false;
		}
		if (key == 'd') {
			keys[3] = false;
		}
		if (this.keyCode == 37) {
			keys[4] = false;
		}
		if (this.keyCode == 38) {
			keys[5] = false;
		}
		if (this.keyCode == 39) {
			keys[6] = false;
		}
		if (this.keyCode == 40) {
			keys[7] = false;
		}
		if (key == 'r') {
			keys[8] = false;
		}
	}
	
//	public void collisionDetection() {
//		int touching = puck.radius + pusherLeft.radius;
//		double distance = Math.sqrt(Math.pow((puck.x - pusherLeft.x), 2) 
//	+ Math.pow((puck.y - pusherLeft.y), 2));
//		
//		// REMEMBER ROUND-OFF ERROR
//		if (distance < touching) {
//			puck.vxm = Math.abs(puck.x - pusherLeft.x) / 20;
//			puck.vym = Math.abs(puck.y - pusherLeft.y) / 20;
//		}
//	}
}







