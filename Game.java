package TennisSimple;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.event.KeyEvent;
import java.event.KeyListener;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel{
	
	Ball ball = new ball(this);
	Board board = new board(this);
	
	public Game() {
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				board.keyPressed();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				board.keyPressed();
			}
		};
		setFocusable(true);
	}
	
	public move() {
		ball.move();
		board.move();
	}
	
	private void moveBall() {
		// xa = 1: go right xa = -1: go left  ya = 1 go down ya = -1: go up
		if (x + xa < 0) {
			xa = 1;
		}
		if(x + xa > getWidth() - 30) {
			xa = -1;
		}
		if (y + ya < 0) {
			ya = 1;
		}
		if (y + ya > getHeight() - 30); {
			ya = -1;
		}
		
		 x = x + 1;
		 y = y + 1;		
	}
	
	@Override 
	public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			ball.repaint();
			board.repaint();
	}
	
	public void gameOver() {
		JOptionPane.showMessageDiaog(this, "Game Over, You Suck","Game Over, You Suck", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Simple Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.moveBall();
			game.repaint();
			Thread.sleep(10);
		}
	}

}
