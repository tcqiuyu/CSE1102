
public class ControlPanel extends javax.swing.JPanel{

	private javax.swing.JLabel _statusLabel;
	
	public ControlPanel(LiteBritePanel liteBritePanel){
		super(new java.awt.BorderLayout());
		ButtonPanel buttonPanel = new ButtonPanel(liteBritePanel);
		this.add(buttonPanel,java.awt.BorderLayout.CENTER);		

		javax.swing.JPanel statusBar = new javax.swing.JPanel();
		statusBar.setBorder(new javax.swing.border.BevelBorder
				(javax.swing.border.BevelBorder.LOWERED));
		this.add(statusBar, java.awt.BorderLayout.SOUTH);
		statusBar.setPreferredSize(new java.awt.Dimension(this.getWidth(),20));
		statusBar.setLayout(new javax.swing.BoxLayout
				(statusBar, javax.swing.BoxLayout.X_AXIS));
		
		_statusLabel = new javax.swing.JLabel(liteBritePanel.getPegNum()+" pegs now used.");
		_statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		statusBar.add(_statusLabel);
		
	}
	
	public void setStatusLabel(String s){
		_statusLabel.setText(s);
	}
	
	private class StatusListener extends java.awt.event.TextEvent{

		public StatusListener(Object source, int id) {
			super(source, id);
			// TODO Auto-generated constructor stub
		}
		
	}
}
