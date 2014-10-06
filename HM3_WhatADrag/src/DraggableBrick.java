/* Yu Qiu, Math Dept.
 * Homework 3
 * "What a drag!"
 */

import java.awt.Color;
import wheels.users.*;

public class DraggableBrick extends Frame{
	
	public DraggableBrick(){
		//create 3 bricks and 1 trash can.
		new BrickGen(50,50,80,50,Color.RED);
		new BrickGen(50,120,50,50,Color.YELLOW);
		new BrickGen(50,180,30,50,Color.BLUE);
		new Trashcan(330,150);
	}
	
	//execute the app.
	public static void main(String[] args){
		new DraggableBrick();
	}

}
