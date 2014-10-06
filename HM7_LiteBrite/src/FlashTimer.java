/*
 * FlashTimer.java
 * This is a class extends Timer
 * When it ticks, it will make the pegs flash.
 */
public class FlashTimer extends javax.swing.Timer{
	private Flasher _flasher;
	public FlashTimer (int anInterval, Flasher aFlasher){
		super(anInterval, null);
		_flasher = aFlasher;
		this.addActionListener(new FlashListener());//register the listener
	}

	private class FlashListener implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent e){
			//invoke the make flash method and repaint the panel.
			_flasher.MakeFlash();
			_flasher.repaint();
		}
	}
}
