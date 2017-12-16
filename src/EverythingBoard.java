import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PShape;

/*
	BUGS:
	- Fix Puck class, seems to be the main problem
	- In drawBoard() (and drawBoardAI()) change "background(255)" to "initialBackground = 255;"

	FIXED!! LEGGO MY EGGO!!


*/
public class EverythingBoard extends PApplet {
	
	private PShape option1, option2;
	
	private Pusher pusherLeft, pusherRight;
	private Puck puck;
	private TableDesigns table;
	private boolean[] keys = new boolean[9];
	private int puckOriginalX = 635, puckOriginalY = 350;
	private int pLOriginalX = 100, pROriginalX = 1169, pOriginalY = 350;
	private int pusherRightScore = 0, pusherLeftScore = 0, winningScoreBoard = 10;
	private int ptime, ctime;
	private int lastCollisionTime = 0;
	private int initialBackground = 225;
	
	private boolean isClicked1 = false;
	private boolean isClicked2 = false;
	
	private Pusher pusherAI, pusherPlayer;
	private int pusherplayerScore = 0, pusherAIScore = 0, winningScoreAI = 3;
	
	
	public EverythingBoard() {
		puck = new Puck(puckOriginalX, puckOriginalY, 25);
		pusherLeft = new Pusher(pLOriginalX, pOriginalY, 50);
		pusherRight = new Pusher(pROriginalX, pOriginalY, 50);
		pusherAI = new Pusher(pLOriginalX, pOriginalY, 50);
		pusherPlayer = new Pusher(pROriginalX, pOriginalY, 50);
		table = new TableDesigns();
	}
	
	public void setup(PApplet drawer) {
		option1 = createShape(PConstants.RECT, width/4, 150, width/2, 150);
		option2 = createShape(PConstants.RECT, width/4, 315, width/2, 150);
		option1.setFill(200);
		option2.setFill(200);
	}

	public void draw() {

		background(initialBackground);

		PFont font = createFont("Arial", 75);
		textFont(font);
		fill(0);
		
		setup(this);
		

		if (mouseX > width/4 && mouseX < 3*width/4 && mouseY > 150 && mouseY < 300) {
			option1.setFill(255);
			if (mousePressed == true) {
				isClicked1 = true;
			}
		}
		if (isClicked1 == true) {
			drawBoard();
			initialBackground = 255;
		}
		
		if (mouseX > width/4 && mouseX < 3*width/4 && mouseY > 315 && mouseY < 465) {
			option2.setFill(255);
			if (mousePressed == true) {
				isClicked2 = true;
			}
		}
		if (isClicked2 == true) {
			drawBoardAI();
			initialBackground = 255;
		}
		
		if (initialBackground == 225) {
			option1.draw(g);
			option2.draw(g);
			text("Pick A Game Mode", 310, 100);
			text("Two Player", 445, 250);
			text("Computer", 460, 415);
		}

	}
	
/////////////////////////////////////////////////////////////////////////////////
	
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
	
/////////////////////////////////////////////////////////////////////////////////
	
	public void drawBoard() {
		background(255);
		table.draw(this);
		
		actBoard();
		
		pusherLeft.draw(this);
		pusherRight.draw(this);
		
		puck.draw(this);
		
		if (puck.collisionDetection(pusherLeft) || puck.collisionDetection(pusherRight)) {
			puck.act(this);
		}
		
		PFont font = createFont("Arial", 75);
		if (puck.x < 0) {
			pusherRightScore++;
			if (pusherRightScore >= winningScoreBoard) {
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
			if (pusherLeftScore >= winningScoreBoard) {
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
		if (pusherLeftScore == winningScoreBoard) {
			text("Left Player Wins!", 350, 75);
			puck.hide();
			if (ctime - ptime > 2000) {
				restartBoard();
			}
		}
		if (pusherRightScore == winningScoreBoard) {
			text("Right Player Wins!", 300, 75);
			puck.hide();
			if (ctime - ptime > 2000) {
				restartBoard();
			}
		}
	}
	
	public void setupBoard() {
		puck.setup(this);
		table.setup(this);
	}
	
	public void resetBoard() {
		puck.x = puckOriginalX;
		puck.y = puckOriginalY;
		puck.vx = 0;
		puck.vy = 0;
		pusherLeft.x = pLOriginalX;
		pusherLeft.y = pOriginalY;
		pusherRight.x = pROriginalX;
		pusherRight.y = pOriginalY;		
	}
	public void restartBoard() {
		resetBoard();
		puck.show();
		pusherLeftScore = 0;
		pusherRightScore = 0;
	}
	public void restartLeft() {
		resetBoard();		
		puck.x = width/2 - 100;
	}
	public void restartRight() {
		resetBoard();	
		puck.x = width/2 + 100;
	}
	
	int speed = 20;
	public void actBoard() {
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
			restartBoard();
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	public void drawBoardAI() {
		background(255);
		table.draw(this);
		
		actAI();
		
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
			if (pusherRightScore >= winningScoreAI) {
				ptime = millis(); // Storing time of win
			}
			textFont(font);
			fill(0);
			resetAI();
		}
		if (pusherRightScore > -1) {
			text(pusherRightScore, 1175, 75);
		}	
		if (puck.x > width) {
			pusherLeftScore++;
			if (pusherLeftScore >= winningScoreAI) {
				ptime = millis(); // Storing time of win
			}
			textFont(font);
			fill(0);
			resetAI();
		}
		if (pusherLeftScore > -1) {
			text(pusherLeftScore, 40, 75);	
		}
		
		
		ctime = millis(); // Storing current time every loop
		if (pusherLeftScore == winningScoreAI) {
			text("Left Player Wins!", 350, 75);
			puck.hide();
			if (ctime - ptime > 2000) {
				restartAI();
			}
		}
		if (pusherRightScore == winningScoreAI) {
			text("Right Player Wins!", 300, 75);
			puck.hide();
			if (ctime - ptime > 2000) {
				restartAI();
			}
		}
		
	}
	
	public void setupAI() {
		puck.setup(this);
		table.setup(this);
	}
	
	public void resetAI() {
		puck.x = puckOriginalX + 100;
		puck.y = puckOriginalY;
		puck.vx = 0;
		puck.vy = 0;
		pusherAI.x = pLOriginalX;
		pusherAI.y = pOriginalY;
		pusherPlayer.x = pROriginalX;
		pusherPlayer.y = pOriginalY;	
	}
	public void restartAI() {
		resetAI();
		puck.show();
		pusherLeftScore = 0;
		pusherRightScore = 0;
	}
	
	int speedAI = 20;
	public void actAI() {
		if (keys[4] == true) {
			pusherPlayer.x -= speedAI;
		}
		if (keys[5] == true) {
			pusherPlayer.y -= speedAI;
		}
		if (keys[6] == true) {
			pusherPlayer.x += speedAI;
		}
		if (keys[7] == true) {
			pusherPlayer.y += speedAI;
		}
		if (keys[8] == true) {
			resetAI();
		}
	}
	
	
	
	
	
	
}
