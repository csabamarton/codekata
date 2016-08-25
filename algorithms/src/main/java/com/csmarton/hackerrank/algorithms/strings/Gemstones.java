package com.csmarton.hackerrank.algorithms.strings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Gemstones {
	public static void main(String[] args) {
		Gemstones gemStones = new Gemstones();

		gemStones.start();
	}

	private void start() {
		Scanner in = new Scanner("3\n" + "abcdde\n" + "baccd\n" + "eeabg");
		int numOfStones = in.nextInt();

		Set<Character> elements = null;
		Set<Character> previousStoneElements = null;

		for(int i = 0; i < numOfStones; i++) {
			elements = new HashSet<>();
			String stone = in.next();

			Set<Character> cleanStone = cleanDuplication(stone);

			if(previousStoneElements == null) {
				previousStoneElements = cleanStone;
			} else {
				Iterator<Character> iter = cleanStone.iterator();

				while(iter.hasNext()) {
					char character = iter.next();
					if(previousStoneElements.contains(character)){
						elements.add(character);
					}
				}

				previousStoneElements = elements;
			}
		}

		System.out.print(elements.size());
	}

	private Set cleanDuplication(String stone){
		Set<Character> elements = new HashSet<>();

		for(char character : stone.toCharArray()) {
			if(!elements.contains(character)){
				elements.add(character);
			}
		}

		return elements;
	}
}