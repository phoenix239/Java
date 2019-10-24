package asSynchronizedFileWrites;

import java.io.*;

public class CompSyncRunnable implements Runnable {
	private String msg;
	private int count;
	private String fileName;
	Object obj;

	public CompSyncRunnable(String msg, int count, String fileName, Object obj) {
		super();
		this.msg = msg;
		this.count = count;
		this.fileName = fileName;
		this.obj = obj;
	}

	@Override
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fileName), true);
			Thread.sleep(100);
			synchronized (obj) {
				for (int i = 0; i < count; i++) {
					pw.println(msg);
					Thread.sleep(100);
				}
			}
			pw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
