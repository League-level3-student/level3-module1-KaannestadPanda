package _01_IntroToArrayLists;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Copyright The League of Amazing Programmers 2013-2017
 *    Level 3
 *    A Murder of Crows
 *    Duration=.00
 *    Platform=Eclipse
 *    Type=Recipe
 *    Objectives=n/a
*/

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class _03_MurderOfCrows implements ActionListener {

    ArrayList<Crow> theMurder = new ArrayList<Crow>();
    Dimension dimension = new Dimension(400,400);

    public static void main(String[] args) {
        _03_MurderOfCrows murderOfCrows = new _03_MurderOfCrows();
        murderOfCrows.initializeCrows();
      murderOfCrows.findTheDiamond();
    }
    

    
    
    int innocentDeaths=0;

    private void findTheDiamond() {
        /*
         * 1. One of the Crows has eaten the diamond. You need to search through the stomach of each Crow, 
         * then print the name of the guilty Crow.
         */
    	
    	for(int i = 0;i<=theMurder.size();i++) {
    		if(theMurder.get(i).getStomachContents().contains("diamond")) {
    			JOptionPane.showMessageDialog(null, "It was "+theMurder.get(i).getName());
    			break;
    		}
    		else {
    			innocentDeaths++;
    		}
    	}
    	
        
        /* 2. How many innocent crows had to die before the diamond was found? */
    	if(innocentDeaths==0) {
    		JOptionPane.showMessageDialog(null,"Well done! You destroyed the GUILTY crow only. That theiving b*****! aahahahahhaaahaHAAaAhAhHhHHHahHAAAHHAHAAHAAAHAHAAHAHAHAHAAHAHAHAHAHAHA");
    	}
    	else{
    	JOptionPane.showMessageDialog(null, "You ripped open "+innocentDeaths+" innocent crows. Was it worth it?");
    	}
    }

    private void initializeCrows() {
        theMurder.add(new Crow("Rok"));
        theMurder.add(new Crow("Merle"));
        theMurder.add(new Crow("Poe"));
        theMurder.add(new Crow("Grenwyn"));
        theMurder.add(new Crow("Crawford"));
        hideTheDiamond();
    }

    private void hideTheDiamond() {
        int randomness = new Random().nextInt(theMurder.size());
        theMurder.get(randomness).getStomachContents().add("diamond");
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}
}

class Crow {
    private String name;
    private ArrayList<String> stomachContents = new ArrayList<String>();

    public Crow(String name) {
        this.name = name;
        fillCrowsStomach();
    }

    private void fillCrowsStomach() {
        for (int i = 0; i < 10; i++)
            this.stomachContents.add(getRandomCrowFood());
    }

    private String getRandomCrowFood() {
        int randomness = new Random().nextInt(4);
        if (randomness == 0) return "carrion";
        else if (randomness == 1)return "snail";
        else if (randomness == 2)return "acorn";
        else if (randomness == 3)return "spider";
        else return "grub";
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getStomachContents() {
        return stomachContents;
    }

}

