package com.interviewcake.solutions;

import java.util.HashSet;
import java.util.Set;

public class Problem30 {

	public static boolean hasPallindromicPermutation(String input) {
		if(input == null) throw new IllegalArgumentException("Invalid Input");
		Set<Character> unPairedChars = new HashSet<>();
		
		for(char c : input.toCharArray()) {
			if(unPairedChars.contains(c))
				unPairedChars.remove(c);
			else 
				unPairedChars.add(c);
		}
		
		return unPairedChars.size()<=1;
	}
	
	public static void main(String[] args) {
		String input = "livci";
		System.out.println(hasPallindromicPermutation(input));
	}
	
	
}
