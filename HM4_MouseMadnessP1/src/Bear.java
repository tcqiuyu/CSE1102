import wheels.users.*;

import java.awt.Color;

public class Bear extends Frame{
	//constructor with no parameter (default)
	public Bear(){
		new BearBody(100,220, Color.GRAY);
		new BearHead(100,100, Color.GRAY);
	}
	
	//constructor with parameters(location, main color)
	public Bear(int x, int y, Color a){
		new BearBody(x,y+120, a);
		new BearHead(x, y, a);
	}
	
	public static void main(String[] args){
		new Bear();
	}
}
