package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS
	// A MATCHING CLOSING BRACKET
//	public static void main(String[] args) {
//		_03_TestMatchingBrackets a = new _03_TestMatchingBrackets();
//		a.setup();
//	}
//	
//	void setup() {
//		
//	}
	private boolean doBracketsMatch(String b) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < b.length(); i++) {
			if(b.charAt(i)=='{') {
				stack.push('g');
			}
			else if(b.charAt(i)=='}') {
				if(stack.size()>0) {
				stack.pop();
				}
				else {
					return false;
				}
			}
			
			
			//stack.push(b.charAt(i));

		}
		if(stack.size()==0) {
		return true;
		}
		else {
			return false;
			}
		
		

//		int counter = 0;
//		for (int k = 0; k < stack.size(); k++) {
//			char popped = stack.pop();
//			if (popped == '{') {
//				counter++;
//				System.out.println("leftbrak");
//			} else if (popped == '}') {
//				counter--;
//				System.out.println("rightbrak");
//			}
//			if (counter > 0) {
//				return false;
//			}
//
//		}
//
//		if (counter == 0) {
//			return true;
//		} else {
//			return false;
//		}

	}

}