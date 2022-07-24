package com.brackets.balancing;

import java.util.Stack;

public class BracketsBalance {

	boolean status = false;
	int count = 0;

	Stack<Character> st = new Stack<>();

	public boolean bracketsBalancing(String input) {
		char[] ch = new char[input.length()];

		for(int i = 0 ; i < input.length() ; i++) {
			ch[i] = input.charAt(i);

			if(ch[i]=='[' || ch[i]=='{' || ch[i]=='(') {  // push when there is opening brackets only
				st.push(ch[i]);
			}

			else if((ch[i]==']' || ch[i]=='}' || ch[i]==')')) {  // if current value is closing brackets only

				if(!st.isEmpty()) {  // move further when only stack is not empty
					
					if(ch[i]==']' && st.peek() == '[') { 
						st.pop();
					}

					else if(ch[i]=='}' && st.peek() == '{') {
						st.pop();
					}

					else if(ch[i]==')' && st.peek() == '(') {
						st.pop();
					}
					else {  // current value is closing brackets but not matching with respective opening bracket on top of stack
						count++;
					}
				}
				else {  // runs when current value is closing brackets but stack is empty 
					count++;
				}
			}

		}

		if(count==0 && st.isEmpty() ) {
			return status = true;
		}
		else {
			return status = false;
		}

	}

}
