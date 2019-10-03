package asTickerSimple;

import java.awt.*;

import javax.swing.*;

public class Ticker extends JPanel implements Runnable{
	
	private boolean moving = false;
	private String symbol = "DVC 32.0";
	private int symbolWidth;
	private int x = 30;
	private int y = 100;
	
	public Ticker() {
		moving = false;
		Thread t1 = new Thread();
		t1.run();
	}
	
	public void run() {
		//Code the run method to animate the ticker.
		while(true){
			if (moving){
				//Update stock Ticker’s draw co-ordinates.
				x--;
				//Call Ticker’s repaint method.
				repaint();
				}
			//Sleep for a fixed time.
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setMoving (boolean newMoving ){moving = newMoving;}

	public boolean isMoving ( ){ return moving;}
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		FontMetrics fm = g.getFontMetrics();
		symbolWidth = fm.stringWidth(symbol);
		g.drawString(symbol, x, y);
	}
}
