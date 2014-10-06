/*
 * MenuBar.java
 * This is a class defines the menu bar of the frame
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MenuBar extends javax.swing.JMenuBar{

	private LiteBritePanel _liteBritePanel;
	
	public MenuBar(LiteBritePanel liteBritePanel){
		super();
		_liteBritePanel = liteBritePanel;
		
		//instantiate and add "File" menu to the menu bar
		JMenu file = new JMenu("File");
		this.add(file);
		//instantiate and add various menu items to the "File" menu.
		//add corresponding listener 
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(new SaveActionListener());
		JMenuItem load = new JMenuItem("Load");
		load.addActionListener(new LoadActionListener());
		JMenuItem export = new JMenuItem("Export as image");
		export.addActionListener(new ExportActionListener());
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ExitActionListener());
		file.add(save);
		file.add(load);
		file.add(export);
		file.addSeparator();
		file.add(exit);
	}
	
	//inner class defines "save" action
	private class SaveActionListener implements java.awt.event.ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//instantiate a file dialog
			FileDialog fileDialog = new FileDialog(new Frame(), "Save", java.awt.FileDialog.SAVE);//the mode is SAVE
 			fileDialog.setVisible(true);
 			try {
				BufferedOutputStream bos = new BufferedOutputStream(
						new FileOutputStream(fileDialog.getDirectory()+fileDialog.getFile()));
				//writhe the number of pegs to the file
				bos.write(_liteBritePanel.getPegNum());
				//write other information to the buffered output stream
				for (int i = 0; i < _liteBritePanel.getPegNum(); i++){
					//use two bytes to write the location of each peg
					bos.write((int) Math.floor(_liteBritePanel.getPegArray()[i].getX()/255));
					bos.write((int) _liteBritePanel.getPegArray()[i].getX()%255);
					bos.write((int) Math.floor(_liteBritePanel.getPegArray()[i].getY()/255)); 
					bos.write((int) _liteBritePanel.getPegArray()[i].getY()%255); 
					//write the color of each peg
					bos.write(_liteBritePanel.getColorArrayList().get(i).getRed());
					bos.write(_liteBritePanel.getColorArrayList().get(i).getGreen());
					bos.write(_liteBritePanel.getColorArrayList().get(i).getBlue());
				}	
				bos.flush();
				bos.close();
			} 
 			catch (IOException e2) {
				System.out.println(e2);
			}				
		}
	}
	
	//inner class defines "load" action
	private class LoadActionListener implements java.awt.event.ActionListener{
	 		@Override
	 		public void actionPerformed(ActionEvent e) {
	 			//instantiate a file dialog
	 			FileDialog fileDialog = new FileDialog(new Frame(), "Open", java.awt.FileDialog.LOAD);//mode is LOAD
	 			fileDialog.setVisible(true);
	 			//read all information from the file selected
	 			try{
	 				//instantiate buffered input stream from the selected file
	 				BufferedInputStream bis = new BufferedInputStream(
	 						new FileInputStream(fileDialog.getDirectory()+fileDialog.getFile()));
	 				//the first data is the number of pegs
	 				int numberOfPegs = bis.read();
	 				//manually set the number of pegs or it will have null pointer exception
	 				_liteBritePanel.setPegNum(numberOfPegs);
	 				ColorEllipse[] tempPegArray = new ColorEllipse[numberOfPegs+1];
	 				java.util.ArrayList<java.awt.Color> tempColorArray = new java.util.ArrayList<java.awt.Color>();
	 				for(int i = 0; i < numberOfPegs; i++){	
	 					//load and set the location and color information from the file
	 					tempPegArray[i] = new ColorEllipse(bis.read()*255+bis.read(), bis.read()*255+bis.read());
	 					java.awt.Color aColor = new java.awt.Color(bis.read(),bis.read(),bis.read());
	 					tempColorArray.add(i, aColor);
	 					tempPegArray[i].setColor(aColor);
	 				}	
	 				//manually set the peg array and color array list to prevent null pointer exception
	 				_liteBritePanel.setPegArray(tempPegArray);
	 				_liteBritePanel.setColorArrayList(tempColorArray);
	 				bis.close();
	 				//repaint the panel
	 				_liteBritePanel.repaint();
	 			}
				catch(IOException e2){
				}
	 		}
	 	}
	
	//inner class defines "export to image" action
	private class ExportActionListener implements java.awt.event.ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//instantiate a file dialog
 			FileDialog fileDialog = new FileDialog(new Frame(), "Export to image", java.awt.FileDialog.SAVE);//mode is SAVE
 			fileDialog.setVisible(true);
 			
 			//define and instantiate a filter
 			FilenameFilter filter = new FilenameFilter() {	
				@Override
				//only appear the file with extension "jpg"
				public boolean accept(File dir, String name) {
					if (name.endsWith("jpg")){
						return true;
					}	
					return false;
				}
			};
			//set the file name filter
			fileDialog.setFilenameFilter(filter);
			//instantiate a buffered image
			BufferedImage image = new BufferedImage(_liteBritePanel.getWidth(), 
					_liteBritePanel.getHeight(), BufferedImage.TYPE_INT_RGB);
			java.awt.Graphics2D graphics = image.createGraphics();
			_liteBritePanel.RestoreColor();
			_liteBritePanel.paint(graphics);
			//write the image to the file
			try {
				File f = new File(fileDialog.getDirectory()+fileDialog.getFile()+".jpg");
				ImageIO.write(image, "jpg", f);
			} 
			catch (IOException e2) {System.out.println("Error setting Java LAF: " + e2);}
		}			
	}
	
	//defines "exit" action
	private class ExitActionListener implements java.awt.event.ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}		
	}
}
