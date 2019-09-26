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
		
		ThreadExt thread1 = new ThreadExt(sx,nx); 
        thread1.start();
        ThreadExt thread2 = new ThreadExt(sy,ny); 
        thread2.start();
        ThreadExt thread3 = new ThreadExt(sz,nz); 
        thread3.start();
	}
}
