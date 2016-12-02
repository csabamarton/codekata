package com.csmarton.hackerrank.datastrucure.tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Contacts {
	private enum Action {
		ADD, FIND;

		static Action getValue(String value)
		{
			for (Action action : Action.values()) {
				if (action.toString().toLowerCase().equals(value)) {
					return action;
				}
			}

			return null;
		}
	}

	private MyNode tries = new MyNode();

	private class MyNode {
		private char letter;
		private Map<Character, MyNode> children;
		private boolean isEnd;
		private int numOfWords;

		public int getNumOfWords()
		{
			return numOfWords;
		}

		public void setNumOfWords(int num)
		{
			this.numOfWords = num;
		}

		public void incrementNumOfWords()
		{
			numOfWords++;
		}

		public char getLetter()
		{
			return letter;
		}

		public void setLetter(char letter)
		{
			this.letter = letter;
		}

		public Map<Character, MyNode> getChildren()
		{
			return children;
		}

		public void setChildren(Map<Character, MyNode> children)
		{
			this.children = children;
		}

		public boolean isEnd()
		{
			return isEnd;
		}

		public void setEnd(boolean end)
		{
			isEnd = end;
		}
	}

	public static void main(String[] args)
	{
		Contacts contacts = new Contacts();

		contacts.start();
	}

	private void start()
	{
		Scanner in = new Scanner(System.in);

		IntStream.range(0, in.nextInt()).forEach(i -> {
			Action action = Action.getValue(in.next());

			String param = in.next();

			switch (action) {
			case FIND:
				find(param);
				break;
			case ADD:
				add(param);
				break;
			}
		});
	}

	private MyNode getEndNode(String word)
	{
		MyNode currentNode = tries;

		if (currentNode == null || currentNode.getChildren() == null) {
			return null;
		}

		currentNode = currentNode.getChildren().get(word.charAt(0));

		if (currentNode == null) {
			return null;
		}

		if (word.length() == 1 && currentNode.isEnd()) {
			return currentNode;
		}

		for (int i = 1; i < word.length(); i++) {
			char letter = word.charAt(i);

			if (currentNode.getChildren() == null) {
				return null;
			}

			currentNode = currentNode.getChildren().get(letter);

			if (currentNode == null) {
				return null;
			}
		}

		return currentNode;
	}

	private boolean triesContains(String word)
	{
		MyNode currentNode = getEndNode(word);

		if (currentNode != null && currentNode.isEnd) {
			return true;
		}

		return false;
	}

	private void add(String param)
	{
		boolean contains = triesContains(param);

		char letter = param.charAt(0);
		Map<Character, MyNode> children;

		if (!contains) {
			char[] letters = param.toCharArray();
			if (tries.getChildren() == null) {
				children = new HashMap<>();
				tries.setChildren(children);
			}

			MyNode currentNode = tries.getChildren().get(letter);

			if (currentNode == null) {
				currentNode = createNewNode(letter);
				tries.getChildren().put(letter, currentNode);
			}

			currentNode.incrementNumOfWords();

			for (int i = 1; i < letters.length; i++) {
				letter = letters[i];

				children = currentNode.getChildren();

				if (children == null) {
					children = new HashMap<>();
					currentNode.setChildren(children);
				}

				MyNode nextNode = children.get(letter);
				if (nextNode == null) {
					nextNode = createNewNode(letter);
					children.put(letter, nextNode);
				}

				currentNode = nextNode;

				currentNode.incrementNumOfWords();
			}
			currentNode.setEnd(true);
		}
	}

	private void find(String word)
	{
		MyNode currentNode = getEndNode(word);

		if (currentNode == null) {
			System.out.println(0);
			return;
		}

		System.out.println(currentNode.getNumOfWords());
	}

	private MyNode createNewNode(char letter)
	{
		MyNode newNode = new MyNode();
		newNode.setLetter(letter);

		return newNode;
	}
}
