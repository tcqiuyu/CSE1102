import wheels.users.*;

import java.awt.Color;

public class TallHat {
	//declare variables 
	private Color _mainColor;
	private Color _alternateColor;
	private Rectangle _brim;
	private Rectangle _band1;
	private Rectangle _band2;
	private Rectangle _band3;
	private Rectangle _band4;
	private ConversationBubble _bubble;
	
	//constructor with no parameter 
	public TallHat() {
		_mainColor = Color.RED;
		_alternateColor = Color.BLUE;
		_brim = new Rectangle();
		_band1 = new Rectangle();
		_band2 = new Rectangle();
		_band3 = new Rectangle();
		_band4 = new Rectangle();
		_bubble = new ConversationBubble("Hello");
		this.setColor(_mainColor, _alternateColor);
		this.setLocation(200, 160);
		this.setSize(100, 15);
	}
	
	//constructor with 5 parameters: main color a, alternate color b, location(x,y), and bubble text z.
	public TallHat(Color a, Color b, int x, int y, String z){
		this();
		_mainColor = a;
		_alternateColor = b;
		this._bubble.setText(z);
		this._bubble.setSize(150,110);
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
		this._brim.setLocation(x,y);
		this._band1.setLocation(x+20, y-25);
		this._band2.setLocation(x+20, y-50);
		this._band3.setLocation(x+20, y-75);
		this._band4.setLocation(x+20, y-100);
		this._bubble.setLocation(x-140, y-150);
	}
	
	//method of setting the hat's size
	public void setSize(int x,int y){
		this._brim.setSize(x, y);
		this._band1.setSize(x-40, y+10);
		this._band2.setSize(x-40, y+10);
		this._band3.setSize(x-40, y+10);
		this._band4.setSize(x-40, y+10);
	}
	
}
