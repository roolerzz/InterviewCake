package com.interviewcake.solutions;

public class Problem13 {

	public static int findRotatedIndex(String[] words) {
		// Sanitize the input.
		if(words == null || words.length <=1)
			throw new IllegalArgumentException("Rotations can be performed with atleast 2 elements.");
		
		String firstWord = words[0];
		int floorIndex = 0, ceilIndex = words.length-1;
		int midIndex;
		while (floorIndex < ceilIndex) {
			midIndex = floorIndex + ((ceilIndex-floorIndex)/2);
			if(words[midIndex].compareTo(firstWord)>=0) {
				floorIndex = midIndex;
			}
			else {
				ceilIndex = midIndex;
			}
			
			if(floorIndex == ceilIndex-1)break;
		}
		
		// Being careful if the array is not rotated, then above algo gives incorrect result.
		
		if(words[floorIndex].compareTo(words[ceilIndex])<=0)
			ceilIndex = floorIndex;
		return ceilIndex;
	}
}
