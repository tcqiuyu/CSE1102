/*
 * Chapter 4: MovableHatApp.java
 * Displays a composite object (a hat) that can be 
 * repositioned using a mouse
 */
import java.awt.Color;

import wheels.users.*;

public class MovableHatApp extends Frame{
	private TallHat _hat1,_hat2; //component
	
	public MovableHatApp(){
		super();
		_hat1=new TallHat(Color.BLACK,Color.LIGHT_GRAY,100,100);
		_hat1=new TallHat(Color.RED,Color.BLUE,300,100);
	}
	
	public static void main (String[] args){
		new MovableHatApp();
	}
}
