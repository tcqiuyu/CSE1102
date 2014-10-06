/*
 * DeadFish.java
 * This class defines dead fish that float up to the surface and gradually disappear. 
 * And the fish appear to be turned while its floating up. 
 */
import java.awt.Color;


public class DeadFish extends Fish{
	private double _changeY;
	//transparency parameter 
	private int _alpha;
	
	public DeadFish(Color aColor, 
    		SmartRectangle aRectangle, double sizeFactor){
		super(aColor,aRectangle,sizeFactor);
		_changeY = 2;
		_alpha = 255;
	}
	
	public void move(){
		double nextY = this.getY()-_changeY;
		//change the size of body and tail so that it looks like the dead fish turns itself
		double nextBodySize = this._body.getMaxY()-this._body.getY()-0.2;
		double nextTailSize = this._tail.getMaxY()-this._tail.getY()-0.2;
		
		//When the fish arrive the surface, do "decompose" step.
		if (nextY <= this.getMinBoundY()){
			this.setLocation(this.getX(), this.getMinBoundY());
			this.decompose();
		}
		//Or if the fish does not arrive the surface, float up.
		else {
			this.setLocation(this.getX(), nextY);
			this._body.setSize(34, nextBodySize);
			this._tail.setSize(12, nextTailSize);
		}
	}
	
	//decompose method, that makes the fish disappear gradually.
	public void decompose(){
		//if the fish is not transparent, then make it transparent gradually
		if ( _alpha >= 1 ){
			_alpha = _alpha - 5; 
			Color currentColor = new Color(0,255,255,_alpha);
			this._body.setColor(currentColor, currentColor);
			this._tail.setColor(currentColor, currentColor);
		}
		else
			_alpha = 0;
	}
	
}
