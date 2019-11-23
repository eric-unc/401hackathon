package src.main.java.hackathon;

import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BallGameWidget extends JPanel implements MouseMotionListener, MouseListener{
	///
	List<JBall> ballList;
	List<JBullet> bulletList;
	JLine line = null;
	
	private final int DEFAULT_WIDTH = 800;
	private final int DEFAULT_HEIGHT = 400;
	
	private int arrowInitX = -1;
	private int arrowInitY = -1;
	
	//
	public BallGameWidget(){
		super();
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		ballList = new ArrayList<JBall>();
		ballList.add(new JBall(100, 599, 1, 1));
		ballList.add(new JBall(50, 599, 30, -50));

		bulletList = new ArrayList<JBullet>();
		for(JBall j : ballList)
			add(j);
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics graphic){
		for(JBall j : ballList)
			j.paintComponent(graphic);
	}

	public void update(){
		this.getGraphics().clearRect(0, 0, 800, 600);
		
		for(JBall ball : ballList){
			ball.setVelocityY(ball.getVelocityY() + 2);
			ball.move(this.getGraphics());
			
			if(ball.getY() - ball.getRadius() < 0)
				ball.setVelocityY(ball.getVelocityY() * -1);
		}
		if (bulletList.size()>0) {
			for(JBall bullet : bulletList){
				bullet.setVelocityY(bullet.getVelocityY() + 2);
				bullet.move(this.getGraphics());
			}
		}
		if (line != null)
			line.paintComponent(this.getGraphics());
		collision();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
			line = new JLine(arrowInitX, arrowInitY, e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		arrowInitX = e.getX();
		arrowInitY = e.getY();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		bulletList.add(new JBullet (arrowInitX, arrowInitY, arrowInitX-e.getX(), arrowInitY-e.getY()));
	}
	
	
	
	
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*public void collision() {
		for (JBall ball : new ArrayList(ballList.toArray()) {
			int ballX = ball.getX();
			int ballY = ball.getY();
			
			for (JBall bullet : bulletList) {
				int bulletX = bullet.getX();
				int bulletY = bullet.getY();
				
				if(Math.sqrt(((bulletX - ballX) * (bulletX - ballX) + 
					(bulletY - ballY) * (bulletY - ballY))) <= ball.getRadius() + bullet.getRadius()) {
					//ballList.remove(ball);
					System.out.println("Exclusion");
				}
					
					
			}
		}
		
	}*/
	
	public void collision() {
		for (int i = 0; i < ballList.size(); i++) {
			int ballX = ballList.get(i).getX();
			int ballY = ballList.get(i).getY();
			
			for (int j = 0; j < bulletList.size(); j++) {
				int bulletX = bulletList.get(j).getX();
				int bulletY = bulletList.get(j).getY();
				
				if (Math.sqrt(((bulletX - ballX) * (bulletX - ballX)) + 
					((bulletY - ballY) * (bulletY - ballY))) <= 
						ballList.get(i).getRadius() + bulletList.get(j).getRadius()) {
							ballList.remove(i);
							System.out.println("Collision");
							i--;
				
					
						
			}
			
		}
		}
	}
}
