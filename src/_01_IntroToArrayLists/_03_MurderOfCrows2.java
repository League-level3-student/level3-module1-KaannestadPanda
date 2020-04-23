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


public class _03_MurderOfCrows2 implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
    ArrayList<Qrow> theMurder = new ArrayList<Qrow>();
    Dimension dimension = new Dimension(400,400);

    public static void main(String[] args) {
        _03_MurderOfCrows2 murderOfCrows = new _03_MurderOfCrows2();
        murderOfCrows.initializeCrows();
        murderOfCrows.setup();
      //murderOfCrows.findTheDiamond();
    }
    
    void setup() {
    	
		
		frame.add(panel);
		
		for(int i = 0; i<theMurder.size();i++) {
			
			JButton button = new JButton();
			button.setPreferredSize(dimension);
			button.addActionListener(this);
			button.setText(theMurder.get(i).getName());
			panel.add(button);
			
		}
		
		
		
		frame.pack();
		frame.setVisible(true);
		
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
    	
    }

    private void initializeCrows() {
        theMurder.add(new Qrow("Rok"));
        theMurder.add(new Qrow("Merle"));
        theMurder.add(new Qrow("Poe"));
        theMurder.add(new Qrow("Grenwyn"));
        theMurder.add(new Qrow("Crawford"));
        hideTheDiamond();
    }

    private void hideTheDiamond() {
        int randomness = new Random().nextInt(theMurder.size());
        theMurder.get(randomness).getStomachContents().add("diamond");
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton check = (JButton) e.getSource();
		
		
		
		for(int i = 0;i<theMurder.size();i++) {
			if(theMurder.get(i).getName()==check.getText()) {
				
				for(int k = 0;k<panel.getComponents().length;k++) {
					if(panel.getComponents()[k] instanceof JButton) {
						
						if( ((JButton)panel.getComponents()[k]).getText()==check.getText() ) {
							panel.remove(panel.getComponents()[k]);
						
						}
						
					}
					
				}
				
				if(theMurder.get(i).getStomachContents().contains("diamond")) {
	    			
	    			
	    			if(innocentDeaths==0) {
	    	    		JOptionPane.showMessageDialog(null,"Well done! You destroyed the GUILTY crow only. It was "+theMurder.get(i).getName()+", that theiving b*****! aahahahahhaaahaHAAaAhAhHhHHHahHAAAHHAHAAHAAAHAHAAHAHAHAHAAHAHAHAHAHAHA");
	    	    	}
	    	    	else{
	    	    	JOptionPane.showMessageDialog(null, "You managed to end the life of the theif, "+theMurder.get(i).getName()+"... you ripped open "+innocentDeaths+" innocent crows. Was it worth it?");
	    	    	
	    	    	}
	    			
	    			
	    			
	    			
	    			System.exit(0);
	    		}
	    		else {
	    			JOptionPane.showMessageDialog(null, "YOU MONSTER! WHY WOULD YOU DO THIS? HE HASN'T DONE ANYTHING WRONG!!! I HOPE YOU'RE HAPPY, YOU BADSKSDCNkCNdkUHHUnuhuhuh \n *sobs* \n*is led away by officers*");
	    			innocentDeaths++;
	    		}
				
				
			}
		}
		
	}
}

class Qrow {
    private String name;
    private ArrayList<String> stomachContents = new ArrayList<String>();

    public Qrow(String name) {
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

