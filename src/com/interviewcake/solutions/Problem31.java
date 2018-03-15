package com.interviewcake.solutions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem31 {

	public static Set<String> getPermutations(String input){
		// base case.
		if(input.length() <= 1)
			return new HashSet<>(Collections.singletonList(input));
		
		String allCharsExceptLast = input.substring(0, input.length()-1);
		char lastChar = input.charAt(input.length()-1);
		
		Set<String> permutationsOfAllExceptLast = getPermutations(allCharsExceptLast);
		
		Set<String> permutations = new HashSet<>();
		
		for(String potentialPerm : permutationsOfAllExceptLast) {
			for(int position = 0 ; position <= allCharsExceptLast.length() ; position++) {
				String permutation = potentialPerm.substring(0,position) + lastChar + potentialPerm.substring(position);
				permutations.add(permutation);
			}
		}
		return permutations;
	}
	
	public static void main(String[] args) {
		String str = "abcd";
		Set<String> permutations = getPermutations(str);
		for(String s : permutations){
			System.out.println(s);
		}
	}
	
}
