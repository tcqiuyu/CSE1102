import java.awt.Color;

import wheels.users.*;

public class Scenario2 {
	private Rectangle _background2;
	private Scenario1 _scen1;
	private Bear _brownyBear;
	private Flip2 _flip2;
	public ConversationBubble _bubble2;
	private ConversationBubble _title;
	
	public Scenario2(){
		
		/*I use a white-filled rectangle to cover the whole frame 
		 * so it seems a whole new picture
		 * but actually, old picture is just covered.*/
		
		_background2 = new Rectangle();
		_background2.setColor(Color.WHITE);
		_background2.setLocation(0, 0);
		_background2.setSize(800, 800);
		
		//another character. I changed the color so you can distinguish.
		_brownyBear = new Bear(400,300,Color.GRAY);
		
		_title = new ConversationBubble("R E S T A U R A N T");
		_title.setFrameColor(null);
		_title.setSize(400, 100);
		_title.setLocation(500, 100);
		_bubble2 = new ConversationBubble("");
		_bubble2.setLocation(230, 210);
		this.setMessage("May I help you?");
		_flip2 = new Flip2();	
	}
	
	public void setMessage(String x){
		_bubble2.setText(x);
	}
	
	//This subclass makes it possbile to click anywhere in the picture would lead to the Scenario3.
	//pretty much like the Flip1
	private class Flip2 extends Rectangle implements MouseListener{
		private Scenario3 _scen3;
		
		public Flip2(){
			this.setColor(null);
			this.setLocation(0, 0);
			this.setSize(800, 800);
		}
		
		public void mouseClicked(java.awt.event.MouseEvent e) { 
			_bubble2.hide();
			_title.hide();
			_scen3 = new Scenario3();
		}
	}

}
