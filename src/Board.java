import processing.core.PApplet;
import processing.core.PFont;

/* BUGS :
 * 1) Minor problems with initial collision detection
 * 2) Slow time check causing puck to get stuck in pusher
 * 
 * RISHIKESH IN THE HOUSE!!!!!!!
 * 
 */

public class Board extends PApplet {
	
	private Pusher pusherLeft, pusherRight;
	private Puck puck;
	private TableDesigns table;
	boolean[] keys = new boolean[9];
	int puckOriginalX = 635, puckOriginalY = 350;
//	int puckOriginalX = 50, puckOriginalY = 50; // Collision Debugger
	int pLOriginalX = 100, pROriginalX = 1169, pOriginalY = 350;
//	int pLOriginalX = 600, pROriginalX = 1169, pOriginalY = 600; // Collision Debugger
	int pusherRightScore = 0, pusherLeftScore = 0;
	final int WINNING_SCORE = 10;
	int ptime, ctime;
	//int lastCollisionTime = 0;
	
	public Board() {
		puck = new Puck(puckOriginalX, puckOriginalY, 25);
		pusherLeft = new Pusher(pLOriginalX, pOriginalY, 50);
		pusherRight = new Pusher(pROriginalX, pOriginalY, 50);
		table = new TableDesigns();
	}

	public void draw() {
		background(255);
		table.draw(this);
		
		act();
		
		pusherLeft.draw(this);
		pusherRight.draw(this);
		
		puck.draw(this);
		
		if (puck.collisionDetection(pusherLeft) || puck.collisionDetection(pusherRight)) {
			puck.act(this);
		}
		
		PFont font = createFont("Arial", 75);
		if (puck.x < 0) {
			pusherRightScore++;
			if (pusherRightScore >= WINNING_SCORE) {
				ptime = millis(); // Storing time of win
			}
			textFont(font);
			fill(0);
			restartLeft();
		}
		if (pusherRightScore > -1) {
			text(pusherRightScore, 1175, 75);
		}	
		if (puck.x > width) {
			pusherLeftScore++;
			if (pusherLeftScore >= WINNING_SCORE) {
				ptime = millis(); // Storing time of win
			}
			textFont(font);
			fill(0);
			restartRight();
		}
		if (pusherLeftScore > -1) {
			text(pusherLeftScore, 40, 75);	
		}

		
		ctime = millis(); // Storing current time every loop
		if (pusherLeftScore == WINNING_SCORE) {
			text("Left Player Wins!", 350, 75);
			puck.hide();
			if (ctime - ptime > 2000) {
				restart();
			}
		}
		if (pusherRightScore == WINNING_SCORE) {
			text("Right Player Wins!", 300, 75);
			puck.hide();
			if (ctime - ptime > 2000) {
				restart();
			}
		}
	}
	
	public void setup() {
		puck.setup(this);
		table.setup(this);
	}
	
	public void reset() {
		puck.x = puckOriginalX;
		puck.y = puckOriginalY;
		puck.vx = 0;
		puck.vy = 0;
		pusherLeft.x = pLOriginalX;
		pusherLeft.y = pOriginalY;
		pusherRight.x = pROriginalX;
		pusherRight.y = pOriginalY;		
	}
	public void restart() {
		reset();
		puck.setFill(200);
		puck.setStroke(0);
		pusherLeftScore = 0;
		pusherRightScore = 0;
	}
	public void restartLeft() {
		reset();		
		puck.x = width/2 - 100;
	}
	public void restartRight() {
		reset();	
		puck.x = width/2 + 100;
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
		if (keys[8] == true) {
			restart();
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
}



