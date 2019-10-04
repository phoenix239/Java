package asTicker;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		Ticker ticker_0 = new Ticker();
		contentPane.add(ticker_0);
		
		Ticker ticker_1 = new Ticker();
		contentPane.add(ticker_1);
		
		Ticker ticker_2 = new Ticker();
		contentPane.add(ticker_2);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnStart = new JButton("Start");
		panel.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		panel.add(btnStop);
	}

}
