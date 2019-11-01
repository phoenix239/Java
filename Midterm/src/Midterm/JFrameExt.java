package Midterm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Beans;
import java.lang.reflect.Field;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextField;

public class JFrameExt extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField[] jtfPropValues = new JTextField[10];
	private JLabel[] jlbPropNames = new JLabel[10];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameExt frame = new JFrameExt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrameExt() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelLeft);

		JPanel panelRight = new JPanel();
		contentPane.add(panelRight);
		panelRight.setLayout(new BorderLayout(0, 0));

		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(128, 0, 0));
		panelRight.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		String[] list = { "", "Midterm.Rect", "Midterm.Circ", "Midterm.Ticker" };

		JComboBox<?> jcboClassName = new JComboBox<Object>(list);
		jcboClassName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String className = (String) jcboClassName.getSelectedItem();

				// keep from crashing when selecting blank option
				if (className.equalsIgnoreCase(""))
					className = "Midterm.Blank";

				Object targetBeanObject = null;
				try {
					targetBeanObject = (JPanel) Beans.instantiate(null, className);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!(targetBeanObject instanceof JPanel)) {
					System.out.println("Opps!! Not a JPanel");
					return;
				}
				contentPane.remove(0);
				contentPane.add((JPanel) targetBeanObject, 0);
				contentPane.validate();

				// Populate Labels
				Field[] var = targetBeanObject.getClass().getDeclaredFields();

				for (int i = 0; i < jlbPropNames.length; i++) {
					jlbPropNames[i].setText("");
				}
				for (int i = 0; i < var.length; i++) {
					jlbPropNames[i].setText("   " + var[i].getName());
				}
				
				
				
				//TESTING
				for (int i = 0; i < var.length; i++) {
					System.out.println(var[i].getName());
					System.out.println(var[i].getType());
				}

			}
		});
		panelTop.add(jcboClassName);

		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.PINK);
		panelRight.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panelPropNames = new JPanel();
		panelPropNames.setBackground(new Color(64, 224, 208));
		panelCenter.add(panelPropNames);
		panelPropNames.setLayout(new GridLayout(10, 1, 0, 0));

		JPanel panelPropValues = new JPanel();
		panelPropValues.setBackground(new Color(0, 100, 0));
		panelCenter.add(panelPropValues);
		panelPropValues.setLayout(new GridLayout(10, 1, 0, 0));

		for (int i = 0; i < jlbPropNames.length; i++) {
			jlbPropNames[i] = new JLabel("");
			panelPropNames.add(jlbPropNames[i]);
		}
		for (int i = 0; i < jtfPropValues.length; i++) {
			jtfPropValues[i] = new JTextField(10);
			panelPropValues.add(jtfPropValues[i]);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Code Here
	}

}
