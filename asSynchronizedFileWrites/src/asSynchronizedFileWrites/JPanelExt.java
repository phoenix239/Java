package asSynchronizedFileWrites;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

public class JPanelExt extends JPanel {
	private JTextField jtfMsg1;
	private JTextField jtfMsg2;
	private JTextField jtfCount;
	private JTextField jtfFileName;
	private String msg1;
	private String msg2;
	private int count;
	private String fileName;
	

	/**
	 * Create the panel.
	 */
	public JPanelExt() {
		setLayout(new BorderLayout(0, 0));

		JPanel TxtInput = new JPanel();
		add(TxtInput, BorderLayout.NORTH);
		TxtInput.setBackground(new Color(204, 51, 0));
		TxtInput.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("  Msg 1: ");
		TxtInput.add(lblNewLabel);

		jtfMsg1 = new JTextField();
		TxtInput.add(jtfMsg1);
		jtfMsg1.setColumns(5);

		JLabel lblNewLabel_1 = new JLabel("  Msg 2: ");
		TxtInput.add(lblNewLabel_1);

		jtfMsg2 = new JTextField();
		TxtInput.add(jtfMsg2);
		jtfMsg2.setColumns(5);

		JLabel lblNewLabel_2 = new JLabel("  Count: ");
		TxtInput.add(lblNewLabel_2);

		jtfCount = new JTextField();
		TxtInput.add(jtfCount);
		jtfCount.setColumns(5);

		JLabel lblNewLabel_3 = new JLabel("  File Name:");
		TxtInput.add(lblNewLabel_3);

		jtfFileName = new JTextField();
		TxtInput.add(jtfFileName);
		jtfFileName.setColumns(10);

		JPanel TxtBox = new JPanel();
		add(TxtBox, BorderLayout.CENTER);
		TxtBox.setBackground(new Color(0, 128, 128));
		FlowLayout fl_TxtBox = (FlowLayout) TxtBox.getLayout();

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setRows(15);
		textArea.setColumns(50);
		TxtBox.add(textArea);

		JPanel Buttons = new JPanel();
		add(Buttons, BorderLayout.SOUTH);
		Buttons.setBackground(new Color(255, 215, 0));

		JButton btnWrite = new JButton("Write");
		btnWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				msg1 = jtfMsg1.getText();
				msg2 = jtfMsg2.getText();
				count = Integer.parseInt(jtfCount.getText().trim());
				fileName = jtfFileName.getText();

				NoSyncRunnable noSync1 = new NoSyncRunnable(msg1, count, fileName);
				NoSyncRunnable noSync2 = new NoSyncRunnable(msg2, count, fileName);

				Thread t1 = new Thread(noSync1);
				Thread t2 = new Thread(noSync2);
				t1.start();
				t2.start();

				System.out.println("Write");
			}
		});
		Buttons.add(btnWrite);

		JButton btnCompWrite = new JButton("Comp Write");
		btnCompWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msg1 = jtfMsg1.getText();
				msg2 = jtfMsg2.getText();
				count = Integer.parseInt(jtfCount.getText().trim());
				fileName = jtfFileName.getText();
				Object obj = new Object();

				CompSyncRunnable CompSync1 = new CompSyncRunnable(msg1, count, fileName, obj);
				CompSyncRunnable CompSync2 = new CompSyncRunnable(msg2, count, fileName, obj);

				Thread t1 = new Thread(CompSync1);
				Thread t2 = new Thread(CompSync2);
				t1.start();
				t2.start();

				System.out.println("CompWrite");
			}
		});
		Buttons.add(btnCompWrite);

		JButton btnCoopWrite = new JButton("Coop Write");
		btnCoopWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msg1 = jtfMsg1.getText();
				msg2 = jtfMsg2.getText();
				count = Integer.parseInt(jtfCount.getText().trim());
				fileName = jtfFileName.getText();
				Object obj = new Object();

				CoopSyncRunnable CoopSync1 = new CoopSyncRunnable(msg1, count, fileName, obj);
				CoopSyncRunnable CoopSync2 = new CoopSyncRunnable(msg2, count, fileName, obj);

				Thread t1 = new Thread(CoopSync1);
				Thread t2 = new Thread(CoopSync2);
				t1.start();
				t2.start();

				System.out.println("CoopWrite");
			}
		});
		Buttons.add(btnCoopWrite);

		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(fileName));

					String st;
					while ((st = br.readLine()) != null) {
						System.out.println(st);
					}
					br.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		Buttons.add(btnDisplay);

		JButton Clear = new JButton("Clear");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(fileName), true);
					pw.println("");
					pw.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		Buttons.add(Clear);

	}

}
