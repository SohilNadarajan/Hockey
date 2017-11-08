import processing.core.PApplet;
import processing.core.PFont;

public class BoardAI extends PApplet {
	
	private Pusher pusherAI, pusherPlayer;
	private Puck puck;
	private TableDesigns table;
	boolean[] keys = new boolean[9];
	int pLOriginalX = 100, pROriginalX = 1169, pOriginalY = 350;
	int puckOriginalX = 635, puckOriginalY = 350;
	int pusherRightScore = 0, pusherLeftScore = 0, winningScore = 1;
	int ptime, ctime;
	
	public BoardAI() {
		puck = new Puck(puckOriginalX, puckOriginalY, 25);
		pusherAI = new Pusher(pLOriginalX, pOriginalY, 50);
		pusherPlayer = new Pusher(pROriginalX, pOriginalY, 50);
		table = new TableDesigns();
	}
	
	public void draw() {
		background(255);
		table.draw(this);
		
		act();
		
		puck.draw(this);
		pusherPlayer.draw(this);
		pusherAI.draw(this);
		
		if (puck.collisionDetection(pusherPlayer) || puck.collisionDetection(pusherAI)) {
			puck.act(this);
		}
		pusherAI.y = puck.y;
		
		PFont font = createFont("Arial", 75);
		if (puck.x < 0) {
			pusherRightScore++;
			if (pusherRightScore >= winningScore) {
				ptime = millis(); // Storing time of win
			}
			textFont(font);
			fill(0);
			reset();
		}
		if (pusherRightScore > -1) {
			text(pusherRightScore, 1175, 75);
		}	
		if (puck.x > width) {
			pusherLeftScore++;
			if (pusherLeftScore >= winningScore) {
				ptime = millis(); // Storing time of win
			}
			textFont(font);
			fill(0);
			reset();
		}
		if (pusherLeftScore > -1) {
			text(pusherLeftScore, 40, 75);	
		}
		
		
		ctime = millis(); // Storing current time every loop
		if (pusherLeftScore == winningScore) {
			text("Left Player Wins!", 350, 75);
			puck.hide();
			if (ctime - ptime > 2000) {
				restart();
			}
		}
		if (pusherRightScore == winningScore) {
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
		puck.x = puckOriginalX + 100;
		puck.y = puckOriginalY;
		puck.vx = 0;
		puck.vy = 0;
		pusherAI.x = pLOriginalX;
		pusherAI.y = pOriginalY;
		pusherPlayer.x = pROriginalX;
		pusherPlayer.y = pOriginalY;	
	}
	public void restart() {
		reset();
		puck.show();
		pusherLeftScore = 0;
		pusherRightScore = 0;
	}
	
	int speed = 20;
	public void act() {
		if (keys[0] == true) {
			pusherPlayer.x -= speed;
		}
		if (keys[1] == true) {
			pusherPlayer.y -= speed;
		}
		if (keys[2] == true) {
			pusherPlayer.x += speed;
		}
		if (keys[3] == true) {
			pusherPlayer.y += speed;
		}
		if (keys[4] == true) {
			reset();
		}
	}
	
	public void keyPressed() {
		if (this.keyCode == 37) {
			keys[0] = true;
		}
		if (this.keyCode == 38) {
			keys[1] = true;
		}
		if (this.keyCode == 39) {
			keys[2] = true;
		}
		if (this.keyCode == 40) {
			keys[3] = true;
		}
		if (key == 'r') {
			keys[4] = true;			
		}
	}
	
	public void keyReleased() {
		if (this.keyCode == 37) {
			keys[0] = false;
		}
		if (this.keyCode == 38) {
			keys[1] = false;
		}
		if (this.keyCode == 39) {
			keys[2] = false;
		}
		if (this.keyCode == 40) {
			keys[3] = false;
		}
		if (key == 'r') {
			keys[4] = false;			
		}
	}
	
	
}





