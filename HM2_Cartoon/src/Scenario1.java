import java.awt.Color;

import wheels.users.*;


public class Scenario1{
	private Background _background;
	private Bear _whiteBear;
	private Table _table1;
	private Table _table2;
	private Table _table3;
	private Table _table4;	
	private Counter _counter;
	public ConversationBubble _bubble1;
	private Flip1 _flip1;
	
	public Scenario1 (){
		_background = new Background();
		_table1 = new Table(470,280,5);
		_table2 = new Table(300,300,7);
		_table3 = new Table(100,280,5);
		_table4 = new Table(480,360,9);
		_whiteBear = new Bear(180,220,Color.WHITE);
		_counter = new Counter();
		_bubble1 = new ConversationBubble("");
		_bubble1.setLocation(60, 120);
		this.setMessage("Hello!");
		_flip1 = new Flip1();
	}
	
	public void setMessage(String x){
		_bubble1.setText(x);
	}

//This subclass makes it possible to click anywhere in the picture would lead to the Scenario2.
	private class Flip1 extends Rectangle implements MouseListener{
		private Scenario2 _scen2;
		
		public Flip1(){
			//set the color to nothing so that people cannot see it, just like a invisible cover
			this.setColor(null);
			this.setLocation(0, 0);
			this.setSize(800, 800);
		}
		
		public void mouseClicked(java.awt.event.MouseEvent e) { 
			_bubble1.hide();
			_scen2 = new Scenario2();
		}

	}

}