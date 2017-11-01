import processing.core.PApplet;
import processing.core.PFont;

public class Board extends PApplet {
	private Pusher pusher1, pusher2;
	private PuckEX puck;
	boolean[] keys = new boolean[9];
	
	public Board() {
		puck = new PuckEX(500, 500, 100, Color.BLACK, Color.GRAY, );
	}

	public void draw() {
		background(255);
		
		//act();
		
		puck.draw(this);
		puck.setVelocity(2, 2);
		puck.act(this);

		
		
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
	
	public void act() {
		if (keys[0] == true) {
			System.out.println("0");
		}
		if (keys[1] == true) {
			System.out.println("1");
		}
		if (keys[2] == true) {
			System.out.println("2");
		}
		if (keys[3] == true) {
			System.out.println("3");
		}
		if (keys[4] == true) {
			System.out.println("4");
		}
		if (keys[5] == true) {
			System.out.println("5");
		}
		if (keys[6] == true) {
			System.out.println("6");
		}
		if (keys[7] == true) {
			System.out.println("7");
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
	
	public void setup() {
		puck.setup(this);
	}
}







