import java.awt.Color;

public class JumpFish extends Fish{
	private FishPanel _panel;
	//attributes of fish movement
	private double _ySpeed;
	private double _initSpeed;
	private double _acceleration;
	private double _initLoc;
	
	public JumpFish(Color aColor, SmartRectangle aRectangle, FishPanel panel){
		super(aColor, aRectangle, 1);
		this.setSpeed(1, 3);
		this.setLocation(170, 200);
		_panel = panel;
		_initSpeed=0;
		_acceleration = 10.5;
		_initLoc=50;
	}
	
	public void move(long startTime){
		//get the current time
		double currentTime = System.currentTimeMillis();
		//calculate the time passed 
		double time = (currentTime - startTime)/1000;
		//current speed on y axis
		_ySpeed =_initSpeed +_acceleration*time;
		//set the Y location
		double locY = _initLoc +_initSpeed*time+ 0.5*_acceleration*time*time;
		
		//if the fish still in the tank, then continue swimming and jumping out
		if (this.getX()<=470){
			//"bounce" up when hitting the bottom of the tank
			if(locY > 350){
				//change the Y speed to the same absolute value but opposite direction
				_initSpeed = -_acceleration*time;
				locY = 350;
				_initLoc = 350;
				//every time when the fish changes its movement, reset the start time  
				_panel.setStartTime();
			}
			else if(_ySpeed >= -5 && _ySpeed <= 0){
				//set the Y initial speed back to 0
				_initSpeed = 0;
				_initLoc = this.getY();
				//every time when the fish changes its movement, reset the start time  
				_panel.setStartTime();
			}
			//change the direction of the fish to the direction it faces
			if(_ySpeed>0){
				this.setRotation(Math.atan(_ySpeed/(10*_changeX)));
			}
			else {
				this.setRotation(Math.atan(_ySpeed/(10*_changeX)));
			}
			
			this.setLocation(this.getX()+_changeX, locY);
		}
		//if the fish jumps out of the tank, it will fall and won't bounce anymore
		else if (this.getX() > 470){
			if(locY > 400){
				_initSpeed = 0;
				locY = 405;
				_initLoc = 405;
				_panel.setStartTime();
				this.setLocation(this.getX(), 405);
			}
			else{
				this.setLocation(this.getX()+_changeX, locY);
			}
			if(_ySpeed>0){
				this.setRotation(Math.atan(_ySpeed/(10*_changeX)));
			}
			else {
				this.setRotation(Math.atan(_ySpeed/(10*_changeX)));
			}
		}
	} 
}

