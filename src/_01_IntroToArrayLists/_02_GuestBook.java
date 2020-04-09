package _01_IntroToArrayLists;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	ArrayList<String> nameList = new ArrayList<String>();
	JButton addButton = new JButton();
	JButton viewButton = new JButton();
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	public static void main(String[] args) {
		_02_GuestBook a = new _02_GuestBook();
		a.setup();
		
	
	}
	
	
	void setup() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		addButton.addActionListener(this);
		viewButton.addActionListener(this);
		
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
	
	void addName() {
		String namae= JOptionPane.showInputDialog("ENTER A NAME YOU FREAK");
		nameList.add(namae);
	}
	
	void viewNames() {
		String summary = "";
		
		JOptionPane.showMessageDialog(null, summary);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addButton) {
			addName();
		}
		else if(e.getSource()==viewButton) {
			viewNames();
		}
	}
	
	
	
	
	
	
}
