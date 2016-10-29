package com.csmarton.hackerrank.algorithms.strings;

import java.util.Scanner;
import java.util.stream.IntStream;

public class LoveLetter {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		int numOfTestCases = in.nextInt();

		IntStream.range(0, numOfTestCases).forEach(i -> solve(in));
	}

	private static void solve(Scanner in)
	{
		String word = in.next();

		boolean even = word.length() % 2 == 0;

		int halfIndex = word.length() / 2;

		int lastIvestigatedIndex = even ? (halfIndex - 1) : halfIndex;

        int sum = IntStream.range(0, lastIvestigatedIndex + 1).map(i -> getDifference(i, word)).sum();

        System.out.println(sum);
    }

	private static int getDifference(int i, String word)
	{
        int abs = Math.abs(word.charAt(i) - word.charAt(word.length() - i - 1));
        System.out.println("Abs: " + abs);
        return abs;
	}
}
