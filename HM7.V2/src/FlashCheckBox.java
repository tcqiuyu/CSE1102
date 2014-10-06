import java.awt.event.ItemEvent;


public class FlashCheckBox extends javax.swing.JCheckBox{

	private LiteBritePanel _britePanel;
	
	public FlashCheckBox(ButtonPanel buttonPanel, LiteBritePanel britePanel){
		super("FLASH");
		_britePanel = britePanel;
		buttonPanel.add(this);
		this.addItemListener(new CheckBoxListener(this));
	}
	
	private class CheckBoxListener implements java.awt.event.ItemListener {
		private FlashCheckBox _container;
		
		public CheckBoxListener(FlashCheckBox container){
			_container = container;
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(_container.isSelected()==true){
				_britePanel.TimerStart();
			}
			else{
				_britePanel.TimerStop();
				_britePanel.RestoreColor();
				_britePanel.repaint();
			}
		}
	}
}
