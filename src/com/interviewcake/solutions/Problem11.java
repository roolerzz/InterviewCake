package com.interviewcake.solutions;

import java.util.HashMap;

public class Problem11 {

	// using a Regular Trie
	
	private class TrieNode{
		private HashMap<Character, TrieNode> nodeChildren;
		
		public TrieNode() {
			this.nodeChildren = new HashMap<>();
		}
		public boolean hasChildNode(char character) {
			return this.nodeChildren.containsKey(character);
		}
		public void addChildNode(char character) {
			this.nodeChildren.put(character, new TrieNode());
		}
		public TrieNode getChildNode(char character) {
			return this.nodeChildren.get(character);
		}
	}
	
	private class Trie{
		TrieNode root;
		private final char endOfWordMarker = '\0';
		public Trie() {
			this.root = new TrieNode();
		}
		public boolean addWord(String word) {
			TrieNode currentNode = root;
			boolean isNewWord = false;
			for(int i = 0 ; i < word.length(); i++) {
				char c = word.charAt(i);
				if(!currentNode.hasChildNode(c)) {
					currentNode.addChildNode(c);
					isNewWord = true;
				}
				currentNode = currentNode.getChildNode(c);
			}
			
			// Explicitely handling the end of the word, to differentiate the visited string vs a normal prefix.
			if(!currentNode.hasChildNode(endOfWordMarker))
			{
				currentNode.addChildNode(endOfWordMarker);
				isNewWord = true;
			}
			return isNewWord;
		}
	}
}
