package src.main.java.hackathon;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BallGameWidget extends JPanel {
	
	JBall j1;
	
	public BallGameWidget(){
		super();
		this.setSize(800, 600);
		/*if(this.getGraphics() == null)
			System.out.println("wtf");*/
		//this.getGraphics().fillOval(10, 10, 5, 5);
		
		j1 = new JBall(0, 0);
		
		add(j1);
	}
	
	@Override
	public void paintComponent(Graphics graphic) {
		//graphic.fillOval(10, 10, 10, 10);
		j1.paintComponent(graphic);
	}
}
