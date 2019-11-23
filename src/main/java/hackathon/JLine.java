package src.main.java.hackathon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
public class JLine extends JPanel  {
	
	Line2D verticalLine;
	
	private final Dimension prefPanelSize = new Dimension(800,600);
	
	public JLine() {
		verticalLine = new Line2D.Float(20, 20,
                40, 40);
	}
	 public void paintComponent(Graphics g) {
	        super.paintComponent(g);  // fixes the immediate problem.
	        Graphics2D g2 = (Graphics2D) g;

	        g2.draw(verticalLine);
	 }
	 /*
	 public void actionPerformed(ActionEvent e) {
	        int currWidth = getWidth();
	        int currHeight = getHeight();

	        //horizontalLine.setLine(0, 40, currWidth, 40);
	        verticalLine.setLine(currWidth / 2, 0, currWidth / 2, currHeight);
	    }
	*/
}
