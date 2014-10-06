import java.awt.Color;

import wheels.users.*;

public class Scenario3 {
	private Background _background;
	private Rectangle _background2;
	private Bear _whiteBear;
	private Table _table1;
	private Table _table2;
	private Table _table3;
	private Table _table4;	
	private Counter _counter;
	public ConversationBubble _bubble3;
	private Scenario2 _scen2;
	private Scenario1 _scen1;
	
	public Scenario3 (){
		/*I use a white-filled rectangle to cover the whole frame 
		 * so it seems a whole new picture
		 * but actually, old picture is just covered.*/
		// just like in scenario 2
		_background2 = new Rectangle();
		_background2.setColor(Color.WHITE);
		_background2.setLocation(0, 0);
		_background2.setSize(800, 800);
		
		_background = new Background();
		_table1 = new Table(470,280,5);
		_table2 = new Table(300,300,7);
		_table3 = new Table(100,280,5);
		_table4 = new Table(480,360,9);
		_whiteBear = new Bear(180,220,Color.WHITE);
		_counter = new Counter();
		_bubble3 = new ConversationBubble("");
		_bubble3.setLocation(60, 120);
		this.setMessage("I want a fish!");
	}
	
	public void setMessage(String x){
		_bubble3.setText(x);
	}

}