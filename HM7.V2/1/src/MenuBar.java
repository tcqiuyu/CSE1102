import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuBar extends javax.swing.JMenuBar{

	private LiteBritePanel _liteBritePanel;
	
	public MenuBar(LiteBritePanel liteBritePanel){
		super();
		_liteBritePanel = liteBritePanel;
		
		JMenu file = new JMenu("File");
		this.add(file);
		
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(new saveAction());
		
		JMenuItem load = new JMenuItem("Load");
		load.addActionListener(new loadAction());
		
		JMenuItem export = new JMenuItem("Export as image");
		export.addActionListener(new exportAction());
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new exitAction());
		
		file.add(save);
		file.add(load);
		file.add(export);
		file.addSeparator();
		file.add(exit);
	}
	
	private class saveAction implements java.awt.event.ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			}
			catch(Exception e1){ System.out.println("Error setting Java LAF:" + e1); }
			
			JFileChooser fileChooser = new JFileChooser();
			
			int returnVal = fileChooser.showSaveDialog(new javax.swing.JFrame());
			if(returnVal == JFileChooser.APPROVE_OPTION){
				try {
					BufferedOutputStream bos = new BufferedOutputStream(
							new FileOutputStream(fileChooser.getSelectedFile().getAbsoluteFile()));
					bos.write(_liteBritePanel.getPegNum());
					for (int i = 0; i < _liteBritePanel.getPegNum(); i++){
						bos.write((int) _liteBritePanel.getEllipseArray()[i].getX());
						bos.write((int) _liteBritePanel.getEllipseArray()[i].getY()); 
						bos.write(_liteBritePanel.getColorArray().get(i).getRed());
						bos.write(_liteBritePanel.getColorArray().get(i).getGreen());
						bos.write(_liteBritePanel.getColorArray().get(i).getBlue());
					}
					
					bos.flush();
					bos.close();
				} catch (IOException e2) {
					System.out.println(e2);
				}				
			}
		}
	}
	
	private class loadAction implements java.awt.event.ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			}
			catch(Exception e1){ System.out.println("Error setting Java LAF:" + e1); }
			
			JFileChooser fileChooser = new JFileChooser();
			
			int returnVal = fileChooser.showOpenDialog(new javax.swing.JFrame());
			if(returnVal == JFileChooser.APPROVE_OPTION){
				try{
					BufferedInputStream bis = new BufferedInputStream(
							new FileInputStream(fileChooser.getSelectedFile().getAbsoluteFile()));
					int numberOfEllipse = bis.read();
					_liteBritePanel.setPegNum(numberOfEllipse);
					ColorEllipse[] tempEllipseArray = new ColorEllipse[numberOfEllipse+1];
					java.util.ArrayList<java.awt.Color> tempColorArray = new java.util.ArrayList<>();

					for(int i = 0; i < numberOfEllipse; i++){
						
						tempEllipseArray[i] = new ColorEllipse(bis.read(), bis.read());
						java.awt.Color aColor = new java.awt.Color(bis.read(),bis.read(),bis.read());
						tempColorArray.add(i, aColor);
						tempEllipseArray[i].setColor(aColor);
					}
					_liteBritePanel.setEllipseArray(tempEllipseArray);
					_liteBritePanel.setColorArray(tempColorArray);
					bis.close();
					_liteBritePanel.repaint();
					
					System.out.print(bis.read()+"\n"+bis.read()+"\n"+bis.read()+"\n"+bis.read());
				}
				catch(IOException e2){
					
				}
			}
		}
	}
	
	private class exportAction implements java.awt.event.ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try { 
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); 
			} 
			catch(Exception e1) { System.out.println("Error setting Java LAF: " + e1); }
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FileNameExtensionFilter("image files", "jpg", "png"));

			int returnVal = fileChooser.showSaveDialog(new javax.swing.JFrame());
			if (returnVal == JFileChooser.APPROVE_OPTION){
				BufferedImage image = new BufferedImage(_liteBritePanel.getWidth(), 
						_liteBritePanel.getHeight(), BufferedImage.TYPE_INT_RGB);
				java.awt.Graphics2D graphics = image.createGraphics();
				_liteBritePanel.RestoreColor();
				_liteBritePanel.paint(graphics);
				try {
					ImageIO.write(image, "jpeg", fileChooser.getSelectedFile().getAbsoluteFile());
				} 
				catch (IOException e2) {System.out.println("Error setting Java LAF: " + e2);}
			}
			
			
		}
		
	}
	
	private class exitAction implements java.awt.event.ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
}
