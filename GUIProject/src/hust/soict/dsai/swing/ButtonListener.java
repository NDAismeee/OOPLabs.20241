package hust.soict.dsai.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.charAt(0) >= '0' && button.charAt(0) <= '9') {
			tfDisplay.setText(tfDisplay.getText() + button);
		}
	}
}
