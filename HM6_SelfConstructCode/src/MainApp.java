/*
 * Homework6: Fantastic Fish
 * Yu Qiu, Math Dep.
 * 
 * MainApp.java
 * This is the main class of the project.
 */

public class MainApp extends javax.swing.JFrame{
	public MainApp(String title){
		super(title);
		this.setSize(600, 450);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.add(new FishPanel(this));
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		new MainApp("Fantastic Fish by Yu Qiu");
	}

}
