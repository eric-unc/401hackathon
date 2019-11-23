package src.main.java.hackathon;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame();
		frame.setTitle("Ball Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BallGameWidget widget = new BallGameWidget();
		
		frame.setContentPane(widget);
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		while(true){
			widget.update();
			Thread.sleep(100);
		}
	}

}
