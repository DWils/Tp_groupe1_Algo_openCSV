package evaluation;

import java.util.Stack;

public class LIFO {
	
	public void exerciceLIFO() {
		char[] listChar = {'E','A','S','*','Y','*','Q','U','E','*','*','*','S','T','*','*','*','I','O','*','N','*','*','*'};
		Stack<Character> stack = new Stack<>();
		for(int i = 0 ; i < listChar.length ; i++) {
			if(listChar[i] == '*') {
				stack.pop();
			}else {
				stack.push(listChar[i]);
			}
			System.out.print("\n");
			System.out.print(stack);
		}	
	}
	
	
}
