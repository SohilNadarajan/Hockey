import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PShape;

public class MainMenu extends PApplet {
	private Board board;
	private BoardAI boardAI;
	PShape option1, option2;

	public MainMenu() {
		board = new Board();
		boardAI = new BoardAI();
	}

	public void setup(PApplet drawer) {
		option1 = createShape(PConstants.RECT, width/4, 150, width/2, 150);
		option2 = createShape(PConstants.RECT, width/4, 315, width/2, 150);

		option1.setFill(200);
		option2.setFill(200);
	}

	public void draw() {

		background(200);

		PFont font = createFont("Arial", 75);
		textFont(font);
		fill(0);
		text("Pick A Game Mode", 310, 75);

		setup(this);

		if (mouseX > width/4 && mouseX < 3*width/4 && mouseY > 150 && mouseY < 300) {
			option1.setFill(255);
			if (mousePressed == true) {
				board = new Board();
//				board.draw();
			}
		}
		if (mouseX > width/4 && mouseX < 3*width/4 && mouseY > 315 && mouseY < 465) {
			option2.setFill(255);
			if (mousePressed == true) {
				boardAI = new BoardAI();
				boardAI.draw();
			}
		}

		option1.draw(g);
		option2.draw(g);


	}
}
