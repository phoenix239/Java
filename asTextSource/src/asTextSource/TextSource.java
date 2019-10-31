package asTextSource;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextSource extends JPanel {
	private JTextField textSource;

	public TextSource() {
		setBackground(new Color(0, 128, 0));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Source Text: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		add(lblNewLabel);

		textSource = new JTextField();
		textSource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewTextEvent nte = new NewTextEvent(textSource.getText());

			}
		});
		add(textSource);
		textSource.setColumns(30);
	}

	public JTextField getTextSource() {
		return textSource;
	}

	public void setTextSource(JTextField textSource) {
		this.textSource = textSource;
	}
}
