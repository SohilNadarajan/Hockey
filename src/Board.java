
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
	int winningScore = 5;
	
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
			text(puckRightScore, 1175, 75);
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
			puck.x = 500;
			puck.y = -100;
			if (ctime - ptime > 2000) {
				restart();
			}
		}
		if (puckRightScore == winningScore) {
			text("Right Player Wins!", 300, 75);
			puck.x = 500;
			puck.y = -100;
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
	
//	public boolean collisionDetectionLeft() {
//		int touching = puck.radius + pusherLeft.radius;
//		double distance = Math.sqrt(Math.pow((puck.x - pusherLeft.x), 2) 
//	+ Math.pow((puck.y - pusherLeft.y), 2));
//		
//		// REMEMBER ROUND-OFF ERROR
//		if (distance <= touching) {
//			puck.vxm = (puck.x - pusherLeft.x) / 20;
//			puck.vym = (puck.y - pusherLeft.y) / 20;
//			return true;
//		}
//		return false;
//	}
//	public boolean collisionDetectionRight() {
//		int touching = puck.radius + pusherRight.radius;
//		double distance = Math.sqrt(Math.pow((puck.x - pusherRight.x), 2) 
//	+ Math.pow((puck.y - pusherRight.y), 2));
//		
//		// REMEMBER ROUND-OFF ERROR
//		if (distance <= touching) {
//			puck.vxm = (puck.x - pusherRight.x) / 20;
//			puck.vym = (puck.y - pusherRight.y) / 20;
//			return true;
//		}
//		return false;
//	}
	
	
	
	
	// FAKE
	public boolean collisionDetectionLeft() {
		int touching = puck.radius + pusherLeft.radius;
		int i = 0, dx = 0, dy = 0;
		double distance = Math.ceil(Math.sqrt(Math.pow((puck.x - pusherLeft.x), 2) 
	+ Math.pow((puck.y - pusherLeft.y), 2)));
		
		// REMEMBER ROUND-OFF ERROR
		if (distance <= touching) {
			dx = puck.vx * puck.vxm;
			dy = puck.vy * puck.vym;
			do {
				i++;
				//System.out.println(i + ", " + distance);
				//puck.print();
				puck.x -= dx;
				puck.y -= dy;
				distance = Math.ceil(Math.sqrt(Math.pow((puck.x - pusherLeft.x), 2) 
					+ Math.pow((puck.y - pusherLeft.y), 2)));
			} while ((distance < touching) && (i < 10));
			advancedCollisionDetection(pusherLeft);
			return true;
		}
		return false;
	}
	
	
	
	public boolean collisionDetectionRight() {
		int touching = puck.radius + pusherRight.radius;
		int i = 0, dx = 0, dy = 0;
		double distance = Math.ceil(Math.sqrt(Math.pow((puck.x - pusherRight.x), 2) 
	+ Math.pow((puck.y - pusherRight.y), 2)));
		
		// REMEMBER ROUND-OFF ERROR
		if (distance <= touching) {
			dx = puck.vx * puck.vxm;
			dy = puck.vy * puck.vym;
			do {
				i++;
				puck.x -= dx;
				puck.y -= dy;
				distance = Math.ceil(Math.sqrt(Math.pow((puck.x - pusherRight.x), 2) 
					+ Math.pow((puck.y - pusherRight.y), 2)));
				//System.out.println(i + ", " + distance + " : " + dx + ", " + dy);
				//puck.print();
			} while ((distance < touching) && (i < 10));
			advancedCollisionDetection(pusherRight);
			return true;
		}
		
		return false;
	}
	
	public void advancedCollisionDetection(Pusher pusher) {
		double angleX = Math.toDegrees(Math.tanh((puck.x - pusher.x) / (puck.y - pusher.y + 0.1)));
		double theta = Math.toRadians(angleX - 90);
		double Vxx = puck.vx * puck.vxm * Math.cos(2 * theta);
		double Vxy = puck.vx * puck.vxm * Math.sin(2 * theta);
		double Vyx = puck.vy * puck.vym * Math.cos(90 - 2 * theta);
		double Vyy = -1 * puck.vy * puck.vym * Math.sin(90 - 2 * theta);
		
		puck.vx = (int) (Vxx + Vyx);
		puck.vy = (int) (Vxy + Vyy);
		puck.print();
		//puck.vxm *= -1; puck.vym *= -1; //sabu
		
	}	



}







