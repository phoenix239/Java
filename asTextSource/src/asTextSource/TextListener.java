package asTextSource;

import javax.swing.JPanel;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

public class TextListener extends JPanel {

	/**
	 * Create the panel.
	 */
	public TextListener() {
		setBackground(new Color(255, 215, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

	}

}
