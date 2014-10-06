
public class FlashTimer extends javax.swing.Timer{
	private Flasher _flasher;
	public FlashTimer (int anInterval, Flasher aFlasher){
		super(anInterval, null);
		_flasher = aFlasher;
		this.addActionListener(new FlashListener());
	}

	private class FlashListener implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent e){
			_flasher.MakeFlash();
			_flasher.repaint();
		}
	}
}
