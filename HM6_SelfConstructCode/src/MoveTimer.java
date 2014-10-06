/*
 * MoveTimer.java
 * This is a timer that ticks every interval and performed certain action at each tick.
 */
public class MoveTimer extends javax.swing.Timer{
	private Mover _mover;
	
	public MoveTimer(int anInterval, Mover aMover){
		super(anInterval, null);
		_mover = aMover;
		this.addActionListener(new MoveListener());
	}
	
	//An inner class that will listen to the event that the timer passed and performed action 
	private class MoveListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
			_mover.move();
		}
	}

}
