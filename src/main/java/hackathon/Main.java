package src.main.java.hackathon;
//h
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		showMessageDialog(null, "For this game, you must throw a dart at each ballon.\n" + 
				"To shoot, simply press, drag, and release.\n" +
				"There are ten ballons total.\n" +
				"The more ballons hit, the bigger the prize!");
		
		JFrame frame = new JFrame();
		frame.setTitle("Ball Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BallGameWidget widget = new BallGameWidget();
		
		frame.setContentPane(widget);
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		while(!widget.isDone()){
			widget.update();
			Thread.sleep(100);
		}
		
		String prize;
		
		int score = widget.getScore();
		
		if(score <= 2)
			prize = "nothing (lol)";
		else if(score <= 5)
			prize = "a cool sticker";
		else if(score <= 7)
			prize = "a stuffed animal";
		else if(score <= 9)
			prize = "a goldfish";
		else
			prize = "the Nobel Peace Prize (wow...)";
		
		showMessageDialog(null, "You won " + prize + " with " + score + " points!");
	}

}
