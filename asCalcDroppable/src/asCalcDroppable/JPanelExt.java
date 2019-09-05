package asCalcDroppable;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class JPanelExt extends JPanel {
	private JTextField jpNum1;
	private JTextField jpNum2;
	private JTextField jpSum;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public JPanelExt() {
		setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(Color.CYAN);
		add(panel_0);
		panel_0.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblFirstNumber = new JLabel("First Number: ");
		panel_0.add(lblFirstNumber);
		
		jpNum1 = new JTextField();
		panel_0.add(jpNum1);
		jpNum1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		add(panel_1);
		
		JLabel lblSecondNumber = new JLabel("Second Number: ");
		panel_1.add(lblSecondNumber);
		
		jpNum2 = new JTextField();
		panel_1.add(jpNum2);
		jpNum2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		add(panel_2);
		
		JLabel lblResults = new JLabel("Results: ");
		panel_2.add(lblResults);
		
		jpSum = new JTextField();
		panel_2.add(jpSum);
		jpSum.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.RED);
		add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_3_0 = new JPanel();
		panel_3_0.setBackground(Color.RED);
		panel_3.add(panel_3_0);
		
		JRadioButton jrbAdd = new JRadioButton("+");
		buttonGroup.add(jrbAdd);
		jrbAdd.setSelected(true);
		jrbAdd.setBackground(Color.RED);
		panel_3_0.add(jrbAdd);
		
		JRadioButton jrbSub = new JRadioButton("-");
		buttonGroup.add(jrbSub);
		jrbSub.setBackground(Color.RED);
		panel_3_0.add(jrbSub);
		
		JRadioButton jrbMul = new JRadioButton("*");
		buttonGroup.add(jrbMul);
		jrbMul.setBackground(Color.RED);
		panel_3_0.add(jrbMul);
		
		JRadioButton jrbDiv = new JRadioButton("/");
		buttonGroup.add(jrbDiv);
		jrbDiv.setBackground(Color.RED);
		panel_3_0.add(jrbDiv);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.BLUE);
		panel_3.add(panel_3_1);
		
		JButton jbCalc = new JButton("Calculate");
		panel_3_1.add(jbCalc);
		
		JButton jbClr = new JButton("Clear");
		panel_3_1.add(jbClr);

	}

}
