package hust.soict.sec.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class NumberGrid extends JFrame {

	private JButton[] btnNumbers = new JButton[10];
	private JButton btnDelete, btnReset;
	
	private JTextField tfDisplay;
	
	public NumberGrid() {
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JPanel panelButtons = new JPanel(new GridLayout(4, 3));
		addButtons(panelButtons);
		
		Container cpContainer = getContentPane();
		cpContainer.setLayout(new BorderLayout());
		cpContainer.add(tfDisplay, BorderLayout.NORTH);
		cpContainer.add(panelButtons, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Number Grid");
		setSize(200, 200);
		setVisible(true);
	}
	
	void addButtons(JPanel panelButtons) {
		// TODO Auto-generated method stub
		ButtonListener btnListener = new ButtonListener();
		for(int i = 1; i <= 9; i++) {
			btnNumbers[i] = new JButton(""+i);
			panelButtons.add(btnNumbers[i]);
			btnNumbers[i].addActionListener(btnListener);
		}
		
		btnDelete = new JButton("Del");
		panelButtons.add(btnDelete);
		btnDelete.addActionListener(btnListener);
		
		btnNumbers[0] = new JButton("0");
		panelButtons.add(btnNumbers[0]);
		btnNumbers[0].addActionListener(btnListener);
		
		btnReset = new JButton("C");
		panelButtons.add(btnReset);
		btnReset.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonString = e.getActionCommand();
			if(buttonString.charAt(0) >= '0' && buttonString.charAt(0) <= '9') {
				tfDisplay.setText(tfDisplay.getText() + buttonString);
			}
			else if(buttonString.equals("DEL")){
				//handlers the DEL case
				tfDisplay.setText(null);
			}
			else {
				//handlers the C case
				tfDisplay.setText("");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NumberGrid();
	}

}
