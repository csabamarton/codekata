package com.csmarton.hackerrank.algorithms.strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PalindromeIndex {
	public static void main(String[] args) throws FileNotFoundException
	{
		ClassLoader classLoader = new PalindromeIndex().getClass().getClassLoader();
		File file = new File(classLoader.getResource("string/palindromeindex/input14.txt").getFile());

		Scanner in = new Scanner(file);

		int numOfTestCases = in.nextInt();

		IntStream.range(0, numOfTestCases).forEach(counter -> solve(in));
	}

	private static void solve(Scanner in)
	{
		String word = in.next();
		int indexOfBadCharacter = -1;
		int length = word.length();

		int reverseIndex = length - 1;

		for (int i = 0; i < length/2; i++) {
			if(indexOfBadCharacter == -1 && word.charAt(i) != word.charAt(reverseIndex)){
				indexOfBadCharacter = i;
				continue;
			}

			if(indexOfBadCharacter != -1 && word.charAt(i) != word.charAt(reverseIndex)) {
				indexOfBadCharacter = word.length()-indexOfBadCharacter-1;

				break;
			}

			reverseIndex--;
		}

		System.out.println(indexOfBadCharacter);
	}
}
