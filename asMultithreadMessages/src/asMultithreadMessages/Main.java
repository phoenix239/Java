package asMultithreadMessages;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		String sx, sy, sz;
		int nx,ny,nz;
		
		sx = JOptionPane.showInputDialog("Enter Message: ");
		nx = Integer.parseInt(JOptionPane.showInputDialog("Enter Count"));
		
		sy = JOptionPane.showInputDialog("Enter Message: ");
		ny = Integer.parseInt(JOptionPane.showInputDialog("Enter Count"));
		
		sz = JOptionPane.showInputDialog("Enter Message: ");
		nz = Integer.parseInt(JOptionPane.showInputDialog("Enter Count"));
		
		MultithreadingExt thread1 = new MultithreadingExt(sx,nx); 
        thread1.start();
        
        MultithreadingExt thread2 = new MultithreadingExt(sy,ny); 
        thread2.start();
        
        MultithreadingExt thread3 = new MultithreadingExt(sz,nz); 
        thread3.start();

	}

}
