package _04_HangMan;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> strings = new Stack<String>();

	public static void main(String[] args) {
		HangMan a = new HangMan();
		a.setup();
	}

	void setup() {
		String inputNumber = JOptionPane
				.showInputDialog("Give a number for the number of words and that's the number you'll give and get");
		int inputInt = Integer.parseInt(inputNumber);
		
		for(int i = 0; i<inputInt;i++) {
			String a = Utilities.readRandomLineFromFile("dictionary.txt");
			strings.push(a);
		}
		

		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		

		Dimension d = new Dimension(400, 400);
		label.setPreferredSize(d);

		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
