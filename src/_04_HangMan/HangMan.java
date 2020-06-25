package _04_HangMan;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener, ActionListener {

	JFrame fram=new JFrame();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	JLabel livesLabel = new JLabel();
	Stack<String> strings = new Stack<String>();
	String currentword;
	String blanks;
	boolean wordFinished=false;

	
	String beginning;
	String ending;
	
	int lives=5;
	boolean success=false;
	
	public static void main(String[] args) {
		HangMan a = new HangMan();
		a.setup();
	}

	void setup() {
		String inputNumber = JOptionPane
				.showInputDialog("Give a number for the number of words and that's the number you'll give and get");
		int inputInt = Integer.parseInt(inputNumber);
		
		for(int i = 0; i<inputInt;i++) {
			String a = Utilities.readRandomLineFromFile("src/_04_HangMan/dictionary.txt");
			strings.push(a);
		}
		

		frame.add(panel);
		panel.add(label);
		panel.add(label2);
		panel.add(livesLabel);
		frame.addKeyListener(this);
		

		Dimension d = new Dimension(400, 400);
		label.setPreferredSize(d);
		label2.setPreferredSize(d);
		livesLabel.setPreferredSize(d);

		frame.pack();
		frame.setVisible(true);
		
		newWord();

	}
	
	void newWord() {
		if(strings.size()>0) {
		currentword=strings.pop();
		label.setText(currentword);
		livesLabel.setText(""+lives);
		
		blanks="";
		for(int i = 0;i<currentword.length();i++) {
		blanks=blanks+"_ ";
		}
		System.out.println(blanks);
		label2.setText(blanks);
		}
		else {
			winGame();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
for(int g = 0; g<currentword.length();g++) {
	if(e.getKeyChar()==(currentword.charAt(g))) {
		
beginning=blanks.substring(0, g*2);
System.out.println(beginning);
ending=blanks.substring(g*2+1);
System.out.println(ending);
		
	
	blanks=beginning+e.getKeyChar()+ending;
	label2.setText(blanks);
	
	success=true;
	}
}
if(success==true) {
	success=false;
}
else {
	lives--;
	livesLabel.setText(""+lives);
	if(lives<=0) {
		loseGame();
	}
}

if(blanks.contains("_")==false) {
	JOptionPane.showMessageDialog(null, "Correct, the word was "+currentword);
	newWord();
	
}


		
		
		
	}
	
	void winGame() {
		JOptionPane.showMessageDialog(null,"win");
		askRestart();
	}
	void loseGame() {
		
		JOptionPane.showMessageDialog(null,"Lose game, this word was "+currentword);
		askRestart();
	}
	
	void askRestart() {
		frame=new JFrame();//delete frame
		
		JPanel pane = new JPanel();
		JButton button = new JButton("Play again?");
		
		fram.add(pane);
		pane.add(button);
		button.addActionListener(this);
		fram.pack();
		fram.setVisible(true);
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		fram=new JFrame();//delete fram
		setup();
	}

}
