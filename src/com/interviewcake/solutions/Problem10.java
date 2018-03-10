package com.interviewcake.solutions;

public class Problem10 {

	private static class Node{
		int value;
		Node left,right;
		
		Node(int value){
			this.value = value;
		}
	}
	
	public static int find2ndLargest(Node root) {
		if(root==null || (root.left==null && root.right==null))
			throw new IllegalArgumentException("2nd largest can only be found if tree has atleast 2 nodes");
		
		Node parent=root, rightN = root;
		while(rightN.right!=null) {
			parent = rightN;
			rightN = rightN.right;
		}
		if(rightN.left==null)
			return parent.value;
		else
			return findLargest(rightN.left);
	}
	
	private static int findLargest(Node node) {
		while(node.right!=null)
			node = node.right;
		return node.value;
	}
	
}
