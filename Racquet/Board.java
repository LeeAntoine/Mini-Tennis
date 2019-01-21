package TennisSimple;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Board {
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;

	int x = 0;
    int xa = 0;
	private Game game;
	
	public void move() {
		if(x + xa > 0 && x + xa < getWidth() - WIDTH)
			x = x + xa;
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(x, 330, 60, 10);
	}
	
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.KeyCode() == KeyEvent.VK_LEFT)
			 xa = -1;
		if(e.KeyCode() == KeyEvent.VK_LEFT)
			xa = 1;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}
	
	public int getTopY() {
		return Y;
	}
}
