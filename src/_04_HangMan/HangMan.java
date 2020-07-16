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

	JFrame fram = new JFrame();
	String gamephase = "guessing";

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	JLabel infoLabel = new JLabel();
	JLabel livesLabel = new JLabel();
	JButton button = new JButton("proceed");
	Stack<String> strings = new Stack<String>();
	String currentword;
	String blanks;
	
	Dimension d = new Dimension(400, 400);
	Dimension dtwo = new Dimension(300, 200);

	String beginning;
	String ending;

	boolean fixedKeyListenerError=false;
	
	int lives;
	boolean success = false;

	public static void main(String[] args) {
		HangMan a = new HangMan();
		a.setup();
	}

	void setup() {
		
		
		lives = 50;
		String inputNumber = JOptionPane
				.showInputDialog("Give a number for the number of words and that's the number you'll give and get");
		int inputInt = Integer.parseInt(inputNumber);

		for (int i = 0; i < inputInt; i++) {
			String a = Utilities.readRandomLineFromFile("src/_04_HangMan/dictionary.txt");
			if(strings.contains(a)==false) {
			strings.push(a);
			}
		}

		frame.add(panel);
		//panel.add(label);
		panel.add(label2);
		panel.add(livesLabel);
		panel.add(infoLabel);
		button.setFocusable(false);
		panel.add(button);
		
		if(fixedKeyListenerError==false) {
		frame.addKeyListener(this);
		fixedKeyListenerError=true;
		}

		
		label.setPreferredSize(d);
		label2.setPreferredSize(d);
		livesLabel.setPreferredSize(d);
		button.setPreferredSize(d);
		button.addActionListener(this);
		infoLabel.setPreferredSize(dtwo);

		frame.pack();
		frame.setVisible(true);

		newWord();

	}

	void newWord() {
		gamephase = "guessing";
		System.out.println("changed to guessing");
		
		
			currentword = strings.pop();
			label.setText(currentword);
			livesLabel.setText("" + lives);

			blanks = "";
			for (int i = 0; i < currentword.length(); i++) {
				blanks = blanks + "_ ";
			}
			System.out.println(blanks);
			label2.setText(blanks);
		
		updateButton();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(gamephase.equals("guessing")) {
			

			for (int g = 0; g < currentword.length(); g++) {
				if (e.getKeyChar() == (currentword.charAt(g))) {

					beginning = blanks.substring(0, g * 2);
					System.out.println(beginning);
					ending = blanks.substring(g * 2 + 1);
					System.out.println(ending);

					blanks = beginning + e.getKeyChar() + ending;
					label2.setText(blanks);

					success = true;
				}
			}
			if (success == true) {
				success = false;
			} else {
				lives--;
				livesLabel.setText("" + lives);
				if (lives <= 0) {
					loseGame();
				}
			}

			if (blanks.contains("_") == false) {
				infoLabel.setText("Correct, the word was " + currentword);
				if(strings.size()>0) {
					gamephase="guessedword";
					System.out.println("changed to guessedword");
				}
				else {
				winGame();
				}
				

			}
			
		}

			updateButton();
		

	}

	void winGame() {

		infoLabel.setText("YOU WIN!!! Your last word was " + currentword);
		gamephase = "end";
		System.out.println("changed to end");
	}

	void loseGame() {

		infoLabel.setText("YOU LOSE, this word was " + currentword);
		gamephase = "end";
		System.out.println("changed to end");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	void updateButton() {
		if (gamephase.equals("end")) {
			button.setText("new game");
		} else if (gamephase.equals("guessedword")) {
			button.setText("new word");
		} else if (gamephase.equals("guessing")) {
			button.setText("guessing");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("buttonclicked");
		if (gamephase.equals("end")) {
			setup();
		} else if (gamephase.equals("guessedword")) {
			
			newWord();
		}
		
	}

}
