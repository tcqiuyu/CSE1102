import java.awt.event.MouseEvent;
import wheels.users.*;

public class HatPart extends Rectangle implements Draggable{
	private TallHat _hat;//a peer object
	public HatPart(TallHat aHat){//constructor with parameter type Hat, so that the part class can know its container
		_hat = aHat;//pass the Hat's information to its part 
	}
	
	public void mousePressed(MouseEvent e){
		_hat.mousePressed(e);//call the mousePressed method in TallHat class. 
	}
	
	public void mouseDragged(MouseEvent e){
		_hat.mouseDragged(e);//call the mouseDragged method in TallHat class
	}
}

