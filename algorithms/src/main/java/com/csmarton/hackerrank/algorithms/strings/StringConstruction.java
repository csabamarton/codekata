package com.csmarton.hackerrank.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class StringConstruction {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		IntStream.range(0, n).forEach(counter -> solve(in));

	}

	private static void solve(Scanner in)
	{
		String word = in.next();
		Set uniqueChars = new HashSet<>();

		word.chars().mapToObj(i -> (char)i).forEach(character -> uniqueChars.add(character));

		System.out.println(uniqueChars.size());
	}
}
