package com.interviewcake.solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem15 {

	
	private static Map<Integer, Integer> memo = new HashMap<>();
	// uses top down memoization which brings down the runtime from 2^n to n. takes O(n) space for each memo table and call stack.
	public static int fibRec(int n) {
		if(n < 0) 
			throw new IllegalArgumentException("Input should be non negative");
		
		if(n == 0 || n == 1)
			return n;
		
		if(memo.containsKey(n))
			return memo.get(n);
		
		int result = fibRec(n-1) + fibRec(n-2);
		memo.put(n, result);
		return result;
	}
	
	// Computes the fib in a bottum up approach, runs in O(n) time and O(1) space.
	public static int fibItr(int n) {
		if(n < 0) 
			throw new IllegalArgumentException("Input should be non negative");
		int prevFib = 0;
		int curFib = 1;
		int result = curFib;
		for(int i = 1 ; i < n ; i++)
			{
			result = prevFib + curFib;
			prevFib = curFib;
			curFib = result;
			}
		return result;
	}
	
}
