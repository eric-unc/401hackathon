package src.main.java.hackathon;

import java.awt.*;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JLine extends JPanel {

	private int originX;
	private int originY;
	private int tailX;
	private int tailY;

	public JLine(int originX, int originY, int tailX, int tailY){
		super();
		this.originX = originX;
		this.originY = originY;
		this.tailX = tailX;
		this.tailY = tailY;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g); // fixes the immediate problem.
		Graphics2D g2 = (Graphics2D) g;

		g2.draw(new Line2D.Float(originX, originY, tailX, tailY));
		g2.fillOval(originX - 5, originY - 5, 10, 10);
	}
}
