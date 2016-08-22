package com.csmarton.hackerrank.algorithms.strings;

import java.util.Scanner;

public class AlternatingCharacters {

	private int numOfTestCases;
	private Scanner in;

	public static void main(String[] args)
	{
		AlternatingCharacters solution = new AlternatingCharacters();

		solution.setNumOfTestCases();

		solution.start();

	}

	private void start()
	{
		for (int i = 0; i < numOfTestCases; i++) {
			solve();
		}
	}

	private void solve()
	{
		String input = in.next();

		int numOfElimination = setCharChain(input);
		System.out.println(numOfElimination);
	}

	private int setCharChain(String input)
	{
		int numOfConsecutive = 0;

		char[] charArray = input.toCharArray();

		for (int i = 0; i < (charArray.length - 1); i++) {
			if (charArray[i] == charArray[i + 1]) {
				numOfConsecutive++;
			}
		}

		return numOfConsecutive;
	}

	private void setNumOfTestCases()
	{
		in = new Scanner(System.in);

		numOfTestCases = in.nextInt();
	}
}
