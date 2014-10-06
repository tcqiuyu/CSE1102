import java.awt.event.MouseEvent;
import wheels.users.*;

public class HatPart extends Rectangle implements Draggable{
	
	private Draggable _hat;//interface polymorphic call 
	
	//constructor with parameter type Hat, so that the part class can know its container
	public HatPart(Draggable aHat){
		//pass the Hat's information to its part 
		_hat = aHat;
	}
	
	public void mousePressed(MouseEvent e){
		//call the mousePressed method in TallHat class. 
		_hat.mousePressed(e);
	}
	
	public void mouseDragged(MouseEvent e){
		//call the mouseDragged method in TallHat class
		_hat.mouseDragged(e);
	}
}

