package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		Boolean fail=false;
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> a = new Stack<Double>();
		
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Random ran=new Random();
		
		double g=0;
		
		for(int i = 0; i<100; i++) {
			g = ran.nextDouble()*100;
			a.push(g);
		}
		
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String first=JOptionPane.showInputDialog("Put a number between 0 and 100 inclusive");
		String second=JOptionPane.showInputDialog("Put a number between 0 and 100 inclusive");
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		double firstInt=Double.parseDouble(first);
		double secondInt=Double.parseDouble(second);

		double highInt=0;
		double lowInt=0;
		
		if(firstInt>100||firstInt<0||secondInt>100||secondInt<0) {
			fail=true;
		}
		
		if(firstInt==secondInt) {
			fail=true;
		}
		else if(firstInt>secondInt) {
			highInt=firstInt;
			lowInt=secondInt;
		}
		else {
			
			highInt=secondInt;
			lowInt=firstInt;
			
		}
		
		
		int numberNum=0;
		
		if(fail==false) {
			System.out.println("Elements between "+lowInt+" and "+highInt+": ");
			
		for(int k=0;k<a.size();k++) {
			Double popInt=a.pop();
			if(popInt>lowInt&&popInt<highInt) {
				numberNum++;
				System.out.println("Element #"+numberNum+": "+popInt);
			}
		}
		if(numberNum==0) {
			System.out.println("There were NONE");
		}
		
		
		}
		else {
			System.out.println("You failed somehow. Either you entered an integer outside 0-100, or you put two of the same integer.");
		}
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
