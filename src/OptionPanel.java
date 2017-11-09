import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class OptionPanel extends JPanel implements ActionListener {
	
	Hockey w;
	
	public OptionPanel(Hockey w) {
		this.w = w;
		JButton button = new JButton("Press me!");
		button.setBackground(Color.CYAN);
		button.addActionListener(this);
		add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
//		w.changePanel();
	}
	
}