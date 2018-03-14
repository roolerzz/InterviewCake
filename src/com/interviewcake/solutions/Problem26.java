package com.interviewcake.solutions;

public class Problem26 {

	public static String reverseStringInPlace(char[] str) {
		
		// Reverses the sequence of characters in a string in O(n) time in place.
		
		if(str == null || str.length ==0)
			throw new IllegalArgumentException("Invalid Argument to method");
		int startIndex = 0;
		int endIndex = str.length-1;
		
		while(startIndex < endIndex) {
			char temp = str[startIndex];
			str[startIndex] = str[endIndex];
			str[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
		
		return new String(str);
	}
	
	public static void main(String[] args) {
		String s = "this will be reversed";
		System.out.println(reverseStringInPlace(s.toCharArray()));
		
	}
	
}
