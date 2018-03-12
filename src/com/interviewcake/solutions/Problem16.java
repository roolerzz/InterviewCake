package com.interviewcake.solutions;

public class Problem16 {

	// Solved Unbounded knapsack problem where we can take a possible value type any number of times to maximize total value.
	// Satisfies Overlapping subproblems, property of dynamic programming.
	// O(n * k) time, and O(k) space, where n is number of types of cake and k is the capacity of the duffel bag
	private class CakeType{
		int value;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		int weight;
		
		
		public CakeType(int value, int weight) {
			this.value = value; 
			this.weight = weight;
		}
	}
/*	
	private class InfinityException extends RuntimeException{
		public InfinityException() {
			super("Value is infinity due to the inputs provided.");
		}
		
	}*/
	
	public static long findMaxValueAtCapacity(int maxCapacity, CakeType[] cakeTypes) {
		if(maxCapacity < 0 || cakeTypes == null || cakeTypes.length==0)
			throw new IllegalArgumentException("");
		long[] maxValueAtCapacity = new long[maxCapacity + 1];
		
		for(int capacity = 0 ; capacity <= maxCapacity ; capacity++) {
			long maxValue = 0;
			for(CakeType cake : cakeTypes) {
				int weight = cake.getWeight();
				int value = cake.getValue();
				int remainingWeight = capacity-weight;
				if(weight == 0 && value != 0)
					throw new RuntimeException();
				if(weight <= capacity) {
					Math.max(maxValue, value + maxValueAtCapacity[remainingWeight]);
				}
				
			}
			maxValueAtCapacity[capacity] = maxValue;
		}
		return maxValueAtCapacity[maxCapacity];
	}
}
