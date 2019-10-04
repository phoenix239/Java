package asTicker;

import java.awt.*;

import javax.swing.*;

public class Ticker extends JPanel implements Runnable{
	
	private boolean moving = false;
	private String symbol;
	private String stockName = "Not Set";
	private double stockPrice = 0.0;
	private boolean direction = true;
	private long sleepTime = 50;
	private int x = 190;
	private int y = 35;
	
	
	public Ticker() {
		Thread t = new Thread(this);
		t.start();
		symbol = stockName + "   " + stockPrice;
	}
	
	@Override	
	public void run() {
		while(true){
			if (moving){
				repaint();
			}
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString(symbol, x, y);
	}
	
	public void setMoving (boolean newMoving ){
		moving = newMoving;
	}

	public boolean isMoving ( ){
		return moving;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public boolean isDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public long getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}
}
