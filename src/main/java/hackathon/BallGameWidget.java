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
	JLine line = null;
	
	private final int DEFAULT_WIDTH = 800;
	private final int DEFAULT_HEIGHT = 400;
	
	private int arrowInitX = -1;
	private int arrowInitY = -1;
	
	//
	public BallGameWidget(){
		super();
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		/*if(this.getGraphics() == null)
			System.out.println("wtf");*/
		//this.getGraphics().fillOval(10, 10, 5, 5);
		/*
		ballArray[0] = new JBall(0,0);
		ballArray[1] = new JBall(100,100);
		*/
		ballList = new ArrayList<JBall>();
		ballList.add(new JBall(100,599,20,-60));
		ballList.add(new JBall(50, 599,30,-50));
		
		for (JBall j : ballList) {
			add(j);
		}
		add(line);
		addMouseMotionListener(this);
	}
	
	@Override
	public void paintComponent(Graphics graphic) {
		//graphic.fillOval(10, 10, 10, 10);
		/*
		ballArray[0].paintComponent(graphic);
		ballArray[1].paintComponent(graphic);
		*/
		for (JBall j : ballList) {
			j.paintComponent(graphic);
		}
		
	}
	public void update() {
		this.getGraphics().clearRect(0,0,800,600);
		for (JBall ball: ballList) {
			ball.setVelocityY(ball.getVelocityY()+2);
			ball.move(this.getGraphics());
			if (ball.getY()-ball.getRadius() < 0)
				ball.setVelocityY(ball.getVelocityY()*-1);
		}
		if (line != null)
			line.paintComponent(this.getGraphics());
	
		
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
		arrowInitX = e.getY();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//SHOOT BALL HERE
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
}
