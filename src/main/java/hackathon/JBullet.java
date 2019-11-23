package src.main.java.hackathon;

import java.awt.Graphics;

public class JBullet extends JBall {
	private int width = 10;
	private int height = 15;
	public JBullet(int x, int y, int velocityX, int velocityY){
		super(x,y,velocityX,velocityY);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillRect(getX() , getY(), getX()+width, getY()+height);
	}
}
