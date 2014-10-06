import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;


public class TallHat implements Draggable{
	//declare variables 
	private Color _mainColor;
	private Color _alternateColor;
	private HatPart _brim, _band1,_band2,_band3,_band4;
	private int _x, _y; //variable to store and pass the value of Hat's original position.
	private Point _lastMousePosition;
	
	//constructor with no parameter 
	public TallHat() {
		_x = 200;
		_y = 160;
		_mainColor = Color.BLACK;
		_alternateColor = Color.DARK_GRAY;
		_brim = new HatPart(this);
		_band1 = new HatPart(this);
		_band2 = new HatPart(this);
		_band3 = new HatPart(this);
		_band4 = new HatPart(this);//inheritance polymorphism 
		this.setColor(_mainColor, _alternateColor);
		this.setLocation(_x, _y);
		this.setSize(100, 15);
	}
	
	//constructor with 4 parameters: main color a, alternate color b, location(x,y)
	public TallHat(Color a, Color b, int x, int y){
		this();
		_mainColor = a;
		_alternateColor = b;
		this.setColor(a, b);
		this.setLocation(x, y);
	}
	
	//method of setting the hat's color
	public void setColor(Color a, Color b){
		this._brim.setColor(a);
		this._band1.setColor(b);
		this._band2.setColor(a);
		this._band3.setColor(b);
		this._band4.setColor(a);
	}
	
	//method of setting the hat's location
	public void setLocation(int x, int y){
		_x = x;
		_y = y;
		this._brim.setLocation(x,y);
		this._band1.setLocation(x+20, y-25);
		this._band2.setLocation(x+20, y-50);
		this._band3.setLocation(x+20, y-75);
		this._band4.setLocation(x+20, y-100);
	}
	
	public Point getLocation(){
		return _brim.getLocation();
	}
	//method of setting the hat's size
	public void setSize(int x,int y){
		this._brim.setSize(x, y);
		this._band1.setSize(x-40, y+10);
		this._band2.setSize(x-40, y+10);
		this._band3.setSize(x-40, y+10);
		this._band4.setSize(x-40, y+10);
	}

	public void mousePressed(MouseEvent e){
		_lastMousePosition = e.getPoint();//get the original location of the hat
	}
	
	public void mouseDragged(MouseEvent e){
		Point currentPoint = e.getPoint();//get the current cursor's location of the hat
		int diffX = currentPoint.x-_lastMousePosition.x;
		int diffY = currentPoint.y-_lastMousePosition.y;//calculate the drift 
		this.setLocation(_x+diffX,_y+diffY);//set the new location of the hat
		_lastMousePosition = currentPoint;//set the new starting location
	}
	
}