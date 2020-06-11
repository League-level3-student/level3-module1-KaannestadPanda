package _03_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	Stack<Character> stak =new Stack<Character>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();	
JLabel label = new JLabel();



	public static void main(String[] args) {
		
		_02_TextUndoRedo a = new _02_TextUndoRedo();
		a.setup();
	

	}
	
	void setup() {
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		Dimension d = new Dimension(400,400);
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
	
		
		if(e.getKeyCode()==8) {
			String g = label.getText();
			if(g.length()>0) {
				Character savedDeletion=g.charAt(g.length()-1);
				stak.push(savedDeletion);
				
				
			String newText = g.substring(0, g.length()-1);
			label.setText(newText);
			}
		}
		else if(e.getKeyCode()==17) {
			if(stak.size()>0) {
			label.setText(label.getText()+stak.pop());
			}
		}
		
	else {
		String g = label.getText();
		e.getKeyChar();
		label.setText(g+e.getKeyChar());
	}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
