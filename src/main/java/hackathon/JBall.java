package src.main.java.hackathon;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JBall extends JPanel {
	private int x;
	private int y;
	
	public JBall(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.fillOval(x, y, 100, 100);
	}
	
	public void move(Graphics graphic){
		this.x += 20;
		this.y += 20;
		
		//paintComponent(this.getGraphics());
		graphic.fillOval(x, y, 100, 100);
	}
}
