import wheels.users.*;

import java.awt.Color;

public class Bear {
	//declare variables
	
	//variables in "Browny's Head"
	private Ellipse _ear1;
	private Ellipse _ear2;
	private Ellipse _head;
	private Ellipse _eye1;
	private Ellipse _eye2;
	private Ellipse _cheek;
	private RoundedRectangle _nose;
	private Line _mouth1;
	private Line _mouth2;
	private Line _mouth3;
	
	//variables in "Browny's Body"
	private RoundedRectangle _arm1;
	private RoundedRectangle _arm2;
	private RoundedRectangle _body;
	private Ellipse _hand1;
	private Ellipse _hand2;
	
	//constructor with no parameter (default)
	public Bear(){
		this.BrownyBody(100,220, Color.GRAY);
		this.BrownyHead(100,100, Color.GRAY);
	}
	
	//constructor with parameters(location, main color)
	public Bear(int x, int y, Color a){
		this.BrownyBody(x,y+120, a);
		this.BrownyHead(x, y, a);
	}
	
	//method to draw character's head
	public void BrownyHead(int x, int y, Color a){
		_ear1 = new Ellipse();
		_ear2 = new Ellipse();
		_head = new Ellipse();
		_eye1 = new Ellipse();
		_eye2 = new Ellipse();
		_cheek = new Ellipse();
		_nose = new RoundedRectangle();
		_mouth1 = new Line();
		_mouth2 = new Line();
		_mouth3 = new Line();
		this.setHeadLocation(x,y);
		this.setHeadColor(a);
		this.setHeadSize();
	}
	
	//set head color
	public void setHeadColor(Color a){
		this._ear1.setFillColor(a);
		this._ear2.setFillColor(a);
		this._eye1.setColor(Color.BLACK);
		this._eye2.setColor(Color.BLACK);
		this._head.setFillColor(a);
		this._cheek.setColor(Color.LIGHT_GRAY);
		this._nose.setColor(Color.BLACK);
		this._mouth1.setColor(Color.BLACK);
		this._mouth2.setColor(Color.BLACK);		
		this._mouth3.setColor(Color.BLACK);
		
		
		this._ear1.setFrameColor(Color.BLACK);
		this._ear2.setFrameColor(Color.BLACK);
		this._head.setFrameColor(Color.BLACK);
		this._mouth1.setThickness(2);
		
		this._ear1.setFrameThickness(2);
		this._ear2.setFrameThickness(2);
		this._head.setFrameThickness(2);
		this._mouth1.setThickness(3);
		this._mouth2.setThickness(3);
		this._mouth3.setThickness(3);

	}
	
	//set head location
	public void setHeadLocation(int x, int y){
		this._head.setLocation(x, y);
		this._ear1.setLocation(x+30, y-20);
		this._ear2.setLocation(x+112, y-20);
		this._eye1.setLocation(x+70, y+55);
		this._eye2.setLocation(x+100, y+55);
		this.setCheekLocation(x+70,y+70);

	}
	
	public void setCheekLocation(int x, int y){
		this._cheek.setLocation(x, y);
		this._nose.setLocation(x+16, y+5);
		this._mouth1.setPoints(x+20, y+10, x+20, y+25);
		this._mouth2.setPoints(x+12, y+35, x+20, y+25);
		this._mouth3.setPoints(x+28, y+35, x+20, y+25);
		
	}
	
	//set head size
	public void setHeadSize(){
		this._ear1.setSize(40, 50);
		this._ear2.setSize(40, 50);
		this._eye1.setSize(9, 9);
		this._eye2.setSize(9, 9);
		this._cheek.setSize(40, 50);
		this._head.setSize(180, 160);
		this._nose.setSize(8, 12);
	}
	
	//method to draw character's body
	public void BrownyBody(int x, int y, Color a){
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
