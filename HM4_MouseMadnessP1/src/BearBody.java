import java.awt.Color;

import wheels.users.*;

public class BearBody {
	//variables in "Browny's Body"
	private RoundedRectangle _arm1;
	private RoundedRectangle _arm2;
	private RoundedRectangle _body;
	private Ellipse _hand1;
	private Ellipse _hand2;
	
	//method to draw character's body
	public BearBody(int x, int y, Color a){
		_arm1 = new RoundedRectangle();
		_hand1 = new Ellipse();
		_arm2 = new RoundedRectangle();
		_hand2 = new Ellipse();
		_body = new RoundedRectangle();
		
		this.setBodyColor(a);
		this.setBodySize();
		this.setBodyLocation(x, y);
	}
	
	//set body color
	public void setBodyColor(Color a){
		this._arm1.setFillColor(a);
		this._hand1.setFillColor(a);
		this._arm2.setFillColor(a);
		this._hand2.setFillColor(a);
		this._body.setFillColor(a);
		
		this._arm1.setFrameColor(Color.BLACK);
		this._hand1.setFrameColor(Color.BLACK);
		this._arm2.setFrameColor(Color.BLACK);
		this._hand2.setFrameColor(Color.BLACK);
		this._body.setFrameColor(Color.BLACK);
		
		this._arm1.setFrameThickness(2);
		this._hand1.setFrameThickness(2);
		this._arm2.setFrameThickness(2);
		this._hand2.setFrameThickness(2);
		this._body.setFrameThickness(2);
		
		
	}
	
	//set body location
	public void setBodyLocation(int x, int y){
			this._arm1.setLocation(x, y);
			this._hand1.setLocation(x-25, y+70);
			this._arm2.setLocation(x+160, y);
			this._hand2.setLocation(x+185, y+70);
			this._body.setLocation(x+25, y-10);
			
			this._arm1.setRotation(30);
			this._arm2.setRotation(150);
	}
	
	//set body size
	public void setBodySize(){
		this._arm1.setSize(30, 90);
		this._hand1.setSize(30, 30);
		this._arm2.setSize(30, 90);
		this._hand2.setSize(30, 30);
		this._body.setSize(130, 130);
	}
}
