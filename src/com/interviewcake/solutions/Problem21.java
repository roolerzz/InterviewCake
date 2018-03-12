package com.interviewcake.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem21 {
	
	public static void main(String[] args) {
		int arr[] ={1,2,3,4,3,2,4,5,5};
		System.out.println(findUniqueInArrayBruteForce(arr));
		System.out.println(findUniqueInArrayExtraSpace(arr));
		System.out.println(findUniqueInArrayBitwise(arr));
		System.out.println(findUniqueInArraySorting(arr));
		
	}

	public static int findUniqueInArrayBruteForce(int[] arr) {
		if(arr==null || arr.length == 0)
			throw new IllegalArgumentException();
		int len = arr.length;
		int unique = -1;
		for(int i = 0 ; i < len ; i++) {
			boolean isMatchFound = false;
			for(int j = i+1 ; j < len ; j++) {
				if(arr[i]==arr[j])
				{
					isMatchFound = true;
					break;
				}
			}
			if(!isMatchFound)
				{
					return arr[i];
				}
				
		}
		return -1;
	}
	
	public static int findUniqueInArraySorting(int[] arr) {
		if(arr==null || arr.length == 0)
			throw new IllegalArgumentException();
		int len = arr.length;
		int unique = -1;
		Arrays.sort(arr);
		for(int i = 0 ; i < len; i=i+2) {
			if(i+1 == len || arr[i] != arr[i+1])
				{
				unique = arr[i];
				break;
				}
		}
		return unique;
	}
	
	public static int findUniqueInArrayExtraSpace(int[] arr) {
		if(arr==null || arr.length == 0)
			throw new IllegalArgumentException();
		int len = arr.length;
		Set<Integer> unique = new HashSet<>();
		for(int elem : arr) 
			if(unique.contains(elem))
				unique.remove(elem);
			else
				unique.add(elem);
		return unique.iterator().next().intValue();
	}
	public static int findUniqueInArrayBitwise(int[] arr) {
		if(arr==null || arr.length == 0)
			throw new IllegalArgumentException();
		int len = arr.length;
		int unique = 0;
		for(int item : arr) {
			unique ^= item;
		}
		return unique;
	}
}
