package com.csmarton.hackerrank.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Amazon {
	static Map<Character, Character> brackets = new HashMap<Character, Character>();

	static {
		brackets.put('(', ')');
		brackets.put('{', '}');
		brackets.put('[', ']');
		brackets.put('<', '>');
	}

	private static Set<Character> endBrackets = new TreeSet<>();

	static {
		endBrackets.add(')');
		endBrackets.add('}');
		endBrackets.add(']');
		endBrackets.add('>');
	}

	private static Stack<Character> stack = new Stack<>();

	public static void main(String[] args)
	{
		System.out.println(hasBalancedBrackets("[](){}<>"));
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int hasBalancedBrackets(String str)
	{

		try {
			if (str == null || str.length() == 0) {
				return 0;
			}

			char[] characters = str.toCharArray();

			Character neededBracket = null;

			List<Character> beginners = new ArrayList<>();
			beginners.addAll(brackets.keySet());

			for (int i = 0; i < characters.length; i++) {
				char next = characters[i];
				if (beginners.contains(next)) {
					stack.push(next);

					continue;
				}

				if (endBrackets.contains(next)) {
					if (stack.size() == 0) {
						return 0;
					}
					char topBeginBracket = stack.pop();

					neededBracket = brackets.get(topBeginBracket);
					if (neededBracket != next) {
						return 0;
					}

					continue;
				}
			}

			if (stack.size() == 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	// METHOD SIGNATURE ENDS
}
