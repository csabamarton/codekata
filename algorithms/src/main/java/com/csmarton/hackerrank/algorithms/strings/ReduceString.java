package com.csmarton.hackerrank.algorithms.strings;

import java.util.Scanner;

public class ReduceString {

	private String EMPTY_STRING = "Empty String";
	private String word;

	public static void main(String[] args)
	{
		ReduceString reduceString = new ReduceString();

		reduceString.solve(null);
	}

	private void solve(String input)
	{
		setData(input);

		while (findDouble()) {
		}

		printResult();
	}

	private void setData(String input)
	{
		Scanner in;

		if (input == null) {
			in = new Scanner(System.in);
		} else {
			in = new Scanner(input);
		}
		word = in.next();
	}

	private boolean findDouble()
	{
		boolean hasDouble = false;
		StringBuilder sb = new StringBuilder();
		if (word.length() > 1) {
			char[] chars = word.toCharArray();
			for (int i = 0; i < word.length(); i++) {
				if (i == word.length() - 1) {
					sb.append(chars[i]);
				} else if (!(chars[i] == chars[i + 1])) {
					sb.append(chars[i]);
				} else {
					i++;
					hasDouble = true;
				}
			}
		}

		word = sb.toString();

		return hasDouble;
	}

	private void printResult()
	{
		if (word.length() == 0) {
			System.out.println(EMPTY_STRING);
		} else {
			System.out.println(word);
		}
	}
}