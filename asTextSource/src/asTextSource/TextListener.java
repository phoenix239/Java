package asTextSource;

import javax.swing.JPanel;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class TextListener extends JPanel implements NewTextListener{

	private TextSource tSource = new TextSource(); 
	
	public TextListener() {
		setBackground(new Color(255, 215, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

	}
	
	public void setSource(TextSource tSource) {
		this.tSource = tSource;
	}

	@Override
	public void newTextEntered(NewTextEvent nte) {
		// TODO Auto-generated method stub
		
	}

}
