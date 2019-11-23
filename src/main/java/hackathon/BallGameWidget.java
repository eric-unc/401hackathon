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
	List<JBall> bulletList;
	JLine line = null;
	
	private final int DEFAULT_WIDTH = 800;
	private final int DEFAULT_HEIGHT = 400;
	//h
	private boolean isDone;
	private int arrowInitX = -1;
	private int arrowInitY = -1;
	private int score;
	//
	public BallGameWidget(){
		super();
		score = 0;
		isDone = false;
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		ballList = new ArrayList<JBall>();
		//ballList.add(new JBall(100, 599, 1, -60 ));
		//ballList.add(new JBall(50, 599, 30, -50));

		bulletList = new ArrayList<JBall>();
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
	//--
	private int counter = 1;
	public void update(){
	
		this.getGraphics().clearRect(0, 0, 800, 600);
		counter++;
		if(counter % 50 == 0 && counter <= 500) {
			int randomXVelocity = (int) (Math.random() * 25) + 5;
			int randomYVelocity = -1 * (int) ((Math.random() * 20) + 40);
			ballList.add(new JBall(0, 600, randomXVelocity, randomYVelocity));
			System.out.println(counter);
			
		}
		if (counter > 550)
			isDone = true;
		
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
		bulletList.add(new JBall (arrowInitX, arrowInitY, arrowInitX-e.getX(), 
				arrowInitY-e.getY(),15));
	}
	
	public boolean isDone() {
		return isDone;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}


	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	public void collision() {
		
		 if (ballList.size() == 0)
			 return;
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
							score++;
				
					
						
				}
			
			}
		}
	}
	public int getScore() {
		
		return score;
	}
}
