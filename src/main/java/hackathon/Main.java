package src.main.java.hackathon;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame();
		frame.setTitle("Ball Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BallGameWidget w = new BallGameWidget();
		
		frame.setContentPane(w);
		frame.setSize(800, 600);
		//frame.pack();
		frame.setVisible(true);
		
		while(true){
			System.out.println("Test");
			w.j1.move(w.getGraphics());
			Thread.sleep(2000);
		}
	}

}
