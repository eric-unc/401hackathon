package src.main.java.hackathon;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
//h
@SuppressWarnings("serial")
public class JBall extends JPanel {
	private int x;
	private int y;
	private int velocityX;
	private int velocityY;
	private int radius;
	private Color color;

	public JBall(int x, int y, int velocityX, int velocityY){
		this.x = x;
		this.y = y;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		radius = 80;
		color = color.RED;
	}
	
	public JBall(int x, int y, int velocityX, int velocityY, int radius){
		this.x = x;
		this.y = y;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.radius = radius;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillOval(x - radius, y - radius, radius, radius);
	}

	public int getVelocityX(){
		return velocityX;
	}

	public int getVelocityY(){
		return velocityY;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public void move(Graphics graphic){
		this.x += velocityX;
		this.y += velocityY;
		graphic.fillOval(x - radius, y - radius, radius, radius);
	}

	public int getRadius(){
		return radius;
	}

	public void setVelocityX(int velocity){
		velocityX = velocity;
	}

	public void setVelocityY(int velocity){
		velocityY = velocity;
	}
}
