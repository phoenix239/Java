package asDraw;

import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelExt extends JPanel{
	
	private String pictureType = "Happy";
	
	public JPanelExt() {
		super();
	}
	
	@Override
	
	public void paintComponent(Graphics g){
		//call the parent method to clean the surface
		super.paintComponent (g);
		
		//include the code that does the drawing here.
		
		if (this.pictureType.equalsIgnoreCase("Happy")){
			g.drawOval(0,0,100,100);
			g.fillOval(25,25,10,10);
			g.fillOval(65,25,10,10);
			g.drawArc(25,25,50,50,0,-180);
		}
		else if (this.pictureType.equalsIgnoreCase ("Sad")){
			g.drawOval(0,0,100,100);
			g.fillOval(25,25,10,10);
			g.fillOval(65,25,10,10);
			g.drawArc(25,50,50,50,0,180);
		}
		else if (this.pictureType.equalsIgnoreCase ("Picture")){
			
		}
	}
	
	public void setPictureType (String pictureType){
		this.pictureType=pictureType;
		this.repaint( );
	}
}
