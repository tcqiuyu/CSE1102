public class LiteBriteFrame extends javax.swing.JFrame{
	
	private ControlPanel _controlPanel; 
	
	public LiteBriteFrame(String title){
		super(title);
		this.setSize(600,480);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		LiteBritePanel liteBritePanel = new LiteBritePanel(this);
		_controlPanel = new ControlPanel(liteBritePanel);
		
		this.add(_controlPanel, java.awt.BorderLayout.SOUTH);
		this.add(liteBritePanel, java.awt.BorderLayout.CENTER);
		this.setJMenuBar(new MenuBar(liteBritePanel));
		this.setVisible(true);
		
	}
	
	public void setStatusBarText(String s){
		_controlPanel.setStatusLabel(s);
	}
	
	public static void main(String[] args){
		new LiteBriteFrame("Hello!");
	}
}
