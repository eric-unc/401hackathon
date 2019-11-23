package src.main.java.hackathon;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BallGameWidget extends JPanel {
	
	JBall[] ballArray = new JBall[2];
	List<JBall> ballList;
	private final int DEFAULT_WIDTH = 800;
	private final int DEFAULT_HEIGHT = 400;
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
	
		
	}
}
