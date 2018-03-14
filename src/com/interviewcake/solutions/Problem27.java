package com.interviewcake.solutions;


public class Problem27 {

	// Reverses the order of words in a string.
	public static String reverseWords(char[] str) {
		reverseCharacters(str, 0, str.length-1);
		int startIndex = 0;
		for(int i = 0 ; i <= str.length ; i++) {
			if(i == str.length || str[i]==' ') {
				reverseCharacters(str, startIndex, i-1);
				startIndex = i+1;
			}
		}
		return new String(str);
	}
	
	public static void main(String[] args) {
		String s = "this will be reversed";
		System.out.println(reverseWords(s.toCharArray()));
	}
	
	
private static String reverseCharacters(char[] str , int startIndex, int endIndex) {
		
		// Reverses the sequence of characters in a string in O(n) time in place.
		
		if(str == null || str.length ==0 || startIndex >= endIndex)
			throw new IllegalArgumentException("Invalid Argument to method");
		/*int startIndex = 0;
		int endIndex = str.length-1;
		*/
		while(startIndex < endIndex) {
			char temp = str[startIndex];
			str[startIndex] = str[endIndex];
			str[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
		
		return new String(str);
	}
}
