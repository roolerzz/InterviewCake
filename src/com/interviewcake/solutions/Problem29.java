package com.interviewcake.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Problem29 {

	public static boolean areBracketsValid(String code) {
		if(code==null)
			throw new IllegalArgumentException("Invalid Input");
		Map<Character,Character> openersToCloser = new HashMap<>();
		openersToCloser.put('(',')');
		openersToCloser.put('{','}');
		openersToCloser.put('[',']');
		Set<Character> openers = openersToCloser.keySet();
		Set<Character> closers = new HashSet<>(openersToCloser.values());
		
		Stack<Character> openerStack = new Stack<>();
		
		for(char c : code.toCharArray()) {
			if(openers.contains(c)) 
				openerStack.push(c);
			else if(closers.contains(c)) {
				if(openerStack.isEmpty())
					return false;
				else {
					char lastUnClosedOpener = openerStack.pop();
					if(openersToCloser.get(lastUnClosedOpener) != c) {
						return false;
					}
				}
			}
			
		}
		return openerStack.empty(); 
	}
	
	public static void main(String[] args) {
		String code = "{ [ }";
		System.out.println(areBracketsValid(code));
	}
	
}
