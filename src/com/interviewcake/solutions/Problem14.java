package com.interviewcake.solutions;

import java.util.HashSet;
import java.util.Set;

public class Problem14 {

	// takes O(n) runtime and O(n) space. If the array was already sorted, we could have done this is O(n)time by keeping 2 pointers
	// 1 at begining, and other at end, & work inwards. 
	public boolean isSpecifiedSumExists(int[] numbers, int sum) {
		if(numbers==null || sum < 0)
			throw new IllegalArgumentException("");
		
		Set<Integer> set = new HashSet<>();
		for(int num : numbers) {
			if(set.contains(sum-num))
					return true;
			set.add(sum-num);
		}
		return false;
	}
	
}
