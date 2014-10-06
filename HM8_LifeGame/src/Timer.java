/*
 * FlashTimer.java
 * This is a class extends Timer
 * When it ticks, it will start the animation.
 */

public class Timer extends javax.swing.Timer{
	private MainPanel _mainPanel;
	public Timer (int anInterval, MainPanel aFlasher){
		super(anInterval, null);
		_mainPanel = aFlasher;
		this.addActionListener(new TickListener());//register the listener
	}

	private class TickListener implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent e){
			//invoke the update game method and repaint the panel.
			_mainPanel.UpdateGame();
			_mainPanel.repaint();
		}
	}
}
