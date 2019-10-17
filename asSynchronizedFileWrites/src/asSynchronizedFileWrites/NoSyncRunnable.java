package asSynchronizedFileWrites;

import java.io.*;

public class NoSyncRunnable implements Runnable {
	private String msg;
	private int count;
	private String fileName;

	public NoSyncRunnable(String msg, int count, String fileName) {
		super();
		this.msg = msg;
		this.count = count;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fileName), true);
			Thread.sleep(100);
			for (int i = 0; i < count; i++) {
				pw.println(msg);
				Thread.sleep(100);
			}
			pw.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
