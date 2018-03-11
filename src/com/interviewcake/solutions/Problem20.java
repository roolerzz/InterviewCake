package com.interviewcake.solutions;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Problem20 {

	// Finding Maximum from a stack at any point.
	
	private Stack<Integer> number = new Stack<>();
	
	private Stack<Integer> max = new Stack<>();
	
	public int getMax() {
		if(max.isEmpty())
			throw new NoSuchElementException();
		return max.peek();
	}
	
	public int pop() {
		if(number.isEmpty())
			throw new NoSuchElementException();
		int num = number.pop();
		if(max.peek() == num)
			max.pop();
		return num;
	}
	
	public void push(int num) {
		number.push(num);
		if(max.isEmpty() || max.peek() <= num) {
			max.push(num);
		}
	}
	
}
