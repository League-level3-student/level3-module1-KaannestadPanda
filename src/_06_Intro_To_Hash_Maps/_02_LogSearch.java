package _06_Intro_To_Hash_Maps;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	HashMap<Integer, String> studentRoster = new HashMap<Integer, String>();
	JButton button = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	
	public static void main(String[] args) {
		_02_LogSearch a = new _02_LogSearch();
		a.setup();
	}
	
	
	void setup() {
		Dimension d = new Dimension(200,200);
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		button.setPreferredSize(d);
		button2.setPreferredSize(d);
		button3.setPreferredSize(d);
		
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		frame.add(panel);
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		
		frame.pack();
		frame.setVisible(true);
	}
  /* 
	 * Create a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton checkButton=(JButton) e.getSource();
		
		if(checkButton==button) {
			String keyString=JOptionPane.showInputDialog("Enter an ID number.");
			int keyInt = Integer.parseInt(keyString);
			String value=JOptionPane.showInputDialog("Now, enter a name.");
			studentRoster.put(keyInt, value);
		}
		else if(checkButton==button2) {
			String searchedKeyString=JOptionPane.showInputDialog("Enter an ID number");
			int searchedKeyInt = Integer.parseInt(searchedKeyString);
			if(studentRoster.containsKey(searchedKeyInt)) {
			JOptionPane.showMessageDialog(null, "The corresponding name is "+studentRoster.get(searchedKeyInt));
			}
			else {
				JOptionPane.showMessageDialog(null, "That key does not exist.");
			}
		}
		else {
	for(int i = 0; i<studentRoster.size();i++) {
		
	}
		}
		
	}
	
}
