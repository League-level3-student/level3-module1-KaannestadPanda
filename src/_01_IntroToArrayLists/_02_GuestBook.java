package _01_IntroToArrayLists;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class _02_GuestBook {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton addButton = new JButton();
		JButton viewButton = new JButton();
		Dimension dimension = new Dimension(400,400);
		addButton.setPreferredSize(dimension);
		viewButton.setPreferredSize(dimension);
		Font font = new Font(null, 1,40);
		addButton.setFont(font);
		viewButton.setFont(font);
		addButton.setText("ADD NAME");
		viewButton.setText("VIEW NAMES");
		
		frame.add(panel);
		panel.add(addButton);
		panel.add(viewButton);
		frame.pack();
		frame.setVisible(true);
	
	}
	
}
