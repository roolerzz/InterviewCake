package com.interviewcake.solutions;

import java.util.Stack;

public class Problem9 {

	private static class Node { 
		int value;  
		Node left;
		Node right;
		Node(int value){
			this.value = value;
		}
	}
	
	private static class NodeBounds{
		Node node; 
		int lower,upper;
		NodeBounds(Node node, int lower, int upper){
			this.node = node; 
			this.lower = lower; 
			this.upper= upper;
		}
	}
	
	private static final int MAX = Integer.MAX_VALUE;
	
	private static final int MIN = Integer.MIN_VALUE;
	
	public static boolean isValidBSTRecursive(Node root) {
		if(root==null) 
			return true;
		return isBSTRecursive(root,MIN,MAX);
	}
	
	private static boolean isBSTRecursive(Node root, int lower, int upper) {
		if(root == null) 
			return true;
		if(root.value >= upper || root.value <= lower)
			return false;
		return isBSTRecursive(root.left, lower, root.value) && isBSTRecursive(root.right, root.value, upper);
	}
	
	public static boolean isValidBSTIterativeDFS(Node root) {
		if (root == null) return true;
		Stack<NodeBounds> stack = new Stack<>();
		NodeBounds bound = new NodeBounds(root, MIN,MAX);
		stack.push(bound);
		while(!stack.isEmpty()) {
			NodeBounds temp= stack.pop();
			Node node = temp.node;
			int lower = temp.lower; 
			int upper = temp.upper;
			if(node.value >= upper || node.value <= lower) return false;
			if(node.left!=null)
				stack.push(new NodeBounds(node.left, lower, node.value));
			if(node.right != null)
				stack.push(new NodeBounds(node.right, node.value, upper));
		}
		return true;
	}
}
