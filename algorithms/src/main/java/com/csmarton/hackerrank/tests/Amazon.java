package com.csmarton.hackerrank.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Amazon {
	private final static Map<Character, Character> brackets;
	private final static Set<Character> endBrackets;

	static {
		Map<Character, Character> modifiableMapForBracket = new HashMap<>();
		modifiableMapForBracket.put('(', ')');
		modifiableMapForBracket.put('{', '}');
		modifiableMapForBracket.put('[', ']');
		modifiableMapForBracket.put('<', '>');

		brackets = Collections.unmodifiableMap(new HashMap<>(modifiableMapForBracket));

		modifiableMapForBracket.clear();

		endBrackets = Collections.unmodifiableSet(new HashSet<>(brackets.values()));
	}

	private static Stack<Character> stack;

	public static void main(String[] args)
	{
		System.out.println(hasBalancedBrackets("(h[e{lo!]~)()()()("));
		System.out.println(hasBalancedBrackets("[](){}<>"));
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int hasBalancedBrackets(String str)
	{
		stack = new Stack<>();

		if (str == null || str.length() == 0) {
			return 0;
		}

		char[] characters = str.toCharArray();

		List<Character> beginners = new ArrayList<>(brackets.keySet());

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

				if (brackets.get(topBeginBracket) != next) {
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

	}
	// METHOD SIGNATURE ENDS
}
