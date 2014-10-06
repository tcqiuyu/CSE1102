import java.awt.event.MouseEvent;
import wheels.users.*;

public class SnowmanPart extends Ellipse implements Draggable{
	private CartoonCharacter _char;//a peer object
	
	//constructor with parameter type Hat, so that the part class can know its container
	public SnowmanPart(CartoonCharacter aChar){
		//pass the character's information to this class
		_char = aChar;
	}
	
	public void mousePressed(MouseEvent e){
		//call the mousePressed method in CartoonCharacter class. 
		_char.mousePressed(e);
	}
	
	public void mouseDragged(MouseEvent e){
		//call the mouseDragged method in CartoonCharacter class. 
		_char.mouseDragged(e);
	}
}
