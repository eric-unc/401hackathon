package src.main.java.hackathon;

public class Ball {
	private int x;
	private int y;
	private int velocityX;
	private int velocityY;
	private int radius;

	private final static int DEFAULT_RADIUS = 5;

	public Ball(int x, int y, int radius){
		this.x = x;
		this.y = y;
		this.velocityX = 10;
		this.velocityY = 10;
		this.radius = radius;

	}

	public Ball(int x, int y){
		this(x, y, DEFAULT_RADIUS);
	}

	public int getVelocityX(){
		return velocityX;
	}

	public int getVelocityY(){
		return velocityY;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public void move(){
		this.x += velocityX;
		this.y += velocityY;
	}

	public void setVelocityX(int velocity){
		velocityX = velocity;
	}

	public void setVelocityY(int velocity){
		velocityX = velocity;
	}
	
	public int getRadius(){
		return radius;
	}
}
