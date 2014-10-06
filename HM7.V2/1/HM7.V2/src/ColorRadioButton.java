
public class ColorRadioButton extends javax.swing.JRadioButton{

	private java.awt.Color _color;
	private LiteBritePanel _britePanel;
	
	public ColorRadioButton(java.awt.Color aColor, String aColorName,
			boolean aSelected, LiteBritePanel britePanel, ButtonPanel buttonPanel, javax.swing.ButtonGroup aGroup){
		super(aColorName, aSelected);
		_color = aColor;
		_britePanel = britePanel;
		buttonPanel.add(this);
		this.setBackground(aColor);
		this.setOpaque(true);
		this.addActionListener(new ColorListener());
		aGroup.add(this);
				
	}
	
	public java.awt.Color getColor(){
		return _color;
	}
	
	private class ColorListener implements java.awt.event.ActionListener{
		public void actionPerformed(java.awt.event.ActionEvent e){
			_britePanel.setColor(_color);
		}
	}
	
}
