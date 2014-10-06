import java.awt.Color;

import javax.swing.ButtonGroup;


public class CustomColorButton extends javax.swing.JRadioButton{

	private java.awt.Color _color = java.awt.Color.white;
	private LiteBritePanel _britePanel;
	
	public CustomColorButton(boolean aSelected, 
			LiteBritePanel britePanel, ButtonPanel buttonPanel, 
			ButtonGroup aGroup) {
		super("Custom", aSelected);
		_britePanel = britePanel;
		buttonPanel.add(this);
		this.addActionListener(new CustomColorListener(this));
		aGroup.add(this);
	}

	private class CustomColorListener implements java.awt.event.ActionListener{
		private CustomColorButton _customColorButton;

		public CustomColorListener(CustomColorButton customColorButton){
			_customColorButton = customColorButton;
		}
		public void actionPerformed(java.awt.event.ActionEvent e){
			java.awt.Color tempColor = _color;
			_color = javax.swing.JColorChooser.showDialog(null, "Color Chooser", _color);
			if(_color == null){
				_color = tempColor;
			}
			
			_britePanel.setColor(_color);
			_customColorButton.setBackground(_color);
			_customColorButton.setOpaque(true);

		}
	}
	
}
