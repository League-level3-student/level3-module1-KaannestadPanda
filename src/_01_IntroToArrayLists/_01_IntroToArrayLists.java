package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> stringArray = new ArrayList<String>();

		//2. Add five Strings to your list
		stringArray.add("zero");
		stringArray.add("one");
		stringArray.add("two");
		stringArray.add("three");
		stringArray.add("four");
		
		//3. Print all the Strings using a standard for-loop
		for(int i = 0;i<stringArray.size();i++) {
			System.out.println(stringArray.get(i));
		}
		System.out.println("\n");
		//4. Print all the Strings using a for-each loop
		for(String s:stringArray) {
			System.out.println(s);
		}
		System.out.println("\n");
		//5. Print only the even numbered elements in the list.
		for(int i = 0;i<stringArray.size();i++) {
			if(i%2==0) {
			System.out.println(stringArray.get(i));
			}
		}
		System.out.println("\n");
		
		//6. Print all the Strings in reverse order.
		for(int i = stringArray.size()-1;i>=0;i--) {
			System.out.println(stringArray.get(i));
		}
		
		System.out.println("\n");
		//7. Print only the Strings that have the letter 'e' in them.
		for(String s:stringArray) {
			if(s.contains("e")) {
			System.out.println(s);
			}
		}

	}
}
