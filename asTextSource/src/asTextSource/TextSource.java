package asTextSource;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class TextSource extends JPanel {
	private JTextField textSource;
	transient private Vector newTextListeners;

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
				fireNewTextEntered(textSource.getText());
			}
		});
		add(textSource);
		textSource.setColumns(30);
	}

	// adding a listener to the above vector
	public synchronized void addNewTextListener(NewTextListener ntl) {
		Vector v = newTextListeners == null ? new Vector(2) : (Vector) newTextListeners.clone();
		if (!v.contains(ntl)) {
			v.addElement(ntl);
			newTextListeners = v;
		}
	}

	// removing a listener from the above vector (optional)
	public synchronized void removeNewTextListener(NewTextListener ntl) {
		if (newTextListeners != null && newTextListeners.contains(ntl)) {
			Vector v = (Vector) newTextListeners.clone();
			v.removeElement(ntl);
			newTextListeners = v;
		}
	}

	// method for calling newTextEntered method of each listener
	protected void fireNewTextEntered(String nt) {
		NewTextEvent nte = new NewTextEvent(nt);
		if (newTextListeners != null) {
			Vector listeners = newTextListeners;
			int count = listeners.size();
			for (int i = 0; i < count; i++) {
				listeners.newTextEntered(nte);
			}
		}
	}

	public JTextField getTextSource() {
		return textSource;
	}

	public void setTextSource(JTextField textSource) {
		this.textSource = textSource;
	}
}
