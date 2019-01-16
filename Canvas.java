package TennisSimple;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Canvas extends JPanel {
	
	Ball ball = new Ball(this);
	Board board = new Board(this);
	
	
	private void move() {
			ball.move();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);
		//first coordinates: x, y  second coordinates: width, height
		g2d.fillOval(0, 0, 30, 30);
		g2d.drawOval(0, 50, 30, 30);		
		g2d.fillRect(50, 0, 30, 30);
		g2d.drawRect(50, 50, 30, 30);

		g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
		
		ball.paint(g2d);
		board.paint(g2d);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mini Tennis");
		frame.add(new Canvas());
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}