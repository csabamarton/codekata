package com.csmarton.hackerrank.datastrucure.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SparseArray {

	private static Map<String, Integer> numOfOccurences = new HashMap<>();

	public static void main(String[] args) {

		String input = "4\n" + "aba\n" + "baba\n" + "aba\n" + "xzxb\n" + "3\n" + "aba\n" + "xzxb\n"
				+ "ab";

		Scanner in = new Scanner(input);

		int numOfStrings = in.nextInt();
		in.nextLine();

		IntStream.range(0, numOfStrings).forEach(i -> processString(in.next()));

		in.nextLine();
		int numOfQueries = in.nextInt();
		in.nextLine();

		//IntStream.range(0, numOfQueries).forEach(i -> printResult(in.nextLine()));


	}

	private static void processString(String word) {
		Integer numOfOccurence = numOfOccurences.get(word);
		if(numOfOccurence == null) {
			numOfOccurence = 0;
		}

		numOfOccurence++;
		numOfOccurences.put(word, numOfOccurence);
	}

	private static void printResult(String query) {
		Integer numOfOccurence = numOfOccurences.get(query);
		if(numOfOccurence == null) {
			System.out.println(0);
		} else {
			System.out.println(numOfOccurence);
		}
	}
}