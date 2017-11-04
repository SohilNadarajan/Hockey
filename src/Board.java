
import processing.core.PApplet;
import processing.core.PFont;

public class Board extends PApplet {
	private Pusher pusherLeft, pusherRight;
	private Puck puck;
	private TableDesigns table;
	boolean[] keys = new boolean[9];
	int puckOriginalX = 635, puckOriginalY = 350;
	int pLOriginalX = 100, pROriginalX = 1169, pOriginalY = 350;
	int puckRightScore = 0, puckLeftScore = 0;
	int ptime, ctime;
	int winningScore = 3;
	
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
		
		if (collisionDetectionLeft() || collisionDetectionRight()) {
			puck.setVelocity(10, 10);
			puck.act(this);
		}
		
		PFont font = createFont("Arial", 75);
		if (puck.x < 0) {
			puckRightScore++;
			if (puckRightScore >= winningScore) {
				ptime = millis(); // Storing time of win
			}
			textFont(font);
			fill(0);
			restartLeft();
		}
		if (puckRightScore > -1) {
			text(puckRightScore, 1200, 75);
		}
		
		if (puck.x > width) {
			puckLeftScore++;
			if (puckLeftScore >= winningScore) {
				ptime = millis(); // Storing time of win
			}
			textFont(font);
			fill(0);
			restartRight();
		}
		if (puckLeftScore > -1) {
			text(puckLeftScore, 40, 75);	
		}
		
		ctime = millis(); // Storing current time every loop
		if (puckLeftScore == winningScore) {
			text("Left Player Wins!", 350, 75);
			if (ctime - ptime > 1000) {
				restart();
			}
		}
		if (puckRightScore == winningScore) {
			text("Right Player Wins!", 300, 75);
			if (ctime - ptime > 1000) {
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
		puckLeftScore = 0;
		puckRightScore = 0;
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
	
	public boolean collisionDetectionLeft() {
		int touching = puck.radius + pusherLeft.radius;
		double distance = Math.sqrt(Math.pow((puck.x - pusherLeft.x), 2) 
	+ Math.pow((puck.y - pusherLeft.y), 2));
		
		// REMEMBER ROUND-OFF ERROR
		if (distance < touching) {
			puck.vxm = (puck.x - pusherLeft.x) / 20;
			puck.vym = (puck.y - pusherLeft.y) / 20;
			return true;
		}
		return false;
	}
	
	public boolean collisionDetectionRight() {
		int touching = puck.radius + pusherRight.radius;
		double distance = Math.sqrt(Math.pow((puck.x - pusherRight.x), 2) 
	+ Math.pow((puck.y - pusherRight.y), 2));
		
		// REMEMBER ROUND-OFF ERROR
		if (distance < touching) {
			puck.vxm = (puck.x - pusherRight.x) / 20;
			puck.vym = (puck.y - pusherRight.y) / 20;
			return true;
		}
		return false;
	}
}







