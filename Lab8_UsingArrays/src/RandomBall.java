
public class RandomBall extends SmartEllipse{
    public RandomBall(){
    	super(java.awt.Color.WHITE);
    	this.setLocation(this.randomNumber(0, 500), this.randomNumber(0, 500));
    	this.setFillColor(new java.awt.Color(this.randomNumber(0, 255),
    			this.randomNumber(0, 255),this.randomNumber(0, 255)));
    	}
    
    public int randomNumber(int low, int high){
    	return low+(int)(Math.random()*(high-low+1));
    }
}
