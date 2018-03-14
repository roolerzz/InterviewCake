package com.interviewcake.solutions;

public class Problem28 {

	public static int findMatchParenIndex(String str, int openingParIndex) {
		int openParenCount = 0;
		
		int length = str.length();
		if(str==null || openingParIndex>=length) {
			throw new IllegalArgumentException("Arguments are invalid.");
		}
		
		for(int i = openingParIndex + 1 ; i < length; i++) {
			if(str.charAt(i) == '(')
				openParenCount++;
			else if(str.charAt(i) == ')') {
				if(openParenCount==0)
					return i;
				else
					openParenCount--;
			}
		}
		throw new RuntimeException("No matching parenthesis found");
		//return -1;
	}
	
	public static void main(String[] args) {
		String str = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
		System.out.println(findMatchParenIndex(str, 10));
	}
	
}
