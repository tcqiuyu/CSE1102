/*
 * Snail.java
 * This class defines snail walking through the edge.
 */
import java.awt.Color;


public class Snail implements Mover{
	private final double HEAD_WIDTH=20, HEAD_HEIGHT=10;
	private final double BODY_SIZE=20;
	private double _rotation;
	private double _changeX;
	private double _changeY;
	private SmartEllipse _body;
	private SmartEllipse _head;
	private SmartLine _antenna1;
	private SmartLine _antenna2;
	//a boolean to determine whether the snail walks in clockwise direction or anti clockwise direction  
	private boolean _clockwise;

	
	public Snail(){
		super();
		_body = new SmartEllipse(Color.MAGENTA,Color.MAGENTA);
		_head = new SmartEllipse(Color.LIGHT_GRAY,Color.LIGHT_GRAY);
		_antenna1 = new SmartLine(Color.BLACK);
		_antenna2 = new SmartLine(Color.BLACK);
		_head.setSize(HEAD_WIDTH, HEAD_HEIGHT);
		_body.setSize(BODY_SIZE, BODY_SIZE);
		this.setLocationClockwise(448, 70);
		this.setRotation(-Math.PI/2);
		//default is to walk in clockwise direction
		_clockwise = true;
	}

	//accessor for different position of the snail
	public double getCenterX(){
		return _body.getX()+15;
	}
	public double getCenterY(){
		return _body.getCenterY();
	}
	public double getX(){
		return _body.getX();
	}
	public double getY(){
		return _body.getY();
	}
	
	//set snail's rotation
	public void setRotation(double rotation){
		_rotation = rotation;
	}
	
	//set snail's location for clockwise and anti clockwise
	public void setLocationClockwise(double x, double y){
		_head.setLocation(x-10, y+9);
		_body.setLocation(x, y);
		_antenna1.setLine(x-6, y+8, x-4, y+4);
		_antenna2.setLine(x-8, y+8, x-10, y+4);
		_head.setRotation(0.5);
	}
	public void setLocationAntiClockwise(double x, double y){
		_head.setLocation(x+10, y+9);
		_body.setLocation(x, y);
		_antenna1.setLine(x+25, y+8, x+23, y+4);
		_antenna2.setLine(x+27, y+8, x+29, y+4);
		_head.setRotation(-0.5);
	}
	
	//set snail's speed
	public void setXSpeed(double xSpeed){
		_changeX = xSpeed;
	}
	public void setYSpeed(double ySpeed){
		_changeY = ySpeed;
	}
	public void setSpeed(double xSpeed, double ySpeed){
		this.setXSpeed(xSpeed);
		this.setYSpeed(ySpeed);
	}
	
	public void move(){
		//simple conditional statement
		if (_clockwise == true){
			this.moveClockwise();
		}
		else if(_clockwise == false){
			this.moveAntiClockwise();
		}
	}
	
	//make the snail move in clockwise direction
	private void moveClockwise(){
		double xSpeed = -_changeX;
		double ySpeed = _changeY;
		double tempX = this.getX()+xSpeed;
		double tempY = this.getY()+ySpeed;
		double nextX;
		double nextY;
		
		//movement before hitting the right-lower corner
		if(tempY<342 && this.getX()+_changeX>=448){
			nextX = 448;
			xSpeed = 0; 
			ySpeed = _changeY;
			nextY = this.getY()+ySpeed;
			this.setLocationClockwise(nextX, nextY);
		}
		//movement before hitting the left-lower corner
		else if(tempY>=342 && tempX > 80){
			nextY = 355;
			xSpeed = -_changeX;
			ySpeed = 0;
			nextX = this.getX()+xSpeed;
			this.setRotation(0);
			this.setLocationClockwise(nextX, nextY);
		}
		//movement before hitting the left-upper corner
		else if(tempY >95 && tempX<=80){
			nextX = 70;
			xSpeed = 0;
			ySpeed = -_changeY;
			nextY = this.getY()+ySpeed;
			this.setRotation(Math.PI/2);
			this.setLocationClockwise(nextX, nextY);
		}
		//change the clockwise status to anti clockwise when hitting the left-upper corner
		else if(tempY<=95 && tempX<85){
			_clockwise = false;
		}
	}
	
	//make the snail move in anti clockwise direction
	private void moveAntiClockwise(){
		double xSpeed = _changeX;
		double ySpeed = _changeY;
		double tempX = this.getX()+xSpeed;
		double tempY = this.getY()+ySpeed;
		double nextX;
		double nextY;
		
		//movement before hitting the left-lower corner
		if(tempY < 350 && this.getX()-_changeX<=85){
			nextX = 70;
			xSpeed = 0;
			ySpeed = _changeY;
			nextY = this.getY()+ySpeed;
			this.setRotation(Math.PI/2);
			this.setLocationAntiClockwise(nextX, nextY);			
		}
		//movement before hitting the right-lower corner
		else if(tempY >= 350 && tempX<448){
			nextY = 355;
			xSpeed = _changeX;
			ySpeed = 0;
			nextX = this.getX()+xSpeed;
			this.setRotation(0);
			this.setLocationAntiClockwise(nextX, nextY);
		}
		//movement before hitting the right-upper corner
		else if(tempY>70 && tempX>=448){
			nextX = 448;
			xSpeed = 0;
			ySpeed = -_changeY;
			nextY = this.getY()+ySpeed;
			this.setRotation(-Math.PI/2);
			this.setLocationAntiClockwise(nextX, nextY);
		}
		//change the anti clockwise status to clockwise when hitting the right-upper corner
		else if(tempY<=70 && tempX >=448){
			_clockwise = true;
		}
	}
	
	public void fill(java.awt.Graphics2D aBrush){
		aBrush.rotate(_rotation, 
				this.getCenterX(), this.getCenterY());
		_head.fill(aBrush);
		_body.fill(aBrush);
		aBrush.rotate(-_rotation, 
				this.getCenterX(), this.getCenterY());
	}
	
	public void draw(java.awt.Graphics2D aBrush){
		aBrush.rotate(_rotation, 
				this.getCenterX(), this.getCenterY());;
		_body.draw(aBrush);
		_antenna1.draw(aBrush);
		_antenna2.draw(aBrush);
		aBrush.rotate(-_rotation,
				this.getCenterX(), this.getCenterY());
	}
}
